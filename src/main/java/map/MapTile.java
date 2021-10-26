package map;

public class MapTile {
	
	//constants representing the maximum and minimum possible map height.
	//0 and 200 were chosen for readability reasons, Perlin Noise (linear)
	//generates values between -1 and 1, so these values could easily be changed as long
	//as it can be mapped to the range -1 to 1.
	private static final int MIN_HEIGHT = 0;
	private static final int MAX_HEIGHT = 200;
	
	//constants representing the dividing lines between the different biomes
	//as they are generated on the map. Anything at 80 and below is ocean,
	//between 81 up to and including 140 is plains, and above that is mountains.
	//Values chosen from generating some maps and choosing values that look good.
	private static final int OCEAN_MAX_HEIGHT = 80;
	private static final int PLAINS_MAX_HEIGHT = 140;
	private static final int MOUNTAIN_MAX_HEIGHT = MAX_HEIGHT;
	
	//height represents the noise value for the specific tile, between 0 & 200.
	private int height;
	//occupied represents if a tile is currently being occupied by a character.
	private boolean occupied;
	//Biome represents the hard coded biomes available on generation. 
	//DEFAULT is for map tiles that have not been assigned a height.
	//DEFAULT will therefore show if a map has been generated or not, and if it's been completely generated.
	private enum Biome {
		OCEAN("ocean", "swimming", "˜"),
		PLAINS("plains", "walking", "."),
		MOUNTAIN("mountain", "flight", "∧"),
		DEFAULT("none", "none", "");
		
		private String name;
		private String accessibility;
		private String symbol;
		private Biome(String name, String accessibility, String symbol) {
			this.name = name;
			this.accessibility = accessibility;
			this.symbol = symbol;
		}
	}
	private Biome biome;
	
	//will create a DEFAULT tile that can later receive a value.
	protected MapTile() {
		this.biome = Biome.DEFAULT;
		this.height = 0;
		this.occupied = false;
	}
	
	//get methods for the scope of the map.
	//these values are used in the tests.
	protected static int getMIN_HEIGHT() { return MIN_HEIGHT; }
	protected static int getMAX_HEIGHT() { return MAX_HEIGHT; }
	protected static int getOCEAN_MAX_HEIGHT() { return OCEAN_MAX_HEIGHT; }
	protected static int getPLAINS_MAX_HEIGHT() { return PLAINS_MAX_HEIGHT; }
	protected static int getMOUNTAIN_MAX_HEIGHT() { return MOUNTAIN_MAX_HEIGHT; }
	
	
	//will set the tile height equal to the provided value
	//as long as the tile is originally a DEFAULT tile
	//and that the height is within the allowed range.
	protected void setTile(int i) {
		if(!(biome == Biome.DEFAULT)) {
			throw new IllegalStateException();
		}
		switch ((MIN_HEIGHT <= i && i <= OCEAN_MAX_HEIGHT) ? 0 : //if i is the ocean height range then go to 0
			(OCEAN_MAX_HEIGHT < i && i <= PLAINS_MAX_HEIGHT) ? 1 : //if i is in the plains height range then go to 1
				(PLAINS_MAX_HEIGHT < i && i <= MOUNTAIN_MAX_HEIGHT) ? 2 : 3) { //if i is in the mountain height range then go to 2
			
		case 0:
			this.biome = Biome.OCEAN;
			break;
		case 1:
			this.biome = Biome.PLAINS;
			break;
		case 2:
			this.biome = Biome.MOUNTAIN;
			break;
		case 3:
			throw new IllegalArgumentException();
		}
		this.height = i;
	}
	
	//get methods for the tile class.
	public int getHeight() {
		return height;
	}
	public String getAccessibility() {
		return biome.accessibility;
	}
	public String getBiome() {
		return biome.name;
	}
	public String getSymbol() {
		return biome.symbol;
	}
	public boolean isOccupied() {
		return occupied;
	}
	
	//set method for occupied variable. Used to show that a tile is occupied.
	//Will throw an IllegalStateException if the tile is being set to the status it already is.
	//If it is not occupied, it should never have to be set to not occupied,
	//and an occupied tile should never be able to be set to occupied before being vacated first.
	//Trying to set a default tile to occupied will also throw an IllegalStateException.
	public void setOccupied(boolean occupiedStatus) {
		if(biome == Biome.DEFAULT) {
			throw new IllegalStateException();
		}
		if(occupied == occupiedStatus) {
			throw new IllegalArgumentException();
		}
		this.occupied = occupiedStatus;
	}
	
	//will output all the relevant data within the tile class. 
	//Can be changed to:
	//return valueOf(height);
	//if needing a more condensed version, or if only wanting the
	//necessary data for, for example, saving the map to the disk.
	@Override
	public String toString() {
		return "Height: " + height + ", Biome: " + biome.name + ", Accessibility: " + biome.accessibility + ", Symbol: " + biome.symbol;
	}
	
	//if object o is this object or an instance of MapTile
	//with the same values, return true. Otherwise return false.
	@Override
	public boolean equals(Object o) {
		
		if (o == this) {
			return true;
		}
		if (!(o instanceof MapTile)) {
			return false;
		}
		MapTile comparand = (MapTile) o;
		return height == comparand.height
				&& biome == comparand.biome;
	}
}
