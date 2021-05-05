package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import models.Farm;
import models.PlantSpecie;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class TestFarm {
	
	private Farm farm;
	
	public TestFarm (){
		farm = new Farm("Granja", 200, 200, 400, 20000);
	}
	
	@Before
	public void createCrop() {
		farm.addCropTypeInProgress(PlantSpecie.POTATO,LocalDate.of(2021, 02, 20), 30, farm.calculateEstimatedProduction(PlantSpecie.POTATO,2), 2000);
		farm.addCropTypeInProgress(PlantSpecie.VETCH,LocalDate.of(2021, 02, 20), 10, farm.calculateEstimatedProduction(PlantSpecie.VETCH,2), 400);
		farm.addCropTypeInProgress(PlantSpecie.CORN,LocalDate.of(2021, 02, 20), 15, farm.calculateEstimatedProduction(PlantSpecie.CORN,2), 5000);
		farm.addCropTypeInProgress(PlantSpecie.BEANS,LocalDate.of(2021, 02, 20), 15, farm.calculateEstimatedProduction(PlantSpecie.BEANS,2), 700);
		farm.addCropTypeInProgress(PlantSpecie.POTATO,LocalDate.of(2021, 02, 20), 20, farm.calculateEstimatedProduction(PlantSpecie.POTATO,2), 120);
		farm.addCropTypeInProgress(PlantSpecie.CORN,LocalDate.of(2021, 02, 20), 50, farm.calculateEstimatedProduction(PlantSpecie.CORN,2), 200);
		farm.addCropTypeInProgress(PlantSpecie.BEANS,LocalDate.of(2021, 02, 20), 25, farm.calculateEstimatedProduction(PlantSpecie.BEANS,2), 5020);
		farm.addCropTypeInProgress(PlantSpecie.VETCH,LocalDate.of(2021, 04, 20), 30, farm.calculateEstimatedProduction(PlantSpecie.VETCH,2), 1232);

		}

	@Test
	void testPercentageOfLandOcuppiedbyCrop() {
		farm.getPercetageOfLandOcuppiedBySpecie();
		
	}
	
	

}
