package Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    Knight knight;

    @BeforeEach
    void setUp() {
        knight = new Knight(new Player());
    }

    @Test
    void knightInitialMaxHealthTest() {
        assertEquals(Profession.KNIGHT_INITIAL_MAXHEALTH, knight.getMaxHealth());
    }

    @Test
    void knightSetMaxHealthTest() {
        knight.setMaxHealth(999);
        assertEquals(999, knight.getMaxHealth());
    }

    @Test
    void knightInitialDamageTest() {
        knight.getDamage();
    }

    @Test
    void knightMaxHealthPerLevel() {
        knight.setLevel(1);
        knight.setMaxHealthWithRegardToLevel();
        assertEquals(330, knight.getMaxHealth());

        knight.setLevel(100);
        knight.setMaxHealthWithRegardToLevel();
        assertEquals(3300, knight.getMaxHealth());
    }


    @Test
    void setLevel() {
    }

    @Test
    void setMaxHealthWithRegardsToLevel() {
    }

    @Test
    void updateHealingAbility() {
        knight.setLevelAndOtherStats(10);
        assertEquals(Meditate.class, knight.getHealingAbility().getClass());
        knight.setLevelAndOtherStats(20);
        assertEquals(Heal.class, knight.getHealingAbility().getClass());
        knight.setLevelAndOtherStats(30);
        assertEquals(GrandHeal.class, knight.getHealingAbility().getClass());
    }

    @Test
    void cantMeditateYet() {
        assertThrows(IllegalArgumentException.class, () -> {
            knight.setLevelAndOtherStats(9);
        });
    }

    @Test
    void cantHealYet() {
        knight.setLevelAndOtherStats(19);
        assertNotEquals(Heal.class, knight.getHealingAbility().getClass());
    }

    @Test
    void cantGrandHealYet() {
        knight.setLevelAndOtherStats(29);
        assertNotEquals(GrandHeal.class, knight.getHealingAbility().getClass());
    }
}