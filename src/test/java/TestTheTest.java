import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

//import map.Testy;

class TestTheTest {

	@Test
	public void testHelloWorld() {
		
		assertEquals("HelloWorld", Testy.helloWorld());
		
	}
	
	@Test
	public void testIncrement() {
		assertEquals(2, Testy.increment(1));
	}

 	@Test
	void testIncrementFail() {
		assertThrows(IllegalStateException.class, () -> {
			Testy.increment(3);
		});
	}

}
