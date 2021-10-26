package Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArcherTest {

    Archer archer;

    @BeforeEach
    void setUp() {
        archer = new Archer(new Player());
        archer.setLevel(1);
    }

    @Test
    void setMaxHealthWithRegardsToLevel() {
        archer.setLevel(1);
        archer.setMaxHealthWithRegardToLevel();
        assertEquals(315, archer.getMaxHealth());

        archer.setLevel(100);
        archer.setMaxHealthWithRegardToLevel();
        assertEquals(1800, archer.getMaxHealth());
    }


}