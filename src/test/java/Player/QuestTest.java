package Player;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Player.Quest.QuestType;

class QuestTest {
	
	@Test
	public void QuestConstructor_ValidParameters_ShouldSucceed() {
		Quest quest = new Quest("TestQuest", QuestType.ALL);
		assertEquals("TestQuest", quest.getName());
		assertEquals(QuestType.ALL, quest.getClassType());
		
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
	
	@Test
	public void testKnightGetsCorrectQuestLines() {
		Character knight = new Knight(new Player());
		knight.setQuestLogForThisCharacter();
		assertEquals(QuestType.ALL, knight.getQuestLog().getMainQuests().get(0).getClassType());
		assertEquals(QuestType.KNIGHT, knight.getQuestLog().getKnightQuests().get(0).getClassType());
	}
	
	@Test
	public void testArcherGetsCorrectQuestLines() {
		Character archer = new Barbarian(new Player());
		archer.setQuestLogForThisCharacter();
		assertEquals(QuestType.ALL, archer.getQuestLog().getMainQuests().get(0).getClassType());
		assertEquals(QuestType.ARCHER, archer.getQuestLog().getArcherQuests().get(0).getClassType());
	}
	
	@Test
	public void Should_ThrowException_When_CharacterIsNPC_And_ReceivesQuestLog() {
		Character npcKnight = new Knight(new NPC());
		assertThrows(IllegalArgumentException.class, () -> {
			npcKnight.setQuestLogForThisCharacter();
		});
	}

}
