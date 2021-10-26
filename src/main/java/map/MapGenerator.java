package map;

import de.articdive.jnoise.JNoise;
import de.articdive.jnoise.interpolation.InterpolationType;
import java.util.Random;

/**
 * MapGenerator.java - class to create and return a procedurally generated map.
 *
 *@author Philip Sjunnesson
 *@see GameMap
 *@see JNoise
 */
public abstract class MapGenerator {
  
  private static final Random RANDOM = new Random();
  
  //Create a noise map using the provided Long seed
  //Noise map is generated using Perlin's algorithm, with the interpolation set to linear.
  //Should only need to be used when generating a map.
  private JNoise generateNoise(Long seed) {
    return JNoise.newBuilder()
        .perlin()
        .setInterpolation(InterpolationType.LINEAR)
        .setSeed(seed)
        .build();
  }

  /**
   * Create a procedurally generated map based on a provided seed.
   *
   * @param width a variable of type Integer.
   * @param height a variable of type Integer.
   * @param seed a variable of type Long.
   * @return a GameMap data type.
   */
  public GameMap generateMap(int width, int height, Long seed) {
    JNoise noise = generateNoise(seed);
    GameMap map = new GameMap(height, width);
    for (int x = GameMap.getMin_Dimension(); x < width; x++) {
      for (int y = GameMap.getMin_Dimension(); y < height; y++) {
        //With Perlin noise, the noise value at whole integers (e.g 1,1)
        //is always equal to 0, therefore the x&y values in the for loop
        //are divided by 30.
        map.setTile(x, y, (int) ((noise.getNoise(((double) x) / 30, ((double) y) / 30) + 1) * 100));
      }
    }
    return map;
  }

  //Will create a new map based on a random seed by calling
  //generateMap(int,int,seed);
  public GameMap generateMap(int width, int height) {
    return generateMap(width, height, RANDOM.nextLong());
  }
}
