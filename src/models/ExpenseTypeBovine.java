package models;

public enum ExpenseTypeBovine {
	
	FEEDING("Alimentaci�n"), VACCINE("Vacuna"), FENCE("Valla"), CARE("Cuidados");
	
	private String label;
	
	private ExpenseTypeBovine(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return this.label;
	}

}
