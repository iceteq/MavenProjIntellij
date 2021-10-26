package map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import de.articdive.jnoise.JNoise;
import de.articdive.jnoise.interpolation.InterpolationType;

public class TestMapGenerator {
	
	private static final GameMap gameMap = new GameMap(2,2);
	private static final MapGenerator generator = new MapGenerator() {};
	private static final JNoise noise = JNoise.newBuilder().perlin().setInterpolation(InterpolationType.LINEAR).setSeed(500l).build();
	
	@BeforeAll
	public static void init() {
		for (int x = GameMap.getMIN_DIMENSION(); x < gameMap.getWidth(); x++) {
			for (int y = GameMap.getMIN_DIMENSION(); y < gameMap.getHeight(); y++) {
				gameMap.setTile(x, y, (int)((noise.getNoise(((double)x)/30, ((double)y)/30)+1)*100));
			}
		}
	}
	
	@Test
	public void testGenerateMap() {
		assertArrayEquals(gameMap.getMap(), generator.generateMap(2,2,500l).getMap());
	}
	
	@Test
	public void testGenerateRandomMap() {
		GameMap map = generator.generateMap(100, 100);
		MapTile defaultTile = new MapTile();
		assertFalse(map.getTile(0, 0).equals(defaultTile));
	}
	
	@Test
	public void testGenerateMapNotTooSmall() {
		assertThrows(IllegalArgumentException.class, () -> {
			generator.generateMap(GameMap.getMIN_DIMENSION()-1, GameMap.getMIN_DIMENSION()-1, 500l);
		});
	}
	@Test
	public void testGenerateMapNotTooLarge() {
		assertThrows(IllegalArgumentException.class, () -> {
			generator.generateMap(GameMap.getMAX_DIMENSION()+1, GameMap.getMAX_DIMENSION()+1, 500l);
		});
	}
	
	@Test
	public void testGenerateRandomMapNotTooSmall() {
		assertThrows(IllegalArgumentException.class, () -> {
			generator.generateMap(GameMap.getMIN_DIMENSION()-1, GameMap.getMIN_DIMENSION()-1);
		});
	}
	@Test
	public void testGenerateRandomMapNotTooLarge() {
		assertThrows(IllegalArgumentException.class, () -> {
			generator.generateMap(GameMap.getMAX_DIMENSION()+1, GameMap.getMAX_DIMENSION()+1);
		});
	}
}
