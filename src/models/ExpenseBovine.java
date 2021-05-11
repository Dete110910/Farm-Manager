package models;

public class ExpenseBovine {

	private ExpenseTypeBovine expenseTypeBovine; 
	private double price;
	
	public ExpenseBovine(ExpenseTypeBovine expenseTypeBovine, double price){
		this.expenseTypeBovine = expenseTypeBovine;
		this.price = price;
	}

	public ExpenseTypeBovine getExpenseTypeBovine() {
		return expenseTypeBovine;
	}

	public void setExpenseTypeBovine(ExpenseTypeBovine expenseTypeBovine) {
		this.expenseTypeBovine = expenseTypeBovine;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
