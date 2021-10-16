package Player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NPCTest {

    @Test
    public void NPCtoStringTest() {
        NPC npc = new NPC();
        assertEquals("NPC{}", npc.toString());
    }
}