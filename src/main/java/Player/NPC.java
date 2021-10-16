package Player;

public class NPC extends CharacterDecorator { //Denna klass skulle kunna göras abstrakt och sedan skapa två konkreta klasser(FriendlyNPC, EnemyNPC) som konkreta underklasser

	public NPC(Character c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		return this.character.getDescription() + "NPC.";
		
	}

	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return this.getHealth();
	}

	@Override
	public void changeHealth(int newHealth) {
		this.character.changeHealth(newHealth);
		
	}










}
