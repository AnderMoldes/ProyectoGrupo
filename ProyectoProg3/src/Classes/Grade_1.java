package Classes;

import java.io.Serializable;
import java.util.Date;

public class Grade_1 extends Workers implements Serializable{
	
	private int grade;
	private Specialty specialty;
	private Date workingYears;
	private int assessment;
	
	public Grade_1(int code, String name, String surname, String gender, int grade, Specialty specialty, Date workingYears,
			int assessment) {
		super(code, name, surname, gender);
		this.grade = grade;
		this.specialty = specialty;
		this.workingYears = workingYears;
		this.assessment = assessment;
	}
	
	public Grade_1() {
		super();
		this.grade = 3;
		this.specialty = specialty.DRIVER;
		this.workingYears = new Date();
		this.assessment = 0;
	}
	

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
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
		return "Grade: " + grade + ". Code: " + code + ". Name: " + name +" "+ surname + ". Gender: " + gender +". Especiality: "
				+ specialty + ". Start working: " + workingYears + ". Assessment: " + assessment;
	}

	
	
	
	
}
