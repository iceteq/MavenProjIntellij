package map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class TestGameMap {
	
	private static final int HEIGHT = 100;
	private static final int WIDTH = 100;
	private static final int SMALLER_HEIGHT = 2;
	private static final int SMALLER_WIDTH = 2;
	private static final int INDEX_TOO_LOW = -1;
	private static final int INDEX_HEIGHT_TOO_HIGH = HEIGHT+1;
	private static final int INDEX_WIDTH_TOO_HIGH = WIDTH+1;
	
	private Random random = new Random();
		
	@Test
	public void testDefaultGeneration() {
		MapTile defaultTile = new MapTile();
		GameMap gameMap = new GameMap(HEIGHT,WIDTH);
		for(int x = 0; x < gameMap.getMap()[0].length; x++) {
			for(int y = 0; y < gameMap.getMap().length; y++) {
				assertEquals(defaultTile, gameMap.getTile(x,y));
			}
		}
	}
	
	@Test
	public void testGetDefaultTile() {
		MapTile defaultTile = new MapTile();
		GameMap gameMap = new GameMap(HEIGHT,WIDTH);
		assertEquals(defaultTile, gameMap.getTile(random.nextInt(WIDTH+1), random.nextInt(HEIGHT+1)));
	}
	
	@Test
	public void testSetDefaultMapOnExistingMap() {
		GameMap gameMap = new GameMap(HEIGHT,WIDTH);
		for(int x = 0; x < gameMap.getMap()[0].length; x++) {
			for(int y = 0; y < gameMap.getMap().length; y++) {
				gameMap.setTile(x,y,random.nextInt(MapTile.getMAX_HEIGHT()+1));
			}
		}
		assertThrows(IllegalStateException.class, () -> {
			gameMap.setDefaultMap();
		});
	}
	
	@Test
	public void testSetTiles() {
		MapTile defaultTile = new MapTile();
		GameMap gameMap = new GameMap(HEIGHT,WIDTH);
		for(int x = 0; x < gameMap.getMap()[0].length; x++) {
			for(int y = 0; y < gameMap.getMap().length; y++) {
				gameMap.setTile(x,y,random.nextInt(MapTile.getMAX_HEIGHT()+1));
				assertFalse(defaultTile.equals(gameMap.getTile(x,y)));
			}
		}
	}
	
	@Test
	public void testMakeMapXTooSmall() {
		assertThrows(IllegalArgumentException.class, () -> {
			GameMap map = new GameMap(GameMap.getMIN_INDEX()-1,0);
		});
	}
	
	@Test
	public void testMakeMapYTooSmall() {
		assertThrows(IllegalArgumentException.class, () -> {
			GameMap map = new GameMap(0,GameMap.getMIN_INDEX()-1);
		});
	}
	
	@Test
	public void testMakeMapXTooLarge() {
		assertThrows(IllegalArgumentException.class, () -> {
			GameMap map = new GameMap(GameMap.getMAX_INDEX()+1,0);
		});
	}
	
	@Test
	public void testMakeMapYTooLarge() {
		assertThrows(IllegalArgumentException.class, () -> {
			GameMap map = new GameMap(0,GameMap.getMAX_INDEX()+1);
		});
	}
	
	@Test
	public void testSetTileXIndexTooLow() {
		GameMap gameMap = new GameMap(HEIGHT,WIDTH);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.setTile(INDEX_TOO_LOW,0,MapTile.getMAX_HEIGHT());
		});
	}
	
	@Test
	public void testSetTileYIndexTooLow() {
		GameMap gameMap = new GameMap(HEIGHT,WIDTH);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.setTile(0,INDEX_TOO_LOW,MapTile.getMAX_HEIGHT());
		});
	}
	
	@Test
	public void testSetTileXIndexTooHigh() {
		GameMap gameMap = new GameMap(HEIGHT,WIDTH);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.setTile(INDEX_WIDTH_TOO_HIGH,0,MapTile.getMAX_HEIGHT());
		});
	}
	
	@Test
	public void testSetTileYIndexTooHigh() {
		GameMap gameMap = new GameMap(HEIGHT,WIDTH);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.setTile(0,INDEX_HEIGHT_TOO_HIGH,MapTile.getMAX_HEIGHT());
		});
	}
	
	@Test
	public void testGetTileXIndexTooLow() {
		GameMap gameMap = new GameMap(HEIGHT,WIDTH);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.getTile(INDEX_TOO_LOW,0);
			});
	}
	
	@Test
	public void testGetTileYIndexTooLow() {
		GameMap gameMap = new GameMap(HEIGHT,WIDTH);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.getTile(0,INDEX_TOO_LOW);
			});
	}
	
	@Test
	public void testGetTileXIndexTooHigh() {
		GameMap gameMap = new GameMap(HEIGHT,WIDTH);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.getTile(INDEX_WIDTH_TOO_HIGH,0);
			});
	}
	
	@Test
	public void testGetTileYIndexTooHigh() {
		GameMap gameMap = new GameMap(HEIGHT,WIDTH);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.getTile(0,INDEX_HEIGHT_TOO_HIGH);
			});
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
		map.setTile(0,0,98);
		map.setTile(0,1,6);
		map.setTile(1,0,199);
		map.setTile(1,1,62);
		assertEquals("Map height: 2, Map width: 2\r\n"
				+ "\r\n"
				+ "Height: 98, Biome: plains, Accessibility: walking, Symbol: .\r\n"
				+ "Height: 6, Biome: ocean, Accessibility: swimming, Symbol: ˜\r\n"
				+ "Height: 199, Biome: mountain, Accessibility: flight, Symbol: ∧\r\n"
				+ "Height: 62, Biome: plains, Accessibility: walking, Symbol: .\r\n", map.toString());
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
		map.setTile(0,0,132);
		map.setTile(0,1,93);
		map.setTile(1,0,26);
		map.setTile(1,1,80);
		assertEquals("∧.\r\n"
				+ "˜.\r\n", map.renderMap());
	}
}
