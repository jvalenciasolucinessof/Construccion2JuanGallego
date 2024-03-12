package app.dto;

import java.sql.Date;

public class OrderDto {
	private long idOrder;
	private PetDto idPet;
	private PersonDto ownerDocument;
	private PersonDto vetDocument;
	private String medicationAndDosage;
	private Date generationDate;

	public OrderDto() {
		this.generationDate = new Date(System.currentTimeMillis());
	}

	public OrderDto(long idOrder) {
		this.idOrder = idOrder;
	}

	public void setGenerationDate(Date generationDate) {
		this.generationDate = generationDate;
	}

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

	public void showOrders() {
		System.out.println("==========================================");
		System.out.println(" Id Orden: "+this.idOrder+
				"\n Id mascota: "+this.idPet.getIdPet()+
				"\n Id dueño: "+this.ownerDocument.getId()+
				"\n Id vaterinario: "+this.vetDocument.getId()+
				"\n Medicamento y dosis: "+this.medicationAndDosage+
				"\n Fecha: "+this.generationDate);
		System.out.println("==========================================");
	}

}
