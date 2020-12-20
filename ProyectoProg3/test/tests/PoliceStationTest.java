package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import classes.PoliceStation;

public class PoliceStationTest {
	

	@Test
	public void testGetName() {
		PoliceStation p = new PoliceStation("Bilbao's station", 400, "Bilbao", null, null);
		assertEquals("Bilbao's station",p.getName());
	}

	@Test
	public void testGetNumWorkers() {
		PoliceStation p = new PoliceStation("Bilbao's station", 400, "Bilbao", null, null);
		assertEquals(400, p.getNumWorkers());

	}

	@Test
	public void testGetAddress() {
		PoliceStation p = new PoliceStation("Bilbao's station", 400, "Bilbao", null, null);
		assertEquals("Bilbao", p.getAddress());

	}


	@Test
	public void testGetWorkers() {
		PoliceStation p = new PoliceStation("Bilbao's station", 400, "Bilbao", null, null);
		assertEquals(null, p.getWorkers());

	}

	@Test
	public void testGetDetained() {
		PoliceStation p = new PoliceStation("Bilbao's station", 400, "Bilbao", null, null);
		assertEquals(null, p.getDetained());

	}

}

