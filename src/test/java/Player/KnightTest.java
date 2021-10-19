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
    void knightInitialHealthTest() {
        assertEquals(1, knight.getHealth());
    }

    @Test
    void knightSetHealthTest() {
        knight.setHealth(999);
        assertEquals(999, knight.getHealth());
    }

    @Test
    void knightInitialDamageTest() {
        knight.getDamage();
    }

    @Test
    void knightHealthPerLevel() {
        knight.setLevel(1);
        assertEquals(330, knight.getHealth(), "knight should have 330 hp at level 1");

        knight.setLevel(50);
        assertEquals(1800, knight.getHealth(), "knight should have 1800 hp at level 50");

        knight.setLevel(99);
        assertEquals(3270, knight.getHealth(), "knight should have 3270 hp at level 99");
    }



}