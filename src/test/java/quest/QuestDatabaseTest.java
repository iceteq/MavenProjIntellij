package quest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import quest.QuestDatabase;

class QuestDatabaseTest {

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
	public void searchMainQuest_ShouldThrowException_WhenQuestNotExists() {
		
		QuestDatabase database = new QuestDatabase();
		
		assertThrows(IllegalArgumentException.class, () -> {
			database.searchMainQuest("WrongName");
		});
		
	}

}
