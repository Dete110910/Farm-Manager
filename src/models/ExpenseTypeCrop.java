package models;

public enum ExpenseTypeCrop {
	
	SOWING("Siembra"), CARE("Cuidados"), PREPARATION_GROUND("P. tierra"), HARVEST("Cosecha");
	
	private String label;
	
	private ExpenseTypeCrop(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return this.label;
	}

}
