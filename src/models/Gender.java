package models;

public enum Gender {
	
	MALE("Macho"), FEMALE("Hembra");
	
	private String label;
	
	private Gender(String labelIn) {
		this.label = labelIn;
	}
	
	public String getLabel() {
		return label;
	}
	
	

}
