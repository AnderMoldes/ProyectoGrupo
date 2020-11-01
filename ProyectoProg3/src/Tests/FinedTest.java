package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Classes.Fined;

public class FinedTest {

	@Test
	public void testGetName() {
		Fined f = new Fined("Paula", "plaza", 18, "female", 1790, "great worker", 23);
		assertEquals("Paula", f.getName());

	}

	@Test
	public void testGetLastName() {
		Fined f = new Fined("Paula", "Plaza", 18, "female", 1790, "great worker", 23);
		assertEquals("Plaza", f.getLastName());

	}

	@Test
	public void testGetAge() {
		Fined f = new Fined("Paula", "plaza", 18, "female", 1790, "great worker", 23);
		assertEquals(18, f.getAge());

	}

	@Test
	public void testGetGender() {
		Fined f = new Fined("Paula", "plaza", 18, "female", 1790, "great worker", 23);
		assertEquals("female", f.getGender());

	}

	@Test
	public void testGetNumber() {
		Fined f = new Fined("Paula", "plaza", 18, "female", 1790, "great worker", 23);
		assertEquals(1790, f.getNumber());

	}

	@Test
	public void testGetDescription() {
		Fined f = new Fined("Paula", "plaza", 18, "female", 1790, "great worker", 23);
		assertEquals("great worker", f.getDescription());

	}
	
	@Test
	public void testGetPayment() {
		Fined f = new Fined("Paula", "plaza", 18, "female", 1790, "great worker", 23);
		assertEquals(23, f.getPayment());

	}
	

}
