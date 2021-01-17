package classes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import classes.Brand.BrandEnum;
import classes.Colour.ColourEnum;
import classes.Specialty.SpecialtyEnum;

import org.junit.jupiter.api.Assertions.*;
public class SpecialtyTest {
	@Test
	public void testGetCode() {
		assertEquals("DRIVER",SpecialtyEnum.DRIVER.name());
		assertEquals("DOCTOR",SpecialtyEnum.DOCTOR.name());
		assertEquals("SECURITY",SpecialtyEnum.SECURITY.name());
	}
}
