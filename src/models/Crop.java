package models;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

public class Crop {
	
	public static final int HUNDRED_PERCENT = 100;
	public static final String TYPE_PLANT = "\nTipo de planta : ";
	public static final String ID = "Id : ";
	public static final String SPACE = "\n";
	public static final String TOTAL_VALUE_EXPENSES = "Valor total en gastos : ";
	public static final String SOLD_PACKAGE = "Bultos vendidos : ";
	public static final String PRICE_PER_PACKAGE = "Precio al que se vendio por bulto : ";
	public static final String SEPARATOR_LINE = "________________________________________";
	public static final String TOTAL= "Total : ";
	
	private byte id;
	private PlantSpecie specie;
	private LocalDate seedTime;
	private double ground;
	private double[] amountSown; 
	private double amountHarvested;
	private int productionObtained;//Produccion vendida en bultos
	private double salePriceperpackage;//Precio de venta de un bulto
	private ArrayList<ExpenseCrop> expenseCrop;
	private double totalValueOfExpense;
	private double expenseCropFinished;
	
	
	
	public Crop(PlantSpecie specie, LocalDate seedTime, double ground ,double[] amountSown, byte id) {
		this.specie = specie;
		this.seedTime = seedTime;
		this.ground = ground;
		this.amountSown = amountSown;
		this.id = id;
		expenseCrop = new ArrayList<ExpenseCrop>();
	}
	
	/**
	 * Metodo constructor para cultivos finalizados
	 * @param specie
	 * @param seedTime
	 * @param ground
	 * @param amountSown
	 * @param id
	 * @param expenseCrop
	 * @param productionObtained
	 * @param salePricePerPackage
	 */
	public Crop(PlantSpecie specie, LocalDate seedTime, double ground ,double[] amountSown, double expenseCropFinished, int productionObtained, double salePricePerPackage) {
		this.specie = specie;
		this.seedTime = seedTime;
		this.ground = ground;
		this.amountSown = amountSown;
		this.expenseCropFinished = expenseCropFinished;
		this.productionObtained = productionObtained;
		this.salePriceperpackage = salePricePerPackage;
	}
	

	
	/**
	 * Metodo para obtener el total de lo que se ha gastado en el cultivo
	 * @return double con el valor 
	 */
	public void getFullValueOfExpenses() {
		if(expenseCrop.size() > 0) {
			for (int i = 0; i < expenseCrop.size(); i++) {
				totalValueOfExpense += expenseCrop.get(i).getPrice();
			}
		}
	} 
	
	public int getDaysBetweenTwoDates() {
		return (int) DAYS.between(seedTime, LocalDate.now());
	}
	
	/**
	 * Metodo para obtener el procentaje de crecimiento de un cultivo
	 * @return porcentaje
	 */
	public double getGrowthPercentage(){
		int timeUntilToday = getDaysBetweenTwoDates();
		return (double)(timeUntilToday*HUNDRED_PERCENT/specie.getMaximunDuration());
	}
	
	
	
	 
	
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
		return (TYPE_PLANT + specie.getLabel() + SPACE +
				ID + id  + SPACE +
				TOTAL_VALUE_EXPENSES + totalValueOfExpense + SPACE + 
				SOLD_PACKAGE + productionObtained + SPACE +
				PRICE_PER_PACKAGE + salePriceperpackage + SPACE +
				SEPARATOR_LINE + SPACE +
				TOTAL + ((productionObtained * salePriceperpackage) - totalValueOfExpense) + "\n");
	}
}

