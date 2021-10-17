package map;
public class MapTile {
	
	private static final int MIN_HEIGHT = 0;
	private static final int MAX_HEIGHT = 200;
	private static final int OCEAN_MAX_HEIGHT = 40;
	private static final int PLAINS_MAX_HEIGHT = 110;
	private static final int MOUNTAIN_MAX_HEIGHT = MAX_HEIGHT;
	
	private int height;
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
	
	protected MapTile() {
		this.biome = Biome.DEFAULT;
		this.height = 0;
	}
	
	protected MapTile(int i) {
		this.biome = Biome.DEFAULT;
		this.height = 0;
		setTile(i);
	}
	
	protected static int getMIN_HEIGHT() { return MIN_HEIGHT; }
	protected static int getMAX_HEIGHT() { return MAX_HEIGHT; }
	protected static int getOCEAN_MAX_HEIGHT() { return OCEAN_MAX_HEIGHT; }
	protected static int getPLAINS_MAX_HEIGHT() { return PLAINS_MAX_HEIGHT; }
	protected static int getMOUNTAIN_MAX_HEIGHT() { return MOUNTAIN_MAX_HEIGHT; }
	
	protected void setTile(int i) {
		if(!(biome == Biome.DEFAULT)) {
			throw new IllegalStateException();
		}
		switch ((MIN_HEIGHT <= i && i <= OCEAN_MAX_HEIGHT) ? 0 : //
			(OCEAN_MAX_HEIGHT < i && i <= PLAINS_MAX_HEIGHT) ? 1 :
				(PLAINS_MAX_HEIGHT < i && i <= MOUNTAIN_MAX_HEIGHT) ? 2 : 3) {
			
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
	
	@Override
	public String toString() {
		return "Height: " + height + ", Biome: " + biome.name + ", Accessibility: " + biome.accessibility + ", Symbol: " + biome.symbol;
	}
	
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
