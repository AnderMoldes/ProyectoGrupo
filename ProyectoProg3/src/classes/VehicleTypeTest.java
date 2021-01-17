package classes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VehicleTypeTest {
	
	@Test
	public void testGetCode() {
	assertEquals(VehicleTypes.PATROLCAR, VehicleTypes.PATROLCAR);
	assertEquals(VehicleTypes.ARMOREDCAR, VehicleTypes.ARMOREDCAR);
	assertEquals(VehicleTypes.ARMOREDVAN, VehicleTypes.ARMOREDVAN);
	assertEquals(VehicleTypes.MOTORBIKE, VehicleTypes.MOTORBIKE);
	assertEquals(VehicleTypes.TRUCK, VehicleTypes.TRUCK);
	
	
	}

}
