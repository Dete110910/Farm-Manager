package models;

public enum PlantSpecie {
	
	POTATO("Papa", 6), VETCH("Arveja", 4), BEANS("Frijol",4), CORN("Maíz", 9);
	
	private String label;
	private int  maximunDuration;
	
	private PlantSpecie(String label, int maximunDuration) {
		this.label = label;
		this.maximunDuration = maximunDuration;
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public int getMaximunDuration() {
		return this.maximunDuration;
	}

}
