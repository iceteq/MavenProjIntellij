package map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import java.util.Random;

public class TestGameMap {
	
	private static final int HEIGHT = 100;
	private static final int WIDTH = 100;
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
	
	public void testGetTileYIndexTooLow() {
		GameMap gameMap = new GameMap(HEIGHT,WIDTH);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.getTile(0,INDEX_TOO_LOW);
			});
	}
	
	public void testGetTileXIndexTooHigh() {
		GameMap gameMap = new GameMap(HEIGHT,WIDTH);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.getTile(INDEX_WIDTH_TOO_HIGH,0);
			});
	}
	
	public void testGetTileYIndexTooHigh() {
		GameMap gameMap = new GameMap(HEIGHT,WIDTH);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			gameMap.getTile(0,INDEX_HEIGHT_TOO_HIGH);
			});
	}
}
