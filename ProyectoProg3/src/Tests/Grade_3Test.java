package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Classes.Grade_2;
import Classes.Grade_3;
import Classes.Specialty;

public class Grade_3Test {

	@Test
	public void testGetName() {
		Grade_3 g = new Grade_3(1, "Pedro", "Ortiz", "male", Specialty.CONDUCTOR, new java.util.Date(), 4);
		assertEquals("Pedro", g.getName());

	}

	@Test
	public void testGetSurName() {
		Grade_3 g = new Grade_3(1, "Pedro", "Ortiz", "male", Specialty.CONDUCTOR, new java.util.Date(), 4);
		assertEquals("Ortiz", g.getSurname());

	}

	@Test
	public void testGetGender() {
		Grade_3 g = new Grade_3(1, "Pedro", "Ortiz", "male", Specialty.CONDUCTOR, new java.util.Date(), 4);
		assertEquals("male", g.getGender());

	}

	@Test
	public void testGetSpecialty() {
		Grade_3 g = new Grade_3(1, "Pedro", "Ortiz", "male", Specialty.CONDUCTOR, new java.util.Date(), 4);
		assertEquals("arrests", g.getSpecialty());

	}

	@Test
	public void testGetWorkingYears() {
		Grade_3 g = new Grade_3(1, "Pedro", "Ortiz", "male", Specialty.CONDUCTOR, new java.util.Date(), 4);
		assertEquals(4, g.getWorkingYears());

	}

	@Test
	public void testGetAssesment() {
		Grade_3 g = new Grade_3(1, "Pedro", "Ortiz", "male", Specialty.CONDUCTOR, new java.util.Date(), 4);
		assertEquals(5, g.getAssessment());

	}

}
