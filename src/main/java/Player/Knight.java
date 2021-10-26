package Player;

/**
 *
 */
public class Knight extends Profession {

    public Knight(Character ch) {
        super(ch);
        character.setMaxHealth(character.getMaxHealth());
        character.setDamage(INITIAL_KNIGHT_DAMAGE);
        if (getLevel() >= MINIMUM_LEVEL_TO_HAVE_HEALING_ABILITY) {
            updateHealingAbility();
        }

    }

    @Override
    public void setLevelAndOtherStats(int level) {
        character.setLevel(level);
        setMaxHealthWithRegardToLevel();
        updateHealingAbility();

    }

    @Override
    public void setMaxHealthWithRegardToLevel() {
        character.setMaxHealth(KNIGHT_INITIAL_MAXHEALTH + (character.getLevel() * KNIGHT_MAXHEALTH_INCREASE_PER_LEVEL));
    }

}
