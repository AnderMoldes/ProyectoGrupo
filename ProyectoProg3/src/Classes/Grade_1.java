package Classes;

public class Grade_1 extends Workers{
	
	private String specialty;
	private int workingYears;
	private int assessment;
	
	public Grade_1(int code, String name, String surname, String gender, String specialty, int workingYears,
			int assessment) {
		super(code, name, surname, gender);
		this.specialty = specialty;
		this.workingYears = workingYears;
		this.assessment = assessment;
	}
	
	public Grade_1() {
		super();
		this.specialty = "";
		this.workingYears = 0;
		this.assessment = 0;
	}

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public int getWorkingYears() {
		return workingYears;
	}

	public void setWorkingYears(int workingYears) {
		this.workingYears = workingYears;
	}

	public int getAssessment() {
		return assessment;
	}

	public void setAssessment(int assessment) {
		this.assessment = assessment;
	}

	@Override
	public String toString() {
		return "Grade_1 [specialty=" + specialty + ", workingYears=" + workingYears + ", assessment=" + assessment
				+ ", getCode()=" + getCode() + ", getName()=" + getName() + ", getSurname()=" + getSurname()
				+ ", getGender()=" + getGender() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
	
	
}
