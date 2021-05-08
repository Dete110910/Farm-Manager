package models;

import java.util.ArrayList;
import java.util.HashMap;

public class GroupBovine {

	private ArrayList<Bovine> dairyCattle;
	private ArrayList<Bovine> fatteningCattle;
	private ArrayList<Bovine> levantCattle;
	private ArrayList<Bovine> babyCattle;
	private ArrayList<ExpenseBovine> expenseListBabyCattle;
	private ArrayList<ExpenseBovine> expenseListLevantCattle;
	private ArrayList<ExpenseBovine> expenseListFatteningCattle;
	private ArrayList<ExpenseBovine> expenseListDairyCattle;
	private ArrayList<BovineSalePurchase> cattleSold;
	private ArrayList<BovineSalePurchase> cattleBought;
	public static final String SAME = " = ";
	public static final String SKIP_LINE = "\n";
	public static final int HUNDRED_PERCENT = 100;
	private int id;
	
	public GroupBovine() {
		dairyCattle = new ArrayList<Bovine>();
		fatteningCattle = new ArrayList<Bovine>();
		levantCattle = new ArrayList<Bovine>();
		babyCattle = new ArrayList<Bovine>();
		expenseListBabyCattle = new ArrayList<ExpenseBovine>();
		expenseListDairyCattle = new ArrayList<ExpenseBovine>();
		expenseListFatteningCattle = new ArrayList<ExpenseBovine>();
		expenseListLevantCattle = new ArrayList<ExpenseBovine>();
		cattleSold = new ArrayList<BovineSalePurchase>();
		cattleBought = new ArrayList<BovineSalePurchase>();
		id = 0;
	}
	
	/**
	 * Metodo para determinar el genero de un bovino
	 * @param type, 1:Macho, 2:Hembra
	 * @return
	 */
	public Gender determineGender(int type) {
		if(type == 1) {
			return Gender.MALE;
		}
		return Gender.FEMALE;
	}
	
	/**
	 * Metodo para reorganizar los bovinos por edad y genero
	 */
	public void moveToList() {
		for (int i = 0; i < babyCattle.size(); i++) {
			Bovine aux = babyCattle.get(i);
			babyCattle.remove(aux);
			arrangeBovine(aux);
		}
		for (int i = 0; i < levantCattle.size(); i++) {
			Bovine aux = levantCattle.get(i);
			levantCattle.remove(aux);
			arrangeBovine(aux);
		}
		for (int i = 0; i < fatteningCattle.size(); i++) {
			Bovine aux = fatteningCattle.get(i);
			fatteningCattle.remove(aux);
			arrangeBovine(aux);
		}
		for (int i = 0; i < dairyCattle.size(); i++) {
			Bovine aux = dairyCattle.get(i);
			dairyCattle.remove(aux);
			arrangeBovine(aux);
		}
	}
	
	/**
	 * Metodo para añadir un bovino
	 * @param bovine
	 */
	public void addBovine(Bovine bovine) {
		if(bovine != null) {
			Bovine newBovine = bovine;
			newBovine.setId((byte)id);
			id++;
			arrangeBovine(newBovine);
		}
	}
	
	/**
	 * Metodo para clasificar un bovino por su edad y/o genero
	 * @param bovine
	 */
	public void arrangeBovine(Bovine bovine) {
		if(bovine != null) {
			if(bovine.getAge() < TypeBovine.LEVANT_CATTLE.getMinimumAge()) {
				babyCattle.add(bovine);
				babyCattle.get(babyCattle.size() - 1).setCurrentType(TypeBovine.BABY_CATTLE);
				cattleBought.add(new BovineSalePurchase(babyCattle.get(babyCattle.size() - 1).getTypeBovine(), babyCattle.get(babyCattle.size() - 1).getPurchaseValue()));
			}else if(bovine.getAge() < TypeBovine.FATTENING_CATTLE.getMinimumAge()) {
				levantCattle.add(bovine);
				levantCattle.get(levantCattle.size() - 1).setCurrentType(TypeBovine.LEVANT_CATTLE);
				cattleBought.add(new BovineSalePurchase(levantCattle.get(levantCattle.size() - 1).getTypeBovine(), levantCattle.get(levantCattle.size() - 1).getPurchaseValue()));
			}else if(bovine.getAge() > TypeBovine.FATTENING_CATTLE.getMinimumAge() && bovine.getGender().equals(Gender.MALE)) {
				fatteningCattle.add(bovine);
				fatteningCattle.get(fatteningCattle.size() - 1).setCurrentType(TypeBovine.FATTENING_CATTLE);
				cattleBought.add(new BovineSalePurchase(fatteningCattle.get(fatteningCattle.size() - 1).getTypeBovine(), fatteningCattle.get(fatteningCattle.size() - 1).getPurchaseValue()));
			}else if(bovine.getAge() > TypeBovine.FATTENING_CATTLE.getMinimumAge() && bovine.getGender().equals(Gender.FEMALE)) {
				dairyCattle.add(bovine);
				dairyCattle.get(dairyCattle.size() - 1).setCurrentType(TypeBovine.DAIRY_CATTLE);
				cattleBought.add(new BovineSalePurchase(dairyCattle.get(dairyCattle.size() - 1).getTypeBovine(), dairyCattle.get(dairyCattle.size() - 1).getPurchaseValue()));
			}
		}
	}
	
