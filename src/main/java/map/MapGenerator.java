package map;

import java.util.Random;

import de.articdive.jnoise.JNoise;
import de.articdive.jnoise.interpolation.InterpolationType;

public abstract class MapGenerator {
	
	//Create a noise map using the provided Long seed
	//Noise map is generated using Perlin's algorithm, with the interpolation set to linear.
	//Should only need to be used when generating a map.
	private JNoise generateNoise(Long seed) {
		return JNoise.newBuilder().perlin().setInterpolation(InterpolationType.LINEAR).setSeed(seed).build();
	}
	
	//Will create a new map based on a set seed, and then using the noise map
	//it will assign the height of each tile of the map.
	//This will then result in a map with different biomes.
	//
	//With Perlin noise, the noise value at whole integers (e.g 1,1)
	//is always equal to 0, therefore the x&y values in the for loop
	//are divided by 30.
	public GameMap generateMap(int width, int height, Long seed) {
		JNoise noise = generateNoise(seed);
		GameMap map = new GameMap(height, width);
		for (int x = GameMap.getMIN_DIMENSION(); x < width; x++) {
			for (int y = GameMap.getMIN_DIMENSION(); y < height; y++) {
				map.setTile(x, y, (int)((noise.getNoise(((double)x)/30, ((double)y)/30)+1)*100));
			}
		}
		return map;
	}
	
	//Will create a new map based on a random seed by calling
	//generateMap(int,int,seed);
	public GameMap generateMap(int width, int height) {
		Random random = new Random();
		return generateMap(width,height,random.nextLong());
	}
}
