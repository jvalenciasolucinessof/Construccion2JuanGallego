package app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import app.config.MYSQLConnection;
import app.dto.SaleDto;

public class SaleDaoImpl implements SaleDao  {
	public Connection connection = MYSQLConnection.getConnection();

	@Override
	public void createSale(SaleDto saleDto) throws Exception {
		String query = "INSERT INTO FACTURA(MASCOTA,PROPIETARIO,PRODUCTO,VALOR,CANTIDAD,FECHA) VALUES (?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		int i = 1;
		preparedStatement.setLong(i++, saleDto.getIdPet().getIdPet());
		preparedStatement.setLong(i++, saleDto.getOwnerDocument().getId());
		preparedStatement.setString(i++, saleDto.getProductName());
		preparedStatement.setDouble(i++, saleDto.getPrice());
		preparedStatement.setInt(i++, saleDto.getAmount());
		preparedStatement.setDate(i++, saleDto.getDate());
		preparedStatement.execute();
		preparedStatement.close();
	}
}
