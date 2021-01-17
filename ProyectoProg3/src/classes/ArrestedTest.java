package classes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ArrestedTest {
	@Test
	public void testGetIdentificative() {
		Arrested a = new Arrested(0, "Ander", "Moldes", 24, "male", 1, "Bad person", "25/9/20", Country.Czechia);
		assertEquals(0, a.getIdentificative());

	}
	
	@Test
	public void testGetName() {
		Arrested a = new Arrested(0, "Ander", "Moldes", 24, "male", 1, "Bad person", "25/9/20", Country.Czechia);
		assertEquals("Ander", a.getName());

	}

	@Test
	public void testGetLastName() {
		Arrested a = new Arrested(0, "Ander", "Moldes", 24, "male", 1, "Bad person", "25/9/20", Country.Czechia);
		assertEquals("Moldes", a.getLastName());

	}

	@Test
	public void testGetAge() {
		Arrested a = new Arrested(0, "Ander", "Moldes", 24, "male", 1, "Bad person", "25/9/20", Country.Czechia);
		assertEquals(24, a.getAge());

	}

	@Test
	public void testGetGender() {
		Arrested a = new Arrested(0, "Ander", "Moldes", 24, "male", 1, "Bad person", "25/9/20", Country.Czechia);
		assertEquals("male", a.getGender());
	}
	@Test
	public void testGetNumberOfArrest() {
		Arrested a = new Arrested(0, "Ander", "Moldes", 24, "male", 1, "Bad person", "25/9/20", Country.Czechia);
		assertEquals(1, a.getNumberOfArrest());

	}

	@Test
	public void testGetDescription() {
		Arrested a = new Arrested(0, "Ander", "Moldes", 24, "male", 2345, "Bad person", "25/9/20", Country.Czechia);
		assertEquals("Bad person", a.getDescription());

	}
	
	@Test
	public void testGetJailRelease() {
		Arrested a = new Arrested(0, "Ander", "Moldes", 24, "male", 2345, "Bad person", "25/9/20", Country.Czechia);
		assertEquals("25/9/20", a.getJailRelease());

	}
	@Test
	public void testGetCitizenship() {
		Arrested a = new Arrested(0, "Ander", "Moldes", 24, "male", 2345, "Bad person", "25/9/20", Country.Czechia);
		assertEquals(Country.Czechia, a.getCitizenship());

	}
	
	

}
