package app.Validators;

public class SaleInputsValidator  extends InputsValidator {
	public long idValidator(String number) throws Exception {
		return super.longValidator(number, "id");
	}
	public void productNameValidator(String reason) throws Exception {
		super.stringValidator(reason, "Nombre del producto ");
	}
	public int amountValidator(String number) throws Exception {
		return super.integerValidator(number, "Cantidad");
	}
	public double priceValidator(String date) throws Exception{
		 return super.doubleValidator(date, "Fecha incorrecta");
	}
}
