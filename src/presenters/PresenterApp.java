package presenters;

import java.time.LocalDate;
import java.util.ArrayList;

import models.*;
import views.*;
import exceptions.views.*;
import utilities.Utilities;


public class PresenterApp {
	
	private Farm farm;
	private Console console;
	
	public PresenterApp() {
		console = new Console();
		//String nameOfFarm = console.readNameOfFarm();
		//double[] grounds = console.readGrounds();
		//console.readInitialCapital()
		farm = new Farm("la granja", 100, 200, 300, 123);
		this.runApp();
	}
	
	private void runApp() {
		this.createCrop();
		console.printData(console.MESSAGE_FOR_SHOW_HEADER + farm.getName());
		console.printNotificationOfCropsFinished(farm.validateGrowthOfCrop());
		byte option = console.readOptionMainMenu();		
		switch(option) {
		
			case 1: 
					this.managerCrops();
					break;
			case 2:
					this.managerOfBovine();
					break;
		}
	
	}
	
	private void managerCrops() {
		console.printData(console.MESSAGE_CROPS);
		byte option = console.readOptionMenuCrop();
		switch(option) {
			case 1:
					this.manageAddCrop();
					break;
			case 2:
					this.manageAddExpense();
					break;
			case 3:
					this.manageShowMyCrops();
					break;
			case 4:
					this.manageNumberOfCropsBySpecieInProgress();
					break;
			case 5: 
					this.manageNumberOfCropsBySpecieFinished();
					break;
					
			case 6: this.managePercentageOfGrowthRateByTypePlant();
					break;
					
			case 7: this.manageGroundByTyplePlant();
					break;
			
			case 8:
					this.managePercentageExpensesByCrop();
					break; 
				
			case 9: 
					this.managePercentageOfCrops();
					break;
				
			case 10: 
					this.manageExpensesByCrop();
					break;
					
			case 11: 
					this.manageEndCrop();
					break;
					
			case 0:
					this.runApp();
					break;
				
		}
		
	}
	
	private void manageAddCrop() {
		byte option = console.readOptionForWayToAdd();
		switch(option) {
				case 1: 
					this.manageAddCropsInCourse();
					break;
					
				case 2:
					this.manageAddCropsFinished();
					break;
				
				case 0:
					this.managerCrops();
					break;
				
				
		}
		
	}
	

	
	private void manageAddCropsInCourse() {
		LocalDate startOfCultivation = null;
		startOfCultivation = console.readSeedTime();
		PlantSpecie planSpecie = getTypePlant(console.readPlantTypeOption());
		double amountOfLand = console.readAmountOfLand();
		while(farm.itIsBigger(amountOfLand)) {
			console.printData(console.MESSAGE_FOR_GREATER_EARTH);
			amountOfLand = console.readAmountOfLand();
		}
		farm.setGroundAvailableOfCrops(farm.getGroundAvailableOfCrops() - amountOfLand);
		double[] production = farm.calculateEstimatedProduction(planSpecie, amountOfLand);
		console.showSowingAmount(production);
		double initialCapital = console.readInitialCapitalCrop();
		farm.addCropTypeInProgress(planSpecie, startOfCultivation, amountOfLand, production, initialCapital);
		console.printData(console.MESSAGE_FOR_SAVED_CROP);
		managerCrops();
	}
	
	private void manageAddCropsFinished() {
		LocalDate startOfCultivation = null; 
		startOfCultivation = console.readSeedTime();
		PlantSpecie plantSpecie = getTypePlant(console.readPlantTypeOption());
		double totalPrice = console.readValueOfExpense();
		double pricePerPackage = console.readSalePricePerPackage();
		double solePricePerPackage = console.readProductionObtained();
		byte id = console.readIdOfCrop();
		farm.addCropTypeFinished(plantSpecie, startOfCultivation, totalPrice, pricePerPackage, solePricePerPackage, id);
		managerCrops();

		
	}
	
	private void manageAddExpense() {
		ArrayList<Byte> expenseList = farm.getCropByPlantSpecie(this.getTypePlant(console.readPlantTypeOption()));
		int sizeExpenseList = expenseList.size();
		if(sizeExpenseList == 0) {
			console.printListOfCropsForSelect(expenseList);
			this.manageAddExpense();
		}
		else {
			console.printListOfCropsForSelect(expenseList);
			byte cropById = console.readIdForSearchCrop(expenseList);
			Crop crop = farm.getCropById(cropById);
			byte typeCrop = console.readExpenseTypeCrop(); 		
			crop.addExpense(this.getExpenseTypeCrop(typeCrop), console.readPriceExpenseTypeCrop());
			managerCrops();
		}
	}
	
