package presenters;

import java.time.LocalDate;

import models.*;
import views.*;
import exceptions.views.*;


public class PresenterApp {
	
	private Farm farm;
	private Console console;
	
	public PresenterApp() {
		console = new Console();
		//String nameOfFarm = console.readNameOfFarm();
		//double[] grounds = console.readGrounds();
		//console.readInitialCapital()
		farm = new Farm("la granja", 25, 25, 12, 123);
		this.runApp();
	}
	
	private void runApp() {
		console.printData(console.MESSAGE_FOR_SHOW_HEADER + farm.getName());
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
					this.manageShowMyCrops();
					break;
			case 3:
					this.manageNumberOfCropsBySpecieInProgress();
					break;
			case 4:
					this.manageNumberOfCropsBySpecieFinished();
					break;
			case 5: 
					this.managePercentageOfGrowthRateBySpecie();
					break;
					
			case 6: this.manageGroundBySpecie();
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
		try {
			startOfCultivation = console.readSeedTime();
		}
		catch(ExceptionDate exceptionDate){
			System.out.println(exceptionDate.getMessage());
			manageAddCrop();
			
		}
		PlantSpecie planSpecie = getTypePlant(console.readPlantTypeOption());
		double amountOfLand = console.readAmountOfLand();
		while(farm.itIsBigger(amountOfLand)) {
			console.printData(console.MESSAGE_FOR_GREATER_EARTH);
			amountOfLand = console.readAmountOfLand();
		}
		farm.setGroundAvailableOfCrops(farm.getGroundAvailableOfCrops() - amountOfLand);
		double[] production = farm.calculateEstimatedProduction(planSpecie, amountOfLand);
		console.printData(console.showSowingAmount(production));
		farm.addCropTypeInProgress(planSpecie, startOfCultivation, amountOfLand, production);
		console.printData(console.MESSAGE_FOR_SAVED_CROP);
		managerCrops();
	}
	
	private void manageAddCropsFinished() {
		LocalDate startOfCultivation = null;
		try {
			startOfCultivation = console.readSeedTime();
		}
		catch (ExceptionDate exceptionDate) {
			System.out.println(exceptionDate.getMessage());
		}
		
		PlantSpecie plantSpecie = getTypePlant(console.readPlantTypeOption());
		double amountOfLand = console.readAmountOfLand();
		while(farm.itIsBigger(amountOfLand)) {
			System.out.println(console.MESSAGE_FOR_GREATER_EARTH);
			amountOfLand = console.readAmountOfLand();
		}
		double[] production = farm.calculateEstimatedProduction(plantSpecie, amountOfLand);
		console.printData(console.showSowingAmount(production));
		double expenseCrop = console.readValueOfExpense();
		int productionObatined = console.readProductionObtained();
		double salesPricePerPackage = console.readSalePricePerPackage();
		farm.addCropTypeFinished(plantSpecie, startOfCultivation, amountOfLand, production, expenseCrop, productionObatined, salesPricePerPackage);
		managerCrops();

		
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
		console.validateLengthOfLists(farm.getCropsInProgress());
		manageShowMyCrops();
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
	
	private void managePercentageOfGrowthRateBySpecie() {
		new PrintHashMap(farm.getPercentageGrowthRateByPlantSpecie(this.getTypePlant(console.readPlantTypeOption())));
		managerCrops();
	}
	
	private void manageGroundBySpecie() {
		new PrintHashMap(farm.getPercetageOfLandOcuppiedBySpecie());
		managerCrops();

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
	
	
	
//	public static void main(String[] sa) {
//		PresenterApp asd = new PresenterApp();
//		System.out.println(asd.getTypePlant((byte)2).getLabel());
//		
//	}

}
