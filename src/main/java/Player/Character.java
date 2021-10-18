package Player;

import equipment.Weapon;

public interface Character {

    int getHealth();
    double getDamage();
    void setDamage(double newDamage);
    void setHealth(int newHealth);
    void setWeapon(String weaponName, Weapon.WeaponType weaponType);

}
