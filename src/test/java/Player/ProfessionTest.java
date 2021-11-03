package Player;

import equipment.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static Player.Profession.KNIGHT_MAXHEALTH_INCREASE_PER_LEVEL;
import static org.junit.jupiter.api.Assertions.*;

class ProfessionTest {
    Profession knight;
    Profession archer;
    BasicCharacter basicCharacter;
    Weapon weapon;

    @BeforeEach
    void setUp() {
        knight = new Knight(new Player());
        archer = new Archer(new Player());
        basicCharacter = new Player();
        weapon = new Weapon();
    }

    @Test
    void getSetWeapon() {

        knight.setWeapon(weapon);
        assertEquals(weapon, knight.getWeapon());

        archer.setWeapon(weapon);
        assertEquals(weapon, archer.getWeapon());
    }


    @Test
    void getInitialMaxHealth() {
        knight = new Knight(new Player());
        archer = new Archer(new Player());

        assertEquals(Profession.KNIGHT_BASE_MAXHEALTH
                + KNIGHT_MAXHEALTH_INCREASE_PER_LEVEL
                , knight.getMaxHealth());
        assertEquals(Profession.ARCHER_BASE_MAXHEALTH
                + Profession.ARCHER_MAXHEALTH_INCREASE_PER_LEVEL
                , archer.getMaxHealth());
    }

    @Test
    void setLevel() {
        knight.setLevelAndOtherStats(100);
        assertEquals(100, knight.getLevel());

        archer.setLevelAndOtherStats(100);
        assertEquals(100, archer.getLevel());
    }

    @Test
    void setDamage() {
        knight.setDamage(100);
        assertEquals(100, knight.getDamage());

        archer.setDamage(100);
        assertEquals(100, archer.getDamage());
    }

    /**
     * should add Boundary values
     */
    @Test
    void knightUpdateHealingAbility() {

        knight.setLevelAndOtherStats(1);
        assertEquals(NoHealingAbility.class, knight.getHealingAbility().getClass());
        // good idea to test level 9 too
        knight.setLevelAndOtherStats(10);
        assertEquals(MiniHeal.class, knight.getHealingAbility().getClass());
        // good idea to test level 19 too
        knight.setLevelAndOtherStats(20);
        assertEquals(Heal.class, knight.getHealingAbility().getClass());
        // good idea to test level 29 too
        knight.setLevelAndOtherStats(30);
        assertEquals(GrandHeal.class, knight.getHealingAbility().getClass());

    }

    @Test
    void archerUpdateHealingAbility() {

        archer.setLevelAndOtherStats(1);
        assertEquals(NoHealingAbility.class, archer.getHealingAbility().getClass());
        archer.setLevelAndOtherStats(10);
        assertEquals(MiniHeal.class, archer.getHealingAbility().getClass());
        archer.setLevelAndOtherStats(20);
        assertEquals(Heal.class, archer.getHealingAbility().getClass());
        archer.setLevelAndOtherStats(30);
        assertEquals(GrandHeal.class, archer.getHealingAbility().getClass());
    }


    @Test
    void knightMaxHealthAtLevelOne(){
        knight.setLevel(1);
        knight.setMaxHealthWithRegardToLevel();
        assertEquals(330, knight.getMaxHealth());
    }

    @Test
    void knightMaxHealthAtLevelTwo(){
        knight.setLevel(2);
        knight.setMaxHealthWithRegardToLevel();
        assertEquals(360, knight.getMaxHealth());
    }


    @Test
    void archerMaxHealthAtLevelOne(){
        archer.setLevel(1);
        knight.setMaxHealthWithRegardToLevel();
        assertEquals(315, archer.getMaxHealth());
    }
    @Test
    void basicCharacterMaxHealthAtLevelOne(){
        basicCharacter.setLevel(1);
        knight.setMaxHealthWithRegardToLevel();
        assertEquals(305, basicCharacter.getMaxHealth());
    }


    @Test
    void archerMaxHealthAtLevelTwo(){
        archer.setLevel(2);
        archer.setMaxHealthWithRegardToLevel();
        assertEquals(330, archer.getMaxHealth());
    }
    @Test
    void basicCharacterMaxHealthAtLevelTwo(){
        basicCharacter.setLevel(2);
        basicCharacter.setMaxHealthWithRegardToLevel();
        assertEquals(310, basicCharacter.getMaxHealth());
    }



    @Test
    void setKnightLevelAndOtherStats() {
        knight.setLevelAndOtherStats(1);
        assertEquals(1, knight.getLevel(), "wrong level");
        assertEquals(NoHealingAbility.class, knight.getHealingAbility().getClass(), "wrong healing ability at lvl 1");
        assertEquals(330, knight.getMaxHealth());
    }
    @Test
    void setArcherLevelAndOtherStats() {
        archer.setLevelAndOtherStats(1);
        assertEquals(1, archer.getLevel(), "wrong level");
        assertEquals(NoHealingAbility.class, archer.getHealingAbility().getClass(), "wrong healing ability at lvl 1");
        assertEquals(315, archer.getMaxHealth());
    }
    @Test
    void setBasicCharacterLevelAndOtherStats() {
        basicCharacter.setLevelAndOtherStats(1);
        assertEquals(1, basicCharacter.getLevel(), "wrong level");

        assertEquals(305, basicCharacter.getMaxHealth());
    }

}