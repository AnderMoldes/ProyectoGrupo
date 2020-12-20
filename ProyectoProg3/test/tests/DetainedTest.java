package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import classes.Detained;

public class DetainedTest {
	
	@Test
	public void testGetIdentificative() {
		Detained d = new Detained(0, "Jon", "Garcia", 17, "male");
		assertEquals(0, d.getIdentificative(),d.getContainer());
		
	}
	
	@Test
	public void testGetName() {
		Detained d = new Detained(0, "Jon", "Garcia", 17, "male");
		assertEquals("Jon", d.getName());

	}

	@Test
	public void testGetLastName() {
		Detained d = new Detained(0, "Jon", "Garcia", 17, "male");
		assertEquals("Garcia", d.getLastName());

	}

	@Test
	public void testGetAge() {
		Detained d = new Detained(0, "Jon", "Garcia", 17, "male");
		assertEquals(17, d.getAge());

	}

	@Test
	public void testGetGender() {
		Detained d = new Detained(0, "Jon", "Garcia", 17, "male");
		assertEquals("male", d.getGender());
	}

}
