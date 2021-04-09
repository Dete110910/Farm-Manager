package models;

import java.util.ArrayList;

public class GroupBovine {

	private ArrayList<Bovine> dairyCattle;
	private ArrayList<Bovine> fatteningCattle;
	private ArrayList<Bovine> levantCattle;
	private ArrayList<Bovine> babyCattle;
	private ArrayList<ExpenseBovine> expenseList;
	
	
	

	
	public GroupBovine() {
		//¿Esto no llevaba nada? ¿O aquí inicializamos las listas?
	}
	
	public void moveToList() {
		
	}
	
	public void addBovine(Bovine bovine) {
		
	}
	
	public void removeBovine(byte id) {
		
	}
	
//	public Bovine searchBovine(byte id) {
//		return Bovine;
//	}
	
	
	
	public ArrayList<Bovine> getDairyCattle() {
		return dairyCattle;
	}

	public ArrayList<Bovine> getFatteningCattle() {
		return fatteningCattle;
	}

	public ArrayList<Bovine> getLevantCattle() {
		return levantCattle;
	}

	public ArrayList<Bovine> getBabyCattle() {
		return babyCattle;
	}

	public ArrayList<ExpenseBovine> getExpenseList() {
		return expenseList;
	}
	
}
