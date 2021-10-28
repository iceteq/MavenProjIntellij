package Player;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Player.Archer;
import Player.Character;
import Player.Knight;
import Player.NPC;
import Player.Player;
import quest.Quest;
import quest.Quest.QuestType;

class CharacterQuestTest {
	
	
	ArrayList<Object> testObjects;
	Character player;
	Character playerKnight;
	Character playerArcher;
	Character npc;
	Character npcKnight;
	int level;
	
	@BeforeEach
	public void beforeEach() {
		
		testObjects = new ArrayList<>();
		player = new Player();
		playerKnight = new Knight(new Player());
		playerArcher = new Archer(new Player());
		npc = new NPC();
		npcKnight = new Knight(new NPC());
		level = 1;
		
		
	}


	@Test
	public void getQuestLog_WhenNPC() {

		assertNotNull(npcKnight.getQuestLog());
	}


	@Test
	public void getNPCQuest_WhenPlayer_ShouldThrowException() {

		testObjects.add(QuestType.ALL);
		testObjects.add(level);

		Quest quest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);

		assertThrows(IllegalArgumentException.class, () -> {

			player.getNPCQuest(quest);

		});

	}

	@Test
	public void getNPCQuest_WhenNPC_And_QuestNotFound_ShouldThrowException() {
		
		testObjects.add(QuestType.ALL);
		testObjects.add(level);

		Quest quest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);

		assertThrows(IllegalArgumentException.class, () -> {

			npc.getNPCQuest(quest);

		});

	}

	@Test
	public void removeCompletedQuestFromPlayer_WhenNPC_ShouldThrowException() {
		
		testObjects.add(QuestType.ALL);
		testObjects.add(level);

		Quest quest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);

		assertThrows(IllegalArgumentException.class, () -> {

			npc.removeCompletedQuest(quest);

		});

	}
	
	@Test
	public void removeCompletedQuestFromPlayer_WhenNPCAndProfession_ShouldThrowException() {
		
		testObjects.add(QuestType.ALL);
		testObjects.add(level);

		Quest quest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);

		assertThrows(IllegalArgumentException.class, () -> {

			npcKnight.removeCompletedQuest(quest);

		});

	}

	@Test
	public void removeCompletedQuestFromPlayer_WhenPlayerAndQuestNotInList_ShouldThrowException() {
		
		testObjects.add(QuestType.ALL);
		testObjects.add(level);

		Quest quest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);

		assertThrows(IllegalArgumentException.class, () -> {

			player.removeCompletedQuest(quest);

		});

	}

	@Test
	public void removeCompletedQuestFromPlayer_WhenPlayerAndQuestInList_ShouldSucceed() {

		testObjects.add(QuestType.ALL);
		testObjects.add(level);

		Quest quest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);

		player.completeQuest(quest);
		player.removeCompletedQuest(quest);

		assertTrue(player.getQuestLog().getCompletedQuests().isEmpty());

	}

	@Test 
	public void test_setCompletedQuest_NotNull() {


		testObjects.add(QuestType.ALL);
		testObjects.add(level);

		Quest quest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);

		playerKnight.completeQuest(quest);

		assertNotNull(playerKnight.getQuestLog().getCompletedQuests());

	}
	
	@Test
	public void test_addQuestToNPC_ShouldSucceed() {
		
		testObjects.add(QuestType.ALL);
		testObjects.add(level);

		Quest quest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);
		
		npc.addQuestToNPC(quest);
		npcKnight.addQuestToNPC(quest);
		
		
		assertEquals(quest, npc.getNPCQuest(quest));	
		assertEquals(quest, npcKnight.getNPCQuest(quest));
	}


}
