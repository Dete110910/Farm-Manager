package models;

public class ExpenseCrop {
	
	private ExpenseTypeCrop expenseTypeCrop;
	private double price;
	
	public ExpenseCrop(ExpenseTypeCrop expenseTypeCrop, double price) {
		this.expenseTypeCrop = expenseTypeCrop;
		this.price = price;
	}

	public ExpenseTypeCrop getExpenseTypeCrop() {
		return expenseTypeCrop;
	}

	public void setExpenseTypeCrop(ExpenseTypeCrop expenseTypeCrop) {
		this.expenseTypeCrop = expenseTypeCrop;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
