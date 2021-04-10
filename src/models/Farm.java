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
		this.name = name;
		this.groundOfAnimals = groundOfAnimals;
		this.groundOfCrops = groundOfCrops;
		this.totalGround = totalGround;
		this.initialCapital = initialCapital;
		
	}
	//el byte es el id? y el localDate es la fecha de creación? los double qué son? el tamaño y el valor?
	public void addCropType(PlantSpecie plantSpecie, LocalDate dateOfCreation, double ground, double amountSown) {
		
	}
	
//	private boolean validateDate() {
//		
//	}
	
	public String deleteCrop() {
		return "Falta por implementar";
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
	public ArrayList<Crop> getCrop() {
		return crop;
	}
	public void setCrop(ArrayList<Crop> crop) {
		this.crop = crop;
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
