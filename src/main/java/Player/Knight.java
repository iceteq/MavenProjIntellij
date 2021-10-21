package Player;

import equipment.Weapon;

/**
 *
 */
public class Knight extends Profession {



    public Knight(Character ch) {
        super(ch);
        character.setMaxHealth(character.getMaxHealth());
        character.setDamage(INITIAL_KNIGHT_DAMAGE);
    }

    @Override
    public void setLevel(int level) {
        character.setLevel(level);
        setHealthWithRegardsToLevel();
    }

    private void setHealthWithRegardsToLevel() {
        character.setMaxHealth(300 + character.getLevel() * 30);
    }

    public int getMaxHealth(){
        return character.getMaxHealth();
    }
    public double getDamage(){
        return character.getDamage();
    }

    @Override
    public void setDamage(double newDamage) {
        
    }

    @Override
    public void setMaxHealth(int newHealth) {
        character.setMaxHealth(newHealth);
    }

    @Override
    public void setWeapon(Weapon weapon) {
        character.setWeapon(weapon);
    }




}