	/**
	 * Metodo para eliminar un bovino por Id
	 * @param id
	 */
	public void removeBovine(byte id, double saleValue) {
		for (int i = 0; i < babyCattle.size(); i++) {
			if(babyCattle.get(i).getId() == id) {
				cattleSold.add(new BovineSalePurchase(babyCattle.get(i).getTypeBovine(), saleValue));
				babyCattle.remove(i);
				return;
			}
		}
		for (int i = 0; i < levantCattle.size(); i++) {
			if(levantCattle.get(i).getId() == id) {
				cattleSold.add(new BovineSalePurchase(levantCattle.get(i).getTypeBovine(), saleValue));
				levantCattle.remove(i);
				return;
			}
		}
		for (int i = 0; i < fatteningCattle.size(); i++) {
			if(fatteningCattle.get(i).getId() == id) {
				cattleSold.add(new BovineSalePurchase(fatteningCattle.get(i).getTypeBovine(), saleValue));
				fatteningCattle.remove(i);
				return;
			}
		}
		for (int i = 0; i < dairyCattle.size(); i++) {
			if(dairyCattle.get(i).getId() == id) {
				cattleSold.add(new BovineSalePurchase(dairyCattle.get(i).getTypeBovine(), saleValue));
				dairyCattle.remove(i);
				return;
			}
		}
	}
	
	/**
	 * Metodo para determinar que tipo de gasto es
	 * @param type
	 * @return 1:Alimentacion, 2:Vacunas, 3:Cerca, 4:Cuidados
	 */
	private ExpenseTypeBovine determineExpense(int type) {
		switch (type) {
		case 1:
			return ExpenseTypeBovine.FEEDING;
		case 2:
			return ExpenseTypeBovine.VACCINE;
		case 3:
			return ExpenseTypeBovine.FENCE;
		case 4:
			return ExpenseTypeBovine.CARE;
		}
		return null;
	}
	
	/**
	 * Metodo para añadir un gasto dependiendo del subGrupo de Bovinos
	 * @param type : 1 : si es sin destetar, 2:Levante, 3: Engorde, 4:Lechero
	 * @param typeExpense 
	 * @param price 
	 */
	public void addExpense(int type, int typeExpense, double price) {
		switch (type) {
		case 1:
			expenseListBabyCattle.add(new ExpenseBovine(determineExpense(typeExpense), price));
			break;
		case 2:
			expenseListLevantCattle.add(new ExpenseBovine(determineExpense(typeExpense), price));
			break;
		case 3:
			expenseListFatteningCattle.add(new ExpenseBovine(determineExpense(typeExpense), price));
			break;
		case 4:
			expenseListDairyCattle.add(new ExpenseBovine(determineExpense(typeExpense), price));
			break;
		}
	}
	
	/**
	 * Metodo para obtener gastos totales por tipo de bovino 
	 * @param type
	 * @return
	 */
	public double getTotalExpensesByType(int type) {
		double totalValue = 0;
		switch (type) {
		case 1:
			for (int i = 0; i < expenseListBabyCattle.size(); i++) {
				totalValue += expenseListBabyCattle.get(i).getPrice();
			}
			break;
		case 2:
			for (int i = 0; i < expenseListLevantCattle.size(); i++) {
				totalValue += expenseListLevantCattle.get(i).getPrice();
			}
			break;
		case 3:
			for (int i = 0; i < expenseListFatteningCattle.size(); i++) {
				totalValue += expenseListFatteningCattle.get(i).getPrice();
			}
			break;
		case 4:
			for (int i = 0; i < expenseListDairyCattle.size(); i++) {
				totalValue += expenseListDairyCattle.get(i).getPrice();
			}
			break;
		}
		return totalValue;
	}
	
