package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import classes.Brand;
import classes.Colour;
import classes.Vehicle;
import classes.Brand.BrandEnum;

public class VehicleTest {

	@Test
	public void testGetLicensePlate() {
		Vehicle v = new Vehicle(2, BrandEnum.NISSAN, Colour.ColourEnum.GOLD, null,null);
		assertEquals(2, v.getLicensePlate());

	}

	@Test
	public void testGetBrand() {
		Vehicle v = new Vehicle(2, BrandEnum.NISSAN, Colour.ColourEnum.GOLD, null,null);
		assertEquals(BrandEnum.NISSAN, v.getBrand());

	}

	@Test
	public void testGetColour() {
		Vehicle v = new Vehicle(2, BrandEnum.NISSAN, Colour.ColourEnum.GOLD, null,null);
		assertEquals(Colour.ColourEnum.GOLD, v.getColour());

	}

	@Test
	public void testGetPolices() {
		Vehicle v = new Vehicle(2, BrandEnum.NISSAN, Colour.ColourEnum.GOLD, null,null);
		assertEquals(null, v.getPolices());

	}

}
