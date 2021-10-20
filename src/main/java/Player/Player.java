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
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
		this.damage += weapon.getWeaponDamage();
	}

	@Override
	public void setLevel(int level) {
		this.level = level;
		setHealthWithRegardsToLevel();
	}

	private void setHealthWithRegardsToLevel() {
		this.maxHealth = 300 + this.getLevel() * 5;
	}

}
