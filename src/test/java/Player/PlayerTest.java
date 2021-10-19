package Player;

import static org.junit.jupiter.api.Assertions.*;

import equipment.Weapon;
import org.junit.jupiter.api.Test;

class PlayerTest {


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

	@Test
	public void playerToStringTest() {
		Player player = new Player();
		assertEquals("Player{}", player.toString());
	}

	@Test
	public void playerDamageNoWeapon(){
		Player player = new Player();
		double expected = 100.0;
		assertEquals(expected, player.getDamage());
	}


	@Test
	public void playerDamageWithWeapon(){
		Player player = new Player();
		double playerBaseDamage = player.getDamage();
		Weapon weapon = new Weapon("x", Weapon.WeaponType.ONEHANDEDSWORD);
		player.setWeapon(weapon);
		double weaponDamage = weapon.getWeaponDamage();
		double expectedMinimum = playerBaseDamage + 81; 
		double expectedMaximum = playerBaseDamage + 130;
		assertTrue(player.getDamage() >= expectedMinimum && player.getDamage() <= expectedMaximum, " expected a value between " + expectedMinimum + " and " + expectedMaximum + " but is " + player.getDamage());
	}

}
