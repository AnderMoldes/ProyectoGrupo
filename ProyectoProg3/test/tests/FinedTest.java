package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import classes.Country;
import classes.Detained;
import classes.Fined;

public class FinedTest {
	@Test
	public void testGetIdentificative() {
		Fined f = new Fined(0, "Aimar", "Herrador", 17, "male", "Agression",Country.Austria, 1000);
		assertEquals(0, f.getIdentificative(),f.getContainer());
		
	}
	
	@Test
	public void testGetName() {
		Fined f = new Fined(0, "Aimar", "Herrador", 17, "male", "Agression",Country.Austria, 1000);
		assertEquals("Aimar", f.getName());

	}

	@Test
	public void testGetLastName() {
		Fined f = new Fined(0, "Aimar", "Herrador", 17, "male", "Agression",Country.Austria, 1000);
		assertEquals("Herrador", f.getLastName());
	}

	@Test
	public void testGetAge() {
		Fined f = new Fined(0, "Aimar", "Herrador", 17, "male", "Agression",Country.Austria, 1000);
		assertEquals(17, f.getAge());

	}

	@Test
	public void testGetGender() {
		Fined f = new Fined(0, "Aimar", "Herrador", 17, "male", "Agression",Country.Austria, 1000);
		assertEquals("male", f.getGender());
	}
	@Test
	public void testGetDescription() {
		Fined f = new Fined(0, "Aimar", "Herrador", 17, "male", "Agression",Country.Austria, 1000);
		assertEquals("Agression", f.getDescription());

	}
	@Test
	public void testGetCitizenship() {
		Fined f = new Fined(0, "Aimar", "Herrador", 17, "male", "Agression",Country.Austria, 1000);
		assertEquals(Country.Austria, f.getCitizenship());

	}
	@Test
	public void testGetPayment() {
		Fined f = new Fined(0, "Aimar", "Herrador", 17, "male", "Agression",Country.Austria, 1000);
		assertEquals(1000, f.getPayment());

	}
	

}
