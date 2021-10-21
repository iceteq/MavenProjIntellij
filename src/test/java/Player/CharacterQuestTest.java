package Player;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Player.Quest.QuestType;

class CharacterQuestTest {
	
	

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
	
	
	
}
