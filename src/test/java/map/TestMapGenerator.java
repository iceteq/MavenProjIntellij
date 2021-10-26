package map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import de.articdive.jnoise.JNoise;
import de.articdive.jnoise.interpolation.InterpolationType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * TestMapGenerator.java - test class for MapGenerator.
 *
 *@author Philip Sjunnesson
 *@see MapGenerator
 */
public class TestMapGenerator {

  private static final GameMap gameMap = new GameMap(2, 2);
  private static final MapGenerator generator = new MapGenerator() {};
  private static final JNoise noise = JNoise.newBuilder()
      .perlin()
      .setInterpolation(InterpolationType.LINEAR)
      .setSeed(500L)
      .build();

  /**
   * Initialises the comparand map to compare the MapGenerator methods against.
   */
  @BeforeAll
  public static void init() {
    for (int x = GameMap.getMin_Dimension(); x < gameMap.getWidth(); x++) {
      for (int y = GameMap.getMin_Dimension(); y < gameMap.getHeight(); y++) {
        gameMap.setTile(x, y, 
            (int) ((noise.getNoise(((double) x) / 30, ((double) y) / 30) + 1) * 100));
      }
    }
  }

  @Test
  public void testGenerateMap() {
    assertArrayEquals(gameMap.getMap(), generator.generateMap(2, 2, 500L).getMap());
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
      generator.generateMap(GameMap.getMin_Dimension() - 1, GameMap.getMin_Dimension() - 1, 500L);
    });
  }
  
  @Test
  public void testGenerateMapNotTooLarge() {
    assertThrows(IllegalArgumentException.class, () -> {
      generator.generateMap(GameMap.getMax_Dimension() + 1, GameMap.getMax_Dimension() + 1, 500L);
    });
  }

  @Test
  public void testGenerateRandomMapNotTooSmall() {
    assertThrows(IllegalArgumentException.class, () -> {
      generator.generateMap(GameMap.getMin_Dimension() - 1, GameMap.getMin_Dimension() - 1);
    });
  }
  
  @Test
  public void testGenerateRandomMapNotTooLarge() {
    assertThrows(IllegalArgumentException.class, () -> {
      generator.generateMap(GameMap.getMax_Dimension() + 1, GameMap.getMax_Dimension() + 1);
    });
  }
}
