package Classes;

import java.util.Date;

public class Detained {
	private String name;
	private String lastName;
	private Date age;
	private Gender gender;
	
	public Detained(String name, String lastName, Date age, Gender gender) {
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
		this.age = new Date();
		this.gender = Gender.OTHER;
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

	public Date getAge() {
		return age;
	}

	public void setAge(Date age) {
		this.age = age;
	}
	

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Detained name: " + name + " " + lastName + ".  Age: " + age + "]";
	}
	
	
	
}
