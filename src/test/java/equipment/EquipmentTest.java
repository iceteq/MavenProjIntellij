package equipment;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import equipment.Armor.ArmorPiece;
import equipment.Armor.ArmorType;
import equipment.Weapon.WeaponType;

class EquipmentTest {

	@Test
	public void WeaponConstructor_ValidParameters_ShouldSucceed() {
		Weapon newWeapon = new Weapon("NewWeapon", WeaponType.ONEHANDEDAXE);
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
		Weapon newWeapon = new Weapon("NewWeapon", WeaponType.ONEHANDEDSWORD);
		assertTrue(newWeapon.getWeaponDamage() >= 81 && newWeapon.getWeaponDamage() <= 130);
	}
	
	@Test
	public void testInitializeArmorValue_IsWithinRange_ShouldSucceed() {
	Armor newArmor = new Armor("NewArmor", ArmorType.LEATHER, ArmorPiece.GLOVES);
	assertTrue(newArmor.getArmorValue() >= 675 && newArmor.getArmorValue() <= 1075);
		
	}
	
	
	

}
