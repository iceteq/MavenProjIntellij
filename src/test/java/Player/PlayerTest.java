package Player;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	public void playerToStringTest() {
		Player player = new Player();
		assertEquals("Player{}", player.toString());
	}

	@Test
	public void playerGetHealthTest() {
		Character player = new Player(1);
		assertEquals(1, player.getHealth());
	}

	@Test
	public void playerChangeHealthTest() {
		Character player = new Player(1);
		player.setHealth(2);
		assertEquals(2, player.getHealth());
	}

}
