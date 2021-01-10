package classes;

import java.util.Date;

public class Workers2 extends Workers {
	

	public Workers2(int code, int grade, String name, String surname, String gender, classes.Specialty specialty,
			String startWorkingIn, String assesment) {
		super(code, grade, name, surname, gender, specialty, startWorkingIn, assesment);
		
	}
	
	public Workers2() {
		super();
		
	}


	@Override
	public String toString() {
		return " worker" +code+ ": Function: Worker. Grade: " + grade + ". Name: " + name + ", " + surname + ". Gender: "
				+ gender + ". Specialty: " + Specialty + ". He/She start workin in " + startWorkingIn + ". Assesment: "
				+ Assesment;
	}

	
	
	
	
	
}
