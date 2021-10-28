package map;

import Player.Character;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Objects;

/**
 * GameMap.java - class to store a map represented by tiles and all characters placed on it.
 *
 *@author Philip Sjunnesson
 *@see MapGenerator
 *@see MapTile
 */
public class GameMap {
  //constants representing the maximum and minimum size of the map.
  //MAX_DIMENSION was chosen arbitrarily, can be changed to anything.
  //MIN_DIMENSION was chosen to make it easier to read, as the starting point of the map is then 0,0
  //MIN_DIMENSION being 0 also limits the complexity of the code.
  private static final int MIN_INDEX = 0;
  private static final int MAX_DIMENSION = 200;
  private static final int MIN_DIMENSION = 1;

  //the 2d array representing the tiled map.
  private MapTile[][] map;

  //Hashmap storing what characters are on the map and where they are located.
  private HashMap<Character, Integer> characterLocations = new HashMap<Character, Integer>();

  /**
   *Create an empty map with all tiles set to DEFAULT.
   *
   * @param x a variable of type Integer. Limit 0-200.
   * @param y a variable of type Integer. Limit 0-200.
   * @exception IllegalArgumentException x or y are outside allowed range.
   */
  public GameMap(int x, int y) {
    if (!(validateDimensions(x) && validateDimensions(y))) {
      throw new IllegalArgumentException();
    }
    this.map = new MapTile[x][y];
    setDefaultMap();
  }

  //get() methods for the maximum and minimum size of the map.
  //used in the testing methods.
  protected static final int getMin_Index() {
    return MIN_INDEX;
  }
  
  protected static final int getMax_Dimension() {
    return MAX_DIMENSION; 
  }
  
  protected static final int getMin_Dimension() {
    return MIN_DIMENSION; 
  }
  
  //Will return true if i is within the inclusive range from MIN_DIMENSION to MAX_DIMENSION
  //and it is not null.
  //Used to check if map dimensions are valid.
  private boolean validateDimensions(int i) {
    if (i < MIN_DIMENSION || i > MAX_DIMENSION) {
      return false;
    }
    return true;
  }

