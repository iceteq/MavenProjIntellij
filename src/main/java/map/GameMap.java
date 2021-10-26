package map;

import Player.Character;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;

public class GameMap {
	
	//constants representing the maximum and minimum size of the map.
	//MAX_DIMENSION was chosen arbitrarily, can be changed to anything.
	//MIN_DIMENSION was chosen to make it easier to read, as the starting point of the map is then 0,0
	//MIN_DIMENSION being 0 also limits the complexity of the code.
	private static final int MIN_DIMENSION = 0;
	private static final int MAX_DIMENSION = 200;
	
	//the 2d array representing the tiled map.
	private MapTile[][] map;
	
	//Hashmap storing what characters are on the map and where they are located.
	private HashMap<Character, Integer> characterLocations = new HashMap<Character, Integer>();
	
	//will create an empty map of the provided proportions.
	//All tiles will be set to DEFAULT.
	//Will throw an exception if x or y are outside the allowed range.
	public GameMap(int x, int y) {
		if(!(validateDimensions(x) && validateDimensions(y))) {
			throw new IllegalArgumentException();
		}
		this.map = new MapTile[x][y];
		setDefaultMap();
	}
	
	//get() methods for the maximum and minimum size of the map.
	//used in the testing methods.
	protected static final int getMIN_DIMENSION() { return MIN_DIMENSION; }
	protected static final int getMAX_DIMENSION() { return MAX_DIMENSION; }
	
	//Will return true if i is within the inclusive range from MIN_DIMENSION to MAX_DIMENSION
	//and it is not null.
	//Used to check if map dimensions are valid.
	private boolean validateDimensions(int i) {
		if(i < MIN_DIMENSION | i > MAX_DIMENSION) {
			return false;
		}
		return true;
	}
	
	//Will return true if i is within the inclusive range from MIN_DIMENSION to MAX_DIMENSION
	//and is not null.
	private boolean validateIndex(int x, int y) {
		if(x < MIN_DIMENSION | x >= map[0].length | y < MIN_DIMENSION | y >= map.length) {
			return false;
		}
		return true;
	}
	
	//Will create a tile located at position x,y to DEFAULT
	//as long as x,y are within the allowed range.
	//Should only be used through the setDefaultMap method.
	private void setTile(int x, int y) {
		map[x][y] = new MapTile();
	}
	
	//Will set an existing tile at index x,y equal to height.
	//as long as x,y are within the allowed range.
	public void setTile(int x, int y, int height) {
		if(!(validateIndex(x,y))) {
			throw new IndexOutOfBoundsException();
		}
		map[x][y].setTile(height);
	}
	
	//Will set all the tiles in a newly created map equal to DEFAULT.
	//Is only used in the constructor to generate a default map.
	private void setDefaultMap() {
		for(int x = MIN_DIMENSION; x < map[0].length; x++) {
			for(int y = MIN_DIMENSION; y < map.length; y++) {
				setTile(x,y);
			}
		}
	}
	
	//Will get the tile from the location x,y in the map
	//as long as x,y are within the allowed range.
	public MapTile getTile(int x, int y) {
		if(!(validateIndex(x,y))) {
			throw new IndexOutOfBoundsException();
		}
		return map[x][y];
	}
	
	//Will return the map in its entirety.
	//Is used in tests, would be used in a class managing the entire game.
	protected MapTile[][] getMap() {
		return map;
	}
	
	//Will respectively return the width and height of the map. Used for testing.
	protected int getWidth() {
		return map[0].length;
	}
	protected int getHeight() {
		return map.length;
	}
	
	
	//Will output the symbols of all the tiles in the map together as one long string
	//divided into the same rows and columns as they are in the map.
	//Makes it easy to visualise the map when coding and choosing biome limits.
	public String renderMap() {
		StringBuilder output = new StringBuilder();
		for(int x = 0; x < map[0].length; x++) {
			for(int y = 0; y < map.length; y++) {
				output.append(map[x][y].getSymbol());
			}
			output.append("\r\n");
		}
		return output.toString();
	}
	
