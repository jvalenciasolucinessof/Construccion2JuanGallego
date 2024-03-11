package app.service;

import app.dto.HistoryDto;
import app.dto.OrderDto;
import app.dto.PersonDto;
import app.dto.PetDto;

public interface VetService {
	public void createOwnerUser(PersonDto personDto) throws Exception;
	public void createPet(PetDto petDto) throws Exception;
	public long createOrder(OrderDto orderDto) throws Exception;
	public void createHistoryClinic(HistoryDto historyDto) throws Exception;

}
