package Player;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Player.Quest.QuestType;

class CharacterQuestTest {
	
	
	ArrayList<Object> testObjects;
	Character player;
	Character npc;
	Character playerKnight;
	
	@BeforeEach
	public void beforeEach() {
		
		testObjects = new ArrayList<>();
		player = new Player();
		npc = new NPC();
		playerKnight = new Knight(new Player());
		
	}

	@Test
	public void removeFailedQuest_WhenNPC_ShouldThrowException() {

		testObjects.add(QuestType.ALL);
		testObjects.add(10);

		Quest quest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);


		assertThrows(IllegalArgumentException.class, () -> {

			npc.removeAcceptedQuestIfFailed(quest);

		});

	}
	
	@Test
	public void test_removeAcceptedQuestIfFailed_ShouldSucceed() {
		
		testObjects.add(QuestType.ALL);
		testObjects.add(1);

		Quest quest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);
		
		player.acceptQuest(quest);
		player.setQuestFailed(quest, true);
		player.removeAcceptedQuestIfFailed(quest);
		
		assertTrue(player.getQuestLog().getAcceptedQuests().isEmpty());

		
	}


	@Test
	public void setQuestFailed_WhenNPC_ShouldThrowException() {

		testObjects.add(QuestType.ALL);
		testObjects.add(10);

		Quest quest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);

		assertThrows(IllegalArgumentException.class, () -> {

			npc.setQuestFailed(quest, true);

		});
	}

	@Test
	public void getNPCQuest_WhenPlayer_ShouldThrowException() {

		testObjects.add(QuestType.ALL);
		testObjects.add(10);

		Quest quest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);

		assertThrows(IllegalArgumentException.class, () -> {

			player.getNPCQuest(quest);

		});

	}

	@Test
	public void getNPCQuest_WhenNPC_And_QuestNotFound_ShouldThrowException() {
		
		testObjects.add(QuestType.ALL);
		testObjects.add(10);

		Quest quest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);

		assertThrows(IllegalArgumentException.class, () -> {

			npc.getNPCQuest(quest);

		});

	}

	@Test
	public void removeCompletedQuestFromPlayer_WhenNPC_ShouldThrowException() {
		
		testObjects.add(QuestType.ALL);
		testObjects.add(10);

		Quest quest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);

		assertThrows(IllegalArgumentException.class, () -> {

			npc.removeCompletedQuest(quest);

		});

	}

	@Test
	public void removeCompletedQuestFromPlayer_WhenPlayerAndQuestNotInList_ShouldThrowException() {
		
		testObjects.add(QuestType.ALL);
		testObjects.add(10);

		Quest quest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);

		assertThrows(IllegalArgumentException.class, () -> {

			player.removeCompletedQuest(quest);

		});

	}

	@Test
	public void removeCompletedQuestFromPlayer_WhenPlayerAndQuestInList_ShouldSucceed() {

		testObjects.add(QuestType.ALL);
		testObjects.add(10);

		Quest quest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);

		player.completeQuest(quest);
		player.removeCompletedQuest(quest);

		assertTrue(player.getQuestLog().getCompletedQuests().isEmpty());

	}

	@Test
	public void test_getQuestFailed_WhenPlayer_ShouldSucceed() {

		testObjects.add(QuestType.ALL);
		testObjects.add(1);

		Quest quest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);

		player.acceptQuest(quest);
		player.setQuestFailed(quest, true);

		assertTrue(player.getQuestFailed(quest));
	}


	@Test 
	public void test_setCompletedQuest_NotNull() {


		testObjects.add(QuestType.ALL);
		testObjects.add(10);

		Quest quest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);

		playerKnight.completeQuest(quest);

		assertNotNull(playerKnight.getQuestLog().getCompletedQuests());

	}
	
	@Test
	public void test_addQuestToNPC_ShouldSucceed() {
		
		testObjects.add(QuestType.ALL);
		testObjects.add(10);

		Quest quest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);
		
		npc.addQuestToNPC(quest);
		
		assertEquals(quest, npc.getNPCQuest(quest));	
		
	}
	
	

}
