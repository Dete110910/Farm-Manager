package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

public class Farm {
	
	public static final int POUNDS_PER_TROUBLE = 25;
	public static final int HUNDRED_PERCENT = 100;
	private String name;
	private String user;
	private String password;
	private double initialCapital;
	private ArrayList<Crop> cropsInProgress;
	private ArrayList<Crop> finishedCrops;
	private double totalGround;
	private double groundOfAnimals;
	private double groundOfCrops;
	private double groundAvailableOfCrops;
	private byte currentCrops;
	
	public Farm(String name, double groundOfAnimals, double groundOfCrops, double totalGround, double initialCapital) {
		this.name = name;
		this.groundOfAnimals = groundOfAnimals;
		this.groundOfCrops = groundOfCrops;
		this.totalGround = totalGround;
		this.initialCapital = initialCapital;
		this.groundAvailableOfCrops = groundOfCrops;
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
		if(ground <= groundAvailableOfCrops) {
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
	
	public int[] getNumberOfCropsByPlantSpecieFinished() {
		int[] cropsFinishedAux = new int[4];
		for(int i = 0; i < finishedCrops.size(); i++) {
			if(finishedCrops.get(i).getSpecie().equals(PlantSpecie.POTATO)) {
				cropsFinishedAux[0]++; 
			}
			else if(finishedCrops.get(i).getSpecie().equals(PlantSpecie.VETCH)) {
				cropsFinishedAux[1]++;
			}
			else if(finishedCrops.get(i).getSpecie().equals(PlantSpecie.BEANS)) {
				cropsFinishedAux[2]++;
			}
			else if(finishedCrops.get(i).getSpecie().equals(PlantSpecie.CORN)) {
				cropsFinishedAux[3]++;
			}
			
		}
		return cropsFinishedAux;
	}
	
	public HashMap<String, Double> getPercentageGrowthRateByPlantSpecie(PlantSpecie plantSpecie) {
		HashMap<String, Double> cropsList = new HashMap<String, Double>();
		for(int i = 0; i < cropsInProgress.size(); i++) {
			if(cropsInProgress.get(i).getSpecie().equals(plantSpecie) && cropsInProgress.get(i).getGrowthPercentage() < 101) {
				cropsList.put(String.valueOf(cropsInProgress.get(i).getId()), cropsInProgress.get(i).getGrowthPercentage());
			}
		}
		return cropsList;
	}
	
	public  HashMap<String, Double> getPercetageOfLandOcuppiedBySpecie(){
		HashMap<String, Double> landOcuppied = new HashMap<String, Double>();
		double[] landOcuppiedAux = new double[4];
		for(int i = 0; i < cropsInProgress.size(); i++) {
			if(cropsInProgress.get(i).getGrowthPercentage() < 101) {
				if(cropsInProgress.get(i).getSpecie().equals(PlantSpecie.POTATO)) {
					landOcuppiedAux[0] += cropsInProgress.get(i).getGround();
				}
				else if(cropsInProgress.get(i).getSpecie().equals(PlantSpecie.VETCH)) {
					landOcuppiedAux[1] += cropsInProgress.get(i).getGround();
				}
				else if(cropsInProgress.get(i).getSpecie().equals(PlantSpecie.BEANS)) {
					landOcuppiedAux[2] += cropsInProgress.get(i).getGround();
				}
				else if(cropsInProgress.get(i).getSpecie().equals(PlantSpecie.CORN)) {
					landOcuppiedAux[3] += cropsInProgress.get(i).getGround();
	
				}
			}
		}
		landOcuppied.put(PlantSpecie.POTATO.getLabel(), landOcuppiedAux[0]*HUNDRED_PERCENT/groundOfCrops);
		landOcuppied.put(PlantSpecie.VETCH.getLabel(), landOcuppiedAux[1]*HUNDRED_PERCENT/groundOfCrops);
		landOcuppied.put(PlantSpecie.BEANS.getLabel(), landOcuppiedAux[2]*HUNDRED_PERCENT/groundOfCrops);
		landOcuppied.put(PlantSpecie.CORN.getLabel(), landOcuppiedAux[3]*HUNDRED_PERCENT/groundOfCrops);
		
		return landOcuppied;
		
	}
	
	public ArrayList<Byte> getCropByPlantSpecie(PlantSpecie plantSpecie){
		ArrayList<Byte> expenseList = new ArrayList<Byte>();
		for(int i = 0; i < cropsInProgress.size(); i++) {
			if(cropsInProgress.get(i).getSpecie().getLabel().equals(plantSpecie.getLabel())) {
				expenseList.add(cropsInProgress.get(i).getId());
			}
		}
		return expenseList;
	}
	

	public Crop getCropById(byte id) {
		Crop cropAux = null;
		for(int i = 0; i < cropsInProgress.size(); i++) {
			if(cropsInProgress.get(i).getId() == id ) {
				cropAux = cropsInProgress.get(i);
			}
		}
		
		return cropAux;
	}
	
	//creo que debo llamar al método getExpenses de crop para acá y cuadrar el presentador

	public String[][] getExpensesByIdCrop(byte id){
		Crop cropAux = this.getCropById(id);
		String[][] expensesList = cropAux.getExpenses();
		return expensesList;
	}
	
	
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
	public double getGroundAvailableOfCrops() {
		return groundAvailableOfCrops;
	}
	public void setGroundAvailableOfCrops(double groundAvailableOfCrops) {
		this.groundAvailableOfCrops = groundAvailableOfCrops;
	}
	public byte getCurrentCrops() {
		return currentCrops;
	}
	public void setCurrentCrops(byte currentCrops) {
		this.currentCrops = currentCrops;
	}

	
	
	
	
	
	
	
	
}
