package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import classes.Brand;
import classes.Colour;
import classes.Vehicle;

public class VehicleTest {

	@Test
	public void testGetLicensePlate() {
		Vehicle v = new Vehicle(2, Brand.NISSAN, Colour.GOLD, null);
		assertEquals(2, v.getLicensePlate());

	}

	@Test
	public void testGetBrand() {
		Vehicle v = new Vehicle(9999, Brand.NISSAN, Colour.GOLD, null);
		assertEquals(Brand.NISSAN, v.getBrand());

	}

	@Test
	public void testGetColour() {
		Vehicle v = new Vehicle(9999, Brand.NISSAN, Colour.GOLD, null);
		assertEquals(Colour.GOLD, v.getColour());

	}

	@Test
	public void testGetPolices() {
		Vehicle v = new Vehicle(9999, Brand.NISSAN, Colour.GOLD, null);
		assertEquals(null, v.getPolices());

	}

}
