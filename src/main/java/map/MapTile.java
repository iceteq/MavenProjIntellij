package map;
public class MapTile {
	
	private static final int MINHEIGHT = 0;
	private static final int MAXHEIGHT = 200;
	private static final int OCEANMAXHEIGHT = 40;
	private static final int PLAINSMAXHEIGHT = 110;
	private static final int MOUNTAINMAXHEIGHT = MAXHEIGHT;
	
	private int height;
	private enum Biome {
		OCEAN("ocean", "swimming"),
		PLAINS("plains", "walking"),
		MOUNTAIN("mountain", "flight");
		
		private String name;
		private String accessibility;
		private Biome(String name, String accessibility) {
			this.name = name;
			this.accessibility = accessibility;
		}
	}
	private Biome biome;
	
	public MapTile(int i) {
		
		switch ((MINHEIGHT <= i && i <= OCEANMAXHEIGHT) ? 0 : //
			(OCEANMAXHEIGHT < i && i <= PLAINSMAXHEIGHT) ? 1 :
				(PLAINSMAXHEIGHT < i && i <= MOUNTAINMAXHEIGHT) ? 2 : 3) {
			
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
	
}
