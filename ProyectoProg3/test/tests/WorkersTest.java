package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import classes.Workers;

public class WorkersTest {

	@Test
	public void testGetCode() {
		Workers w = new Workers(1234, "Pablo", "Moldes", "male");
		assertEquals(2, w.getCode());

	}

	@Test
	public void testGetName() {
		Workers w = new Workers(1234, "Pablo", "Moldes", "male");
		assertEquals("Pablo", w.getName());

	}

	@Test
	public void testGetSurname() {
		Workers w = new Workers(1234, "Pablo", "Moldes", "male");
		assertEquals("Moldes", w.getSurname());

	}

	@Test
	public void testGetGender() {
		Workers w = new Workers(1234, "Pablo", "Moldes", "male");
		assertEquals("male", w.getGender());

	}

}
