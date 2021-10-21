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
        setMaxHealthWithRegardsToLevel();
    }

    @Override
    protected void setMaxHealthWithRegardsToLevel() {
        character.setMaxHealth(KNIGHT_INITIAL_MAXHEALTH + (character.getLevel() * KNIGHT_MAXHEALTH_INCREASE_PER_LEVEL));
    }








}
