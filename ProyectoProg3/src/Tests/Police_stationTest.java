package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Classes.Police_Station;

public class Police_stationTest {

	@Test
	public void testGetName() {
		Police_Station p = new Police_Station("Bilbao's station", 400, "Bilbao", null, null, null);
		assertEquals("Bilbao's station", p.getName());

	}

	@Test
	public void testGetNumWorkers() {
		Police_Station p = new Police_Station("Bilbao's station", 400, "Bilbao", null, null, null);
		assertEquals(400, p.getNumWorkers());

	}

	@Test
	public void testGetAddress() {
		Police_Station p = new Police_Station("Bilbao's station", 400, "Bilbao", null, null, null);
		assertEquals("Bilbao", p.getAddress());

	}

	@Test
	public void testGetBoss() {
		Police_Station p = new Police_Station("Bilbao's station", 400, "Bilbao", null, null, null);
		assertEquals(null, p.getBoss());

	}

	@Test
	public void testGetWorkers() {
		Police_Station p = new Police_Station("Bilbao's station", 400, "Bilbao", null, null, null);
		assertEquals(null, p.getWorkers());

	}

	@Test
	public void testGetDetained() {
		Police_Station p = new Police_Station("Bilbao's station", 400, "Bilbao", null, null, null);
		assertEquals(null, p.getDetained());

	}

}
