package Player;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Player.Quest.QuestType;

class CharacterQuestTest {

	@Test
	public void removeFailedQuest_WhenNPC_ShouldThrowException() {
		
		Character npc = new NPC();
		
		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ALL);
		testObjects.add(10);
		
		Quest quest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);
		
		
		assertThrows(IllegalArgumentException.class, () -> {
			
			npc.removeAcceptedQuestIfFailed(quest);
			
		});
		
	}
	
	@Test
	public void setQuestFailed_WhenNPC_ShouldThrowException() {
		
		Character npc = new NPC();
		
		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ALL);
		testObjects.add(10);
		
		Quest quest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);

		assertThrows(IllegalArgumentException.class, () -> {

			npc.setQuestFailed(quest, true);

		});
	}
	
	@Test
	public void getNPCQuest_WhenPlayer_ShouldThrowException() {
		
		Character player = new Player();
		
		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ALL);
		testObjects.add(10);
		
		Quest quest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);
		
		assertThrows(IllegalArgumentException.class, () -> {

			player.getNPCQuest(quest);

		});
		
	}
	
	@Test
	public void getNPCQuest_WhenNPC_And_QuestNotFound_ShouldThrowException() {
		
		Character npc = new NPC();
		
		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ALL);
		testObjects.add(10);
		
		Quest quest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);
		
		assertThrows(IllegalArgumentException.class, () -> {

			npc.getNPCQuest(quest);

		});
		
	}
	
	@Test
	public void removeCompletedQuestFromPlayer_WhenNPC_ShouldThrowException() {
		
		Character npc = new NPC();
		
		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ALL);
		testObjects.add(10);
		
		Quest quest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);
		
		assertThrows(IllegalArgumentException.class, () -> {

			npc.removeCompletedQuest(quest);

		});
		
	}
	
	@Test
	public void removeCompletedQuestFromPlayer_WhenPlayerAndQuestNotInList_ShouldThrowException() {
		
		Character player = new Player();
		
		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ALL);
		testObjects.add(10);
		
		Quest quest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);
		
		assertThrows(IllegalArgumentException.class, () -> {

			player.removeCompletedQuest(quest);

		});
		
	}
	
	@Test
	public void removeCompletedQuestFromPlayer_WhenPlayerAndQuestInList_ShouldSucceed() {
		
		Character player = new Player();
		
		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ALL);
		testObjects.add(10);
		
		Quest quest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);
		
		player.completeQuest(quest);
		player.removeCompletedQuest(quest);
		
		assertTrue(player.getQuestLog().getCompletedQuests().isEmpty());
		
	}
	
	

}
