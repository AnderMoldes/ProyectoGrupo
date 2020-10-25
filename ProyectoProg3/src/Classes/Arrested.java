package Classes;

import java.util.Date;

public class Arrested extends Detained{
	public static int counter = 1;
	private String name_a;
	private String lastName_a;
	private Date age_a;
	private String description;
	public Arrested(String name, String lastName, int age, String name_a, String lastName_a, Date age_a,
			String description) {
		super(name, lastName, age);
		this.counter = counter++;
		this.name_a = name_a;
		this.lastName_a = lastName_a;
		this.age_a = age_a;
		this.description = description;
	}
	public Arrested() {
		super();
		this.name_a = "";
		this.lastName_a = "";
		this.age_a = new Date();
		this.description = "";
	}
	@Override
	public String toString() {
		return "Arrested name: " + name_a + ". Last name: " + lastName_a + ". Age: " + age_a + ". The description: "
				+ description;
	}
	
	
	

}
