package app.controller;

import java.util.Scanner;

import app.Validators.HistoryInputsValidator;
import app.Validators.PersonInputsValidator;
import app.Validators.PetInputsValidator;
import app.Validators.SaleInputsValidator;
import app.dto.HistoryDto;
import app.dto.OrderDto;
import app.dto.PersonDto;
import app.dto.PetDto;
import app.dto.SaleDto;
import app.service.AdministratorService;
import app.service.SellerService;
import app.service.VetService;
import app.service.VeterinaryService;

public class DominioController {
	PersonInputsValidator personInputsValidator = new PersonInputsValidator();
	PetInputsValidator petInputsValidator = new PetInputsValidator();
	HistoryInputsValidator historyInputsValidator = new HistoryInputsValidator();
	SaleInputsValidator saleInputsValidator = new SaleInputsValidator();
	private static Scanner reader = new Scanner(System.in);
	private static AdministratorService administratorService = new VeterinaryService();
	private static VetService vetService = new VeterinaryService();
	private static SellerService sellerService = new VeterinaryService();
	private static final String MENUADMIN = "1. Crear usuario \n2. Cerrar sesion";
	private static final String MENUVET = "1. Crear dueño \n2. Crear Mascota \n3. Atender Mascota \n4. Consultar Historia Clinica \n5. Listado Ordenes \n6. Anular Orden \n7. Cerrar sesion";
	private static final String MENUSELLER = "1. Consultar Ordenes \n2. Facturar Orden \n3. Cerrar Sesion";

