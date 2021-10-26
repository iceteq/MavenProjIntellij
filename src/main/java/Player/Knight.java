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

    /**
     * perhaps a bit vague as a method name.
     * it updates health and abilities,
     * since those two things depend on level
     * @param level
     */
    @Override
    public void setLevelAndOtherStats(int level) {
        character.setLevel(level);
        setMaxHealthWithRegardToLevel();
        updateHealingAbility();

    }

    /**
     * basically, looks at the level of this character, and
     * multiplies that by some value. The product is the bonus
     * health that the character gets. Add that to be base health,
     * or "initial health" as it's called here.
     */
    @Override
    public void setMaxHealthWithRegardToLevel() {
        character.setMaxHealth(KNIGHT_INITIAL_MAXHEALTH + (character.getLevel() * KNIGHT_MAXHEALTH_INCREASE_PER_LEVEL));
    }

}
