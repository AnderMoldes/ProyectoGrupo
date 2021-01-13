package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import classes.Brand.BrandEnum;

import org.junit.jupiter.api.Assertions.*;
public class BrandTest {
	@Test
	public void testGetCode() {
	assertEquals("SEAT",BrandEnum.SEAT.name());
	assertEquals("MITSUBISHI",BrandEnum.MITSUBISHI.name());
	assertEquals("NISSAN",BrandEnum.NISSAN.name());
	assertEquals("RENAULT",BrandEnum.RENAULT.name());
	assertEquals("PEUGEOT",BrandEnum.PEUGEOT.name());
	
	}
}
