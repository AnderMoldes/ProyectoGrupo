package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import classes.Brand.BrandEnum;
import classes.Colour.ColourEnum;
import classes.Specialty.SpecialtyEnum;

import org.junit.jupiter.api.Assertions.*;
public class ColourTest {
	@Test
	public void testGetCode() {
	assertEquals("RED",ColourEnum.RED.name());
	assertEquals("BLUE",ColourEnum.BLUE.name());
	assertEquals("BLACK",ColourEnum.BLACK.name());
	assertEquals("WHITE",ColourEnum.WHITE.name());
	assertEquals("GREEN",ColourEnum.GREEN.name());
	assertEquals("GOLD",ColourEnum.GOLD.name());
	assertEquals("GREY",ColourEnum.GREY.name());
	
	}
}

