package models;

public class ExpenseCorral {
	
	private double expense;
	private ExpenseTypeCorral typeExpenseCorral;
	
	public ExpenseCorral(ExpenseTypeCorral typeExpenseCorral, double expense) {
		this.typeExpenseCorral = typeExpenseCorral;
		this.expense = expense;
	}
	
	public double getExpense() {
		return expense;
	}

	public void setExpense(double expense) {
		this.expense = expense;
	}

	public ExpenseTypeCorral getTypeExpenseCorral() {
		return typeExpenseCorral;
	}

	public void setTypeExpenseCorral(ExpenseTypeCorral typeExpenseCorral) {
		this.typeExpenseCorral = typeExpenseCorral;
	}
	
	

}
