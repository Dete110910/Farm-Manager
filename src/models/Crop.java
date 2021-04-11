package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

public class Crop {
	
	private byte id;
	private double growthRate;
	private PlantSpecie specie;
	private LocalDate seedTime;
	private LocalDate completionTime;
	private double ground;
	private double[] amountSown; 
	private double amountHarvested;
	private double productionObtained;//Produccion vendida en bultos
	private double salePriceperpackage;//Precio de venta de un bulto
	private ArrayList<ExpenseCrop> expenseCrop;
	
	
	
	public Crop(PlantSpecie specie, LocalDate seedTime, double ground ,double[] amountSown, byte id) {
		this.specie = specie;
		this.seedTime = seedTime;
		this.ground = ground;
		this.amountSown = amountSown;
		this.id = id;
		expenseCrop = new ArrayList<ExpenseCrop>();
	}
	
	public double getGrowthRatePercentage() {
		if(specie.getLabel().equals(PlantSpecie.POTATO.getLabel())) {
			return 0;
		}
		return 0;
	}
	
	/**
	 * Metodo para obtener el total de lo que se ha gastado en el cultivo
	 * @return double con el valor 
	 */
	public double getFullValueOfExpenses() {
		double value = 0;
		if(expenseCrop.size() > 0) {
			for (int i = 0; i < expenseCrop.size(); i++) {
				value += expenseCrop.get(i).getPrice();
			}
		}
		return value;
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

	public double[] getAmountSown() {
		return amountSown;
	}

	public void setAmountSown(double[] amountSown) {
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
	
	@Override
	public String toString() {
		return ("\nTipo de planta : " + specie.getLabel() + "\n" +
				"Id : " + id  + "\n" +
				"Valor total en gastos : " + getFullValueOfExpenses() + "\n" + 
				"Bultos vendidos : " + productionObtained + "\n" +
				"Precio al que se vendio por bulto : " + salePriceperpackage + "\n" +
				"________________________________________" + "\n" +
				"Total : " + ((productionObtained * salePriceperpackage) - getFullValueOfExpenses()) + "\n");
	}
}

