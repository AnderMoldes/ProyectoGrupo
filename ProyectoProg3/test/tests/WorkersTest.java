package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import classes.Specialty;
import classes.Workers;

public class WorkersTest {

	@Test
	public void testGetCode() {
		Workers w = new Workers(2, 0, "Pablo", "Moldes", "male", Specialty.DOCTOR, null , "Good");
		assertEquals(2, w.getCode());
	}
	
	@Test
	public void testGetGrade() {
		Workers w = new Workers(1, 0, "Pablo", "Moldes", "male", Specialty.DOCTOR, null , "Good");
		assertEquals(0, w.getGrade());
	}

	@Test
	public void testGetName() {
		Workers w = new Workers(1, 0, "Pablo", "Moldes", "male", Specialty.DOCTOR, null , "Good");
		assertEquals("Pablo", w.getName());

	}

	@Test
	public void testGetSurname() {
		Workers w = new Workers(1, 0, "Pablo", "Moldes", "male", Specialty.DOCTOR, null , "Good");
		assertEquals("Moldes", w.getSurname());

	}

	@Test
	public void testGetGender() {
		Workers w = new Workers(1, 0, "Pablo", "Moldes", "male", Specialty.DOCTOR, null , "Good");
		assertEquals("male", w.getGender());

	}
	@Test
	public void testGetSpecialty() {
		Workers w = new Workers(1, 0, "Pablo", "Moldes", "male", Specialty.DOCTOR, null , "Good");
		assertEquals(Specialty.DOCTOR, w.getSpecialty());

	}
	@Test
	public void testGetStartWorkinIn() {
		Workers w = new Workers(1, 0, "Pablo", "Moldes", "male", Specialty.DOCTOR, null , "Good");
		assertEquals(null, w.getStartWorkingIn());

	}
	@Test
	public void testGetAssessment() {
		Workers w = new Workers(1, 0, "Pablo", "Moldes", "male", Specialty.DOCTOR, null , "Good");
		assertEquals("Good", w.getAssesment());

	}

}
