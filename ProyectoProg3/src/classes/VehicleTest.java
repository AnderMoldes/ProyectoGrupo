package classes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import classes.Brand.BrandEnum;

public class VehicleTest {


	@Test
	public void testGetBrand() {
		Vehicle v = new Vehicle(BrandEnum.NISSAN, Colour.ColourEnum.GOLD,null,null);
		assertEquals(BrandEnum.NISSAN, v.getBrand());

	}

	@Test
	public void testGetColour() {
		Vehicle v = new Vehicle(BrandEnum.NISSAN, Colour.ColourEnum.GOLD,null, null);
		assertEquals(Colour.ColourEnum.GOLD, v.getColour());

	}

}
