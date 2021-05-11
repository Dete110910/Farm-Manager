package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.HashMap;

import models.ExpenseTypeCrop;
import models.Farm;
import models.PlantSpecie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

 class TestCrop {
	
	private Farm farm;

	TestCrop(){
		farm = new Farm("la granja", 100, 100, 200, 123);;
	}

	@BeforeEach
	void initAll() {
		farm.addCropTypeInProgress(PlantSpecie.POTATO,LocalDate.of(2021, 02, 20), 30, farm.calculateEstimatedProduction(PlantSpecie.POTATO,30), 2000);
		farm.addCropTypeInProgress(PlantSpecie.VETCH,LocalDate.of(2021, 02, 20), 10, farm.calculateEstimatedProduction(PlantSpecie.VETCH,10), 400);
		farm.addCropTypeInProgress(PlantSpecie.CORN,LocalDate.of(2021, 02, 20), 20, farm.calculateEstimatedProduction(PlantSpecie.CORN,15), 5000);
		farm.addCropTypeInProgress(PlantSpecie.BEANS,LocalDate.of(2021, 02, 20), 15, farm.calculateEstimatedProduction(PlantSpecie.BEANS,15), 700);
		farm.addCropTypeInProgress(PlantSpecie.POTATO,LocalDate.of(2021, 02, 20), 20, farm.calculateEstimatedProduction(PlantSpecie.POTATO,20), 120);
		farm.addCropTypeInProgress(PlantSpecie.CORN,LocalDate.of(2021, 02, 20), 50, farm.calculateEstimatedProduction(PlantSpecie.CORN,50), 200);
		farm.addCropTypeInProgress(PlantSpecie.BEANS,LocalDate.of(2021, 02, 20), 25, farm.calculateEstimatedProduction(PlantSpecie.BEANS,25), 5020);
		farm.addCropTypeInProgress(PlantSpecie.VETCH,LocalDate.of(2021, 04, 20), 30, farm.calculateEstimatedProduction(PlantSpecie.VETCH,30), 1232);

		farm.getCropsInProgress().get(0).addExpense(ExpenseTypeCrop.CARE, 1000);
		farm.getCropsInProgress().get(1).addExpense(ExpenseTypeCrop.HARVEST, 10000);
		farm.getCropsInProgress().get(2).addExpense(ExpenseTypeCrop.SOWING, 2000);
		farm.getCropsInProgress().get(3).addExpense(ExpenseTypeCrop.PREPARATION_GROUND, 1000);
	}
	
	@Test
	void testPercentageOfLandOcuppiedbyCrop() {
		HashMap<String, Double> landOcuppiedRes = farm.getPercetageOfLandOcuppiedBySpecie();
		HashMap<String, Double> landOcuppiedExpected = new HashMap<String, Double>();;
		landOcuppiedExpected.put("Papa", 50.0);
		landOcuppiedExpected.put("Arveja", 40.0);		
		landOcuppiedExpected.put("Frijol", 40.0);
		landOcuppiedExpected.put("Maíz", 70.0);
		
		assertEquals(landOcuppiedRes, landOcuppiedExpected);
	}
	
	@Test
	void testPercentageOfCrops() {
		HashMap<String, Double> percentageOfCrops = farm.getPercentageOfCrops();
		HashMap<String, Double> percentageOfCropsExpected = new HashMap<String, Double>();
		percentageOfCropsExpected.put("Papa", 25.0);
		percentageOfCropsExpected.put("Arveja", 25.0);
		percentageOfCropsExpected.put("Frijol", 25.0);
		percentageOfCropsExpected.put("Maíz", 25.0);
		assertEquals(percentageOfCrops, percentageOfCropsExpected);
	}
	
	@Test
	void testPercentageOfExpensesByTypeCrop() {
		HashMap<String, Double> percentageOfExpensesByCrop = farm.getPercentageOfExpensesByTypeCrop();
		HashMap<String, Double> percentageOfExpensesByCropExpected = new HashMap<String, Double>();
		percentageOfExpensesByCropExpected.put("Papa", 7.142857142857143);
		percentageOfExpensesByCropExpected.put("Arveja", 71.42857142857143);
		percentageOfExpensesByCropExpected.put("Frijol", 7.142857142857143);
		percentageOfExpensesByCropExpected.put("Maíz", 14.285714285714286);
		assertEquals(percentageOfExpensesByCrop, percentageOfExpensesByCropExpected);
		}
	
	

}
