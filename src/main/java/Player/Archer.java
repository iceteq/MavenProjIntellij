package Player;

/**
 *
 */
public class Archer extends Profession {


    public Archer(Character ch) {
        super(ch);
        character.setMaxHealth(ARCHER_BASE_MAXHEALTH + ARCHER_MAXHEALTH_INCREASE_PER_LEVEL);
        character.setDamage(INITIAL_KNIGHT_DAMAGE);
        updateHealingAbility();
    }

    @Override
    public void setLevelAndOtherStats(int level) {
        character.setLevel(level);
        setMaxHealthWithRegardToLevel();
        updateHealingAbility();
    }



    @Override
    public void setMaxHealthWithRegardToLevel() {
        character.setMaxHealth(ARCHER_BASE_MAXHEALTH + (character.getLevel() * ARCHER_MAXHEALTH_INCREASE_PER_LEVEL));

    }
}