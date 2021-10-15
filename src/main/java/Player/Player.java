package Player;

public class Player extends CharacterDecorator {
	
	public Player(Character c) {
		super(c);

	}

	@Override
	public String getDescription() {
		return this.character.getDescription() + "Player.";
	}


}
