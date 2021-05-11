package models;

import java.time.LocalDate;

public class CorralSales {

	
	private LocalDate lastSale;
	private int numberEgss;
	private double saleValue;
	
	public CorralSales(int numberEggs, double salesValue, LocalDate date) {
		this.numberEgss = numberEggs;
		this.saleValue = salesValue;
		this.lastSale = date;
	}
	
	

	public LocalDate getLastSale() {
		return lastSale;
	}

	public void setLastSale(LocalDate lastSale) {
		this.lastSale = lastSale;
	}

	public int getNumberEgss() {
		return numberEgss;
	}

	public void setNumberEgss(int numberEgss) {
		this.numberEgss = numberEgss;
	}

	public double getSaleValue() {
		return saleValue;
	}

	public void setSaleValue(double saleValue) {
		this.saleValue = saleValue;
	}
	
	
}