	/**
	 * Metodo para obtener porcentaje de gastos por tipo de bovino
	 * @return
	 */
	public HashMap<String, Double> obtainExpensePercentagesByType(){
		double valueExpensesBaby = getTotalExpensesByType(1);
		double valueExpenseLevant = getTotalExpensesByType(2);
		double valueExpenseFatting = getTotalExpensesByType(3);
		double valueExpenseDairy = getTotalExpensesByType(4);
		double totalExpenses = valueExpensesBaby + valueExpenseLevant + valueExpenseFatting + valueExpenseDairy;
		HashMap<String, Double> percentages = new HashMap<String, Double>();
		percentages.put(TypeBovine.BABY_CATTLE.getLabel(),(double)(valueExpensesBaby * HUNDRED_PERCENT)/totalExpenses);
		percentages.put(TypeBovine.LEVANT_CATTLE.getLabel(),(double)(valueExpenseLevant * HUNDRED_PERCENT)/totalExpenses);
		percentages.put(TypeBovine.FATTENING_CATTLE.getLabel(),(double)(valueExpenseFatting * HUNDRED_PERCENT)/totalExpenses);
		percentages.put(TypeBovine.DAIRY_CATTLE.getLabel(),(double)(valueExpenseDairy * HUNDRED_PERCENT)/totalExpenses);
		return percentages;
	}
	
	/**
	 * Metodo para obtener el porcentaje del numero de bovinos por tipo
	 * @return
	 */
	public HashMap<String, Double> obtainPercentageOfNumberOfCattle(){
		double numberbabyCattle = babyCattle.size();
		double numberlevantCattle = levantCattle.size();
		double numberfatteningCattle = fatteningCattle.size();
		double numberDairyCattle = dairyCattle.size();
		double totalCattle = numberbabyCattle + numberlevantCattle + numberfatteningCattle + numberDairyCattle;
		HashMap<String, Double> percentages = new HashMap<String, Double>();
		percentages.put(TypeBovine.BABY_CATTLE.getLabel(),(double)(numberbabyCattle * HUNDRED_PERCENT)/totalCattle);
		percentages.put(TypeBovine.LEVANT_CATTLE.getLabel(),(double)(numberlevantCattle * HUNDRED_PERCENT)/totalCattle);
		percentages.put(TypeBovine.FATTENING_CATTLE.getLabel(),(double)(numberfatteningCattle * HUNDRED_PERCENT)/totalCattle);
		percentages.put(TypeBovine.DAIRY_CATTLE.getLabel(),(double)(numberDairyCattle * HUNDRED_PERCENT)/totalCattle);
		return percentages;
	}
	
	/**
	 * Metodo para obtener el porcentaje de compras por tipo
	 * @return
	 */
	public HashMap<String, Double> getPercentageOfBoughtByType(){
		HashMap<String, Double> percentages = new HashMap<String, Double>();
		int boughtBabyCattle = 0;
		int boughtLevantCattle = 0;
		int boughtFateningCattle = 0;
		int boughtDairyCattle = 0;
		for (int i = 0; i < cattleBought.size(); i++) {
			if(cattleBought.get(i).getType().equals(TypeBovine.BABY_CATTLE)) {
				boughtBabyCattle++;
			}else if(cattleBought.get(i).getType().getLabel().equals(TypeBovine.LEVANT_CATTLE.getLabel())) {
				boughtLevantCattle++;
			}else if(cattleBought.get(i).getType().getLabel().equals(TypeBovine.FATTENING_CATTLE.getLabel())) {
				boughtFateningCattle++;
			}else if(cattleBought.get(i).getType().getLabel().equals(TypeBovine.DAIRY_CATTLE.getLabel())) {
				boughtDairyCattle++;
			}	
		}
		int totalBougth = boughtBabyCattle + boughtLevantCattle + boughtFateningCattle + boughtDairyCattle;
		percentages.put(TypeBovine.BABY_CATTLE.getLabel(), (double) ((boughtBabyCattle * HUNDRED_PERCENT)/totalBougth));
		percentages.put(TypeBovine.LEVANT_CATTLE.getLabel(), (double) ((boughtLevantCattle * HUNDRED_PERCENT)/totalBougth));
		percentages.put(TypeBovine.FATTENING_CATTLE.getLabel(), (double) ((boughtFateningCattle * HUNDRED_PERCENT)/totalBougth));
		percentages.put(TypeBovine.DAIRY_CATTLE.getLabel(), (double) ((boughtDairyCattle * HUNDRED_PERCENT)/totalBougth));
		return percentages;
	}
	
