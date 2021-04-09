package presenters;

import models.Farm;
import views.Console;

import models.Farm;

public class PresenterApp {
	
	private Farm farm;
	private Console console;
	
	public PresenterApp() {
		console = new Console();
		String nameOfFarm = console.readNameOfFarm();
		double[] grounds = console.readGrounds();
		farm = new Farm(nameOfFarm, grounds[0], grounds[1], grounds[2], console.readInitialCapital());
		this.runApp();
	}
	
	private void runApp() {
		
		byte option = 0;
		
		switch(option) {
			case 1:
				
		}
	
	}
	
	

}
