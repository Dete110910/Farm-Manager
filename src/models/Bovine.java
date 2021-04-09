package models;

import java.time.LocalDate;

public class Bovine extends Animal{
	
	private byte id;
	private double purchaseValue;
	
	public Bovine(byte id, double purchaseValue, byte age, Gender gender, LocalDate dateOfAdmission) {
		super(age, gender, dateOfAdmission);
		this.id = id;
		this.purchaseValue = purchaseValue;
	}
	
	public void setId(byte id) {
		this.id = id;
	}
	
	public byte getId() {
		return this.id;
	}
	
	public void setPurchaseValue(double purchaseValue) {
		this.purchaseValue = purchaseValue;
	}
	
	public double getPurchaseValue() {
		return this.purchaseValue;
	}
	

}
