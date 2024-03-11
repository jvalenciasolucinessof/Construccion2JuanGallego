package app.models;

public class Sale {
	private String admissionDate;
	private Person doctor;
	private String reason;
	private String symptomatology;
	private String diagnosis;
	private String procedure = null;
	private String medicine = null;
	private String medicationDosage = null;
	private Order idOrder = null;
	private String vaccinationHistory = null;
	private String medicinesAllegic = null;
	
	
	public String getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}
	public Person getDoctor() {
		return doctor;
	}
	public void setDoctor(Person doctor) {
		this.doctor = doctor;
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
	
	
}
