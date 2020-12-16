package classes;

import java.util.Date;

public class Detained {
	
	public static int container= 1;
	
	protected int identificative;
	protected String name;
	protected String lastName;
	protected int age;
	protected String gender;
	
	
	
	

	public Detained(int identificative, String name, String lastName, int age, String gender) {
		super();
		this.identificative = container++;
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
	}



	public Detained() {
		super();
		this.identificative= container++;
		this.name = "";
		this.lastName = "";
		this.age = 0;
		this.gender = "";
	}
	
	

	public static int getContainer() {
		return container++;
	}

	public int getIdentificative() {
		return identificative;
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
		return "Detained " + identificative + " = " + name + ", " + lastName + ", "
				+ age + ", " + gender + "";
	}

	
	
	
	
}
