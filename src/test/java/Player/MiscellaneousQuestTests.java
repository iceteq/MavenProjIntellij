package Player;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Player.Quest.QuestType;

class MiscellaneousQuestTests {


	@Test
	public void test_Quest_getLevel() {
		
		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ALL);
		testObjects.add(10);
		Quest quest = new Quest("TestQuest", testObjects,  1000, 100, "TestQuest blablabla");
		
		assertEquals(10, quest.getLevel());
	}
	
	@Test
	public void test_Quest_getQuestType() {
		
		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ALL);
		testObjects.add(10);
		Quest quest = new Quest("TestQuest", testObjects,  1000, 100, "TestQuest blablabla");
		
		assertEquals(QuestType.ALL, quest.getQuestType());
	}
	
	@Test
	public void test_Quest_ToString_ShouldSucceed() {
		
		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ALL);
		testObjects.add(10);
		Quest quest = new Quest("TestQuest", testObjects,  1000, 100, "TestQuest blablabla");
		String expected = "Name: TestQuest\nClassType: ALL\nLevel: 10\nExperience: 1000\nCurrency: 100";
		
		assertEquals(expected, quest.toString());
	}
	
	
	@Test
	public void Should_ThrowException_When_CharacterIsNPC_And_ReceivesQuestLog() {
		
		Character npcKnight = new Knight(new NPC());
		
		assertThrows(IllegalArgumentException.class, () -> {
			
			npcKnight.setQuestLogForThisCharacter();
			
		});
	}
	
	@Test 
	public void test_setCompletedQuest_NotNull() {
		
		Character playerKnight = new Knight(new Player());
		playerKnight.setQuestLogForThisCharacter();
		
		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ALL);
		testObjects.add(10);
		
		Quest testQuest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla");
		
		playerKnight.addCompletedQuestForThisPlayer(testQuest);
		
		assertNotNull(playerKnight.getQuestLog().getCompletedQuests());
		
	}
	
	
	
	@Test
	public void test_QuestEquality() {
		
		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ARCHER);
		testObjects.add(10);
		
		Quest q1 = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla");
		Quest q2 = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla");
		
		assertEquals(q1, q2);
	}
	

}
