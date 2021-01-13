package classes;

import java.util.Date;

import classes.Specialty.SpecialtyEnum;

public class Boss extends Workers{
	private String function;
	

	public Boss(int code, int grade, String name, String surname, String gender, SpecialtyEnum specialty,
			String startWorkingIn, String assesment, String function) {
		super(code, grade, name, surname, gender, specialty, startWorkingIn, assesment);
		this.function = function;
	}

	public Boss() {
		super();
		this.function = "";
	}


	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	@Override
	public String toString() {
		return "  Boss " +code+ ": . Function:" +function+ ". Name: " + name + " " 
				+ surname + "Gender: " + gender + " Specialty: " + Specialty
				+ "Start Working: " + startWorkingIn + ". Assessment: " + Assesment;
	}	
	public int compareTo(Workers o) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(o.getName());
	}
	
	
	
	

}
