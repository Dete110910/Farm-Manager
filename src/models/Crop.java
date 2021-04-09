package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Crop {
	
	private byte id;
	private double growthRate;
	private PlantSpecie specie;
	private LocalDate seedTime;
	private double ground;
	private double amountSown; 
	private double amountHarvested;
	private ArrayList<ExpenseCrop> expenseCrop;
	
	
	
	public Crop(PlantSpecie specie, LocalDate seedTime, double ground) {
		this.specie = specie;
		this.seedTime = seedTime;
		this.ground = ground;
	}
	
	public double getGrowthRatePercentage() {
		if(specie.getLabel().equals(PlantSpecie.POTATO.getLabel())) {
			return 0;
		}
		return 0;
	}
	
//	private double getGrowthRatePercentageForPotatoes(){
//		
//	}
	
	public void productionEstimate() {
		
	}
	
	public void addExpense(ExpenseTypeCrop expenseTypeCrop, double price) {
		
	}
	
	
	
	
	
	
	
	
	
	
	public byte getId() {
		return id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public double getGrowthRate() {
		return growthRate;
	}

	public void setGrowthRate(double growthRate) {
		this.growthRate = growthRate;
	}

	public PlantSpecie getSpecie() {
		return specie;
	}

	public void setSpecie(PlantSpecie specie) {
		this.specie = specie;
	}

	public LocalDate getSeedTime() {
		return seedTime;
	}

	public void setSeedTime(LocalDate seedTime) {
		this.seedTime = seedTime;
	}

	public double getGround() {
		return ground;
	}

	public void setGround(double ground) {
		this.ground = ground;
	}

	public double getAmountSown() {
		return amountSown;
	}

	public void setAmountSown(double amountSown) {
		this.amountSown = amountSown;
	}

	public double getAmountHarvested() {
		return amountHarvested;
	}

	public void setAmountHarvested(double amountHarvested) {
		this.amountHarvested = amountHarvested;
	}

	public ArrayList<ExpenseCrop> getExpenseCrop() {
		return expenseCrop;
	}

	
	
	
	
	
	
	
	
	
	

}