	// SESION ADMIN
	public void sessionAdmin() {
		boolean runApp = true;
		while (runApp) {
			try {
				System.out.println("==========INGRESE=============");
				System.out.println(MENUADMIN);
				System.out.println("==============================");
				String option = reader.nextLine();
				runApp = menuAdmin(option);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}

	private boolean menuAdmin(String option) throws Exception {
		switch (option) {
		case "1": {
			createUser();
			return true;
		}
		case "2": {
			return false;
		}
		default: {
			System.out.println("ingrese una opcion valida");
			return true;
		}
		}
	}

	public void createUser() throws Exception {
		System.out.println("==============================");
		System.out.println("Ingresa la cedula");
		Long id = personInputsValidator.idValidator(reader.nextLine());

		System.out.println("Ingresa el nombre completo");
		String fullName = reader.nextLine();
		personInputsValidator.fullNameValidator(fullName);

		System.out.println("Ingresa la edad");
		int age = personInputsValidator.ageValidator(reader.nextLine());

		System.out.println("ingrese el rol (Admin,Vet,Seller)");
		String role = reader.nextLine();
		personInputsValidator.rollValidator(role);

		System.out.println("ingrese nombre de usuario");
		String userName = reader.nextLine();
		personInputsValidator.fullNameValidator(userName);

		System.out.println("ingrese la contraseña");
		String password = reader.nextLine();
		personInputsValidator.fullNameValidator(password);

		PersonDto personDto = new PersonDto(id, fullName, age, role, userName, password);
		administratorService.createUserWithRole(personDto);
	}

	// SESSION VET
	public void sessionVet() {
		boolean runApp = true;
		while (runApp) {
			try {
				System.out.println("==========INGRESE=============");
				System.out.println(MENUVET);
				System.out.println("==============================");
				String option = reader.nextLine();
				runApp = menuVet(option);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}

	private boolean menuVet(String option) throws Exception {
		switch (option) {
		case "1": {
			createOwnerUser();
			return true;
		}
		case "2": {
			createPet();
			return true;
		}
		case "3": {
			createHistoryClinic();
			return true;
		}
		case "4": {
			findHistoryClinic();
			return true;
		}
		case "5": {
			findOrders();
			return true;
		}
		case "6": {
			cancelOrders();
			return true;
		}
		case "7": {
			return false;
		}
		default: {
			System.out.println("ingrese una opcion valida");
			return true;
		}
		}
	}

	public void createOwnerUser() throws Exception {
		System.out.println("==============================");
		System.out.println("Ingresa la cedula");
		Long id = personInputsValidator.idValidator(reader.nextLine());
		System.out.println("Ingresa el nombre completo");
		String fullName = reader.nextLine();
		personInputsValidator.fullNameValidator(fullName);
		System.out.println("Ingresa la edad");
		int age = personInputsValidator.ageValidator(reader.nextLine());
		String role = "Owner";
		String userName = "N/A";
		String password = "N/A";
		PersonDto personDto = new PersonDto(id, fullName, age, role, userName, password);
		vetService.createOwnerUser(personDto);
	}

	public void createPet() throws Exception {
		System.out.println("==============INGRESO DE MASCOSTA================");
		System.out.println("Ingresa el nombre de la mascota");
		String namePet = reader.nextLine();
		petInputsValidator.namePetValidator(namePet);
		System.out.println("Ingresa el documento del dueño");
		Long ownerDoct = petInputsValidator.idValidator(reader.nextLine());
		PersonDto personDto = new PersonDto(ownerDoct);
		System.out.println("Ingresa la edad");
		int agePet = petInputsValidator.agePetValidator(reader.nextLine());
		System.out.println("ingrese la especie (Perro,Gato,Pez,Ave)");
		String specie = reader.nextLine();
		petInputsValidator.specieValidator(specie);
		System.out.println("ingrese la raza");
		String race = reader.nextLine();
		petInputsValidator.raceValidator(specie);
		System.out.println("ingrese las caracteristicas (color,tamaño)");
		String characteristic = reader.nextLine();
		petInputsValidator.characteristicValidator(characteristic);
		System.out.println("Ingresa el peso en KLS");
		int weight = petInputsValidator.agePetValidator(reader.nextLine());
		PetDto petDto = new PetDto(namePet, agePet, specie, race, characteristic, weight);
		petDto.setOwnerDocument(personDto);
		vetService.createPet(petDto);
	}

	public void createHistoryClinic() throws Exception {
		long actualDate = System.currentTimeMillis();
		System.out.println("==============INGRESO DE HISTORIA CLINICA================");
		System.out.println("Ingresa el id de la mascota");
		long idPet = historyInputsValidator.idValidator(reader.nextLine());
		PetDto petDto = new PetDto(idPet);
		System.out.println("Ingresa la razon de la consulta");
		String reason = reader.nextLine();
		historyInputsValidator.reasonValidator(reason);
		System.out.println("Ingresa la sintomatologia");
		String symptomatology = reader.nextLine();
		historyInputsValidator.symptomatologyValidator(symptomatology);
		System.out.println("Ingresa el diagnostico");
		String diagnosis = reader.nextLine();
		historyInputsValidator.diagnosisValidator(diagnosis);
		System.out.println("Genera Procedimiento? \n 1. SI \n 2. NO");
		String optProcedure = reader.nextLine();
		String procedure = "";
		switch (optProcedure) {
		case "1": {
			System.out.println("Ingrese el procedimiento");
			procedure = reader.nextLine();
			historyInputsValidator.procedureValidator(procedure);
			
			break;
		}
		case "2": {
			procedure = "N/A";
			break;
		}
		default: {
			System.out.print("Ingrese una opción válida");
			break;
		}
		}

		System.out.println("Necesita Medicamentos ? \n 1. SI \n 2. NO");
		String optMedicine = reader.nextLine();
		String medicine = "";
		String medicationDosage = "";
		OrderDto idOrder = null;
		switch (optMedicine) {
		case "1": {
			System.out.println("Ingrese la medicina");
			medicine = reader.nextLine();
			historyInputsValidator.medicineValidator(medicine);

			System.out.println("Ingrese la dosis de la medicina");
			medicationDosage = reader.nextLine();
			historyInputsValidator.medicationDosageValidator(medicationDosage);
			idOrder = createOrder(petDto, medicine, medicationDosage);
			break;
		}
		case "2": {
			medicine = "N/A";
			medicationDosage = "N/A";
			idOrder = null;
			break;
		}
		default: {
			System.out.print("ingrese una opcion valida");
			break;
		}
		}
		System.out.println("Se realizo vacunacion ? \n 1. SI \n 2. NO");
		String optVaccination = reader.nextLine();
		String vaccinationHistory = "";
		switch (optVaccination) {
		case "1": {
			System.out.println("Ingresa la historia de vacunacion");
			vaccinationHistory = reader.nextLine();
			historyInputsValidator.vaccinationHistoryValidator(vaccinationHistory);
			break;
		}
		case "2": {
			vaccinationHistory = "N/A";
			break;
		}
		default: {
			System.out.print("ingrese una opcion valida");
			break;
		}
		}
		System.out.println("Presenta alergia a medicamentos ? \n 1. SI \n 2. NO");
		String optMedicinesAllegic = reader.nextLine();
		String medicinesAllegic = "";
		switch (optMedicinesAllegic) {
		case "1": {
			System.out.println("Ingresa los mendicamentos");
			medicinesAllegic = reader.nextLine();
			historyInputsValidator.medicineValidator(medicinesAllegic);
			break;
		}
		case "2": {
			medicinesAllegic = "N/A";
			break;
		}
		default: {
			System.out.print("ingrese una opcion valida");
			break;
		}
		}
		System.out.println("Ingresa el detalle del procedimiento realizado");
		String proceduredetail = reader.nextLine();
		historyInputsValidator.proceduredetailValidator(proceduredetail);
		int orderCancelation = 0;
		HistoryDto historyDto = new HistoryDto();
		historyDto.setAdmissionDate(actualDate);
		historyDto.setIdPet(petDto);
		historyDto.setReason(reason);
		historyDto.setSymptomatology(symptomatology);
		historyDto.setDiagnosis(diagnosis);
		historyDto.setProcedure(procedure);
		historyDto.setMedicine(medicine);
		historyDto.setMedicationDosage(medicationDosage);
		historyDto.setIdOrder(idOrder);
		historyDto.setVaccinationHistory(vaccinationHistory);
		historyDto.setMedicinesAllegic(medicinesAllegic);
		historyDto.setProceduredetail(proceduredetail);
		historyDto.setOrderCancelation(orderCancelation);
		vetService.createHistoryClinic(historyDto);

	}

	public OrderDto createOrder(PetDto petDto, String medicine, String medicationDosage) throws Exception {
		OrderDto orderDto = new OrderDto();
		orderDto.setIdPet(petDto);
		orderDto.setMedicationAndDosage(medicine + " - " + medicationDosage);
		long idOrder = vetService.createOrder(orderDto);
		orderDto.setIdOrder(idOrder);
		System.out.println("Se genero a la Orden con el id: " + idOrder);
		return orderDto;
	}

	public void findHistoryClinic() throws Exception {
		System.out.println("==============INGRESO DE DATOS================");
		System.out.println("Ingresa el id de la mascota");
		long idPet = historyInputsValidator.idValidator(reader.nextLine());
		PetDto petDto = new PetDto(idPet);
		HistoryDto historyDto = new HistoryDto();
		historyDto.setIdPet(petDto);
		vetService.findHistoryClinic(historyDto);
	}

	public void findOrders() throws Exception {
		System.out.println("==============ORDENES================");
		vetService.findOrders();
	}
	
	public void cancelOrders() throws Exception{
		System.out.println("================ANULACION===============");
		System.out.println("Ingresa el id de la Orden");
		long idOrder = historyInputsValidator.idValidator(reader.nextLine());
		OrderDto orderDto = new OrderDto(idOrder);
		HistoryDto historyDto = new HistoryDto();
		historyDto.setIdOrder(orderDto);
		vetService.cancelOrder(orderDto);
		
	}
	
	// SESSION SELLER
		public void sessionSeller() {
			boolean runApp = true;
			while (runApp) {
				try {
					System.out.println("==========INGRESE=============");
					System.out.println(MENUSELLER);
					System.out.println("==============================");
					String option = reader.nextLine();
					runApp = menuSeller(option);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}
		}
		
		private boolean menuSeller(String option) throws Exception {
			switch (option) {
			case "1": {
				findOrders();
				return true;
			}
			case "2": {
				createSale();
				return true;
			}
			case "3": {
				return false;
			}
			default: {
				System.out.println("ingrese una opcion valida");
				return true;
			}
			}
		}
		
		public void createSale()  throws Exception{
			System.out.println("================ANULACION===============");
			System.out.println("Ingresa el id de la Orden");
			long idOrder = historyInputsValidator.idValidator(reader.nextLine());
			OrderDto orderDto = new OrderDto(idOrder);
			System.out.println("Ingresa el nombre del producto");
			String productName = reader.nextLine();
			saleInputsValidator.productNameValidator(productName);
			System.out.println("Ingresa el cantidad");
			int amount = saleInputsValidator.amountValidator(reader.nextLine());
			System.out.println("Ingresa el precio");
			double price = saleInputsValidator.priceValidator(reader.nextLine());
			SaleDto saleDto = new SaleDto();
			saleDto.setIdOrder(orderDto);
			saleDto.setProductName(productName);
			saleDto.setAmount(amount);
			saleDto.setPrice(price);
			sellerService.createSale(saleDto);
		}

		
	

}
