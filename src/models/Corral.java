package models;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDate;
import java.util.ArrayList;


public class Corral {

	private int numberChickens;
	private LocalDate creationDate;
	private double initialInvestmen;
	private byte age;
	private byte id;
	private ArrayList<ExpenseCorral> expenseListCorral;
	private ArrayList<CorralSales> corralSalesList;
	
	public Corral(int numberChickens, LocalDate creationDate, double initialInvestmen, byte id) {
		this.numberChickens = numberChickens;
		this.creationDate = creationDate;
		this.initialInvestmen = initialInvestmen;
		this.id = id;
		expenseListCorral = new ArrayList<ExpenseCorral>();
		this.corralSalesList = new ArrayList<CorralSales>();
	}
	
	/**
	 * M�todo para a�adir un gasto al corral
	 * @param expenseTypeCorral Tipo de gasto que se desea a�adir
	 * @param price Valor del gasto que se desea a�adir
	 */
	public void addExpense(ExpenseTypeCorral expenseTypeCorral, double price) {
		this.expenseListCorral.add(new ExpenseCorral(expenseTypeCorral, price));
	}
	
	
	/**
	 * M�todo para generar una venta de huevos del corral
	 * @param numberEggs N�mero de huevos que vender�
	 * @param price Precio al que vender� la totalidad de los huevos
	 * @param numberDays N�mero de d�as entre los que se quiere	efectuar la venta
	 * @return true: si se pudo efectuar la venta. false: si no se pudo efectuar la venta 
	 */
	public boolean saleEggs(int numberEggs, double price, int numberDays) {
		if(corralSalesList.size() > 0) {
			System.out.println((creationDate.until(LocalDate.now(), DAYS) - numberDays));
			if((creationDate.until(LocalDate.now(), DAYS) - numberDays) >= 0
			&&((creationDate.until(LocalDate.now(), DAYS) - numberDays) > (creationDate.until(corralSalesList.get(corralSalesList.size() - 1).getLastSale(), DAYS)))){
				
				corralSalesList.add(new CorralSales(numberEggs, price, LocalDate.now()));
				return true;
			}
		}
		else
			if((creationDate.until(LocalDate.now(), DAYS) - numberDays) >= 0){
				corralSalesList.add(new CorralSales(numberEggs, price, LocalDate.now()));
				return true;
			}
		return false;
	}
	
	/**
	 * M�todo que genera una aproximaci�n de lo que ser�a una producci�n de huevos normal en un corral dependiendo del n�mero de gallinas y el n�mero de d�as
	 * @param numberDays N�mero de d�as entre los que se quiere estimar la producci�n obtenida por el corral
	 * @return N�mero de huevos producidos por el corral
	 */
	public int generateEggs(int numberDays) {
		return (int)((Math.random() * ((numberChickens * numberDays * 2) - (numberChickens * numberDays))) + numberChickens * numberDays) ;
	}
	
	/*
	 * RECUERDE QUE LE A�ADIMOS EL LOCALDATE.NOW AL CONSTRUCTOR DE CORRALSALES
	 */
	
	
	
	
	
	
	
	
	
	
	
//	public void asd() {
//		corralSalesList.add(new CorralSales(100, 1000, LocalDate.of(2021,05,05)));
//		
//	}
//	
//	
//	
//	
	
	
	
	
//	
//	public static void main(String[] args) {
//		Corral corral = new Corral(100, LocalDate.of(2021, 5, 01), 1000, (byte)0);
//		corral.asd();
//		corral.saleEggs(100, 1000, 4);
//		System.out.println(corral.corralSalesList.size());
//	}
//	
//	
	
	
	
	
	
	
	
	public int getNumeberChickens() {
		return numberChickens;
	}
	public void setNumeberChickens(int numeberChickens) {
		this.numberChickens = numeberChickens;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public double getInitialInvestmen() {
		return initialInvestmen;
	}
	public void setInitialInvestmen(double initialInvestmen) {
		this.initialInvestmen = initialInvestmen;
	}
	public byte getAge() {
		return age;
	}
	public void setAge(byte age) {
		this.age = age;
	}
	
	public void setExpenseTypeCorral(ArrayList<ExpenseCorral> expenseTypeCorral){
		this.expenseListCorral = expenseTypeCorral;
	}
	
	public ArrayList<ExpenseCorral> getExpenseTypeCorral(){
		return this.expenseListCorral;
	}


	public byte getId() {
		return id;
	}


	public void setId(byte id) {
		this.id = id;
	}
	
}
