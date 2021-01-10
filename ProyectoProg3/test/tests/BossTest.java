package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import classes.Arrested;
import classes.Boss;
import classes.Specialty;
import classes.Workers;

public class BossTest {
	@Test
	public void testGetCode() {
		Boss b = new Boss(1, 0, "Xabat", "Plaza", "male", Specialty.DOCTOR, null , "Good", "organization and control");
		assertEquals(1, b.getCode());
	}
	
	@Test
	public void testGetGrade() {
		Boss b = new Boss(1, 0, "Xabat", "Plaza", "male", Specialty.DOCTOR, null , "Good", "organization and control");
		assertEquals(0, b.getGrade());
	}

	@Test
	public void testGetName() {
		Boss b = new Boss(1, 0, "Xabat", "Plaza", "male", Specialty.DOCTOR, null , "Good", "organization and control");
		assertEquals("Xabat", b.getName());

	}

	@Test
	public void testGetSurname() {
		Boss b = new Boss(1, 0, "Xabat", "Plaza", "male", Specialty.DOCTOR, null , "Good", "organization and control");
		assertEquals("Plaza", b.getSurname());

	}

	@Test
	public void testGetGender() {
		Boss b = new Boss(1, 0, "Xabat", "Plaza", "male", Specialty.DOCTOR, null , "Good", "organization and control");
		assertEquals("male", b.getGender());

	}
	@Test
	public void testGetSpecialty() {
		Boss b = new Boss(1, 0, "Xabat", "Plaza", "male", Specialty.DOCTOR, null , "Good", "organization and control");
		assertEquals(Specialty.DOCTOR, b.getSpecialty());

	}
	@Test
	public void testGetStartWorkinIn() {
		Boss b = new Boss(1, 0, "Xabat", "Plaza", "male", Specialty.DOCTOR, null , "Good", "organization and control");
		assertEquals(null, b.getStartWorkingIn());

	}
	@Test
	public void testGetAssessment() {
		Boss b = new Boss(1, 0, "Xabat", "Plaza", "male", Specialty.DOCTOR, null , "Good", "organization and control");
		assertEquals("Good", b.getAssesment());

	}
	@Test
	public void testGetFunction() {
		Boss b = new Boss(1, 0, "Pablo", "Moldes", "male", Specialty.DOCTOR, null , "Good", "organization and control");
		assertEquals("organization and control", b.getFunction());

	}

}
