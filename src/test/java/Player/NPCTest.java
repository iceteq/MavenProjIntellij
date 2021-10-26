package Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NPCTest {
    NPC npc;


    @Test
    void testToString() {
        assertEquals("NPC{}", npc.toString());
    }


}