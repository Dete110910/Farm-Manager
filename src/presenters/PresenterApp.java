package presenters;

import java.time.LocalDate;

import models.*;
import views.Console;
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
				
					break;
			case 4:
				
					break;
		}
		
	}
	
	private void manageAddCrop() {
		PlantSpecie planSpecie = getTypePlant(console.readPlantTypeOption());
		LocalDate startOfCultivation = null;
		try {
			startOfCultivation = console.readSeedTime();
		}
		catch(ExceptionDate exceptionDate){
			System.out.println(exceptionDate.getMessage());
			
		}
		
		Double amountOfLand = console.readAmountOfLand();
		while(farm.itIsBigger(amountOfLand)) {
			console.printData(console.MESSAGE_FOR_GREATER_EARTH);
			amountOfLand = console.readAmountOfLand();
		}
		double[] production = farm.calculateEstimatedProduction(planSpecie, amountOfLand);
		console.printData(console.showSowingAmount(production));
		farm.addCropType(planSpecie, startOfCultivation, amountOfLand, production);
		console.printData(console.MESSAGE_FOR_SAVED_CROP);
		managerCrops();
	}
	
	private void manageShowMyCrops() {
		console.validateLengthOfLists(farm.getCropsInProgress());
		managerCrops();
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
