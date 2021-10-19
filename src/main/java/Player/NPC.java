package Player;

import equipment.Weapon;

class NPC extends BasicCharacter {
    public NPC(int health) {
        super(health);
    }

    public NPC() {
    }

    @Override
    public String toString() {
        return "NPC{}";
    }

    @Override
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        this.damage += weapon.getWeaponDamage();
    }

}
