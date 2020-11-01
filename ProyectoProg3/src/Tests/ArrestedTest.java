package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Classes.Arrested;

public class ArrestedTest {

	@Test
	public void testGetName() {
		Arrested a = new Arrested("Ander", "Moldes", 24, "male", 2345, "Bad person", "25/9/20");
		assertEquals("Ander", a.getName());

	}

	@Test
	public void testGetLastName() {
		Arrested a = new Arrested("Ander", "Moldes", 24, "male", 2345, "Bad person", "25/9/20");
		assertEquals("Moldes", a.getLastName());

	}

	@Test
	public void testGetAge() {
		Arrested a = new Arrested("Ander", "Moldes", 24, "male", 2345, "Bad person", "25/9/20");
		assertEquals(24, a.getAge());

	}

	@Test
	public void testGetGender() {
		Arrested a = new Arrested("Ander", "Moldes", 24, "male", 2345, "Bad person", "25/9/20");
		assertEquals("male", a.getGender());

	}

	@Test
	public void testGetNumberOfArrest() {
		Arrested a = new Arrested("Ander", "Moldes", 24, "male", 1, "Bad person", "25/9/20");
		assertEquals(1, a.getNumberOfArrest());

	}

	@Test
	public void testGetDescription() {
		Arrested a = new Arrested("Ander", "Moldes", 24, "male", 2345, "Bad person", "25/9/20");
		assertEquals("Bad person", a.getDescription());

	}
	
	@Test
	public void testGetJailRelease() {
		Arrested a = new Arrested("Ander", "Moldes", 24, "male", 2345, "Bad person", "25/9/20");
		assertEquals("25/9/20", a.getJailRelease());

	}
	

}
