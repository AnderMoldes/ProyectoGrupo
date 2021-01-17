package classes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CounterTest {

	@Test
	public void testGetCounterT() {
		Counter c = new Counter();
		assertEquals(1,c.getCounterT());
	}
	
	@Test
	public void testGetCounterD() {
		Counter c = new Counter();
		assertEquals(1,c.getCounterD());
	}
}
