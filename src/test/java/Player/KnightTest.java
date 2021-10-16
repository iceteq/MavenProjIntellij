package Player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    @Test
    void knightHealthTest() {
        Knight kn = new Knight(new Player(1));
        assertEquals(1, kn.getHealth());
    }

    @Test
    void knightChangeHealthTest() {
        Knight kn = new Knight(new Player());
        kn.setHealth(2);
        assertEquals(2, kn.getHealth());
    }

}