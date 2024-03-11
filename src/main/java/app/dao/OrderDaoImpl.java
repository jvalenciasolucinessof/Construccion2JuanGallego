package app.dao;

import app.config.MYSQLConnection;
import app.dto.OrderDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class OrderDaoImpl  implements OrderDao {
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
		query = "SELECT ID FROM ORDEN WHERE FECHA = ?";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setDate(1, orderDto.getGenerationDate());
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
	
}
