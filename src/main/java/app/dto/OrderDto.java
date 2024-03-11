package app.dto;

import java.sql.Date;

import app.models.Person;

public class OrderDto {
    private long idOrder;
    private PetDto idPet;
    private PersonDto ownerDocument;
    private PersonDto vetDocument;
    private String medicationAndDosage;
    private Date generationDate = new Date(System.currentTimeMillis());
    
	public long getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(long idOrder) {
		this.idOrder = idOrder;
	}
	public PetDto getIdPet() {
		return idPet;
	}
	public void setIdPet(PetDto idPet) {
		this.idPet = idPet;
	}
	public PersonDto getOwnerDocument() {
		return ownerDocument;
	}
	public void setOwnerDocument(PersonDto ownerDocument) {
		this.ownerDocument = ownerDocument;
	}
	public String getMedicationAndDosage() {
		return medicationAndDosage;
	}
	public void setMedicationAndDosage(String medicationAndDosage) {
		this.medicationAndDosage = medicationAndDosage;
	}
	public Date getGenerationDate() {
		return generationDate;
	}

	public PersonDto getVetDocument() {
		return vetDocument;
	}
	public void setVetDocument(PersonDto vetDocument) {
		this.vetDocument = vetDocument;
	}
	
    
}
