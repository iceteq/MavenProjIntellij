package Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArcherTest {

    Archer archer;

    @BeforeEach
    void setUp() {
        archer = new Archer(new Player());
    }



}