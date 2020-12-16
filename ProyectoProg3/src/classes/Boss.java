package classes;

import java.util.Date;

public class Boss extends Workers{
	private String function;
	

	public Boss(int code, int grade, String name, String surname, String gender, classes.Specialty specialty,
			Date startWorkingIn, String assesment, String function) {
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
		return "Code of the Worker: " + code+ ". Function:" +function+ ". Name: " + name + " " 
				+ surname + "Gender: " + gender + " Specialty: " + Specialty
				+ "Start Working: " + startWorkingIn + ". Assessment: " + Assesment;
	}	

	
	
	
	

}
