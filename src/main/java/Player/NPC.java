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
    public void setWeapon(String weaponName, Weapon.WeaponType weaponType) {
        this.weapon = new Weapon(weaponName, weaponType);
    }
}
