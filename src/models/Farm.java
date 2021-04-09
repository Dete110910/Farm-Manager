package models;

import java.util.ArrayList;
import java.time.LocalDate;

public class Farm {
	
	private String name;
	private String user;
	private String password;
	private double initialCapital;
	private ArrayList<Crop> crop;
	private double totalGround;
	private double groundOfAnimals;
	private double groundOfCrops;
	private byte currentCrops = 0;
	
	
	public Farm(String name, double groundOfAnimals, double groundOfCrops, double totalGround, double initialCapital) {
		
	}
	//el byte es el id? y el localDate es la fecha de creación? los double qué son? el tamaño y el valor?
	public void addCropType(PlantSpecie plantSpecie, LocalDate dateOfCreation, double ground, double amountSown) {
		
	}
	
	public String deleteCrop() {
		return "Falta por implementar";
	}
	
	
	
	
}
