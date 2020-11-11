package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import classes.Arrested;
import classes.Boss;

public class BossTest {

	@Test
	public void testGetName() {
		Boss b = new Boss(3678, "Juan", "Gonzalez", "male", 20, "organization and control");
		assertEquals("Juan", b.getName());

	}

	@Test
	public void testGetSurname() {
		Boss b = new Boss(3678, "Juan", "Gonzalez", "male", 20, "organization and control");
		assertEquals("Gonzalez", b.getSurname());

	}

	@Test
	public void testGetGender() {
		Boss b = new Boss(3678, "Juan", "Gonzalez", "male", 20, "organization and control");
		assertEquals("male", b.getGender());

	}

	@Test
	public void testGetCodeBoss() {
		Boss b = new Boss(3678, "Juan", "Gonzalez", "male", 20, "organization and control");
		assertEquals(20, b.getCodeBoss());

	}

	@Test
	public void testGetFunction() {
		Boss b = new Boss(3678, "Juan", "Gonzalez", "male", 20, "organization and control");
		assertEquals("organization and control", b.getFunction());

	}

}
