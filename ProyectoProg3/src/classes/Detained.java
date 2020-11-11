package classes;

import java.util.Date;

public class Detained {
	private String name;
	private String lastName;
	private int age;
	private String gender;
	
	public Detained(String name, String lastName, int age, String gender) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
	}
	
	public Detained() {
		super();
		this.name = "";
		this.lastName = "";
		this.age = 0;
		this.gender = "";
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
		return "Detained name: " + name + " " + lastName + ".  Age: " + age + "]";
	}
	
	
	
}
