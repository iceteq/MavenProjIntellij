package Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NPCTest {

    @Test
    void testToString() {
        NPC npc = new NPC();
        assertEquals("NPC{}", npc.toString());
    }
}