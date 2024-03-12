package app.Validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class InputsValidator {
	public void stringValidator(String string, String element) throws Exception {
		if (string == null || string.equals("")) {
			throw new Exception(element + " no es un valor valido");
		}
	}

	public int integerValidator(String number, String element) throws Exception {
		stringValidator(number, element);
		try {
			return Integer.parseInt(number);
		} catch (Exception e) {
			throw new Exception(element + " no es un numero valido");
		}
	}

	public long longValidator(String number, String element) throws Exception {
		stringValidator(number, element);
		try {
			return Long.parseLong(number);
		} catch (Exception e) {
			throw new Exception(element + " no es un numero valido");
		}
	}
	
	public double doubleValidator(String number, String element) throws Exception {
		stringValidator(number, element);
		try {
			return Double.parseDouble(number);
		} catch (Exception e) {
			throw new Exception(element + " no es un numero valido");
		}
	}
	
	public java.sql.Date dateValidator(String dateHistory, String element) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaDate;
		try {
			fechaDate = dateFormat.parse(dateHistory);
		} catch (ParseException e) {
			throw new Exception(element+" incorrecta. Asegúrate de usar el formato YYYY-MM-DD.");
		}
		java.sql.Date sqlDate = new java.sql.Date(fechaDate.getTime());
		return sqlDate;
	}

}
