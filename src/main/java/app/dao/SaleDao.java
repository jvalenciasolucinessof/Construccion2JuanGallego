package app.dao;

import app.dto.SaleDto;

public interface SaleDao {
	public void createSale(SaleDto saleDto) throws Exception;

}
