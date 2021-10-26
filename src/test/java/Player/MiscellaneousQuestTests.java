package Player;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Player.Quest.QuestType;

class MiscellaneousQuestTests {
	
	ArrayList<Object> testObjects;
	
	@BeforeEach
	public void beforeEach() {
		testObjects = new ArrayList<>();
	}
	
	@Test
	public void test_Quest_getLevel() {
		
		 
		testObjects.add(QuestType.ALL);
		testObjects.add(10);
		Quest quest = new Quest("TestQuest", testObjects,  1000, 100, "TestQuest blablabla", false);
		
		assertEquals(10, quest.getLevel());
	}
	 
	@Test
	public void test_Quest_getQuestType() {
		
		
		testObjects.add(QuestType.ALL);
		testObjects.add(10);
		Quest quest = new Quest("TestQuest", testObjects,  1000, 100, "TestQuest blablabla", false);
		
		assertEquals(QuestType.ALL, quest.getQuestType());
	}
	
	@Test
	public void test_Quest_ToString_ShouldSucceed() {
		
		
		testObjects.add(QuestType.ALL);
		testObjects.add(10);
		Quest quest = new Quest("TestQuest", testObjects,  1000, 100, "TestQuest blablabla", false);
		String expected = "Name: TestQuest\nClassType: ALL\nLevel: 10\nExperience: 1000\nCurrency: 100";
		
		assertEquals(expected, quest.toString());
	}
	
	
	@Test
	public void test_QuestEquality() {
		
		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ARCHER);
		testObjects.add(10);
		
		Quest q1 = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);
		Quest q2 = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);
		
		assertEquals(q1, q2);
	}
	
	@Test	
	public void test_QuestEquality_WhenComparedWithNull() {
		
		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ARCHER);
		testObjects.add(10);
		
		Quest q1 = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);
		Quest q2 = null;
		
		assertNotEquals(q1, q2);
	}
	
	@Test	
	public void test_QuestEquality_WhenComparedOtherClass() {
		
		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ARCHER);
		testObjects.add(10);
		
		Quest q1 = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);
		int q2 = 5;
		
		assertNotEquals(q1, q2);
	}
	
	@Test
	public void test_isQuestFailed_ShouldSucceed() {
		
		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ALL);
		testObjects.add(10);
		
		Quest q1 = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);
		
		q1.setQuestFailed(true);
		
		assertTrue(q1.isQuestFailed());
	}

}
