package classes;

import java.util.Date;

public class Boss extends Workers{
	public static int counter = 1;
	private int codeBoss;
	private String function;
	

	public Boss(int code, int grade, String name, String surname, String gender, classes.Specialty specialty,
			Date startWorkingIn, String assesment, int codeBoss, String function) {
		super(code, grade, name, surname, gender, specialty, startWorkingIn, assesment);
		this.codeBoss = counter++;
		this.function = function;
	}

	public Boss() {
		super();
		this.codeBoss = counter++;
		this.function = "";
	}
	

	public static int getCounter() {
		return counter;
	}


	public int getCodeBoss() {
		return codeBoss;
	}

	public void setCodeBoss(int codeBoss) {
		this.codeBoss = codeBoss;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	@Override
	public String toString() {
		return "Code of the Worker: " + code+ ". Function: Boss. Code of the boss: "+ codeBoss + 
				". Name: " + name + " " + surname + "Gender: " + gender + " Specialty: " + Specialty
				+ "Start Working: " + startWorkingIn + ". Assessment: " + Assesment;
	}

	
	
	
	

}
