package Classes;

import java.util.Date;

public class Arrested extends Detained {
	public static int counter = 1;
	private int numberOfArrest;
	private String description;
	private String jailRelease;

	public Arrested(String name, String lastName, int age, String gender, int numberOfArrest, String description,
			String jailRelease) {
		super(name, lastName, age, gender);
		this.numberOfArrest = counter++;
		this.description = description;
		this.jailRelease = jailRelease;
	}

	public Arrested() {
		super();

		this.description = "";
		this.jailRelease = "";
	}

	public int getNumberOfArrest() {
		return numberOfArrest;
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
		return "Arrested number: " + numberOfArrest + " Why is he/she arrested? " + description
				+ " When is going to leave? " + jailRelease;
	}

}
