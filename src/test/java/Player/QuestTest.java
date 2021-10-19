package Player;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Player.Quest.QuestType;

class QuestTest {
	
	@Test
	public void QuestConstructor_ValidParameters_ShouldSucceed() {
		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ALL);
		testObjects.add(10);
		Quest quest = new Quest("TestQuest", testObjects,  1000, 100, "TestQuest blablabla");
		assertEquals("TestQuest", quest.getName());
		assertEquals(1000, quest.getExperience());
		assertEquals(100, quest.getCurrency());
		assertEquals("TestQuest blablabla", quest.getQuestDescription());
		
	}
	
	@Test
	public void Should_ThrowException_When_ListIsEmpty() {
		ArrayList<Object> testObjects = new ArrayList<>();
		assertThrows(IllegalStateException.class, () -> {
			new Quest("TestQuest", testObjects,  1000, 100, "TestQuest blablabla");
		});
		
	}
	
	@Test
	public void Should_ThrowException_When_InvalidObjectInList() {
		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(10.0);
		assertThrows(IllegalArgumentException.class, () -> {
			new Quest("TestQuest", testObjects,  1000, 100, "TestQuest blablabla");
		});
	}
	
	@Test
	public void Should_ThrowException_When_ListContainsMoreThanOneInteger() {
		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(10);
		testObjects.add(20);
		assertThrows(IllegalArgumentException.class, () -> {
			new Quest("TestQuest", testObjects,  1000, 100, "TestQuest blablabla");
		});
	}
	
	@Test
	public void Should_ThrowException_When_ListContainsZeroIntegers() {
		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ALL);
		assertThrows(IllegalArgumentException.class, () -> {
			new Quest("TestQuest", testObjects,  1000, 100, "TestQuest blablabla");
		});
	}
	
	@Test
	public void Should_ThrowException_When_ListContainsMoreThanOneQuestType() {
		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ALL);
		testObjects.add(QuestType.KNIGHT);
		assertThrows(IllegalArgumentException.class, () -> {
			new Quest("TestQuest", testObjects,  1000, 100, "TestQuest blablabla");
		});
	}
	
	@Test
	public void Should_ThrowException_When_ListContainsZeroQuestTypes() {
		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(10);
		assertThrows(IllegalArgumentException.class, () -> {
			new Quest("TestQuest", testObjects,  1000, 100, "TestQuest blablabla");
		});
	}
	
	
	
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
	public void testMainQuestsFromDatabaseNotNull() {
		QuestDatabase database = new QuestDatabase();
		assertNotNull(database.getMainQuests());
	}
	
	@Test
	public void testKnightQuestsFromDatabaseNotNull() {
		QuestDatabase database = new QuestDatabase();
		assertNotNull(database.getKnightQuests());
	}
	
	@Test
	public void testArcherQuestsFromDatabaseNotNull() {
		QuestDatabase database = new QuestDatabase();
		assertNotNull(database.getArcherQuests());
	}
	
	@Test void testPlayerGetsCorrectQuestLine() {
		Character player = new Player();
		player.setQuestLogForThisCharacter();
		
		for(Quest q: player.getQuestLog().getMainQuests()) {
			assertEquals(QuestType.ALL, q.getQuestType());
		}
		
		assertTrue(player.getQuestLog().getKnightQuests().isEmpty());
		assertTrue(player.getQuestLog().getArcherQuests().isEmpty());
	}
	
	@Test
	public void testKnightGetsCorrectQuestLines() {
		Character knight = new Knight(new Player());
		knight.setQuestLogForThisCharacter();
		
		for(Quest q: knight.getQuestLog().getMainQuests()) {
			assertEquals(QuestType.ALL, q.getQuestType());
		}
		
		for(Quest q: knight.getQuestLog().getKnightQuests()) {
			assertEquals(QuestType.KNIGHT, q.getQuestType());
		}
		
		assertTrue(knight.getQuestLog().getArcherQuests().isEmpty());
	}
	
	@Test
	public void testArcherGetsCorrectQuestLines() {
		Character archer = new Archer(new Player());
		archer.setQuestLogForThisCharacter();
		
		for(Quest q: archer.getQuestLog().getMainQuests()) {
			assertEquals(QuestType.ALL, q.getQuestType());
		}
		
		for(Quest q: archer.getQuestLog().getArcherQuests()) {
			assertEquals(QuestType.ARCHER, q.getQuestType());
		}
		
		assertTrue(archer.getQuestLog().getKnightQuests().isEmpty());
	}
	
	@Test
	public void Should_ThrowException_When_CharacterIsNPC_And_ReceivesQuestLog() {
		Character npcKnight = new Knight(new NPC());
		assertThrows(IllegalArgumentException.class, () -> {
			npcKnight.setQuestLogForThisCharacter();
		});
	}

}
