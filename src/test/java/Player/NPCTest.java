package Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NPCTest {
    NPC npc;
    @BeforeEach
    void setUp() {
        npc = new NPC();
    }

    @Test
    void testToString() {
        assertEquals("NPC{}", npc.toString());
    }

    @Test
    void playerMaxHealthPerLevel() {
        npc.setLevelAndOtherStats(1);
        assertEquals(305, npc.getMaxHealth());

        npc.setLevelAndOtherStats(2);
        assertEquals(310, npc.getMaxHealth());
    }

    @Test
    void playerSetLevel() {
        npc.setLevel(1);
        assertEquals(1, npc.getLevel());
    }
}