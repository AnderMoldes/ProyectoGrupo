package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Classes.Detained;

public class DetainedTest {

	@Test
	public void testGetName() {
		Detained d = new Detained("Jon", "Garcia", 17, "male");
		assertEquals("Jon", d.getName());

	}

	@Test
	public void testGetLastName() {
		Detained d = new Detained("Jon", "Garcia", 17, "male");
		assertEquals("Garcia", d.getLastName());

	}

	@Test
	public void testGetAge() {
		Detained d = new Detained("Jon", "Garcia", 17, "male");
		assertEquals(17, d.getAge());

	}

	@Test
	public void testGetGender() {
		Detained d = new Detained("Jon", "Garcia", 17, "male");
		assertEquals("male", d.getGender());
	}

}
