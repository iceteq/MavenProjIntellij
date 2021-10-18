package Player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    @Test
    void knightInitialHealthTest() {
        Knight knight = new Knight(new Player(1));
        assertEquals(2, knight.getHealth());
    }

    @Test
    void knightSetHealthTest() {
        Knight kn = new Knight(new Player());
        kn.setHealth(2);
        assertEquals(2, kn.getHealth());
    }

    @Test
    void knightInitialDamageTest() {

        // beslutstabell för damage som beror på vilket vapen spelaren har?

    }



}