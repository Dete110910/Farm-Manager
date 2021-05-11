package models;

public enum ExpenseTypeCorral {
	
	FEEDING("Alimentaci�n"), CARE("Cuidados"), INFRAESTRUCTURE("Vivienda");
	
	private String label; 
	
	private ExpenseTypeCorral(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
}
