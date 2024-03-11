package app.models;

import java.sql.Date;

public class History {
	private Date admissionDate = new Date(System.currentTimeMillis());
	private Pet idPet;
	private Person vet;
	private String reason;
	private String symptomatology;
	private String diagnosis;
	private String procedure;
	private String medicine;
	private String medicationDosage;
	private Order idOrder;
	private String vaccinationHistory;
	private String medicinesAllegic;
	private String proceduredetail;
	private int ordercancelation = 0;
	
	public Date getAdmissionDate() {
		return admissionDate;
	}
	public Pet getIdPet() {
		return idPet;
	}
	public void setIdPet(Pet idPet) {
		this.idPet = idPet;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getSymptomatology() {
		return symptomatology;
	}
	public void setSymptomatology(String symptomatology) {
		this.symptomatology = symptomatology;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getProcedure() {
		return procedure;
	}
	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}
	public String getMedicine() {
		return medicine;
	}
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	public String getMedicationDosage() {
		return medicationDosage;
	}
	public void setMedicationDosage(String medicationDosage) {
		this.medicationDosage = medicationDosage;
	}
	public Order getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(Order idOrder) {
		this.idOrder = idOrder;
	}
	public String getVaccinationHistory() {
		return vaccinationHistory;
	}
	public void setVaccinationHistory(String vaccinationHistory) {
		this.vaccinationHistory = vaccinationHistory;
	}
	public String getMedicinesAllegic() {
		return medicinesAllegic;
	}
	public void setMedicinesAllegic(String medicinesAllegic) {
		this.medicinesAllegic = medicinesAllegic;
	}
	public Person getVet() {
		return vet;
	}
	public void setVet(Person vet) {
		this.vet = vet;
	}
	public String getProceduredetail() {
		return proceduredetail;
	}
	public void setProceduredetail(String proceduredetail) {
		this.proceduredetail = proceduredetail;
	}
	public int getOrdercancelation() {
		return ordercancelation;
	}
	public void setOrdercancelation(int ordercancelation) {
		this.ordercancelation = ordercancelation;
	}
    	
	
}
