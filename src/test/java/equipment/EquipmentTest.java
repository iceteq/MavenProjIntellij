package equipment;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import equipment.Armor.ArmorPiece;
import equipment.Armor.ArmorType;
import equipment.Weapon.WeaponType;

class EquipmentTest {

	@Test
	public void WeaponConstructor_ValidParameters_ShouldSucceed() {
		Weapon newWeapon = new Weapon(WeaponType.ONEHANDEDAXE, "NewWeapon");
		assertEquals("NewWeapon", newWeapon.getName());
		assertEquals(WeaponType.ONEHANDEDAXE, newWeapon.getWeaponType());
		
	}
	
	@Test
	public void ArmorConstructor_ValidParameters_ShouldSucceed() {
		Armor newArmor = new Armor("NewArmor", ArmorType.PLATE, ArmorPiece.CHEST);
		assertEquals("NewArmor", newArmor.getName());
		assertEquals(ArmorType.PLATE, newArmor.getType());
		assertEquals(ArmorPiece.CHEST, newArmor.getPiece());
		
	}
	
	@Test
	public void testInitializeWeaponDamage_IsWithinRange_ShouldSucceed() {
		Weapon newWeapon = new Weapon(WeaponType.ONEHANDEDSWORD, "NewWeapon");
		assertTrue(newWeapon.getWeaponDamage() >= 81 && newWeapon.getWeaponDamage() <= 130);
	}
	
	@Test
	public void testInitializeArmorValue_IsWithinRange_ShouldSucceed() {
	Armor newArmor = new Armor("NewArmor", ArmorType.LEATHER, ArmorPiece.GLOVES);
	assertTrue(newArmor.getArmorValue() >= 675 && newArmor.getArmorValue() <= 1075);
		
	}

	// boundary values for weapon damage
	@Test
	public void weaponAccaptableDamage() {
		Weapon newWeapon = new Weapon(WeaponType.ONEHANDEDSWORD, 0.0);
		assertEquals(81, newWeapon.getWeaponDamage());

		newWeapon = new Weapon(WeaponType.ONEHANDEDSWORD, 0.5);
		assertEquals(106, newWeapon.getWeaponDamage());

		newWeapon = new Weapon(WeaponType.ONEHANDEDSWORD, 1.0);
		assertEquals(131, newWeapon.getWeaponDamage());
	}

	@Test
	public void weaponDamageTooLow() {
		Weapon newWeapon = new Weapon(WeaponType.ONEHANDEDSWORD, 0.0);
		assertNotEquals(80, newWeapon.getWeaponDamage());
	}

	@Test
	public void weaponDamageTooHigh() {
		Weapon newWeapon = new Weapon(WeaponType.ONEHANDEDSWORD, 1.0);
		assertNotEquals(132, newWeapon.getWeaponDamage());
	}

		
}