  //Will return true if i is within the inclusive range from MIN_DIMENSION to MAX_DIMENSION
  //and is not null.
  private boolean validateIndex(int x, int y) {
    if (x < MIN_INDEX || x >= map[0].length || y < MIN_INDEX || y >= map.length) {
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

  /**
   * Set a tile located at coordinates x,y in the map equal to height.
   *
   * @param x a variable of type Integer. Limited by size of map.
   * @param y a variable of type Integer. Limited by size of map.
   * @exception IndexOutOfBoundsException x or y are outside allowed range.
   * @param height a variable of type Integer. Limited in accordance to MapTile max and min size.
   */
  public void setTile(int x, int y, int height) {
    if (!(validateIndex(x, y))) {
      throw new IndexOutOfBoundsException();
    }
    map[x][y].setTile(height);
  }

  //Will set all the tiles in a newly created map equal to DEFAULT.
  //Is only used in the constructor to generate a default map.
  private void setDefaultMap() {
    for (int x = MIN_INDEX; x < map[0].length; x++) {
      for (int y = MIN_INDEX; y < map.length; y++) {
        setTile(x, y);
      }
    }
  }

  /**
   * Retrieve the tile at location x,y in the map.
   *
   * @param x a variable of type Integer. Limited by size of map.
   * @param y a variable of type Integer. Limited by size of map.
   * @exception IndexOutOfBoundsException x or y are outside allowed range.
   * @return A MapTile data type.
   */
  public MapTile getTile(int x, int y) {
    if (!(validateIndex(x, y))) {
      throw new IndexOutOfBoundsException();
    }
    return map[x][y];
  }

  //Will return the map in its entirety.
  //Is used in tests, would be used in a class managing the entire game.
  protected MapTile[][] getMap() {
    return map;
  }

  //Will return the width of the map. Used for testing.
  protected int getWidth() {
    return map[0].length;
  }
  
  //Will return the height of the map. Used for testing.
  protected int getHeight() {
    return map.length;
  }

  /**
   * Create a String that represents the map as it would be shown in the game.
   *
   * @return a String data type.
   */
  public String renderMap() {
    StringBuilder output = new StringBuilder();
    for (int x = 0; x < map[0].length; x++) {
      for (int y = 0; y < map.length; y++) {
        output.append(map[x][y].getSymbol());
      }
      output.append("\r\n");
    }
    return output.toString();
  }

  /**
   * Place a character on a tile on the map.
   *
   * @param character a variable of type Player.Character.
   * @param x a variable of type Integer. Limited by size of map.
   * @param y a variable of type Integer. Limited by size of map.
   * @exception IndexOutOfBoundsException x or y are outside allowed range.
   * @exception IllegalStateException tile is already occupied.
   */
  public void placeCharacter(Character character, int x, int y) {
    if (!(validateIndex(x, y))) {
      throw new IndexOutOfBoundsException();
    }
    if (map[x][y].isOccupied()) {
      throw new IllegalStateException();
    }
    if (characterLocations.containsKey(character)) {
      map[characterLocations.get(
          character) / MAX_DIMENSION][characterLocations.get(character) % MAX_DIMENSION
                                      ].setOccupied(false);
    }
    characterLocations.put(character, x * MAX_DIMENSION + y);
    map[x][y].setOccupied(true);
  }

  //Will return true if two characters are within one tile of each other.
  public boolean isNeighbour(Character origin, Character target) {
    return withinRange(origin, target, 1);
  }

  /**
   * Check if two characters are within range of each other.
   *
   * @param origin a variable of type Player.Character.
   * @param target a variable of type Player.Character.
   * @param range a variable of type Integer.
   * @exception NullPointerException origin or target don't exist in array.
   * @return a Boolean data type.
   */
  public boolean withinRange(Character origin, Character target, int range) {

    if (!(characterLocations.containsKey(origin) && characterLocations.containsKey(target))) {
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

  /**
   * Check if a character is within range of a tile.
   *
   * @param origin a variable of type Player.Character.
   * @param targetX a variable of type Integer. Limited by size of map.
   * @param targetY a variable of type Integer. Limited by size of map.
   * @param range a variable of type Integer.
   * @exception NullPointerException origin doesn't exist in the array.
   * @return a Boolean data type
   */
  public boolean withinRange(Character origin, int targetX, int targetY, int range) {

    if (!(characterLocations.containsKey(origin))) {
      throw new NullPointerException();
    }

    int indexOrigin = characterLocations.get(origin);

    int originX = indexOrigin / MAX_DIMENSION;
    int originY = indexOrigin % MAX_DIMENSION;

    return withinRange(originX, originY, targetX, targetY, range);
  }

  /**
   * Check if two tiles are within range of each other.
   *
   * @param originX a variable of type Integer. Limited by size of map.
   * @param originY a variable of type Integer. Limited by size of map.
   * @param targetX a variable of type Integer. Limited by size of map.
   * @param targetY a variable of type Integer. Limited by size of map.
   * @param range a variable of type Integer.
   * @exception IndexOutOfBoundsException originX ,originY ,targetX,
   *     targetY are outside allowed range.
   * @return a Boolean data type.
   */
  public boolean withinRange(int originX, int originY, int targetX, int targetY, int range) {
    if (!(validateIndex(originX, originY) 
        && validateIndex(targetX, targetY))) {
      throw new IndexOutOfBoundsException();
    }
    if ((targetX >= originX - range && targetX <= originX + range) 
        && (targetY >= originY - range && targetY <= originY + range)) {
      return true;
    }
    return false;
  }

  /**
   * Retrieve a character based on their location on the map.
   *
   * @param x a variable of type Integer. Limited by size of map.
   * @param y a variable of type Integer. Limited by size of map.
   * @exception IndexOutOfBoundsException x or y are outside allowed range.
   * @return a Player.Character data type.
   */
  public Character getCharacter(int x, int y) {
    if (!(validateIndex(x, y))) {
      throw new IndexOutOfBoundsException();
    }
    if (map[x][y].isOccupied()) {
      int index = x * MAX_DIMENSION + y;
      for (Entry<Character, Integer> entry : characterLocations.entrySet()) {
        if (Objects.equals(index, entry.getValue())) {
          return entry.getKey();
        }
      }
    }
    return null;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + Arrays.deepHashCode(map);
    result = prime * result + Objects.hash(characterLocations);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof GameMap)) {
      return false;
    }
    GameMap other = (GameMap) obj;
    return Objects.equals(characterLocations, other.characterLocations) 
        && Arrays.deepEquals(map, other.map);
  }

  @Override
  public String toString() {
    return "GameMap [map=" + Arrays.toString(map) 
      + ", characterLocations=" + characterLocations + "]";
  }
}
