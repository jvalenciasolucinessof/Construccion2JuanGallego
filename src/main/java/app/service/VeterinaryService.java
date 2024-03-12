package app.service;

import java.util.Arrays;
import java.util.List;

import app.dao.HistoryDao;
import app.dao.HistoryDaoImpl;
import app.dao.LoginDao;
import app.dao.LoginDaoImpl;
import app.dao.OrderDao;
import app.dao.OrderDaoImpl;
import app.dao.PersonDao;
import app.dao.PersonDaoImpl;
import app.dao.PetDao;
import app.dao.PetDaoImpl;
import app.dto.HistoryDto;
import app.dto.OrderDto;
import app.dto.PersonDto;
import app.dto.PetDto;
import app.dto.SessionDto;

public class VeterinaryService implements AdministratorService, VetService, LoginService {
	List<String> roles = Arrays.asList("Admin", "Vet", "Owner", "Seller");
	List<String> speciesPet = Arrays.asList("Perro", "Gato", "Pez", "Ave");
	private static long sessionId = 0L;

	private void createUser(PersonDto personDto) throws Exception {
		if (!roles.contains(personDto.getRoll())) {
			throw new Exception("El rol no es valido");
		}
		PersonDao personDao = new PersonDaoImpl();
		if (personDao.findUserExist(personDto)) {
			throw new Exception("Ya existe usuario con esa cedula");
		}
		if (personDto.getRoll() != "Owner") {
			if (personDao.existUserByUserName(personDto)) {
				throw new Exception("Ya existe el usuario");
			}
		}
		personDao.createPerson(personDto);

	}

	@Override
	public void setSesionID(long sesionId) {
		sessionId = sesionId;
	}

	@Override
	public void login(PersonDto personDto) throws Exception {
		PersonDao personDao = new PersonDaoImpl();
		PersonDto personDtoValidate = personDao.findUserByUserName(personDto);
		if (personDtoValidate == null) {
			throw new Exception("Usuario no valido");
		}
		if (!personDto.getPassword().equals(personDtoValidate.getPassword())) {
			throw new Exception("Usuario o contraseña incorrecta");
		}
		personDto.setRoll(personDtoValidate.getRoll());
		LoginDao loginDao = new LoginDaoImpl();
		SessionDto sessionDto = loginDao.login(personDtoValidate);
		setSesionID(sessionDto.getId());
	}

	@Override
	public void logout() throws Exception {
		LoginDao loginDao = new LoginDaoImpl();
		loginDao.logout(sessionId);
		setSesionID(0);
	}

	@Override
	public void createUserWithRole(PersonDto personDto) throws Exception {
		createUser(personDto);
	}

	@Override
	public void createOwnerUser(PersonDto personDto) throws Exception {
		createUser(personDto);
	}

	@Override
	public void createPet(PetDto petDto) throws Exception {
		LoginDao loginDao = new LoginDaoImpl();
		SessionDto sessionDto = loginDao.findSessionById(sessionId);
		if (sessionDto == null) {
			throw new Exception("no hay una sesion valida");
		}
		PersonDao personDao = new PersonDaoImpl();
		PersonDto personDto = new PersonDto(petDto.getOwnerDocument().getId());
		personDto = personDao.findUserById(personDto);
		if (personDto == null) {
			throw new Exception("no hay un dueño valido");
		}
		if (!speciesPet.contains(petDto.getSpecies())) {
			throw new Exception("La Especie no es valida");
		}
		PetDao petDao = new PetDaoImpl();
		petDao.createPet(petDto);
	}

	@Override
	public long createOrder(OrderDto orderDto) throws Exception {
		LoginDao loginDao = new LoginDaoImpl();
		SessionDto sessionDto = loginDao.findSessionById(sessionId);
		if (sessionDto == null) {
			throw new Exception("no hay una sesion valida");
		}
		PersonDao personDao = new PersonDaoImpl();
		PersonDto personDto = new PersonDto(sessionDto.getUserName(), "");
		personDto = personDao.findUserByUserName(personDto);
		if (personDto == null) {
			throw new Exception("no hay un usuario valido");
		}
		orderDto.setVetDocument(personDto);
		PetDao petDao = new PetDaoImpl();
		PersonDto ownerDocument = new PersonDto(petDao.findOwnerPetById(orderDto.getIdPet()));
		orderDto.setOwnerDocument(ownerDocument);
		OrderDao orderDao = new OrderDaoImpl();
		long idOrder = orderDao.createOrder(orderDto);
		return idOrder;
	}

	@Override
	public void createHistoryClinic(HistoryDto historyDto) throws Exception {
		LoginDao loginDao = new LoginDaoImpl();
		SessionDto sessionDto = loginDao.findSessionById(sessionId);
		if (sessionDto == null) {
			throw new Exception("no hay una sesion valida");
		}
		PersonDao personDao = new PersonDaoImpl();
		PersonDto personDto = new PersonDto(sessionDto.getUserName(), "");
		personDto = personDao.findUserByUserName(personDto);
		if (personDto == null) {
			throw new Exception("no hay un usuario valido");
		}
		historyDto.setVet(personDto);
		PetDao petDao = new PetDaoImpl();
		if (!petDao.findPetById(historyDto.getIdPet())) {
			throw new Exception("no hay una mascota valida");
		}
		HistoryDao historyDao = new HistoryDaoImpl();
		historyDao.createHistory(historyDto);
	}

	@Override
	public void findHistoryClinic(HistoryDto historyDto) throws Exception {
		PetDao petDao = new PetDaoImpl();
		if (!petDao.findPetById(historyDto.getIdPet())) {
			throw new Exception("no hay una mascota valida");
		}
		HistoryDao historyDao = new HistoryDaoImpl();
		List<HistoryDto> resultHistoryDto = historyDao.findHistory(historyDto);
		if (resultHistoryDto.size() == 0) {
			throw new Exception("no hay un historia clinica");
		}
		for (int i = 0; i < resultHistoryDto.size(); i++) {
			resultHistoryDto.get(i).showHistorys();
		}
	}

	@Override
	public void findOrders() throws Exception {
		OrderDao orderDao = new OrderDaoImpl();
		List<OrderDto> resultOrders = orderDao.findOrders();
		if (resultOrders.size() == 0) {
			throw new Exception("no hay un historia clinica, o ya estan anuladas");
		}
		for (int i = 0; i < resultOrders.size(); i++) {
			resultOrders.get(i).showOrders();
		}
	}

	@Override
	public void cancelOrder(OrderDto orderDto) throws Exception {
		OrderDao orderDao = new OrderDaoImpl();
		if (!orderDao.findOrderById(orderDto)) {
			throw new Exception("no hay una orden valida");
		}
		orderDao.cancelOrder(orderDto);

	}

}
