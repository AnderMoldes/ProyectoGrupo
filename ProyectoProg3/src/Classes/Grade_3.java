package Classes;

public class Grade_3 extends Workers{
	
	private String specialty;
	private int workingYears;
	private int assessment;
	
	public Grade_3(int code, String name, String surname, String gender, String specialty, int workingYears,
			int assessment) {
		super(code, name, surname, gender);
		this.specialty = specialty;
		this.workingYears = workingYears;
		this.assessment = assessment;
	}
	
	public Grade_3() {
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
		return "Police grade 1 with the speciality: " + specialty + ". Working Years: " + workingYears + ". Assessment: " + assessment;
		}
	
	
	
}
