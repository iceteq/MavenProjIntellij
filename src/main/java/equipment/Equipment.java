package equipment;

public abstract class Equipment implements Carriable {
	
	private String name;
	
	protected Equipment(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;	
	}

	@Override
	public String toString() {
		return "Equipment{" +
				"name='" + name + '\'' +
				'}';
	}
}
