package app.dao;

import app.dto.OrderDto;

public interface OrderDao {
	public long createOrder(OrderDto orderDto) throws Exception;
}
