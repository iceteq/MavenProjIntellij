package Player;

import equipment.Weapon;

public class Barbarian extends Profession {
    public Barbarian(Character ch) {
        super(ch);
        character.setDamage(character.getDamage() * 2);
    }

    @Override
    public void setLevel(int level) {

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

<<<<<<< Updated upstream:src/main/java/Player/Archer.java
=======

>>>>>>> Stashed changes:src/main/java/Player/Barbarian.java
}
