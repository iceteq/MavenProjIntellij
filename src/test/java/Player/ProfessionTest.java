package Player;

import equipment.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfessionTest {
    Profession knight;
    Profession archer;
    Weapon weapon;

    @BeforeEach
    void setUp() {
        knight = new Knight(new Player());
        archer = new Archer(new Player());
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

        assertEquals(Profession.KNIGHT_INITIAL_MAXHEALTH, knight.getMaxHealth());
        assertEquals(Profession.ARCHER_INITIAL_MAXHEALTH, archer.getMaxHealth());
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

    @Test
    void updateHealingAbility() {

        knight.setLevelAndOtherStats(10);
        assertEquals(Meditate.class, knight.getHealingAbility().getClass());
        knight.setLevelAndOtherStats(20);
        assertEquals(Heal.class, knight.getHealingAbility().getClass());
        knight.setLevelAndOtherStats(30);
        assertEquals(GrandHeal.class, knight.getHealingAbility().getClass());

        archer.setLevelAndOtherStats(10);
        assertEquals(Meditate.class, archer.getHealingAbility().getClass());
        archer.setLevelAndOtherStats(20);
        assertEquals(Heal.class, archer.getHealingAbility().getClass());
        archer.setLevelAndOtherStats(30);
        assertEquals(GrandHeal.class, archer.getHealingAbility().getClass());
    }

}