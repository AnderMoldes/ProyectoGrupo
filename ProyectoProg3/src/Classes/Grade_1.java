package Classes;

import java.util.Date;

public class Grade_1 extends Workers{
	
	private Specialty specialty;
	private Date workingYears;
	private int assessment;
	
	public Grade_1(int code, String name, String surname, String gender, Specialty specialty, Date workingYears,
			int assessment) {
		super(code, name, surname, gender);
		this.specialty = specialty;
		this.workingYears = workingYears;
		this.assessment = assessment;
	}
	
	public Grade_1() {
		super();
		this.specialty = specialty.CONDUCTOR;
		this.workingYears = new Date();
		this.assessment = 0;
	}

	public Specialty getSpecialty() {
		return specialty;
	}

	public void setSpecialty(Specialty specialty2) {
		this.specialty = specialty2;
	}

	public Date getWorkingYears() {
		return workingYears;
	}

	public void setWorkingYears(Date date) {
		this.workingYears = date;
	}

	public int getAssessment() {
		return assessment;
	}

	public void setAssessment(int assessment) {
		this.assessment = assessment;
	}

	public String toString() {
		return "Grade: 1. Code: " + code + "Name: " + name +" "+ surname + ". Gender: " + gender +". Especiality: "
				+ specialty + ". Start working: " + workingYears + ". Assessment: " + assessment;
	}

	
	
	
	
}
