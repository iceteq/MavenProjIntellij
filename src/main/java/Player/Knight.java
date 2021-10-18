package Player;

import equipment.Weapon;

/**
 *
 */
public class Knight extends Profession {

    public Knight(Character ch) {
        super(ch);
        character.setHealth(character.getHealth() * 2);
    }

    public int getHealth(){
        return character.getHealth();
    }
    public double getDamage(){
        return character.getDamage();
    }

    @Override
    public void setDamage(double newDamage) {
        
    }

    @Override
    public void setHealth(int newHealth) {
        character.setHealth(newHealth);
    }

    @Override
    public void setWeapon(String weaponName, Weapon.WeaponType weaponType) {
        character.setWeapon(weaponName, weaponType);
    }


}
