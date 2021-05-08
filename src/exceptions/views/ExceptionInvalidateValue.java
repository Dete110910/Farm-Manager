package exceptions.views;

public class ExceptionInvalidateValue extends NumberFormatException{
	
	private static final long serialVersionUID = 1L;
	
	public static final String MESSAGE =  "El valor ingresado no es correcto, intente nuevamente";
	
	public ExceptionInvalidateValue() {
		super(MESSAGE);
	}

}
