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
	
	@Test
	public void getHealth_InitializedHealth_ShouldSucceed() {
		Character playerCharacter = new Player(new BasicCharacter());
		assertEquals(100, playerCharacter.getHealth());
	}
	
	@Test
	public void changeHealth_NewHealth_ShouldSucceed() {
		Character playerCharacter = new Player(new BasicCharacter());
		playerCharacter.changeHealth(200);
		assertEquals(200, playerCharacter.getHealth());
	}

}
