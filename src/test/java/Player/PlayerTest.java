package Player;

import static org.junit.jupiter.api.Assertions.*;

import equipment.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {

	Character player;

	@BeforeEach
	void setUp() {
		player = new Player(1);
	}


	@Test
	public void playerSetHealthTest() {
		player.setHealth(2);
		assertEquals(2, player.getHealth());
	}

	@Test
	public void playerToStringTest() {
		assertEquals("Player{}", player.toString());
	}

	@Test
	public void playerDamageNoWeapon(){
		double expected = 100.0;
		assertEquals(expected, player.getDamage());
	}

	/* 211019
	Not sure if it's a good idea to expect any particular weapon damage here, since player class
	is not responsible for weapon damage at all. Maybe I should test whether damage has increased,
	instead of testing for exact damage?
	 */
	@Test
	public void playerDamageWithWeapon(){
		Weapon weapon = new Weapon(Weapon.WeaponType.ONEHANDEDSWORD, 0.0);
		player.setWeapon(weapon);
		double expected = 100 + 81;
		assertEquals(expected, player.getDamage());
	}

	@Test
	public void playerHasMoreDamageWithWeapon(){
		double priorDamage = player.getDamage();
		player.setWeapon(new Weapon(Weapon.WeaponType.ONEHANDEDSWORD, 0.0));
		assertTrue(player.getDamage() > priorDamage);
	}

}
