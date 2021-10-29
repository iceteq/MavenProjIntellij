package Player;

/**
 *
 */
public class Knight extends Profession {

    public Knight(Character ch) {
        super(ch);
        character.setMaxHealth(KNIGHT_BASE_MAXHEALTH + KNIGHT_MAXHEALTH_INCREASE_PER_LEVEL);
        character.setDamage(INITIAL_KNIGHT_DAMAGE);
        if (getLevel() >= MINIMUM_LEVEL_TO_HAVE_HEALING_ABILITY) {
            updateHealingAbility();
        }

    }

    /**
     * perhaps a bit vague as a method name.
     * it updates health and abilities,
     * since those two things depend on level.
     * Could be used everytime a character levels up.
     * @param level
     */
    @Override
    public void setLevelAndOtherStats(int level) {
        character.setLevel(level);
        setMaxHealthWithRegardToLevel();
        updateHealingAbility();

    }

    /**
     * since max health depends on level and profession,
     * we need to have a profession specific multiplier
     * KNIGHT_MAXHEALTH_INCREASE_PER_LEVEL
     *
     * and to multiply it with the level itself.
     *
     * this should always be summed with the initial health, otherwise
     * the healthpoint will just be equal to bonus health per level.
     */
    @Override
    public void setMaxHealthWithRegardToLevel() {
        character.setMaxHealth(KNIGHT_BASE_MAXHEALTH + (character.getLevel() * KNIGHT_MAXHEALTH_INCREASE_PER_LEVEL));
    }

}
