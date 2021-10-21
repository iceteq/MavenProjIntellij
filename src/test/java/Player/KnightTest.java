package Player;

import equipment.Weapon;
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
        assertEquals(330, knight.getMaxHealth());

        knight.setLevel(100);
        assertEquals(3300, knight.getMaxHealth());
    }


}