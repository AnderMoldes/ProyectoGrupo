package classes;

import java.util.Date;

public class Boss extends Workers{
	private int codeBoss;
	private String function;
	

	public Boss(int code, int grade, String name, String surname, String gender, classes.Specialty specialty,
			Date startWorkingIn, String assesment, int codeBoss, String function) {
		super(code, grade, name, surname, gender, specialty, startWorkingIn, assesment);
		this.codeBoss = codeBoss;
		this.function = function;
	}

	public Boss() {
		super();
		this.codeBoss = 0;
		this.function = "";
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
		return "Boss [codeBoss=" + codeBoss + ", function=" + function + ", code=" + code + ", grade=" + grade
				+ ", name=" + name + ", surname=" + surname + ", gender=" + gender + ", Specialty=" + Specialty
				+ ", startWorkingIn=" + startWorkingIn + ", Assesment=" + Assesment + "]";
	}

	
	
	
	

}
