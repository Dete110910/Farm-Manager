package models;

public enum TypeBovine {
	
	DAIRY_CATTLE("Vaca lechera"), FATTENING_CATTLE("Ganado de engorde"), LEVANT_CATTLE("Ganado de levante"), BABY_CATTLE("Ganado beb�");
	
	private TypeBovine(String label) {
		this.label = label;
	}
	private String label;
	
	public String getLabel() {
		return this.label;
	}
}
