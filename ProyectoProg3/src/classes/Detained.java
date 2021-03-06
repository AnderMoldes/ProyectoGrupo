package classes;

import java.io.Serializable;
import java.util.Date;

public class Detained implements Asignable,Serializable{
	
	
	protected int identificative;
	protected String name;
	protected String lastName;
	protected int age;
	protected String gender;
	
	
	
	

	public Detained(int identificative, String name, String lastName, int age, String gender) {
		super();
		this.identificative = identificative;
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
	}



	public Detained() {
		super();
		this.identificative= 0;
		this.name = "";
		this.lastName = "";
		this.age = 0;
		this.gender = "";
	}
	
	
	public int getIdentificative() {
		return identificative;
	}
	
	public void setIdentificative(int identificative) {
		this.identificative = identificative;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Detained = " + name + ", " + lastName + ", "
				+ age + ", " + gender + "";
	}

	
	
	
	
}
