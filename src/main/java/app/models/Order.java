package app.models;

import java.sql.Date;

public class Order {
    private long idOrder;
    private Pet idPet;
    private Person ownerDocument;
    private Person vetDocument;
    private String medicationAndDosage;
    private Date generationDate = new Date(System.currentTimeMillis());
    
	public long getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(long idOrder) {
		this.idOrder = idOrder;
	}
	public Pet getIdPet() {
		return idPet;
	}
	public void setIdPet(Pet idPet) {
		this.idPet = idPet;
	}
	public Person getOwnerDocument() {
		return ownerDocument;
	}
	public void setOwnerDocument(Person ownerDocument) {
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
	public Person getVetDocument() {
		return vetDocument;
	}
	public void setVetDocument(Person vetDocument) {
		this.vetDocument = vetDocument;
	}
	
    
}
