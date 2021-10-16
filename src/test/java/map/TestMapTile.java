package map;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import map.MapTile;

public class TestMapTile {
	
	@Test
	public void testHeightTooLow() {
		assertThrows(IllegalArgumentException.class, () -> {
			MapTile tile = new MapTile(-1);});
	}
	
	@Test
	public void testHeightTooHigh() {
		assertThrows(IllegalArgumentException.class, () -> {
			MapTile tile = new MapTile(201);});
	}
	
	@Test
	public void testGetHeight() {
		MapTile tile = new MapTile(50);
		assertEquals(50, tile.getHeight());
	}
	
	@Test
	public void testGetAccessibilityFlight() {
		MapTile tile = new MapTile(180);
		assertEquals("flight", tile.getAccessibility());
	}
	
	@Test
	public void testGetAccessibilitySwim() {
		MapTile tile = new MapTile(20);
		assertEquals("swimming", tile.getAccessibility());
	}
	
	@Test
	public void testGetAccessibilityWalk() {
		MapTile tile = new MapTile(50);
		assertEquals("walking", tile.getAccessibility());
	}
	
	@Test
	public void testGetBiomeMountain() {
		MapTile tile = new MapTile(180);
		assertEquals("mountain", tile.getBiome());
	}
	
	@Test
	public void testGetBiomeOcean() {
		MapTile tile = new MapTile(20);
		assertEquals("ocean", tile.getBiome());
	}
	
	@Test
	public void testGetBiomePlains() {
		MapTile tile = new MapTile(50);
		assertEquals("plains", tile.getBiome());
	}

}