	//Will add a character to a location on the map and set the associated tile as being occupied.
	//If the tile is already occupied then the original tile is reset to not occupied first.
	public void placeCharacter(Character character, int x, int y) {
		if(!(validateIndex(x,y))) {
			throw new IndexOutOfBoundsException();
		}
		if(map[x][y].isOccupied()) {
			throw new IllegalStateException();
		}
		if(characterLocations.containsKey(character)) {
			map[characterLocations.get(character) / MAX_DIMENSION][characterLocations.get(character) % MAX_DIMENSION].setOccupied(false);
		}
		characterLocations.put(character, x*MAX_DIMENSION + y);
		map[x][y].setOccupied(true);
	}
	
	//Will return true if two characters are within one tile of each other.
	public boolean isNeighbour(Character origin, Character target) {
		return withinRange(origin,target,1);
	}
	
	//Will return true if two characters that exist on the map are within a specified range of each other.
	public boolean withinRange(Character origin, Character target, int range) {
		
		if(!(characterLocations.containsKey(origin) && characterLocations.containsKey(target))) {
			throw new NullPointerException();
		}
		
		int indexOrigin = characterLocations.get(origin);
		int indexTarget = characterLocations.get(target);
		
		int originX = indexOrigin / MAX_DIMENSION;
		int originY = indexOrigin % MAX_DIMENSION;
		
		int targetX = indexTarget / MAX_DIMENSION;
		int targetY = indexTarget % MAX_DIMENSION;
		
		return withinRange(originX, originY, targetX, targetY, range);
	}
	
	//Will return true if a character that exists on the map is within a specified range of a specific tile.
	public boolean withinRange(Character origin, int targetX, int targetY, int range) {
		
		if(!(characterLocations.containsKey(origin))) {
			throw new NullPointerException();
		}
		
		int indexOrigin = characterLocations.get(origin);
		
		int originX = indexOrigin / MAX_DIMENSION;
		int originY = indexOrigin % MAX_DIMENSION;
		
		return withinRange(originX, originY, targetX, targetY, range);
	}
	
	//Will return true if two tiles (origin and target) are within a specified range of each other.
	public boolean withinRange(int originX, int originY, int targetX, int targetY, int range) {
		if(!(validateIndex(originX, originY) &&
				validateIndex(targetX, targetY))) {
			throw new IndexOutOfBoundsException();
		}
		if((targetX >= originX - range && targetX <= originX + range) &&
				(targetY >= originY - range && targetY <= originY + range)) {
			return true;
		}
		return false;
	}
	
	
	//Will return a character located at the provided coordinates.
	//Will throw exceptions if coordinates are outside allowed range
	//and will return null if the tile is not occupied.
	public Character getCharacter(int x, int y) {
		if(!(validateIndex(x,y))) {
			throw new IndexOutOfBoundsException();
		}
		if(map[x][y].isOccupied()) {
			int index = x * MAX_DIMENSION + y;
			for(Entry<Character, Integer> entry : characterLocations.entrySet()) {
				if(Objects.equals(index, entry.getValue())) {
					return entry.getKey();
				}
			}
		}
		return null;
	}
	
	//Will output a string with all the information in the class.
	//Could be used for a save to disk function with some changes (make it less readable, more information dense.)
	//Currently only used for debugging purposes.
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append("Map height: " + map.length + ", Map width: " + map[0].length + "\r\n\r\n");
		for(int x = 0; x < map[0].length; x++) {
			for(int y = 0; y < map.length; y++) {
				output.append(map[x][y].toString() + "\r\n");
			}
		}
		return output.toString();
	}
	
	//if object o is an instance of GameMap, and all the tiles in the map are equal
	//return true
	//else
	//return false.
	@Override
	public boolean equals(Object o) {
		if ((o instanceof GameMap)) {
			if (Arrays.deepEquals(map, ((GameMap) o).getMap())) {
				return true;
			}
		}
		return false;
	}
}
