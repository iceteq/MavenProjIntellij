package map;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import map.MapTile;

public class TestMapTile {
	
	private static final int TOO_LOW = MapTile.getMIN_HEIGHT()-1;
	private static final int TOO_HIGH = MapTile.getMAX_HEIGHT()+1;
	
	private static final MapTile mountainTile = new MapTile();
	private static final MapTile plainsTile = new MapTile();
	private static final MapTile oceanTile = new MapTile();
	private static final MapTile defaultTile = new MapTile();
	
	@BeforeAll
	public static void init() {
		mountainTile.setTile(MapTile.getMOUNTAIN_MAX_HEIGHT());
		plainsTile.setTile(MapTile.getPLAINS_MAX_HEIGHT());
		oceanTile.setTile(MapTile.getOCEAN_MAX_HEIGHT());
	}
	
	@Test
	public void testHeightTooLow() {
		MapTile tile = new MapTile();
		assertThrows(IllegalArgumentException.class, () -> {
			tile.setTile(TOO_LOW);});
	}
	
	@Test
	public void testHeightTooHigh() {
		MapTile tile = new MapTile();
		assertThrows(IllegalArgumentException.class, () -> {
			tile.setTile(TOO_HIGH);});
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
		assertEquals("", defaultTile.getSymbol());
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
		assertEquals("Height: " + MapTile.getMOUNTAIN_MAX_HEIGHT() + ", Biome: mountain, Accessibility: flight, Symbol: ∧", mountainTile.toString());
	}
	
	@Test
	public void testToStringOcean() {
		assertEquals("Height: " + MapTile.getOCEAN_MAX_HEIGHT() + ", Biome: ocean, Accessibility: swimming, Symbol: ˜", oceanTile.toString());
	}
	
	@Test
	public void testToStringPlains() {
		assertEquals("Height: " + MapTile.getPLAINS_MAX_HEIGHT() + ", Biome: plains, Accessibility: walking, Symbol: .", plainsTile.toString());
	}
	
	@Test
	public void testEqualsItself() {
		assertTrue(mountainTile.equals(mountainTile));
	}
	
	@Test
	public void testEqualsAnotherObject() {
		assertFalse(mountainTile.equals(54));
	}
	
	@Test
	public void testEqualsMountain() {
		MapTile tile = new MapTile();
		tile.setTile(MapTile.getMOUNTAIN_MAX_HEIGHT());
		assertTrue(tile.equals(mountainTile));
	}
	
	@Test
	public void testNotEqualsMountain() {
		MapTile tile = new MapTile();
		tile.setTile(MapTile.getPLAINS_MAX_HEIGHT());
		assertFalse(tile.equals(mountainTile));
	}
	
	@Test
	public void testEqualsPlains() {
		MapTile tile = new MapTile();
		tile.setTile(MapTile.getPLAINS_MAX_HEIGHT());
		assertTrue(tile.equals(plainsTile));
	}
	
	@Test
	public void testNotEqualsPlains() {
		MapTile tile = new MapTile();
		tile.setTile(MapTile.getOCEAN_MAX_HEIGHT());
		assertFalse(tile.equals(plainsTile));
	}
	
	@Test
	public void testEqualsOcean() {
		MapTile tile = new MapTile();
		tile.setTile(MapTile.getOCEAN_MAX_HEIGHT());
		assertTrue(tile.equals(oceanTile));
	}
	
	@Test
	public void testNotEqualsOcean() {
		MapTile tile = new MapTile();
		tile.setTile(MapTile.getMOUNTAIN_MAX_HEIGHT());
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
		MapTile tile = new MapTile();
		tile.setTile(MapTile.getMAX_HEIGHT());
		assertThrows(IllegalStateException.class, () -> {
			tile.setTile(MapTile.getMIN_HEIGHT());});
	}
	
	@Test
	public void testSetOccupied() {
		MapTile tile = new MapTile();
		tile.setTile(MapTile.getPLAINS_MAX_HEIGHT());
		tile.setOccupied(true);
		assertTrue(tile.isOccupied());
	}
	
	@Test
	public void testGetDefaultOccupied() {
		MapTile tile = new MapTile();
		assertFalse(tile.isOccupied());
	}
	
	@Test
	public void testSetOccupiedAlreadyOccupied() {
		MapTile tile = new MapTile();
		tile.setTile(MapTile.getPLAINS_MAX_HEIGHT());
		tile.setOccupied(true);
		assertThrows(IllegalArgumentException.class, () -> {
			tile.setOccupied(true);});
	}
	
	@Test
	public void testSetVacantAlreadyVacant() {
		MapTile tile = new MapTile();
		tile.setTile(MapTile.getPLAINS_MAX_HEIGHT());
		assertThrows(IllegalArgumentException.class, () -> {
			tile.setOccupied(false);});
	}
	
	@Test
	public void testSetOccupiedOnDefaultTile() {
		MapTile tile = new MapTile();
		assertThrows(IllegalStateException.class, () -> {
			tile.setOccupied(true);});
	}
	
	@Test
	public void testSetVacantOnDefaultTile() {
		MapTile tile = new MapTile();
		assertThrows(IllegalStateException.class, () -> {
			tile.setOccupied(false);});
	}
	
}
