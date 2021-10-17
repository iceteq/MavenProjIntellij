package Player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    @Test
    void knightInitialHealthTest() {

        Archer archer = new Archer(new Player(1));
        Knight knight = new Knight(new Player(1));

        double healthRatio = knight.getHealth() / archer.getHealth();

        assertEquals(2.0, healthRatio);
    }

    @Test
    void knightChangeHealthTest() {
        Knight kn = new Knight(new Player());
        kn.setHealth(2);
        assertEquals(2, kn.getHealth());
    }



}