	/**
	 * Metodo para obtener el procentaje de ventas(en cantidad) por tipo
	 * @return el HashMap con la informacion de los porcentajes
	 */
	public HashMap<String, Double> getPercentagesSalesByType(){
		HashMap<String, Double> percentages = new HashMap<String, Double>();
		int salesBabyCattle = 0;
		int salesLevantCattle = 0;
		int salesFateningCattle = 0;
		int salesDairyCattle = 0;
		for (int i = 0; i < cattleSold.size(); i++) {
			if(cattleSold.get(i).getType().equals(TypeBovine.BABY_CATTLE)) {
				salesBabyCattle++;
			}else if(cattleSold.get(i).getType().equals(TypeBovine.LEVANT_CATTLE)) {
				salesLevantCattle++;
			}else if(cattleSold.get(i).getType().equals(TypeBovine.FATTENING_CATTLE)) {
				salesFateningCattle++;
			}else if(cattleSold.get(i).getType().equals(TypeBovine.DAIRY_CATTLE)) {
				salesDairyCattle++;
			}	
		}
		int totalSales = salesBabyCattle + salesLevantCattle + salesFateningCattle + salesDairyCattle;
		percentages.put(TypeBovine.BABY_CATTLE.getLabel(), (double) ((salesBabyCattle * HUNDRED_PERCENT)/totalSales));
		percentages.put(TypeBovine.LEVANT_CATTLE.getLabel(), (double) ((salesLevantCattle * HUNDRED_PERCENT)/totalSales));
		percentages.put(TypeBovine.FATTENING_CATTLE.getLabel(), (double) ((salesFateningCattle * HUNDRED_PERCENT)/totalSales));
		percentages.put(TypeBovine.DAIRY_CATTLE.getLabel(), (double) ((salesDairyCattle * HUNDRED_PERCENT)/totalSales));
		return percentages;
	}
	
	/**
	 * Metodo para obtener el porcentaje de ventas (en valor) por tipo 
	 * @return
	 */
	public HashMap<String, Double> getPercentagesSalesByTypeB(){
		HashMap<String, Double> percentages = new HashMap<String, Double>();
		int salesBabyCattle = 0;
		int salesLevantCattle = 0;
		int salesFateningCattle = 0;
		int salesDairyCattle = 0;
		for (int i = 0; i < cattleSold.size(); i++) {
			if(cattleSold.get(i).getType().equals(TypeBovine.BABY_CATTLE)) {
				salesBabyCattle += cattleSold.get(i).getSaleValue();
			}else if(cattleSold.get(i).getType().getLabel().equals(TypeBovine.LEVANT_CATTLE.getLabel())) {
				salesLevantCattle += cattleSold.get(i).getSaleValue();
			}else if(cattleSold.get(i).getType().getLabel().equals(TypeBovine.FATTENING_CATTLE.getLabel())) {
				salesFateningCattle += cattleSold.get(i).getSaleValue();
			}else if(cattleSold.get(i).getType().getLabel().equals(TypeBovine.DAIRY_CATTLE.getLabel())) {
				salesDairyCattle += cattleSold.get(i).getSaleValue();
			}	
		}
		int totalSales = salesBabyCattle + salesLevantCattle + salesFateningCattle + salesDairyCattle;
		percentages.put(TypeBovine.BABY_CATTLE.getLabel(), (double) ((salesBabyCattle * HUNDRED_PERCENT)/totalSales));
		percentages.put(TypeBovine.LEVANT_CATTLE.getLabel(), (double) ((salesLevantCattle * HUNDRED_PERCENT)/totalSales));
		percentages.put(TypeBovine.FATTENING_CATTLE.getLabel(), (double) ((salesFateningCattle * HUNDRED_PERCENT)/totalSales));
		percentages.put(TypeBovine.DAIRY_CATTLE.getLabel(), (double) ((salesDairyCattle * HUNDRED_PERCENT)/totalSales));
		return percentages;
	}
	
