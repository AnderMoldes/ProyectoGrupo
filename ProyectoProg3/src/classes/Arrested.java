package classes;

import java.util.Date;

public class Arrested extends Detained {
	
	protected int numberOfArrest;
	protected String description;
	protected String jailRelease;
	

	

	public Arrested(String name, String lastName, int age, String gender, int numberOfArrest, String description,
			String jailRelease) {
		super(name, lastName, age, gender);
		this.numberOfArrest = numberOfArrest;
		this.description = description;
		this.jailRelease = jailRelease;
	}

	public Arrested() {
		super();
		this.numberOfArrest = 0;
		this.description = "";
		this.jailRelease = "";
	}

	public int getNumberOfArrest() {
		return numberOfArrest;
	}

	public void setNumberOfArrest(int numberOfArrest) {
		this.numberOfArrest = numberOfArrest;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getJailRelease() {
		return jailRelease;
	}

	public void setJailRelease(String jailRelease) {
		this.jailRelease = jailRelease;
	}

	@Override
	public String toString() {
		return "Arrested" + identificative + " = " + numberOfArrest + ", " + description + ", "
				+ jailRelease + ", " + identificative + ", " + name + ", " + lastName
				+ ", " + age + ", " + gender + "";
	}

	

}
