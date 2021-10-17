package map;
public class GameMap {
	
	private static final int MIN_INDEX = 0;
	private static final int MAX_INDEX = 200;
	
	private MapTile[][] map;
	
	public GameMap(int x, int y) {
		if(!(validateIndex(x) && validateIndex(y))) {
			throw new IllegalArgumentException();
		}
		this.map = new MapTile[x][y];
		setDefaultMap();
	}
	
	protected static final int getMIN_INDEX() { return MIN_INDEX; }
	protected static final int getMAX_INDEX() { return MAX_INDEX; }
	
	private boolean validateIndex(int i) {
		if(i < MIN_INDEX | i > MAX_INDEX) {
			return false;
		}
		return true;
	}
	
	private void setTile(int x, int y) {
		if(!(validateIndex(x) && validateIndex(y))) {
			throw new IllegalArgumentException();
		}
		map[x][y] = new MapTile();
	}
	
	public void setTile(int x, int y, int height) {
		if(!(validateIndex(x) && validateIndex(y))) {
			throw new IndexOutOfBoundsException();
		}
		map[x][y].setTile(height);
	}
	
	public void setDefaultMap() {
		if(!(map[0][0] == null)) {
			throw new IllegalStateException();
		}
		for(int x = 0; x < map[0].length; x++) {
			for(int y = 0; y < map.length; y++) {
				setTile(x,y);
			}
		}
	}
	
	public MapTile getTile(int x, int y) {
		if(!(validateIndex(x) && validateIndex(y))) {
			throw new IndexOutOfBoundsException();
		}
		return map[x][y];
	}
	
	protected MapTile[][] getMap() {
		return map;
	}
}
