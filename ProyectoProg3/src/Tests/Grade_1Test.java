package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import Classes.Grade_1;
import Classes.Specialty;

public class Grade_1Test {

	@Test
	public void testGetName() {
		Grade_1 g = new Grade_1(1, "Pedro", "Ortiz", "male", Specialty.CONDUCTOR, new java.util.Date(), 4);
		assertEquals("Pedro", g.getName());

	}

	@Test
	public void testGetSurName() {
		Grade_1 g = new Grade_1(1, "Pedro", "Ortiz", "male", Specialty.CONDUCTOR, new java.util.Date(), 4);
		assertEquals("Ortiz", g.getSurname());

	}

	@Test
	public void testGetGender() {
		Grade_1 g = new Grade_1(1, "Pedro", "Ortiz", "male", Specialty.CONDUCTOR, new java.util.Date(), 4);
		assertEquals("male", g.getGender());

	}

	@Test
	public void testGetSpecialty() {
		Grade_1 g = new Grade_1(1, "Pedro", "Ortiz", "male", Specialty.CONDUCTOR, new java.util.Date(), 4);
		assertEquals("arrests", g.getSpecialty());

	}

	@Test
	public void testGetWorkingYears() {
		Grade_1 g = new Grade_1(1, "Pedro", "Ortiz", "male", Specialty.CONDUCTOR, new java.util.Date(), 4);
		assertEquals(4, g.getWorkingYears());

	}

	@Test
	public void testGetAssesment() {
		Grade_1 g = new Grade_1(1, "Pedro", "Ortiz", "male", Specialty.CONDUCTOR, new java.util.Date(), 4);
		assertEquals(5, g.getAssessment());

	}

}
