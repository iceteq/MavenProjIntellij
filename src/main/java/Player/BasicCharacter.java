package Player;

class BasicCharacter implements Character {
	protected Character character;
	private int health;
	//private int level;
	
	protected BasicCharacter() {
		this.health = 1;
		//this.level = 1;
	}
	
	@Override
	public String getDescription() {
		return "Basic Character.";
		
	}

	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return this.health;
	}
	
	@Override
	public void changeHealth(int newHealth) {
		this.health = newHealth;
		
	}
	
	


	
		
}
