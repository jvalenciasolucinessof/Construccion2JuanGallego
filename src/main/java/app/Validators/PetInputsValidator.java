package app.Validators;

public class PetInputsValidator  extends InputsValidator {
	public long idValidator(String number) throws Exception {
		return super.longValidator(number, "id");
	}
	public void namePetValidator(String namePet) throws Exception {
		super.stringValidator(namePet, "nombre de la mascota");
	}
	public int agePetValidator(String number) throws Exception {
		return super.integerValidator(number, "edad de la mascota");
	}
	public int ownerDoucumentValidator(String document) throws Exception {
		return super.integerValidator(document, "Documento del dueño");
	}
	public void specieValidator(String specie) throws Exception {
		super.stringValidator(specie, "Especie ");
	}
	public void raceValidator(String race) throws Exception {
		super.stringValidator(race, "Especie ");
	}
	public void characteristicValidator(String characteristic) throws Exception {
		super.stringValidator(characteristic, "Caracteristicas ");
	}
	public int weightValidator(String weight) throws Exception {
		return super.integerValidator(weight, "Peso");
	}
}
