package equipment;

public abstract class Equipment {
	
	private String name;
	
	protected Equipment(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;	
	}
}
