package Player;

import equipment.Weapon;

class Player extends BasicCharacter {

	public Player(int health) {
		super(health);
	}

	public Player() {
	}

	@Override
	public String toString() {
		return "Player{}";
	}



	@Override
	public void setWeapon(String weaponName, Weapon.WeaponType weaponType) {
		this.weapon = new Weapon(weaponName, weaponType);
		this.damage += weapon.getWeaponDamage();
	}
}
