package Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static Player.Profession.*;
import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    Knight knight;

    @BeforeEach
    void setUp() {
        knight = new Knight(new Player());
    }

    @Test
    void knightInitialMaxHealthTest() {
        assertEquals(KNIGHT_BASE_MAXHEALTH + KNIGHT_MAXHEALTH_INCREASE_PER_LEVEL, knight.getMaxHealth());
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


}