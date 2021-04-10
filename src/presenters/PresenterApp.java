package presenters;

import java.time.LocalDate;

import models.*;
import views.Console;

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
		console.print(console.MESSAGE_FOR_SHOW_HEADER + farm.getName());
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
		console.print(console.MESSAGE_CROPS);
		byte option = console.readOptionMenuCrop();
		switch(option) {
					case 1:
							this.farm.addCropType(this.getTypePlant(console.readPlantTypeOption()), LocalDate.of(2020, 5, 1), 2000, 20);;
							break;
		}
		
	}
	
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
