package models;

public enum TypeBovine {
	
	DAIRY_CATTLE("Vaca lechera", 14), FATTENING_CATTLE("Ganado de engorde", 14), LEVANT_CATTLE("Ganado de levante", 6), BABY_CATTLE("Ganado sin destetar", 0);
	
	private TypeBovine(String label, int minimumAge) {
		this.label = label;
		this.minimumAge = minimumAge;
	}
	private String label;
	private int minimumAge;
	
	public String getLabel() {
		return this.label;
	}
	
	public int getMinimumAge() {
		return this.minimumAge;
	}
}