	private ExpenseTypeCrop getExpenseTypeCrop(byte option) {
		ExpenseTypeCrop expenseTypeCrop = null;
		switch(option) {
				case 1:
					expenseTypeCrop = ExpenseTypeCrop.SOWING;
					break;
				
				case 2:
					expenseTypeCrop = ExpenseTypeCrop.CARE;
					break;
				
				case 3: 
					expenseTypeCrop = ExpenseTypeCrop.PREPARATION_GROUND;
					break;
				
				case 4: 
					expenseTypeCrop = ExpenseTypeCrop.HARVEST;
					break;
					
				case 0:
					this.managerCrops();
					break;
		}
		return expenseTypeCrop;
	}
	
	private void manageShowMyCrops() {
		byte option = console.readTypeOfCrop();
		switch(option) {
					
				case 1:
						this.manageCropsInProgress();
						break;
						
				case 2:
						this.manageFinishedCrops();
					
				case 0:
						this.managerCrops();
						break;
						
		}
	}
	
	private void manageCropsInProgress() {
		if(farm.getCropsInProgress().size() != 0) {
			for(int i = 0; i < farm.getCropsInProgress().size(); i++) {
				console.printData(farm.getCropsInProgress().get(i).toStringInCourse());
			}
			this.manageShowMyCrops();
		}
		else {
			System.out.println(console.MESSAGE_FOR_VOID_LIST);
			manageShowMyCrops();
		}
	}
	
	private void manageFinishedCrops() {
		console.validateLengthOfLists(farm.getFinishedCrops());
		manageShowMyCrops();
	}

	
	/**
	 * Metodo para determinar el tipo de plata del que sera el cultivo
	 * @param option, byte obtenido de la vista
	 * @return objeto de tipo PlantSpecie
	 */
	private PlantSpecie getTypePlant(byte option) {
		PlantSpecie plantSpecieAux = null;
		switch(option) {
		case 1:
				plantSpecieAux = PlantSpecie.POTATO;
				break;
				
		case 2: 
				plantSpecieAux = PlantSpecie.VETCH;
				break;
				
		case 3:
				plantSpecieAux =  PlantSpecie.BEANS;
				break;
				
		case 4:
				plantSpecieAux = PlantSpecie.CORN;
				break;
		
		case 0:
				this.managerCrops();
				break;
		
		}
		
		return plantSpecieAux;
	}
	
	private void manageNumberOfCropsBySpecieInProgress() {
		console.printCropsBySpecieInProgressAsTable(farm.getNumberOfCropsByPlantSpecieInProgress());
		managerCrops();
	}
	
	private void manageNumberOfCropsBySpecieFinished() {
		console.printCropsBySpecieInProgressAsTable(farm.getNumberOfCropsByPlantSpecieFinished());
		managerCrops();
	}
	
	private void managePercentageOfGrowthRateByTypePlant() {
		new PrintHashMap(farm.getPercentageGrowthRateByPlantSpecie(this.getTypePlant(console.readPlantTypeOption())), console.MESSAGE_GRAPHIC_FOR_PERCENTAGE_OF_GROWTH_RATE);
		managerCrops();
	}
	
	private void manageGroundByTyplePlant() {
		new PrintHashMap(farm.getPercetageOfLandOcuppiedBySpecie(), console.MESSAGE_GRAPHIC_FOR_PERCENTAGE_GROUND_OCCUPIED);
		managerCrops();

	}
	
	private void manageExpensesByCrop() {
		ArrayList<Byte> expenseList = farm.getCropByPlantSpecie(this.getTypePlant(console.readPlantTypeOption()));
		int arrayListSize = expenseList.size();
		console.printListOfCropsForSelect(expenseList);
		String[][] crop = farm.getExpensesByIdCrop(console.readIdForSearchCrop(expenseList));
		console.printExpesesByCrop(crop);
		manageExpensesByCrop();
		
	}
	
	private void manageEndCrop() {
		byte option = console.readTypeEndingCrop();
		switch(option) {
				case 1:
					this.manageEndCropByHarvest();
					break;
				
				case 2: 
					this.manageEndCropByDamage();
					break;
					
				case 0:
					this.managerCrops();
					break;
		}
	}
	
