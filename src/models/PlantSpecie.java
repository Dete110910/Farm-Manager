package models;

public enum PlantSpecie {
	
	POTATO("Papa", 180, 0.06), VETCH("Arveja", 120, 0.0015), BEANS("Frijol", 120, 0.0015), CORN("Maíz", 270, 0.002);
	
	private String label;
	private int maximunDuration;
	private double productionInArrobasPerSquareMeter;
	
	private PlantSpecie(String label, int maximunDuration, double productionInArrobasPerSquareMeter) {
		this.label = label;
		this.maximunDuration = maximunDuration;
		this.productionInArrobasPerSquareMeter = productionInArrobasPerSquareMeter;
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public int getMaximunDuration() {
		return this.maximunDuration;
	}

	public double getProduction() {
		return productionInArrobasPerSquareMeter;
	}
}
