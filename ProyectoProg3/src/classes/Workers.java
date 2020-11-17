package classes;

import java.io.Serializable;
import java.util.Date;

public class Workers implements Serializable{
    public static int counter = 0;

    protected int code;
    protected int grade;
    protected String name;
    protected String surname;
    protected String gender;
    protected Specialty Specialty;
    protected Date startWorkingIn;
    protected String Assesment;
    
	
	
	public Workers(int code, int grade, String name, String surname, String gender, Specialty specialty,
			Date startWorkingIn, String assesment) {
		super();
		this.code = counter++;
		this.grade = grade;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.Specialty = specialty;
		this.startWorkingIn = startWorkingIn;
		Assesment = assesment;
	}
	
	public Workers() {
		super();
		this.grade = 0;
		this.name = "";
		this.surname = "";
		this.gender = "";
		this.Specialty = null;
		this.startWorkingIn = null;
		this.Assesment = "";
	}

	

	public int getCode() {
		return counter++;
	}


	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Specialty getSpecialty() {
		return Specialty;
	}

	public void setSpecialty(Specialty specialty) {
		Specialty = specialty;
	}

	public Date getStartWorkingIn() {
		return startWorkingIn;
	}

	public void setStartWorkingIn(Date startWorkingIn) {
		this.startWorkingIn = startWorkingIn;
	}

	public String getAssesment() {
		return Assesment;
	}

	public void setAssesment(String assesment) {
		Assesment = assesment;
	}
	

	@Override
	public String toString() {
		return "Workers [code=" + code + ", grade=" + grade + ", name=" + name + ", surname=" + surname + ", gender="
				+ gender + ", Specialty=" + Specialty + ", startWorkingIn=" + startWorkingIn + ", Assesment="
				+ Assesment + "]";
	}
	
	
	
    

}
