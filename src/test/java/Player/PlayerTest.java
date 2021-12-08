package Player;

import static Player.BasicCharacter.INITIAL_BASICCHARACTER_DAMAGE;
import static org.junit.jupiter.api.Assertions.*;

import equipment.Weapon;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;

class PlayerTest {

	BasicCharacter player;

	@BeforeEach
	void setUp() {
		player = new Player();
	}

	@Test
	public void playerSetHealthTest() {
		player.setMaxHealth(2);
		assertEquals(2, player.getMaxHealth());
	}

	@Test
	public void playerToStringTest() {
		assertEquals("Player{}", player.toString());
	}

	@Test
	public void playerDamageNoWeapon(){
		double expected = INITIAL_BASICCHARACTER_DAMAGE;
		assertEquals(expected, player.getDamage());
	}

	/* 211019
	Not sure if it's a good idea to expect any particular weapon damage here, since player class
	is not responsible for weapon damage at all. Maybe I should test whether damage has increased,
	instead of testing for exact damage?
	 */
	/*
	 Agreed. Weapon damage should be initialised upon creation in the equipment class 
	 and further modified by the characters own variable stats(eg. strength, agility, intelligence).
	 */
	@Test
	public void playerDamageWithWeapon(){
		Weapon weapon = new Weapon(Weapon.WeaponType.ONEHANDEDSWORD, 0.0);
		player.setWeapon(weapon);
		assertEquals(INITIAL_BASICCHARACTER_DAMAGE + weapon.getWeaponDamage(), player.getDamage());
	}

	@Test
	public void playerHasMoreDamageWithWeapon(){
		double priorDamage = player.getDamage();
		player.setWeapon(new Weapon(Weapon.WeaponType.ONEHANDEDSWORD, 0.0));
		assertTrue(player.getDamage() > priorDamage);
	}


	@Test
	void playerMaxHealthPerLevel() {
		player.setLevelAndOtherStats(1);
		assertEquals(305, player.getMaxHealth());

		player.setLevelAndOtherStats(2);
		assertEquals(310, player.getMaxHealth());
	}

	@Test
	void playerSetLevel() {
		player.setLevel(1);
		assertEquals(1, player.getLevel());
	}


	@Test
	void setName() {
		player.setName("Abe");
		assertEquals("Abe", player.getName());
	}
	@Test
	void setName2() {
		player.setName("Abbbe");
		assertEquals(null, player.getName());
	}
	@Test
	void setName3() {
		player.setName("Aaabe");
		assertEquals(null, player.getName());
	}
	@Test
	void setName4() {
		player.setName("abe");
		assertEquals(null, player.getName());
	}
	@Test
	void setName5() {
		player.setName("Aa");
		assertEquals(null, player.getName());
	}
	@Test
	void setName6() {
		player.setName("Bb");
		assertEquals(null, player.getName());
	}
	@Test
	void setName8() {
		player.setName("Abababababa");
		assertEquals(null, player.getName());
	}
	@Test
	void setName9() {
		player.setName("A");
		assertEquals(null, player.getName());
	}
	@Test
	void setName10() {
		assertThrows(NullPointerException.class, () -> {
			player.setName(null);
		});
	}
	@Test
	void setName11() {
		player.setName("");
		assertEquals(null, player.getName());
	}



}
