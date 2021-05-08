package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;

public class Farm {
	
	public static final int POUNDS_PER_TROUBLE = 25;
	public static final int HUNDRED_PERCENT = 100;
	private String name;
	private String user;
	private String password;
	private double capital;
	private ArrayList<Crop> cropsInProgress;
	private ArrayList<Crop> finishedCrops;
	private double totalGround;
	private double groundOfCrops;
	private double groundOfAnimals;	
	private double groundAvailableOfCrops;
	private byte currentCrops;
	private GroupBovine bovines;
	private ArrayList<Corral> corralList;
	private byte currentCorrals;
	
	public Farm(String name, double groundOfCrops, double groundOfAnimals, double totalGround, double initialCapital) {
		this.name = name;
		this.groundOfCrops = groundOfCrops;
		this.totalGround = totalGround;
		this.groundOfAnimals = groundOfAnimals;
		this.capital = initialCapital;
		this.groundAvailableOfCrops = groundOfCrops;
		this.bovines = new GroupBovine();
		cropsInProgress = new ArrayList<Crop>();
		finishedCrops = new ArrayList<Crop>();
		corralList = new ArrayList<Corral>();
	}
	
	public void addCropTypeInProgress(PlantSpecie plantSpecie, LocalDate dateOfCreation, double ground, double[] amountSown, double initialCapital) {
		currentCrops++;
		cropsInProgress.add(new Crop(plantSpecie, dateOfCreation, ground, amountSown, initialCapital, currentCrops));
	}
	
	
	public void addCropTypeFinished(PlantSpecie specie, LocalDate seedTime,  double expenseCropFinished, double productionObtained, double salePricePerPackage, byte id){
		finishedCrops.add(new Crop(specie, seedTime, expenseCropFinished, productionObtained,salePricePerPackage, id));
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
	
	public double decreaseCapitalFarm(double expense) {
		capital = capital - expense;
		return capital;
	}
	
	public double increaseCapital(double sell) {
		capital = capital + sell;
		return capital;
	}
	
	public void increaseGroundOfCrops(double ground) {
		groundAvailableOfCrops += ground;
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
		boolean flag = true;
		for(int i = 0; i < cropsInProgress.size() && flag; i++) {
			if(cropsInProgress.get(i).getId() == id ) {
				cropAux = cropsInProgress.get(i);
				flag = false;
			}
		}
		return cropAux;
	}
	
	
	
	public String[][] getExpensesByIdCrop(byte id){
		Crop cropAux = this.getCropById(id);
		String[][] expensesList = cropAux.getExpenses();
		return expensesList;
	}
	
	public byte validateGrowthOfCrop() {
		byte numberOfCropsGrown = 0;
		for(int i = 0; i < cropsInProgress.size(); i++) {
			if(cropsInProgress.get(i).validateGrowthRateCrop(cropsInProgress.get(i).getSeedTime())) {
				numberOfCropsGrown++;
			}
		}
		return numberOfCropsGrown;
	}
	
	public void deleteCropInProgress(Crop cropInProgress) {
		cropsInProgress.remove(cropInProgress);
	
	}
	
	public HashMap<String, Double> getPercentageOfExpensesByTypeCrop(){
		HashMap<String, Double> listOfExpenses = new HashMap<String, Double>();
		double[] expenses = new double[4];
		double totalExpenses = this.getTotalExpenses();
		for(int i = 0; i < cropsInProgress.size(); i++) {
			if(cropsInProgress.get(i).getSpecie().equals(PlantSpecie.POTATO)) {
				expenses[0] += cropsInProgress.get(i).calculateTotalValueOfExpenses();
			}
			else if(cropsInProgress.get(i).getSpecie().equals(PlantSpecie.VETCH)) {
				expenses[1] += cropsInProgress.get(i).calculateTotalValueOfExpenses();
			}
			else if(cropsInProgress.get(i).getSpecie().equals(PlantSpecie.BEANS)) {
				expenses[2] += cropsInProgress.get(i).calculateTotalValueOfExpenses();
			}
			else if(cropsInProgress.get(i).getSpecie().equals(PlantSpecie.CORN)) {
				expenses[3] += cropsInProgress.get(i).calculateTotalValueOfExpenses();
			}
		}
		listOfExpenses.put(PlantSpecie.POTATO.getLabel(), (expenses[0] * HUNDRED_PERCENT)/totalExpenses);
		listOfExpenses.put(PlantSpecie.VETCH.getLabel(), (expenses[1] * HUNDRED_PERCENT)/totalExpenses);
		listOfExpenses.put(PlantSpecie.BEANS.getLabel(), (expenses[2] * HUNDRED_PERCENT)/totalExpenses);
		listOfExpenses.put(PlantSpecie.CORN.getLabel(), (expenses[3]  * HUNDRED_PERCENT)/totalExpenses);
		
		return listOfExpenses;
	}
	
	public double getTotalExpenses() {
		double totalExpenses = 0;
		for(int i = 0; i < cropsInProgress.size(); i++) {
			totalExpenses += cropsInProgress.get(i).calculateTotalValueOfExpenses();
		}
		return totalExpenses;
	}
	
	
	public HashMap<String, Double> getPercentageOfCrops(){
		HashMap<String, Double> listPercentageOfCrops = new HashMap<String, Double>();
		double[] listOfCropsAux = new double[4];
		for(int i = 0; i < cropsInProgress.size(); i++) {
			if(cropsInProgress.get(i).getSpecie().equals(PlantSpecie.POTATO)) {
				listOfCropsAux[0] += 1;
				System.out.println("Sumo una");
			} 
			
			else if(cropsInProgress.get(i).getSpecie().equals(PlantSpecie.VETCH)) {
				listOfCropsAux[1] += 1;
				System.out.println("Sumo vetch");
			}
			
			else if(cropsInProgress.get(i).getSpecie().equals(PlantSpecie.BEANS)) {
				listOfCropsAux[2] += 1;
			}
			else if(cropsInProgress.get(i).getSpecie().equals(PlantSpecie.CORN)) {
				listOfCropsAux[3] += 1;
			}
		}
		listPercentageOfCrops.put(PlantSpecie.POTATO.getLabel(), (listOfCropsAux[0] * HUNDRED_PERCENT) / cropsInProgress.size());
		listPercentageOfCrops.put(PlantSpecie.VETCH.getLabel(), (listOfCropsAux[1] * HUNDRED_PERCENT) / cropsInProgress.size());
		listPercentageOfCrops.put(PlantSpecie.BEANS.getLabel(), (listOfCropsAux[2] * HUNDRED_PERCENT) / cropsInProgress.size());
		listPercentageOfCrops.put(PlantSpecie.CORN.getLabel(), (listOfCropsAux[3] * HUNDRED_PERCENT) / cropsInProgress.size());
		
		//System.out.println(cropsInProgress + " Lista");
		return listPercentageOfCrops;
	}
	
	public void addCorral(int numberChicken, LocalDate creationDate, double initialInvestmen) {
		currentCorrals++;
		corralList.add(new Corral(numberChicken, creationDate, initialInvestmen, currentCorrals));
	}
	
	public double getCapital() {
		return capital;
	}

	public void setCapital(double capital) {
		this.capital = capital;
	}

	public GroupBovine getBovines() {
		return bovines;
	}

	public void setBovines(GroupBovine bovines) {
		this.bovines = bovines;
	}

	public ArrayList<Corral> getCorralList() {
		return corralList;
	}

	public void setCorralList(ArrayList<Corral> corralList) {
		this.corralList = corralList;
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
		return capital;
	}
	public void setInitialCapital(double initialCapital) {
		this.capital = initialCapital;
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
	public GroupBovine getGroupBovine() {
		return bovines;
	}
	
	
	
	
	
	
	
	
	
}
