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
	private double totalValueOfExpense; //no la estamos usando. Es una variable local en un método de abajo. ¿Deberíamos dejarla ahí? Quizá la estoy usando mal
	private double expenseCropFinished;
	
	
	
	public Crop(PlantSpecie specie, LocalDate seedTime, double ground ,double[] amountSown, byte id) {
		this.specie = specie;
		this.seedTime = seedTime;
		this.ground = ground;
		this.amountSown = amountSown;
		this.id = id;
		expenseCrop = new ArrayList<ExpenseCrop>();
		totalValueOfExpense = 0; // no estoy seguro de si se debería inicializar. En caso de ser así, estaría en 0
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
		expenseCrop.add(new ExpenseCrop(expenseTypeCrop, price));
	}
	
	 public String[][] getExpenses(){
		 String[][] listExpensesAux = new String[expenseCrop.size()][2];
		 for(int i = 0; i < expenseCrop.size(); i++) {
			 for(int j = 0; j < 1; j++) {
				 listExpensesAux[i][0] = String.valueOf(expenseCrop.get(i).getExpenseTypeCrop().getLabel());
				 listExpensesAux[i][1] = String.valueOf(expenseCrop.get(i).getPrice());
			 }
		 }
		 return listExpensesAux;
	 }
	 
	 public double calculateTotalValueOfExpenses() {
		 for(int i = 0; i < expenseCrop.size(); i++) {
			 totalValueOfExpense += expenseCrop.get(i).getPrice();
		 }
		 return totalValueOfExpense;
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
				TOTAL_VALUE_EXPENSES + this.calculateTotalValueOfExpenses() + SPACE + 
				SOLD_PACKAGE + productionObtained + SPACE +
				PRICE_PER_PACKAGE + salePriceperpackage + SPACE +
				SEPARATOR_LINE + SPACE +
				TOTAL + ((productionObtained * salePriceperpackage) - this.calculateTotalValueOfExpenses()) + "\n");
	}
}

