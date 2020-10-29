package Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import Classes.Police_Station;

class Police_stationTest {
	
	private Police_Station p;
	
	@Before
	public void setUp() {
	
	 Police_Station p = new Police_Station("Bilbao's station", 400, "Bilbao", null, null, null);
	}

	@Test
	public void testGetName() {
	assertEquals("Bilbao's tation", p.getName());
	
	}
	
	@Test
	public void testGetNumWorkers() {
	assertEquals(400, p.getNumWorkers());
	
	}
	
	@Test
	public void testGetAddress() {
	assertEquals("Bilbao", p.getAddress());
	
	}
	@Test
	public void testGetBoss() {
	assertEquals(null, p.getBoss());
	
	}
	
	@Test
	public void testGetWorkers() {
	assertEquals(null, p.getWorkers());
	
	}
	
	@Test
	public void testGetDetained() {
	assertEquals(null, p.getDetained());
	
	}
	
	

}
