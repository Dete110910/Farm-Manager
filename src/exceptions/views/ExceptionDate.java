package exceptions.views;

public class ExceptionDate extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public static final String MESSAGE = "La fecha no ha sido ingresada correctamente. Por favor, intente nuevamente siguiendo el formato dado.";
	
	public ExceptionDate() {
		super(MESSAGE);
	}
}
