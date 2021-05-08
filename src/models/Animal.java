package models;

import static java.time.temporal.ChronoUnit.DAYS;
import java.time.LocalDate;

public class Animal {
	
	private byte age;
	private Gender gender;
	private LocalDate dateOfAdmission;
	
	public Animal (byte age, Gender gender, LocalDate dateOfAdmission) {
		this.age = age;
		this.gender = gender;
		this.dateOfAdmission = dateOfAdmission;
	}
	
	

	protected void increaseAge() {
		age++;
	}
	
	public void setAge(byte age) {
		this.age = age;
	}
	
	public byte getAge() {
		return (byte)((Math.round((double)((int) DAYS.between(dateOfAdmission, LocalDate.now()))/30)) + age);
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setDateOfAdmission(LocalDate dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}
	
	public LocalDate getDateOfAdmission() {
		return dateOfAdmission;
	}
	
	

}
