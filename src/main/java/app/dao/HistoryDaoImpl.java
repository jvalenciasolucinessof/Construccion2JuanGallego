package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.config.MYSQLConnection;
import app.dto.HistoryDto;
import app.dto.OrderDto;
import app.dto.PersonDto;
import app.dto.PetDto;
import java.util.ArrayList;
import java.util.List;


public class HistoryDaoImpl implements HistoryDao {
	public Connection connection = MYSQLConnection.getConnection();

	@Override
	public void createHistory(HistoryDto historyDto) throws Exception {
		String query = "INSERT INTO HISTORIA(FECHA,MASCOTA,MEDICO,MOTIVO,SINTOMATOLOGIA,PROCEDIMIENTO,MEDICAMENTO,ORDEN,VACUNACION,ALERGIA,DETALLES_PROCEDIMIENTO,DIAGNOSIS,MEDICATIONDOSAGE,ORDERCANCELATION) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		int i = 1;
		preparedStatement.setLong(i++, historyDto.getAdmissionDate());
		preparedStatement.setLong(i++, historyDto.getIdPet().getIdPet());
		preparedStatement.setLong(i++, historyDto.getVet().getId());
		preparedStatement.setString(i++, historyDto.getReason());
		preparedStatement.setString(i++, historyDto.getSymptomatology());
		preparedStatement.setString(i++, historyDto.getProcedure());
		preparedStatement.setString(i++, historyDto.getMedicine());
		preparedStatement.setLong(i++, historyDto.getIdOrder().getIdOrder());
		preparedStatement.setString(i++, historyDto.getVaccinationHistory());
		preparedStatement.setString(i++, historyDto.getMedicinesAllegic());
		preparedStatement.setString(i++, historyDto.getProceduredetail());
		preparedStatement.setString(i++, historyDto.getDiagnosis());
		preparedStatement.setString(i++, historyDto.getMedicationDosage());
		preparedStatement.setInt(i++, historyDto.getOrderCancelation());
		preparedStatement.execute();
		preparedStatement.close();
	}

	@Override
	public List<HistoryDto> findHistory(HistoryDto historyDto) throws Exception {
		String query = "SELECT FECHA,MASCOTA,MEDICO,MOTIVO,SINTOMATOLOGIA,PROCEDIMIENTO,MEDICAMENTO,ORDEN,VACUNACION,ALERGIA,DETALLES_PROCEDIMIENTO,DIAGNOSIS,MEDICATIONDOSAGE,ORDERCANCELATION FROM  HISTORIA WHERE MASCOTA = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setLong(1, historyDto.getIdPet().getIdPet());
		ResultSet resulSet = preparedStatement.executeQuery();
		
		List<HistoryDto> historys = new ArrayList<HistoryDto>();
		while (resulSet.next()) {
			HistoryDto resultHistoryDto = new HistoryDto();
			PetDto petDto = new PetDto(resulSet.getLong("MASCOTA")); 
			PersonDto personDto = new PersonDto(resulSet.getLong("MEDICO")); 
			OrderDto orderDto = new OrderDto(resulSet.getLong("MEDICO"));
			resultHistoryDto.setAdmissionDate(resulSet.getLong("FECHA"));
			resultHistoryDto.setIdPet(petDto);
			resultHistoryDto.setVet(personDto);
			resultHistoryDto.setReason(resulSet.getString("MOTIVO"));
			resultHistoryDto.setSymptomatology(resulSet.getString("SINTOMATOLOGIA"));
			resultHistoryDto.setProcedure(resulSet.getString("PROCEDIMIENTO"));
			resultHistoryDto.setMedicine(resulSet.getString("MEDICAMENTO"));;
			resultHistoryDto.setIdOrder(orderDto);
			resultHistoryDto.setVaccinationHistory(resulSet.getString("VACUNACION"));
			resultHistoryDto.setMedicinesAllegic(resulSet.getString("ALERGIA"));
			resultHistoryDto.setProceduredetail(resulSet.getString("DETALLES_PROCEDIMIENTO"));
			resultHistoryDto.setDiagnosis(resulSet.getString("DIAGNOSIS"));
			resultHistoryDto.setMedicationDosage(resulSet.getString("MEDICATIONDOSAGE"));
			resultHistoryDto.setOrderCancelation(resulSet.getInt("ORDERCANCELATION"));;
			historys.add(resultHistoryDto);
		}
		resulSet.close();
		preparedStatement.close();
		return historys;
	}

}
