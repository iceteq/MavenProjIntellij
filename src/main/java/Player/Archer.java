package Player;

import equipment.Weapon;

public class Archer extends Profession {
    public Archer(Character ch) {
        super(ch);
        character.setDamage(character.getDamage() * 2);
    }

    public int getHealth(){
        return character.getHealth();
    }

    @Override
    public double getDamage() {
        return character.getDamage();
    }

    @Override
    public void setDamage(double newDamage) {
        character.setDamage(newDamage);
    }

    @Override
    public void setHealth(int newHealth) {
        character.setHealth(newHealth);
    }

    @Override
    public void setWeapon(Weapon weapon) {
        character.setWeapon(weapon);
        character.setDamage(weapon.getWeaponDamage());

    }
}
