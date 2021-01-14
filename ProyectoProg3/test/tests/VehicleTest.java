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
	public void testGetBrand() {
		Vehicle v = new Vehicle(BrandEnum.NISSAN, Colour.ColourEnum.GOLD,null);
		assertEquals(BrandEnum.NISSAN, v.getBrand());

	}

	@Test
	public void testGetColour() {
		Vehicle v = new Vehicle(BrandEnum.NISSAN, Colour.ColourEnum.GOLD,null);
		assertEquals(Colour.ColourEnum.GOLD, v.getColour());

	}

}
