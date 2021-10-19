package Player;

import equipment.Weapon;

/**
 *
 */
public class Knight extends Profession {



    public Knight(Character ch) {
        super(ch);
        character.setHealth(character.getHealth());
        character.setDamage(INITIAL_KNIGHT_DAMAGE);
    }

    @Override
    public void setLevel(int level) {
        character.setLevel(level);
        setHealthWithRegardsToLevel();
    }

    private void setHealthWithRegardsToLevel() {
        character.setHealth(300 + character.getLevel() * 30);
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
    public void setWeapon(Weapon weapon) {
        character.setWeapon(weapon);
    }




}
