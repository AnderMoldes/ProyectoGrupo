package classes;

import java.awt.Container;
import java.io.Serializable;
import java.util.Date;

import classes.Specialty.SpecialtyEnum;

public class Workers implements Asignable,Serializable, Comparable<Workers>{


    protected int code;
    protected int grade;
    protected String name;
    protected String surname;
    protected String gender;
    protected SpecialtyEnum Specialty;
    protected String startWorkingIn;
    protected String Assesment;
    
	
	
	public Workers(int code, int grade, String name, String surname, String gender, SpecialtyEnum specialty,
			String startWorkingIn, String assesment) {
		super();
		this.code = code;
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
		this.code= 0;
		this.grade = 0;
		this.name = "";
		this.surname = "";
		this.gender = "";
		this.Specialty = null;
		this.startWorkingIn = "";
		this.Assesment = "";
	}

	

	

	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
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

	public SpecialtyEnum getSpecialty() {
		return Specialty;
	}

	public void setSpecialty(SpecialtyEnum specialty) {
		Specialty = specialty;
	}

	public String getStartWorkingIn() {
		return startWorkingIn;
	}

	public void setStartWorkingIn(String startWorkingIn) {
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
		return " worker: " +code+ ": Function: Worker. Grade: " + grade + ". Name: " + name + ", " + surname + "Gender: "
				+ gender + ". Specialty: " + Specialty + ". He/She start workin in " + startWorkingIn + ". Assesment: "
				+ Assesment;
	}

	@Override
	public int compareTo(Workers o) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(o.getName());
	}
	

	
	
	
	
    

}
