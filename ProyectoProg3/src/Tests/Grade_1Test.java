package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Classes.Grade_1;

public class Grade_1Test {

	@Test
	public void testGetName() {
		Grade_1 g = new Grade_1(1, "Pedro", "Ortiz", "male", "arrests", 4, 5);
		assertEquals("Pedro", g.getName());

	}

	@Test
	public void testGetSurName() {
		Grade_1 g = new Grade_1(1, "Pedro", "Ortiz", "male", "arrests", 4, 5);
		assertEquals("Ortiz", g.getSurname());

	}

	@Test
	public void testGetGender() {
		Grade_1 g = new Grade_1(1, "Pedro", "Ortiz", "male", "arrests", 4, 5);
		assertEquals("male", g.getGender());

	}

	@Test
	public void testGetSpecialty() {
		Grade_1 g = new Grade_1(1, "Pedro", "Ortiz", "male", "arrests", 4, 5);
		assertEquals("arrests", g.getSpecialty());

	}

	@Test
	public void testGetWorkingYears() {
		Grade_1 g = new Grade_1(1, "Pedro", "Ortiz", "male", "arrests", 4, 5);
		assertEquals(4, g.getWorkingYears());

	}

	@Test
	public void testGetAssesment() {
		Grade_1 g = new Grade_1(1, "Pedro", "Ortiz", "male", "arrests", 4, 5);
		assertEquals(5, g.getAssessment());

	}

}
