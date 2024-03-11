package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.config.MYSQLConnection;
import app.dto.PetDto;
import app.dto.SessionDto;

public class PetDaoImpl implements PetDao{
	public Connection connection = MYSQLConnection.getConnection();
	@Override
	public void createPet(PetDto petDto) throws Exception {
		String query = "INSERT INTO MASCOTA(PROPIETARIO,NOMBRE,EDAD,PESO,RAZA,ESPECIE,CARACTERISTICAS) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		int i = 1;
		preparedStatement.setLong(i++, petDto.getOwnerDocument().getId());
		preparedStatement.setString(i++, petDto.getNamePet());
		preparedStatement.setInt(i++, petDto.getAgePet());
		preparedStatement.setInt(i++, petDto.getWeight());
		preparedStatement.setString(i++, petDto.getRace());
		preparedStatement.setString(i++, petDto.getSpecies());
		preparedStatement.setString(i++, petDto.getCharacteristics());
		preparedStatement.execute();
	}
	@Override
	public long findOwnerPetById(PetDto petDto) throws Exception {
		String query = "SELECT PROPIETARIO FROM MASCOTA WHERE ID = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setLong(1, petDto.getIdPet());
		ResultSet resulSet = preparedStatement.executeQuery();
		if (resulSet.next()) {
			long id = resulSet.getLong("PROPIETARIO");
			resulSet.close();
			preparedStatement.close();
			return id;
		}
		resulSet.close();
		preparedStatement.close();
		return (Long) null;
	}

}
