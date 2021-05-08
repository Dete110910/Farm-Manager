package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Corral {

	private int numeberChickens;
	private LocalDate creationDate;
	private double initialInvestmen;
	private byte age;
	private byte id;
	private ArrayList<ExpenseCorral> expenseListCorral;
	
	public Corral(int numberChickens, LocalDate creationDate, double initialInvestmen, byte id) {
		this.numeberChickens = numberChickens;
		this.creationDate = creationDate;
		this.initialInvestmen = initialInvestmen;
		this.id = id;
		expenseListCorral = new ArrayList<ExpenseCorral>();
	}
	
	
	public void addExpense(ExpenseTypeCorral expenseTypeCorral, double price) {
		this.expenseListCorral.add(new ExpenseCorral(expenseTypeCorral, price));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getNumeberChickens() {
		return numeberChickens;
	}
	public void setNumeberChickens(int numeberChickens) {
		this.numeberChickens = numeberChickens;
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
