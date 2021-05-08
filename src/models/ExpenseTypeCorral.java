package models;

public enum ExpenseTypeCorral {
	
	FEEDING("Alimentación"), CARE("Cuidados"), INFRAESTRUCTURE("Vivienda");
	
	private String label; 
	
	private ExpenseTypeCorral(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}
	
}
