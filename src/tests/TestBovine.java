package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.Bovine;
import models.Farm;
import models.Gender;

public class TestBovine {
	
	private Farm farm;
	
	TestBovine(){
		farm = new Farm("la granja", 100, 100, 200, 123);
	}
	
	@BeforeEach
	void initAll() {
		farm.getGroupBovine().addBovine(new Bovine(50000, (byte) 5, Gender.MALE, LocalDate.now()));
		farm.getGroupBovine().addBovine(new Bovine(50000, (byte) 4, Gender.FEMALE, LocalDate.now()));
		farm.getGroupBovine().addBovine(new Bovine(50000, (byte)13, Gender.MALE, LocalDate.now()));
		farm.getGroupBovine().addBovine(new Bovine(50000, (byte)16, Gender.FEMALE, LocalDate.now()));
		farm.getGroupBovine().addBovine(new Bovine(50000, (byte)20, Gender.MALE, LocalDate.now()));
		farm.getGroupBovine().addBovine(new Bovine(50000, (byte)2, Gender.MALE, LocalDate.of(2021, 01, 5)));
	}
	
	@Test
	void testGetTotalExpensesByTypeCrop() {
		double[] totalExpensesExpected = new double[4];
		double[] totalExpenses = new double[4];
		totalExpenses[0] = farm.getGroupBovine().getTotalExpensesByType(0);
		totalExpenses[1] = farm.getGroupBovine().getTotalExpensesByType(1);
		totalExpenses[2] = farm.getGroupBovine().getTotalExpensesByType(2);
		totalExpenses[3] = farm.getGroupBovine().getTotalExpensesByType(3);
		
		totalExpensesExpected[0] = 0.0;
		totalExpensesExpected[1] = 0.0;
		totalExpensesExpected[2] = 0.0;
		totalExpensesExpected[3] = 0.0;
		
		assertArrayEquals(totalExpenses, totalExpensesExpected);
	}
	
	@Test
	void testPercentageOfNumberCattle() {
		HashMap<String, Double> percentages = farm.getGroupBovine().obtainPercentageOfNumberOfCattle();
		HashMap<String, Double> percentagesExpected = new HashMap<String, Double>();
		percentagesExpected.put("Vaca lechera", 16.666666666666668);
		percentagesExpected.put("Ganado de engorde", 16.666666666666668);
		percentagesExpected.put("Ganado sin destetar", 33.333333333333336);
		percentagesExpected.put("Ganado de levante", 33.333333333333336);
		
		assertEquals(percentages, percentagesExpected);
	}

}
