package Player;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

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

}
