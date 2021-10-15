package Player;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CharacterTest {

	@Test
	public void testPlayerDescription() {
		Character playerCharacter = new Player(new BasicCharacter());
		assertEquals("Basic Character.Player.", playerCharacter.getDescription());
	}
	
	@Test
	public void testNPCDescription() {
		Character NPCCharacter = new NPC(new BasicCharacter());
		assertEquals("Basic Character.NPC.", NPCCharacter.getDescription());
	}

}