	/**
	 * Metodo para obtener el porcentaje de compras(en valor) por tipo
	 * @return
	 */
	public HashMap<String, Double> getPercentageOfBoughtByTypeB(){
		HashMap<String, Double> percentages = new HashMap<String, Double>();
		int boughtBabyCattle = 0;
		int boughtLevantCattle = 0;
		int boughtFateningCattle = 0;
		int boughtDairyCattle = 0;
		for (int i = 0; i < cattleBought.size(); i++) {
			if(cattleBought.get(i).getType().equals(TypeBovine.BABY_CATTLE)) {
				boughtBabyCattle += cattleBought.get(i).getSaleValue();
			}else if(cattleBought.get(i).getType().getLabel().equals(TypeBovine.LEVANT_CATTLE.getLabel())) {
				boughtLevantCattle += cattleBought.get(i).getSaleValue();
			}else if(cattleBought.get(i).getType().getLabel().equals(TypeBovine.FATTENING_CATTLE.getLabel())) {
				boughtFateningCattle += cattleBought.get(i).getSaleValue();
			}else if(cattleBought.get(i).getType().getLabel().equals(TypeBovine.DAIRY_CATTLE.getLabel())) {
				boughtDairyCattle += cattleBought.get(i).getSaleValue();
			}	
		}
		int totalBougth = boughtBabyCattle + boughtLevantCattle + boughtFateningCattle + boughtDairyCattle;
		percentages.put(TypeBovine.BABY_CATTLE.getLabel(), (double) ((boughtBabyCattle * HUNDRED_PERCENT)/totalBougth));
		percentages.put(TypeBovine.LEVANT_CATTLE.getLabel(), (double) ((boughtLevantCattle * HUNDRED_PERCENT)/totalBougth));
		percentages.put(TypeBovine.FATTENING_CATTLE.getLabel(), (double) ((boughtFateningCattle * HUNDRED_PERCENT)/totalBougth));
		percentages.put(TypeBovine.DAIRY_CATTLE.getLabel(), (double) ((boughtDairyCattle * HUNDRED_PERCENT)/totalBougth));
		return percentages;
	}
	
	/**
	 * Obtener lista de gastos por tipo de bovino
	 * @param type 1:Sin destetar, 2:levante, 3:Engorde, 4:Lechero
	 * @return
	 */
	public String[][] generateExpenseTableByType(int type){
		String[][] expenses = null;
		switch (type) {
		case 1:
			expenses = new String[expenseListBabyCattle.size()][2];
			for (int i = 0; i < expenseListBabyCattle.size(); i++) {
				expenses[i][0] = expenseListBabyCattle.get(i).getExpenseTypeBovine().getLabel();
				expenses[i][1] = String.valueOf(expenseListBabyCattle.get(i).getPrice());
			}
			return expenses;
		case 2:
			expenses = new String[expenseListLevantCattle.size()][2];
			for (int i = 0; i < expenseListLevantCattle.size(); i++) {
				expenses[i][0] = expenseListLevantCattle.get(i).getExpenseTypeBovine().getLabel();
				expenses[i][1] = String.valueOf(expenseListLevantCattle.get(i).getPrice());
			}
			return expenses;
		case 3:
			expenses = new String[expenseListFatteningCattle.size()][2];
			for (int i = 0; i < expenseListFatteningCattle.size(); i++) {
				expenses[i][0] = expenseListFatteningCattle.get(i).getExpenseTypeBovine().getLabel();
				expenses[i][1] = String.valueOf(expenseListFatteningCattle.get(i).getPrice());
			}
			return expenses;
		case 4:
			expenses = new String[expenseListDairyCattle.size()][2];
			for (int i = 0; i < expenseListDairyCattle.size(); i++) {
				expenses[i][0] = expenseListDairyCattle.get(i).getExpenseTypeBovine().getLabel();
				expenses[i][1] = String.valueOf(expenseListDairyCattle.get(i).getPrice());
			}
			return expenses;
		}
		return expenses;
	}
	
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

	/**
	 * @return the expenseListBabyCattle
	 */
	public ArrayList<ExpenseBovine> getExpenseListBabyCattle() {
		return expenseListBabyCattle;
	}

	/**
	 * @return the expenseListLevantCattle
	 */
	public ArrayList<ExpenseBovine> getExpenseListLevantCattle() {
		return expenseListLevantCattle;
	}

	/**
	 * @return the expenseListFatteningCattle
	 */
	public ArrayList<ExpenseBovine> getExpenseListFatteningCattle() {
		return expenseListFatteningCattle;
	}

	/**
	 * @return the expenseListDairyCattle
	 */
	public ArrayList<ExpenseBovine> getExpenseListDairyCattle() {
		return expenseListDairyCattle;
	}
	
	public ArrayList<BovineSalePurchase> getCattleSold(){
		return cattleSold;
	}
	
	@Override
	public String toString() {
		return (TypeBovine.BABY_CATTLE.getLabel() + SAME + babyCattle.size() + SKIP_LINE +
				TypeBovine.LEVANT_CATTLE.getLabel() + SAME + levantCattle.size() + SKIP_LINE +
				TypeBovine.FATTENING_CATTLE.getLabel() + SAME + fatteningCattle.size() + SKIP_LINE +
				TypeBovine.DAIRY_CATTLE.getLabel() + SAME + dairyCattle.size() + SKIP_LINE );
	}
}