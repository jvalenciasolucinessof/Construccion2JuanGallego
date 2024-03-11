package app.service;

import app.dto.PersonDto;

public interface AdministratorService {
	public void createUserWithRole(PersonDto personDto) throws Exception;

}
