package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.HashMap;

import models.Farm;
import models.PlantSpecie;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class TestFarm {
	
	private Farm farm;
	
	public TestFarm (){
		farm = new Farm("la granja", 100, 100, 200, 123);
	}
	
	@Before
	public void before() {
		farm.addCropTypeInProgress(PlantSpecie.POTATO,LocalDate.of(2021, 02, 20), 30, farm.calculateEstimatedProduction(PlantSpecie.POTATO,30), 2000);
		farm.addCropTypeInProgress(PlantSpecie.VETCH,LocalDate.of(2021, 02, 20), 10, farm.calculateEstimatedProduction(PlantSpecie.VETCH,10), 400);
		farm.addCropTypeInProgress(PlantSpecie.CORN,LocalDate.of(2021, 02, 20), 20, farm.calculateEstimatedProduction(PlantSpecie.CORN,15), 5000);
		farm.addCropTypeInProgress(PlantSpecie.BEANS,LocalDate.of(2021, 02, 20), 15, farm.calculateEstimatedProduction(PlantSpecie.BEANS,15), 700);
		farm.addCropTypeInProgress(PlantSpecie.POTATO,LocalDate.of(2021, 02, 20), 20, farm.calculateEstimatedProduction(PlantSpecie.POTATO,20), 120);
		farm.addCropTypeInProgress(PlantSpecie.CORN,LocalDate.of(2021, 02, 20), 50, farm.calculateEstimatedProduction(PlantSpecie.CORN,50), 200);
		farm.addCropTypeInProgress(PlantSpecie.BEANS,LocalDate.of(2021, 02, 20), 25, farm.calculateEstimatedProduction(PlantSpecie.BEANS,25), 5020);
		farm.addCropTypeInProgress(PlantSpecie.VETCH,LocalDate.of(2021, 04, 20), 30, farm.calculateEstimatedProduction(PlantSpecie.VETCH,30), 1232);

		}
	@Before
	public HashMap<String, Double> landOcuppiedExpected(){
		HashMap<String, Double> landOcuppiedEsp = new HashMap<String, Double>();
		landOcuppiedEsp.put("Papa", 50.0);
		landOcuppiedEsp.put("Arveja", 40.0);		
		landOcuppiedEsp.put("Frijol", 40.0);
		landOcuppiedEsp.put("Maíz", 70.0);
		return landOcuppiedEsp;
	}

	@Test
	void testPercentageOfLandOcuppiedbyCrop() {
		this.before();
		HashMap<String, Double> landOcuppiedRes = farm.getPercetageOfLandOcuppiedBySpecie();
		HashMap<String, Double> landOcuppiedExpected = this.landOcuppiedExpected();
		assertEquals(landOcuppiedRes, landOcuppiedExpected);
	}
	
	

}
