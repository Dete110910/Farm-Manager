package models;

import java.util.ArrayList;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

public class Farm {
	
	public static final int POUNDS_PER_TROUBLE = 25;
	private String name;
	private String user;
	private String password;
	private double initialCapital;
	private ArrayList<Crop> cropsInProgress;
	private ArrayList<Crop> finishedCrops;
	private double totalGround;
	private double groundOfAnimals;
	private double groundOfCrops;
	private byte currentCrops;
	
	
	public Farm(String name, double groundOfAnimals, double groundOfCrops, double totalGround, double initialCapital) {
		this.name = name;
		this.groundOfAnimals = groundOfAnimals;
		this.groundOfCrops = groundOfCrops;
		this.totalGround = totalGround;
		this.initialCapital = initialCapital;
		cropsInProgress = new ArrayList<Crop>();
		finishedCrops = new ArrayList<Crop>();
		
	}
	
	public void addCropTypeInProgress(PlantSpecie plantSpecie, LocalDate dateOfCreation, double ground, double[] amountSown) {
		currentCrops++;
		cropsInProgress.add(new Crop(plantSpecie, dateOfCreation, ground, amountSown, currentCrops));
	}
	
	public void addCropTypeFinished(PlantSpecie specie, LocalDate seedTime, double ground, double[] amountSown, double expenseCrop, int productionObtained, double salesPricePerPackage){
		finishedCrops.add(new Crop(specie, seedTime, ground, amountSown, expenseCrop, productionObtained, salesPricePerPackage));
	}
	
	/**
	 * Metodo para determinar la cantidad optima de siembra dependiendo del terreno
	 * @param plant : Tipo de planta
	 * @param amountOfLand : Cantidad de tierra para la siembra
	 * @return Double[], donde double[0] = 1 o 2, si es 1 seran arrobas si es 2 seran libras, double[1] = cantidad de semilla a usar;
	 */
	public double[] calculateEstimatedProduction(PlantSpecie plant, double amountOfLand) {
		double[] production = new double[2];
		if(plant.getLabel().equals(PlantSpecie.POTATO.getLabel())) {
			if((plant.getProduction() * amountOfLand) < 1) {
				production[0] = 2;
				production[1] = plant.getProduction() * amountOfLand * POUNDS_PER_TROUBLE;
			}else {
				production[0] = 1;
				production[1] = plant.getProduction() * amountOfLand;
			}
		}if(plant.getLabel().equals(PlantSpecie.VETCH.getLabel()) || plant.getLabel().equals(PlantSpecie.BEANS.getLabel())) {
			if((plant.getProduction() * amountOfLand) < 1) {
				production[0] = 2;
				production[1] = plant.getProduction() * amountOfLand * POUNDS_PER_TROUBLE;
			}else {
				production[0] = 1;
				production[1] = plant.getProduction() * amountOfLand;
			}
		}if(plant.getLabel().equals(PlantSpecie.CORN.getLabel())) {
			if((plant.getProduction() * amountOfLand) < 1) {
				production[0] = 2;
				production[1] = plant.getProduction() * amountOfLand * POUNDS_PER_TROUBLE;
			}else {
				production[0] = 1;
				production[1] = plant.getProduction() * amountOfLand;
			}
		}
		return production;
	}
	
	public boolean itIsBigger(double ground) {
		if(ground <= groundOfCrops) {
			return false;
		}
		return true;
	}
	
	
	
	
	public String deleteCrop() {
		return "Falta por implementar";
	}
	
	public int[] getNumberOfCropsByPlantSpecieInProgress() {
		int[] cropsInProgressAux = new int[4];
		for(int i = 0; i < cropsInProgress.size(); i++) {
			if(cropsInProgress.get(i).getSpecie().equals(PlantSpecie.POTATO)) {
				cropsInProgressAux[0]++;
			}
			
			else if(cropsInProgress.get(i).getSpecie().equals(PlantSpecie.VETCH)) {
				cropsInProgressAux[1]++;
			}
			
			else if(cropsInProgress.get(i).getSpecie().equals(PlantSpecie.BEANS)) {
				cropsInProgressAux[2]++;
			}
			
			else if(cropsInProgress.get(i).getSpecie().equals(PlantSpecie.CORN)) {
				cropsInProgressAux[3]++;
			}
		}
		return cropsInProgressAux;
		
	}
	
	/**
	 * Metodo para obtener la cantidad de dias entrte la fecha actual y la fecha en la que se sembro el cultivo
	 * @param fechaFinal
	 * @return
	 */

	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getInitialCapital() {
		return initialCapital;
	}
	public void setInitialCapital(double initialCapital) {
		this.initialCapital = initialCapital;
	}
	public ArrayList<Crop> getCropsInProgress() {
		return cropsInProgress;
	}
	public void setCropsInProgress(ArrayList<Crop> crop) {
		this.cropsInProgress = crop;
	}
	public ArrayList<Crop> getFinishedCrops(){
		return finishedCrops;
	}
	public void setFinishedCrops(ArrayList<Crop> crop) {
		this.finishedCrops = crop;
	}
	public double getTotalGround() {
		return totalGround;
	}
	public void setTotalGround(double totalGround) {
		this.totalGround = totalGround;
	}
	public double getGroundOfAnimals() {
		return groundOfAnimals;
	}
	public void setGroundOfAnimals(double groundOfAnimals) {
		this.groundOfAnimals = groundOfAnimals;
	}
	public double getGroundOfCrops() {
		return groundOfCrops;
	}
	public void setGroundOfCrops(double groundOfCrops) {
		this.groundOfCrops = groundOfCrops;
	}
	public byte getCurrentCrops() {
		return currentCrops;
	}
	public void setCurrentCrops(byte currentCrops) {
		this.currentCrops = currentCrops;
	}

	
	
	
	
	
	
	
	
}
