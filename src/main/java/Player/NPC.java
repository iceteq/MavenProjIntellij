package Player;

public class NPC extends CharacterDecorator {

	public NPC(Character c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		return this.character.getDescription() + "NPC.";
		
	}



}
