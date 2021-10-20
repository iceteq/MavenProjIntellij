package Player;

import equipment.Weapon;

public class Archer extends Profession {
    public Archer(Character ch) {
        super(ch);
        character.setDamage(character.getDamage() * 2);
    }

    @Override
    public void setLevel(int level) {

    }


    public int getMaxHealth(){
        return character.getMaxHealth();
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
    public void setMaxHealth(int newHealth) {
        character.setMaxHealth(newHealth);
    }

    @Override
    public void setWeapon(Weapon weapon) {
        character.setWeapon(weapon);
        character.setDamage(weapon.getWeaponDamage());

    }


}
