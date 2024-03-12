package app.dao;

import app.config.MYSQLConnection;
import app.dto.OrderDto;
import app.dto.PersonDto;
import app.dto.PetDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
	public Connection connection = MYSQLConnection.getConnection();

	@SuppressWarnings("null")
	@Override
	public long createOrder(OrderDto orderDto) throws Exception {
		String query = "INSERT INTO ORDEN(MASCOTA,PROPIETARIO,MEDICO,MEDICAMENTO,FECHA) VALUES (?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		int i = 1;
		preparedStatement.setLong(i++, orderDto.getIdPet().getIdPet());
		preparedStatement.setLong(i++, orderDto.getOwnerDocument().getId());
		preparedStatement.setLong(i++, orderDto.getVetDocument().getId());
		preparedStatement.setString(i++, orderDto.getMedicationAndDosage());
		preparedStatement.setDate(i++, orderDto.getGenerationDate());
		preparedStatement.execute();
		query = "SELECT ID FROM ORDEN WHERE FECHA = ? AND MEDICAMENTO = ?";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setDate(1, orderDto.getGenerationDate());
		preparedStatement.setString(2, orderDto.getMedicationAndDosage());
		ResultSet resulSet = preparedStatement.executeQuery();
		if (resulSet.next()) {
			long id = resulSet.getLong("ID");
			resulSet.close();
			preparedStatement.close();
			return id;
		}
		resulSet.close();
		preparedStatement.close();
		return (Long) null;
	}

	@Override
	public List<OrderDto> findOrders() throws Exception {
		String query = "SELECT  O.ID,O.MASCOTA,O.PROPIETARIO,O.MEDICO,O.MEDICAMENTO,O.FECHA FROM ORDEN AS O JOIN HISTORIA AS H ON (H.ORDEN = O.ID) WHERE H.ORDERCANCELATION = 0";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet resulSet = preparedStatement.executeQuery();
		List<OrderDto> orders = new ArrayList<OrderDto>();
		while (resulSet.next()) {
			OrderDto resultOrderDto = new OrderDto();
			PetDto petDto = new PetDto(resulSet.getLong("MASCOTA"));
			PersonDto ownerDto = new PersonDto(resulSet.getLong("PROPIETARIO"));
			PersonDto vetDto = new PersonDto(resulSet.getLong("MEDICO"));
			resultOrderDto.setIdOrder(resulSet.getLong("ID"));
			resultOrderDto.setIdPet(petDto);
			resultOrderDto.setOwnerDocument(ownerDto);
			resultOrderDto.setVetDocument(vetDto);
			resultOrderDto.setMedicationAndDosage(resulSet.getString("MEDICAMENTO"));
			resultOrderDto.setGenerationDate(resulSet.getDate("FECHA"));
			orders.add(resultOrderDto);
		}
		resulSet.close();
		preparedStatement.close();
		return orders;
	}

	@Override
	public boolean findOrderById(OrderDto orderDto) throws Exception {
		String query = "SELECT ORDEN FROM HISTORIA WHERE ORDEN = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setLong(1, orderDto.getIdOrder());
		ResultSet resulSet = preparedStatement.executeQuery();
		boolean result = resulSet.next();
		resulSet.close();
		preparedStatement.close();
		return result;
	}

	@Override
	public void cancelOrder(OrderDto orderDto) throws Exception {
		String query = "UPDATE HISTORIA SET ORDERCANCELATION = 1 WHERE ORDEN = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setLong(1, orderDto.getIdOrder());
		preparedStatement.execute();
		preparedStatement.close();
	}

	@Override
	public OrderDto findDataOrder(OrderDto orderDto) throws Exception {
		String query = "SELECT ID,MASCOTA,PROPIETARIO,MEDICO,MEDICAMENTO,FECHA FROM ORDEN WHERE ID = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setLong(1, orderDto.getIdOrder());
		ResultSet resulSet = preparedStatement.executeQuery();
		if(resulSet.next()) {
			OrderDto responseOrderDto = new OrderDto();
			PetDto petDto = new PetDto(resulSet.getLong("MASCOTA"));
			PersonDto ownerDocument = new PersonDto(resulSet.getLong("PROPIETARIO"));
			PersonDto vetDocument = new PersonDto(resulSet.getLong("MEDICO"));
			responseOrderDto.setIdOrder(resulSet.getLong("ID"));
			responseOrderDto.setIdPet(petDto);
			responseOrderDto.setOwnerDocument(ownerDocument);;
			responseOrderDto.setVetDocument(vetDocument);
			responseOrderDto.setMedicationAndDosage(resulSet.getString("MEDICAMENTO"));
			responseOrderDto.setGenerationDate(resulSet.getDate("FECHA"));
			return responseOrderDto;
		}
		resulSet.close();
		preparedStatement.close();
		return null;
	}

}
