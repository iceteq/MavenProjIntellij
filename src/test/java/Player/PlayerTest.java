package Player;

import static Player.BasicCharacter.INITIAL_BASICCHARACTER_DAMAGE;
import static org.junit.jupiter.api.Assertions.*;

import equipment.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


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


	/**
	 * Below are a set of tests for player names.
	 * Most of the tests comes in pairs:
	 * 1. Check that a wrongly formatted name can't be set.
	 * 2. Check that the regex pattern used above actually works.
	 *
	 * For example:
	 * Name should start with capital, so "abe" should fail.
	 * But there could hypothetically be something else in the
	 * "setName("abe")" call that made it fail. So I also test
	 * setName's helper method "matchesPattern" to make sure
	 * that it finds the pattern that I want.
	 */
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
	void nameHasTooManyConsonantsInARow() {
		player.setName("Abbbe");
		assertEquals(null, player.getName());
	}
	@Test
	void regexFoundTooManyConsonants(){
		assertTrue(player.matchesPattern(Player.THREE_CONSONANTS_IN_A_ROW, "Abbbe"));
	}

	@Test
	void nameHasTooManyVowelsInARow() {
		player.setName("Aaabe");
		assertEquals(null, player.getName());
	}
	@Test
	void regexFoundTooManyVowelsInARow(){
		assertTrue(player.matchesPattern(Player.THREE_VOWELS_IN_A_ROW, "Aaabe"));
	}

	@Test
	void nameDoesntBeginWithCapitalLetter() {
		player.setName("abe");
		assertEquals(null, player.getName());
	}

		@Test
		void regexFoundNameBeginningWithLowerCase(){
			assertTrue(player.matchesPattern(Player.FIRST_LETTER_LOWER_CASE, "abe"));
		}

	@Test
	void nameLacksConsonant() {
		player.setName("Aa");
		assertEquals(null, player.getName());
	}

	@Test
	void regexFoundNoConsonant(){
		assertFalse(player.matchesPattern(Player.AT_LEAST_ONE_CONSONANT, "Aa"));
	}

	@Test
	void nameLacksVowels() {
		player.setName("Bb");
		assertEquals(null, player.getName());
	}
	@Test
	void regexFoundNoVowel(){
		assertFalse(player.matchesPattern(Player.AT_LEAST_ONE_VOWEL, "Bb"));
	}


	@Test
	void tooLongName() {
		player.setName("Abababababa");
		assertEquals(null, player.getName());
	}
	@Test
	void tooShortName() {
		player.setName("A");
		assertEquals(null, player.getName());
	}
	@Test
	void nameInputIsNull() {
		assertThrows(NullPointerException.class, () -> {
			player.setName(null);
		});
	}
	@Test
	void nameInputIsEmpty() {
		player.setName("");
		assertEquals(null, player.getName());
	}



}
