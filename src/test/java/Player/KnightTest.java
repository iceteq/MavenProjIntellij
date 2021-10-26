package Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static Player.Profession.INITIAL_KNIGHT_DAMAGE;
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
        assertEquals(INITIAL_KNIGHT_DAMAGE, knight.getDamage());
    }

    @Test
    void setLevel() {
        knight.setLevel(3);
        assertEquals(3, knight.getLevel());
    }

    @Test
    void setMaxHealthWithRegardToLevel() {
        knight.setLevel(1);
        knight.setMaxHealthWithRegardToLevel();
        assertEquals(330, knight.getMaxHealth());

        knight.setLevel(100);
        knight.setMaxHealthWithRegardToLevel();
        assertEquals(3300, knight.getMaxHealth());
    }




}