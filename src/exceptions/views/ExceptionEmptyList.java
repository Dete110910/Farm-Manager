package exceptions.views;

public class ExceptionEmptyList extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public static final String MESSAGE = "\n***Aún no hay elementos en esta lista***\n";
	
	public ExceptionEmptyList() {
		super(MESSAGE);
	}
}
