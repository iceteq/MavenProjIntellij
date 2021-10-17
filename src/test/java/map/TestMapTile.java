package map;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import map.MapTile;

public class TestMapTile {
	
	private static final int TOO_LOW = MapTile.getMIN_HEIGHT()-1;
	private static final int TOO_HIGH = MapTile.getMAX_HEIGHT()+1;
	
	private MapTile mountainTile = new MapTile(MapTile.getMOUNTAIN_MAX_HEIGHT());
	private MapTile plainsTile = new MapTile(MapTile.getPLAINS_MAX_HEIGHT());
	private MapTile oceanTile = new MapTile(MapTile.getOCEAN_MAX_HEIGHT());
	private MapTile defaultTile = new MapTile();
	
	@Test
	public void testHeightTooLow() {
		assertThrows(IllegalArgumentException.class, () -> {
			MapTile tile = new MapTile(TOO_LOW);});
	}
	
	@Test
	public void testHeightTooHigh() {
		assertThrows(IllegalArgumentException.class, () -> {
			MapTile tile = new MapTile(TOO_HIGH);});
	}
	
	@Test
	public void testHeightDefaultTile() {
		assertEquals(MapTile.getMIN_HEIGHT(), defaultTile.getHeight());
	}
	
	@Test
	public void testAccessibilityDefaultTile() {
		assertEquals("none", defaultTile.getAccessibility());
	}
	
	@Test
	public void testBiomeDefaultTile() {
		assertEquals("none", defaultTile.getBiome());
	}
	
	@Test
	public void testSymbolDefaultTile() {
		assertEquals("", defaultTile.toString());
	}
	
	@Test
	public void testGetHeight() {
		assertEquals(MapTile.getPLAINS_MAX_HEIGHT(), plainsTile.getHeight());
	}
	
	@Test
	public void testGetAccessibilityFlight() {
		assertEquals("flight", mountainTile.getAccessibility());
	}
	
	@Test
	public void testGetAccessibilitySwim() {
		assertEquals("swimming", oceanTile.getAccessibility());
	}
	
	@Test
	public void testGetAccessibilityWalk() {
		assertEquals("walking", plainsTile.getAccessibility());
	}
	
	@Test
	public void testGetBiomeMountain() {
		assertEquals("mountain", mountainTile.getBiome());
	}
	
	@Test
	public void testGetBiomeOcean() {
		assertEquals("ocean", oceanTile.getBiome());
	}
	
	@Test
	public void testGetBiomePlains() {
		assertEquals("plains", plainsTile.getBiome());
	}
	
	@Test
	public void testGetSymbolMountain() {
		assertEquals("∧", mountainTile.getSymbol());
	}
	
	@Test
	public void testGetSymbolOcean() {
		assertEquals("˜", oceanTile.getSymbol());
	}
	
	@Test
	public void testGetSymbolPlains() {
		assertEquals(".", plainsTile.getSymbol());
	}
	
	@Test
	public void testToStringMountain() {
		assertEquals("Height: 200, Biome: mountain, Accessibility: flight, Symbol: ∧", mountainTile.toString());
	}
	
	@Test
	public void testToStringOcean() {
		assertEquals("Height: 40, Biome: ocean, Accessibility: swimming, Symbol: ˜", mountainTile.toString());
	}
	
	@Test
	public void testToStringPlains() {
		assertEquals("Height: 110, Biome: plains, Accessibility: walking, Symbol: .", mountainTile.toString());
	}
	
	@Test
	public void testEqualsMountain() {
		MapTile tile = new MapTile(MapTile.getMOUNTAIN_MAX_HEIGHT());
		assertTrue(tile.equals(mountainTile));
	}
	
	@Test
	public void testNotEqualsMountain() {
		MapTile tile = new MapTile(MapTile.getPLAINS_MAX_HEIGHT());
		assertFalse(tile.equals(mountainTile));
	}
	
	@Test
	public void testEqualsPlains() {
		MapTile tile = new MapTile(MapTile.getPLAINS_MAX_HEIGHT());
		assertTrue(tile.equals(plainsTile));
	}
	
	@Test
	public void testNotEqualsPlains() {
		MapTile tile = new MapTile(MapTile.getOCEAN_MAX_HEIGHT());
		assertFalse(tile.equals(plainsTile));
	}
	
	@Test
	public void testEqualsOcean() {
		MapTile tile = new MapTile(MapTile.getOCEAN_MAX_HEIGHT());
		assertTrue(tile.equals(oceanTile));
	}
	
	@Test
	public void testNotEqualsOcean() {
		MapTile tile = new MapTile(MapTile.getMOUNTAIN_MAX_HEIGHT());
		assertFalse(tile.equals(oceanTile));
	}
	
	@Test
	public void testSetMountain() {
		MapTile tile = new MapTile();
		tile.setTile(MapTile.getMOUNTAIN_MAX_HEIGHT());
		assertTrue(tile.equals(mountainTile));
	}
	
	@Test
	public void testSetPlains() {
		MapTile tile = new MapTile();
		tile.setTile(MapTile.getPLAINS_MAX_HEIGHT());
		assertTrue(tile.equals(plainsTile));
	}
	
	@Test
	public void testSetOcean() {
		MapTile tile = new MapTile();
		tile.setTile(MapTile.getOCEAN_MAX_HEIGHT());
		assertTrue(tile.equals(oceanTile));
	}
	
	@Test
	public void testSetHeightTooHigh() {
		MapTile tile = new MapTile();
		assertThrows(IllegalArgumentException.class, () -> {
			tile.setTile(TOO_LOW);});
	}
	
	@Test
	public void testSetHeightTooLow() {
		MapTile tile = new MapTile();
		assertThrows(IllegalArgumentException.class, () -> {
			tile.setTile(TOO_HIGH);});
	}
	
	@Test
	public void testSetAlreadyAssigned() {
		MapTile tile = new MapTile(MapTile.getMAX_HEIGHT());
		assertThrows(IllegalStateException.class, () -> {
			tile.setTile(MapTile.getMIN_HEIGHT());});
	}
	
}
