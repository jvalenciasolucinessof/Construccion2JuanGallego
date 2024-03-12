package app.Validators;

import java.sql.Date;

public class HistoryInputsValidator  extends InputsValidator {
	public long idValidator(String number) throws Exception {
		return super.longValidator(number, "id");
	}
	public void reasonValidator(String reason) throws Exception {
		super.stringValidator(reason, "razon");
	}
	public void symptomatologyValidator(String symptomatology) throws Exception {
		super.stringValidator(symptomatology, "sintomatologia");
	}
	public void diagnosisValidator(String diagnosis) throws Exception {
		super.stringValidator(diagnosis, "Diagnostico");
	}
	public void procedureValidator(String procedure) throws Exception {
		super.stringValidator(procedure, "Procedimiento");
	}
	public void medicineValidator(String medicine) throws Exception {
		super.stringValidator(medicine, "Medicamento");
	}
	public void medicationDosageValidator(String medicationDosage) throws Exception {
		super.stringValidator(medicationDosage, "Dosis de medicamento");
	}
	public void vaccinationHistoryValidator(String vaccinationHistory) throws Exception {
		super.stringValidator(vaccinationHistory, "Historico de vacunacion");
	}
	public void medicinesAllegicValidator(String medicinesAllegic) throws Exception {
		super.stringValidator(medicinesAllegic, "Alergia medicina ");
	}
	public void proceduredetailValidator(String proceduredetail) throws Exception {
		super.stringValidator(proceduredetail, "Detalle del procemiento");
	}
	public int orderCancelationValidator(String number) throws Exception {
		return super.integerValidator(number, "Cancelacion de orden");
	}
	public Date admissionDateValidator(String date) throws Exception{
		 return super.dateValidator(date, "Fecha incorrecta");
	}
}
