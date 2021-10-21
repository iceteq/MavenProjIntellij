package Player;

import equipment.Weapon;

public class Archer extends Profession {
    public Archer(Character ch) {
        super(ch);

    }

    @Override
    protected void setMaxHealthWithRegardsToLevel() {
        character.setMaxHealth(ARCHER_INITIAL_MAXHEALTH + (character.getLevel() * ARCHER_MAXHEALTH_INCREASE_PER_LEVEL));
    }


}
