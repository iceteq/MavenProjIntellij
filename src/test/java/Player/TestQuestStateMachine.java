package Player;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestQuestStateMachine {
	
	Character npc;
	Character player;
	Character playerKnight;
	QuestDatabase database;
	QuestingSimulator simulator;
	Quest mainQuest01;
	Quest mainQuest02;
	Quest mainQuest03;
	Quest mainQuest04;
	Quest mainQuest05;
	
	Quest knightQuest01;
	Quest knightQuest02;
	Quest knightQuest03;
	
	
	@BeforeEach
	public void beforeEach() {
		
		simulator = new QuestingSimulator();
		database = new QuestDatabase();
		
		mainQuest01 = database.getMainQuests().get(0);
		mainQuest02 = database.getMainQuests().get(1);
		mainQuest03 = database.getMainQuests().get(2);
		mainQuest04 = database.getMainQuests().get(3);
		mainQuest05 = database.getMainQuests().get(4);

		
		knightQuest01 = database.getKnightQuests().get(0);
		knightQuest02 = database.getKnightQuests().get(1);
		knightQuest03 = database.getKnightQuests().get(2);
		
		npc = new NPC();
		player = new Player();
		playerKnight = new Knight(new Player());
		
		
	}

	@Test
	public void testGetQuestLogForNPC() {
		
		assertNotNull(npc.getQuestLog());
		
	}
	
	
	@Test
	public void testGetNpcQuests() {
	
		assertTrue(npc.getQuestLog().getNPCQuests().isEmpty());
			
	}
	
	@Test
	public void playerAcceptFirstQuestFailsTwiceAndPasses() {
		
		ArrayList<ArrayList<Quest>> toCheck = new ArrayList<>();
		
		toCheck.addAll(simulator.runAcceptFirstQuestFailsTwiceAndPasses(npc, player, mainQuest01));
		
		
		//Completed
		assertTrue(toCheck.get(0).contains(mainQuest01));
		
		//Accepted
		assertTrue(toCheck.get(1).isEmpty());
		
		//NPC
		assertTrue(toCheck.get(2).contains(mainQuest01));
		
		
	}

	@Test
	public void playerFailsToGetCheckPointFailsBackToFirstMainQuest() {
		
		ArrayList<ArrayList<Quest>> toCheck = new ArrayList<>();
		
		toCheck.addAll(simulator.runGetToCheckPointFailAndFailBackToFirstMainQuest(
				npc, player, mainQuest01, mainQuest02, mainQuest03));
		
		
		//Completed
		assertTrue(toCheck.get(0).contains(mainQuest01));
	
		//Accepted
		assertTrue(toCheck.get(1).isEmpty());
		
		//NPC
		assertTrue(toCheck.get(2).contains(mainQuest01));
		assertTrue(toCheck.get(2).contains(mainQuest02));
		assertTrue(toCheck.get(2).contains(mainQuest03));
	
			
		
		
	}
	
	@Test
	public void playerKnightGetsToLastKnightQuestAndFailsBackToFirstKnightQuest() {
		
		ArrayList<ArrayList<Quest>> toCheck = new ArrayList<>();
		
		toCheck.addAll(simulator.runPlayerKnightCompletesMainAndKnightQuestLines(
				npc, playerKnight, mainQuest01, mainQuest02, mainQuest03, mainQuest04, mainQuest05, 
				knightQuest01, knightQuest02, knightQuest03));
		
		
		//Completed
		assertTrue(toCheck.get(0).contains(mainQuest01));
		assertTrue(toCheck.get(0).contains(mainQuest02));
		assertTrue(toCheck.get(0).contains(mainQuest03));
		assertTrue(toCheck.get(0).contains(mainQuest04));
		assertTrue(toCheck.get(0).contains(mainQuest05));
	
		//Accepted
		assertTrue(toCheck.get(1).isEmpty());
		
		//NPC
		assertTrue(toCheck.get(2).contains(mainQuest01));
		assertTrue(toCheck.get(2).contains(mainQuest02));
		assertTrue(toCheck.get(2).contains(mainQuest03));
		assertTrue(toCheck.get(2).contains(mainQuest04));
		assertTrue(toCheck.get(2).contains(mainQuest05));
		assertTrue(toCheck.get(2).contains(knightQuest01));
		assertTrue(toCheck.get(2).contains(knightQuest02));
		assertTrue(toCheck.get(2).contains(knightQuest03));
		
		}
	
}
