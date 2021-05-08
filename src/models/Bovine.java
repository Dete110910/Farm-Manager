package models;


import java.time.LocalDate;

public class Bovine extends Animal{
	
	private byte id;
	private double purchaseValue;
	private TypeBovine currentType;
	public static final String AGE = "Edad : ";
	public static final String LINE_BREAK = "\n";
	public static final String ID = "Id : ";
	public static final String GENDER = "Genero : ";
	public static final String PURCHASE_VALUE = "Valor de compra : ";
	
	
	public Bovine(double purchaseValue, byte age, Gender gender, LocalDate dateOfAdmission) {
		super(age, gender, dateOfAdmission);
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
	
	public void setCurrentType(TypeBovine type) {
		this.currentType = type;
	}
	
	public TypeBovine getTypeBovine() {
		return this.currentType;
	}
	
	@Override
	public String toString() {
		return (LINE_BREAK + ID + id + LINE_BREAK +
				GENDER + getGender().getLabel() + LINE_BREAK +
				AGE + getAge() + LINE_BREAK +
				PURCHASE_VALUE + purchaseValue + LINE_BREAK);
	}
	
	public static void main(String[] args) {
		Bovine bovine = new Bovine(50000, (byte)5, Gender.MALE, LocalDate.of(2021, 01, 04));
		System.out.println(bovine.getAge());
	}
}