	private void manageEndCropByHarvest() {
		ArrayList<Byte> listOfCrops = farm.getCropByPlantSpecie(this.getTypePlant(console.readPlantTypeOption()));
		int arrayListSize = listOfCrops.size();
		if(arrayListSize > 0) {
			console.printListOfCropsForSelect(listOfCrops);
			Crop cropInTransition = farm.getCropById(console.readIdForSearchCrop(listOfCrops));
			byte option = console.readFinishDecision(cropInTransition.validateGrowthRateCrop(cropInTransition.getSeedTime()));
			switch(option) {
					case 1:	
						double numberOfPackages = console.readNumberPackagesHarvest();
						double priceToBeSold = console.readPriceToBeSold();
						farm.increaseGroundOfCrops(cropInTransition.getGround());
						farm.deleteCropInProgress(cropInTransition);
						farm.addCropTypeFinished(cropInTransition.getSpecie(), cropInTransition.getSeedTime(), cropInTransition.getInitialCapital() + cropInTransition.calculateTotalValueOfExpenses(), numberOfPackages, priceToBeSold, cropInTransition.getId());
						this.manageEndCrop();
						break;
					case 2:
						this.manageEndCrop();
						break;
			}
		}
		else {
			System.out.println(console.MESSAGE_FOR_VOID_LIST);
			this.manageEndCropByHarvest();
		}
	}
	

	
	private void manageEndCropByDamage() {
		ArrayList<Byte> listOfCrops = farm.getCropByPlantSpecie(this.getTypePlant(console.readPlantTypeOption()));
		int arrayListSize = listOfCrops.size();
		if(arrayListSize > 0) {
			console.printListOfCropsForSelect(listOfCrops);
			Crop cropInTransition = farm.getCropById(console.readIdForSearchCrop(listOfCrops));
			double numberOfPackages = console.readNumberPackagesHarvest();
			double priceToBeSold = console.readPriceToBeSold();
			farm.increaseGroundOfCrops(cropInTransition.getGround());
			farm.deleteCropInProgress(cropInTransition);
			farm.addCropTypeFinished(cropInTransition.getSpecie(), cropInTransition.getSeedTime(), cropInTransition.getInitialCapital() + cropInTransition.calculateTotalValueOfExpenses(), numberOfPackages, priceToBeSold, cropInTransition.getId());
			this.manageEndCrop();
		}
	}
	
	
	private void managePercentageExpensesByCrop() {
		new PrintHashMap(farm.getPercentageOfExpensesByTypeCrop(), console.MESSAGE_GRAPHIC_FOR_PERCENTAGE_EXPENSES);
		this.managerCrops();
	}
	
	private void managePercentageOfCrops() {
		System.out.println(farm.getPercentageOfCrops());
		new PrintHashMap(farm.getPercentageOfCrops(), console.MESSAGE_GRAPHIC_FOR_PERCENTAGE_OF_CROPS);
		this.managerCrops();
	}
	
	private void createCrop() {
	farm.addCropTypeInProgress(PlantSpecie.POTATO,LocalDate.of(2021, 02, 20), 30, farm.calculateEstimatedProduction(PlantSpecie.POTATO,1), 2000);
	farm.addCropTypeInProgress(PlantSpecie.VETCH,LocalDate.of(2021, 02, 20), 10, farm.calculateEstimatedProduction(PlantSpecie.VETCH,2), 400);
	farm.addCropTypeInProgress(PlantSpecie.CORN,LocalDate.of(2021, 02, 20), 15, farm.calculateEstimatedProduction(PlantSpecie.CORN,3), 5000);
	farm.addCropTypeInProgress(PlantSpecie.BEANS,LocalDate.of(2021, 02, 20), 15, farm.calculateEstimatedProduction(PlantSpecie.BEANS,4), 700);
	farm.addCropTypeInProgress(PlantSpecie.POTATO,LocalDate.of(2021, 02, 20), 20, farm.calculateEstimatedProduction(PlantSpecie.POTATO,5), 120);
	farm.addCropTypeInProgress(PlantSpecie.CORN,LocalDate.of(2021, 02, 20), 50, farm.calculateEstimatedProduction(PlantSpecie.CORN,6), 200);
	farm.addCropTypeInProgress(PlantSpecie.BEANS,LocalDate.of(2021, 02, 20), 25, farm.calculateEstimatedProduction(PlantSpecie.BEANS,7), 5020);
	farm.addCropTypeInProgress(PlantSpecie.VETCH,LocalDate.of(2021, 04, 20), 30, farm.calculateEstimatedProduction(PlantSpecie.VETCH,8), 1232);

	}

	
	private void managerOfBovine() {
		System.out.println("Vacas");
	}
	
	private void managerOfChickenCoop() {
		System.out.println("Pollos");
	}
	
	private void managerOfDeaper() {
		System.out.println("Abejas");
	}
	
	
	


}
