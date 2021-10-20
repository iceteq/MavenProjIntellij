package Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    Knight knight;

    @BeforeEach
    void setUp() {
        knight = new Knight(new Player(1));
    }

    @Test
    void knightInitialMaxHealthTest() {
        assertEquals(1, knight.getMaxHealth());
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
        assertEquals(330, knight.getMaxHealth());

        knight.setLevel(100);
        assertEquals(3300, knight.getMaxHealth());
    }



}