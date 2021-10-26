package map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
  public void testGenerateRandomMap_ShouldNotReturnDefaultTile() {
    GameMap map = generator.generateMap(100, 100);
    assertNotNull(map.getTile(1 / 30, 1 / 30));
  }

  @Test
  public void testGenerateMap_WidthIndexTooSmall() {
    assertThrows(IllegalArgumentException.class, () -> {
      generator.generateMap(GameMap.getMin_Dimension() - 1, GameMap.getMax_Dimension(), 500L);
    });
  }
  
  @Test
  public void testGenerateMap_WidthIndexTooLarge() {
    assertThrows(IllegalArgumentException.class, () -> {
      generator.generateMap(GameMap.getMax_Dimension() + 1, GameMap.getMax_Dimension(), 500L);
    });
  }
  
  @Test
  public void testGenerateMap_HeightIndexTooSmall() {
    assertThrows(IllegalArgumentException.class, () -> {
      generator.generateMap(GameMap.getMax_Dimension(), GameMap.getMin_Dimension() - 1, 500L);
    });
  }
  
  @Test
  public void testGenerateMap_HeightIndexTooLarge() {
    assertThrows(IllegalArgumentException.class, () -> {
      generator.generateMap(GameMap.getMax_Dimension(), GameMap.getMax_Dimension() + 1, 500L);
    });
  }

  @Test
  public void testGenerateRandomMap_WidthIndexTooSmall() {
    assertThrows(IllegalArgumentException.class, () -> {
      generator.generateMap(GameMap.getMin_Dimension() - 1, GameMap.getMax_Dimension());
    });
  }
  
  @Test
  public void testGenerateRandomMap_WidthIndexTooLarge() {
    assertThrows(IllegalArgumentException.class, () -> {
      generator.generateMap(GameMap.getMax_Dimension() + 1, GameMap.getMax_Dimension());
    });
  }
  
  @Test
  public void testGenerateRandomMap_HeightIndexTooSmall() {
    assertThrows(IllegalArgumentException.class, () -> {
      generator.generateMap(GameMap.getMax_Dimension(), GameMap.getMin_Dimension() - 1);
    });
  }
  
  @Test
  public void testGenerateRandomMap_HeightIndexTooLarge() {
    assertThrows(IllegalArgumentException.class, () -> {
      generator.generateMap(GameMap.getMax_Dimension(), GameMap.getMax_Dimension() + 1);
    });
  }
}
