package Player;

abstract class CharacterDecorator implements Character {
	protected Character character;

	
	public CharacterDecorator(Character c) {
		this.character = c;
		
	}
}
