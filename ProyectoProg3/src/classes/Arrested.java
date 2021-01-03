package classes;

import java.util.Date;

public class Arrested extends Detained {
	
	protected int numberOfArrest;
	protected String description;
	protected String jailRelease;
	protected Country citizenship;
	

	public Arrested(int identificative, String name, String lastName, int age, String gender, int numberOfArrest,
			String description, String jailRelease, Country citizenship) {
		super(identificative, name, lastName, age, gender);
		this.numberOfArrest = numberOfArrest;
		this.description = description;
		this.jailRelease = jailRelease;
		this.citizenship = citizenship;
	}

	public Arrested() {
		super();
		this.numberOfArrest = 0;
		this.description = "";
		this.jailRelease = "";
		this.citizenship= null;
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

	public Country getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(Country citizenship) {
		this.citizenship = citizenship;
	}

	@Override
	public String toString() {
		return "Arrested = " + numberOfArrest + ", " + description + ", "
				+ jailRelease + ", " + identificative + ", " + name + ", " + lastName
				+ ", " + age + ", " + gender + "," +citizenship+ ", ";
	}

	

}
