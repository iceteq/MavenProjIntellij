package Player;

abstract class CharacterDecorator implements Character {
	protected Character character;

	
	protected CharacterDecorator(Character c) {
		this.character = c;
		
	}
	
}
