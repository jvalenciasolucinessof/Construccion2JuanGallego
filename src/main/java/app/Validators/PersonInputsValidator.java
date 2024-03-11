package app.Validators;

public class PersonInputsValidator extends InputsValidator {
	public long idValidator(String number) throws Exception {
		return super.longValidator(number, "id usuario");
	}
	public void fullNameValidator(String fullname) throws Exception {
		super.stringValidator(fullname, "nombre de usuario");
	}
	public int ageValidator(String number) throws Exception {
		return super.integerValidator(number, "edad del usuario");
	}
	public void rollValidator(String roll) throws Exception {
		super.stringValidator(roll, "rol de usuario");
	}
	
	public void userNameValidator(String userName) throws Exception {
		super.stringValidator(userName, "usuario ");
	}
	public void passwordValidator(String password) throws Exception {
		super.stringValidator(password, "contraseña de usuario ");
	}

}
