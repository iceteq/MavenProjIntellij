package map;

import Player.*;
import Player.Character;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class TestGameMap {
	
	private static final int HEIGHT = 100;
	private static final int WIDTH = 100;
	private static final int SMALLER_HEIGHT = 2;
	private static final int SMALLER_WIDTH = 2;
	private static final int INDEX_TOO_LOW = -1;
	private static final int INDEX_HEIGHT_TOO_HIGH = HEIGHT;
	private static final int INDEX_WIDTH_TOO_HIGH = WIDTH;
	
	private Random random = new Random();
		
	@Test
	public void testDefaultGeneration() {
		MapTile defaultTile = new MapTile();
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		for(int x = 0; x < gameMap.getMap()[0].length; x++) {
			for(int y = 0; y < gameMap.getMap().length; y++) {
				assertEquals(defaultTile, gameMap.getTile(x,y));
			}
		}
	}
	
	@Test
	public void testGetDefaultTile() {
		MapTile defaultTile = new MapTile();
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertEquals(defaultTile, gameMap.getTile(random.nextInt(WIDTH), random.nextInt(HEIGHT)));
	}
	
	@Test
	public void testGetTileMaxIndex() {
		MapTile defaultTile = new MapTile();
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertEquals(defaultTile, gameMap.getTile(WIDTH-1, HEIGHT-1));
	}
	
	@Test
	public void testGetTileMinIndex() {
		MapTile defaultTile = new MapTile();
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertEquals(defaultTile, gameMap.getTile(0, 0));
	}
	
	@Test
	public void testSetTiles() {
		MapTile defaultTile = new MapTile();
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		for(int x = 0; x < gameMap.getMap()[0].length; x++) {
			for(int y = 0; y < gameMap.getMap().length; y++) {
				gameMap.setTile(x,y,random.nextInt(MapTile.getMAX_HEIGHT()+1));
				assertFalse(defaultTile.equals(gameMap.getTile(x,y)));
			}
		}
	}
	
	@Test
	public void testSetTileAlreadySet() {
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		gameMap.setTile(0, 0, 0);
		assertThrows(IllegalStateException.class, () -> {
			gameMap.setTile(0, 0, 4);
		});
	}
	
	@Test
	public void testMakeMapXTooSmall() {
		assertThrows(IllegalArgumentException.class, () -> {
			GameMap map = new GameMap(GameMap.getMIN_DIMENSION()-1,0);
		});
	}
	
	@Test
	public void testMakeMapYTooSmall() {
		assertThrows(IllegalArgumentException.class, () -> {
			GameMap map = new GameMap(0,GameMap.getMIN_DIMENSION()-1);
		});
	}
	
	@Test
	public void testMakeMapXTooLarge() {
		assertThrows(IllegalArgumentException.class, () -> {
			GameMap map = new GameMap(GameMap.getMAX_DIMENSION()+1,0);
		});
	}
	
	@Test
	public void testMakeMapYTooLarge() {
		assertThrows(IllegalArgumentException.class, () -> {
			GameMap map = new GameMap(0,GameMap.getMAX_DIMENSION()+1);
		});
	}
	
	@Test
	public void testSetTileXIndexTooLow() {
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.setTile(INDEX_TOO_LOW,0,MapTile.getMAX_HEIGHT());
		});
	}
	
	@Test
	public void testSetTileYIndexTooLow() {
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.setTile(0,INDEX_TOO_LOW,MapTile.getMAX_HEIGHT());
		});
	}
	
	@Test
	public void testSetTileXIndexTooHigh() {
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.setTile(INDEX_WIDTH_TOO_HIGH,0,MapTile.getMAX_HEIGHT());
		});
	}
	
	@Test
	public void testSetTileYIndexTooHigh() {
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.setTile(0,INDEX_HEIGHT_TOO_HIGH,MapTile.getMAX_HEIGHT());
		});
	}
	
	@Test
	public void testPlaceCharacter() {
		Character character = new NPC(50);
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		gameMap.setTile(WIDTH-1, HEIGHT-1, MapTile.getPLAINS_MAX_HEIGHT());
		gameMap.placeCharacter(character, WIDTH-1, HEIGHT-1);
		assertEquals(character, gameMap.getCharacter(WIDTH-1, HEIGHT-1));
	}
	
	@Test
	public void testPlaceCharacterOnOccupiedTile() {
		Character character = new NPC(50);
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		gameMap.setTile(WIDTH-1, HEIGHT-1, MapTile.getPLAINS_MAX_HEIGHT());
		gameMap.placeCharacter(character, WIDTH-1, HEIGHT-1);
		assertThrows(IllegalStateException.class, () -> {
			gameMap.placeCharacter(new NPC(50), WIDTH-1, HEIGHT-1);
		});
	}
	
	@Test
	public void testMoveCharacter() {
		Character character = new NPC(50);
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		gameMap.setTile(WIDTH-1, HEIGHT-1, MapTile.getPLAINS_MAX_HEIGHT());
		gameMap.setTile(0, 0, MapTile.getPLAINS_MAX_HEIGHT());
		gameMap.placeCharacter(character, WIDTH-1, HEIGHT-1);
		gameMap.placeCharacter(character, 0, 0);
		assertFalse(gameMap.getTile(WIDTH-1, HEIGHT-1).isOccupied());
		assertEquals(character, gameMap.getCharacter(0, 0));
	}
	
	@Test
	public void testPlaceCharacterXTooHigh() {
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.placeCharacter(new NPC(50), WIDTH, 0);
		});
	}
	
	@Test
	public void testPlaceCharacterXTooLow() {
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.placeCharacter(new NPC(50), INDEX_TOO_LOW, 0);
		});
	}
	
	@Test
	public void testPlaceCharacterYTooHigh() {
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.placeCharacter(new NPC(50), 0, HEIGHT);
		});
	}
	
	@Test
	public void testPlaceCharacterYTooLow() {
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.placeCharacter(new NPC(50), 0, INDEX_TOO_LOW);
		});
	}
	
	@Test
	public void testIsNeighbour() {
		Character character = new NPC(50);
		Character neighbour = new NPC(50);
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		gameMap.setTile(WIDTH-1, HEIGHT-1, MapTile.getPLAINS_MAX_HEIGHT());
		gameMap.setTile(WIDTH-2, HEIGHT-2, MapTile.getPLAINS_MAX_HEIGHT());
		gameMap.placeCharacter(character, WIDTH-1, HEIGHT-1);
		gameMap.placeCharacter(neighbour, WIDTH-2, HEIGHT-2);
		assertTrue(gameMap.isNeighbour(character, neighbour));
	}
	
	@Test
	public void testIsNotNeighbour() {
		Character character = new NPC(50);
		Character neighbour = new NPC(50);
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		gameMap.setTile(WIDTH-1, HEIGHT-1, MapTile.getPLAINS_MAX_HEIGHT());
		gameMap.setTile(WIDTH-3, HEIGHT-3, MapTile.getPLAINS_MAX_HEIGHT());
		gameMap.placeCharacter(character, WIDTH-1, HEIGHT-1);
		gameMap.placeCharacter(neighbour, WIDTH-3, HEIGHT-3);
		assertFalse(gameMap.isNeighbour(character, neighbour));
	}
	
	@Test
	public void testWithinRangeOfTarget() {
		Character character = new NPC(50);
		Character target = new NPC(50);
		int range = 15;
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		gameMap.setTile(WIDTH-1, HEIGHT-1, MapTile.getPLAINS_MAX_HEIGHT());
		gameMap.setTile(WIDTH-range-1, HEIGHT-range-1, MapTile.getPLAINS_MAX_HEIGHT());
		gameMap.placeCharacter(character, WIDTH-1, HEIGHT-1);
		gameMap.placeCharacter(target, WIDTH-range-1, HEIGHT-range-1);
		assertTrue(gameMap.withinRange(character, target, range));
	}
	
	@Test
	public void testNotWithinRangeOfTarget() {
		Character character = new NPC(50);
		Character neighbour = new NPC(50);
		int range = 15;
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		gameMap.setTile(WIDTH-1, HEIGHT-1, MapTile.getPLAINS_MAX_HEIGHT());
		gameMap.setTile(WIDTH-range-2, HEIGHT-range-2, MapTile.getPLAINS_MAX_HEIGHT());
		gameMap.placeCharacter(character, WIDTH-1, HEIGHT-1);
		gameMap.placeCharacter(neighbour, WIDTH-range-2, HEIGHT-range-2);
		assertFalse(gameMap.withinRange(character, neighbour, range));
	}
	
	@Test
	public void testWithinRangeCharacterDoesntExist() {
		Character character = new NPC(50);
		Character target = new NPC(50);
		int range = 15;
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		gameMap.setTile(WIDTH-1, HEIGHT-1, MapTile.getPLAINS_MAX_HEIGHT());
		gameMap.placeCharacter(target, WIDTH-1, HEIGHT-1);
		assertThrows(NullPointerException.class, () -> {
			gameMap.withinRange(character, target, range);
		});
	}
	
	@Test
	public void testWithinRangeTargetDoesntExist() {
		Character character = new NPC(50);
		Character target = new NPC(50);
		int range = 15;
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		gameMap.setTile(WIDTH-1, HEIGHT-1, MapTile.getPLAINS_MAX_HEIGHT());
		gameMap.placeCharacter(character, WIDTH-1, HEIGHT-1);
		assertThrows(NullPointerException.class, () -> {
			gameMap.withinRange(character, target, range);
		});
	}
	
	@Test
	public void testWithinRangeOfTile() {
		Character character = new NPC(50);
		int range = 15;
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		gameMap.setTile(WIDTH-1, HEIGHT-1, MapTile.getPLAINS_MAX_HEIGHT());
		gameMap.placeCharacter(character, WIDTH-1, HEIGHT-1);
		assertTrue(gameMap.withinRange(character, WIDTH-range-1, HEIGHT-range-1, range));
	}
	
	@Test
	public void testNotWithinRangeOfTile() {
		Character character = new NPC(50);
		int range = 15;
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		gameMap.setTile(WIDTH-1, HEIGHT-1, MapTile.getPLAINS_MAX_HEIGHT());
		gameMap.placeCharacter(character, WIDTH-1, HEIGHT-1);
		assertFalse(gameMap.withinRange(character, WIDTH-range-2, HEIGHT-range-2, range));
	}
	
	@Test
	public void testWithinRangeOfTileCharacterDoesntExist() {
		Character character = new NPC(50);
		int range = 15;
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertThrows(NullPointerException.class, () -> {
			gameMap.withinRange(character, WIDTH-range-1, HEIGHT-range-1, range);
		});
	}
	
	@Test
	public void testTilesWithinRange() {
		int range = 15;
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertTrue(gameMap.withinRange(WIDTH-1, HEIGHT-1, WIDTH-range-1, HEIGHT-range-1, range));
	}
	
	@Test
	public void testTilesNotWithinRange() {
		int range = 15;
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertFalse(gameMap.withinRange(WIDTH-1, HEIGHT-1, WIDTH-range-2, HEIGHT-range-2, range));
	}
	
	@Test
	public void testTilesWithinRangeOriginXTooLarge() {
		int range = 15;
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.withinRange(INDEX_WIDTH_TOO_HIGH, HEIGHT-1, WIDTH-range-2, HEIGHT-range-2, range);
		});
	}
	@Test
	public void testTilesWithinRangeOriginXTooSmall() {
		int range = 15;
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.withinRange(INDEX_TOO_LOW, HEIGHT-1, WIDTH-range-2, HEIGHT-range-2, range);
		});
	}
	@Test
	public void testTilesWithinRangeOriginYTooLarge() {
		int range = 15;
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.withinRange(WIDTH-1, INDEX_HEIGHT_TOO_HIGH, WIDTH-range-2, HEIGHT-range-2, range);
		});
	}
	@Test
	public void testTilesWithinRangeOriginYTooSmall() {
		int range = 15;
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.withinRange(WIDTH-1, INDEX_TOO_LOW, WIDTH-range-2, HEIGHT-range-2, range);
		});
	}
	@Test
	public void testTilesWithinRangeTargetXTooLarge() {
		int range = 15;
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.withinRange(WIDTH-1, HEIGHT-1, INDEX_WIDTH_TOO_HIGH, HEIGHT-range-2, range);
		});
	}
	@Test
	public void testTilesWithinRangeTargetXTooSmall() {
		int range = 15;
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.withinRange(WIDTH-1, HEIGHT-1, INDEX_TOO_LOW, HEIGHT-range-2, range);
		});
	}
	@Test
	public void testTilesWithinRangeTargetYTooLarge() {
		int range = 15;
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.withinRange(WIDTH-1, HEIGHT-1, WIDTH-range-2, INDEX_HEIGHT_TOO_HIGH, range);
		});
	}
	@Test
	public void testTilesWithinRangeTargetYTooSmall() {
		int range = 15;
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.withinRange(WIDTH-1, HEIGHT-1, WIDTH-range-2, INDEX_TOO_LOW, range);
		});
	}
	
	@Test
	public void testGetCharacterTileNotOccupied() {
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertEquals(null, gameMap.getCharacter(WIDTH-1, HEIGHT-1));
	}
	
	@Test
	public void testGetCharacterXTooHigh() {
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.getCharacter(INDEX_WIDTH_TOO_HIGH, HEIGHT-1);
		});
	}
	@Test
	public void testGetCharacterXTooLow() {
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.getCharacter(INDEX_TOO_LOW, HEIGHT-1);
		});
	}
	@Test
	public void testGetCharacterYTooHigh() {
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.getCharacter(WIDTH-1, INDEX_HEIGHT_TOO_HIGH);
		});
	}
	@Test
	public void testGetCharacterYTooLow() {
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.getCharacter(WIDTH-1, INDEX_TOO_LOW);
		});
	}
	
	@Test
	public void testGetTileXIndexTooLow() {
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.getTile(INDEX_TOO_LOW,0);
		});
	}
	
	@Test
	public void testGetTileYIndexTooLow() {
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.getTile(0,INDEX_TOO_LOW);
		});
	}
	
	@Test
	public void testGetTileXIndexTooHigh() {
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.getTile(INDEX_WIDTH_TOO_HIGH,0);
		});
	}
	
	@Test
	public void testGetTileYIndexTooHigh() {
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.getTile(0,INDEX_HEIGHT_TOO_HIGH);
		});
	}
	
	@Test
	public void testGetWidth() {
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertEquals(WIDTH, gameMap.getWidth());
	}
	@Test
	public void testGetHeight() {
		GameMap gameMap = new GameMap(WIDTH,HEIGHT);
		assertEquals(HEIGHT, gameMap.getHeight());
	}
	
	@Test
	public void testEqualsDefaultMap() {
		GameMap map = new GameMap(WIDTH,HEIGHT);
		GameMap comparandMap = new GameMap(WIDTH,HEIGHT);
		assertTrue(map.equals(comparandMap));
	}
	
	@Test
	public void testNotEqualsDefaultMap() {
		GameMap map = new GameMap(WIDTH,HEIGHT);
		map.setTile(0, 0, HEIGHT);
		GameMap comparandMap = new GameMap(WIDTH,HEIGHT);
		assertFalse(map.equals(comparandMap));
	}
	
	@Test
	public void testEqualsMap() {
		GameMap map = new GameMap(SMALLER_WIDTH, SMALLER_HEIGHT);
		map.setTile(0,0,98);
		map.setTile(0,1,6);
		map.setTile(1,0,199);
		map.setTile(1,1,62);
		GameMap comparandMap = new GameMap(SMALLER_WIDTH, SMALLER_HEIGHT);
		comparandMap.setTile(0,0,98);
		comparandMap.setTile(0,1,6);
		comparandMap.setTile(1,0,199);
		comparandMap.setTile(1,1,62);
		assertTrue(map.equals(comparandMap));
	}
	
	@Test
	public void testNotEqualsMap() {
		GameMap map = new GameMap(SMALLER_WIDTH, SMALLER_HEIGHT);
		map.setTile(0,0,98);
		map.setTile(0,1,6);
		map.setTile(1,0,199);
		map.setTile(1,1,62);
		GameMap comparandMap = new GameMap(SMALLER_WIDTH, SMALLER_HEIGHT);
		comparandMap.setTile(0,0,25);
		comparandMap.setTile(0,1,89);
		comparandMap.setTile(1,0,1);
		comparandMap.setTile(1,1,180);
		assertFalse(map.equals(comparandMap));
	}
	
	@Test
	public void testEqualsSameMap() {
		GameMap map = new GameMap(WIDTH,HEIGHT);
		map.setTile(0,0,98);
		map.setTile(0,1,6);
		map.setTile(1,0,199);
		map.setTile(1,1,62);
		assertTrue(map.equals(map));
	}
	
	@Test
	public void testDefaultMapToString() {
		GameMap map = new GameMap(SMALLER_WIDTH, SMALLER_HEIGHT);
		assertEquals("Map height: 2, Map width: 2\r\n"
				+ "\r\n"
				+ "Height: 0, Biome: none, Accessibility: none, Symbol: \r\n"
				+ "Height: 0, Biome: none, Accessibility: none, Symbol: \r\n"
				+ "Height: 0, Biome: none, Accessibility: none, Symbol: \r\n"
				+ "Height: 0, Biome: none, Accessibility: none, Symbol: \r\n", map.toString());
	}
	
	@Test
	public void testMapToString() {
		GameMap map = new GameMap(SMALLER_WIDTH, SMALLER_HEIGHT);
		map.setTile(0,0,MapTile.getMOUNTAIN_MAX_HEIGHT());
		map.setTile(0,1,MapTile.getOCEAN_MAX_HEIGHT());
		map.setTile(1,0,MapTile.getPLAINS_MAX_HEIGHT());
		map.setTile(1,1,MapTile.getPLAINS_MAX_HEIGHT());
		assertEquals("Map height: 2, Map width: 2\r\n"
				+ "\r\n"
				+ "Height: 200, Biome: mountain, Accessibility: flight, Symbol: ∧\r\n"
				+ "Height: 80, Biome: ocean, Accessibility: swimming, Symbol: ˜\r\n"
				+ "Height: 140, Biome: plains, Accessibility: walking, Symbol: .\r\n"
				+ "Height: 140, Biome: plains, Accessibility: walking, Symbol: .\r\n", map.toString());
	}
	
	@Test
	public void testRenderDefaultMap() {
		GameMap map = new GameMap(SMALLER_WIDTH, SMALLER_HEIGHT);
		assertEquals("\r\n"
				+ "\r\n", map.renderMap());
	}
	
	@Test
	public void testRenderMap() {
		GameMap map = new GameMap(SMALLER_WIDTH, SMALLER_HEIGHT);
		map.setTile(0,0,MapTile.getMOUNTAIN_MAX_HEIGHT());
		map.setTile(0,1,MapTile.getOCEAN_MAX_HEIGHT());
		map.setTile(1,0,MapTile.getPLAINS_MAX_HEIGHT());
		map.setTile(1,1,MapTile.getPLAINS_MAX_HEIGHT());
		assertEquals("∧˜\r\n"
				+ "..\r\n", map.renderMap());
	}
}
