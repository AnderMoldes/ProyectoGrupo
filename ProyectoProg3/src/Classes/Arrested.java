package Classes;

import java.util.Date;

public class Arrested extends Detained{
	public static int counter = 1;
	private int numberOfArrest;
	private String description;
	private Date jailRelease;
	
	public Arrested(String name, String lastName, Date age, Gender gender, int numberOfArrest, String description,
			Date jailRelease) {
		super(name, lastName, age, gender);
		this.numberOfArrest = counter++;
		this.description = description;
		this.jailRelease = jailRelease;
	}

	public Arrested() {
		super();
		this.numberOfArrest = 0;
		this.description = "";
		this.jailRelease = new Date();
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
	public Date getJailRelease() {
		return jailRelease;
	}
	public void setJailRelease(Date jailRelease) {
		this.jailRelease = jailRelease;
	}
	@Override
	public String toString() {
		return "Arrested number: " + numberOfArrest + " Why is he/she arrested? " + description + " When is going to leave? "
				+ jailRelease;
	}
	
	
	

}
