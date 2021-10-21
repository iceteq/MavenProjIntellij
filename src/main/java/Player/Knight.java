package Player;

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
    public void setLevelAndOtherStats(int level) {
        character.setLevelAndOtherStats(level);
        setMaxHealthWithRegardToLevel();
        updateHealingAbility();
    }




    @Override
    protected void setMaxHealthWithRegardToLevel() {
        character.setMaxHealth(KNIGHT_INITIAL_MAXHEALTH + (character.getLevel() * KNIGHT_MAXHEALTH_INCREASE_PER_LEVEL));
    }

    @Override
    void updateHealingAbility() {

        int level = character.getLevel();

        if (level >= 30) {
            healingAbility = new GrandHeal();
            return;
        } else if (level >= 20) {
            healingAbility = new Heal();
            return;
        } else if (level >= 10) {
            healingAbility = new Meditate();
            return;
        } else if (level >= 0) {
            throw new IllegalArgumentException("can't set an ability for someone below level 10");
        }

    }


}
