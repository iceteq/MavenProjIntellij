package Player;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestQuestStateMachine {
	
	
	private ArrayList<Quest> mainQuests = new ArrayList<>();
	private ArrayList<Quest> knightQuests = new ArrayList<>();
	private ArrayList<Quest> archerQuests = new ArrayList<>();
	private ArrayList<Quest> mainAndKnightQuests = new ArrayList<>();
	private ArrayList<Quest> mainAndArcherQuests = new ArrayList<>();
	
	Character npc;
	Character player;
	Character playerKnight;
	Character playerArcher;
	
	QuestDatabase database;
	QuestingSimulator simulator;
	
	
	
	@BeforeEach
	public void beforeEach() {
		
		simulator = new QuestingSimulator();
		database = new QuestDatabase();
		
		npc = new NPC();
		player = new Player();
		playerKnight = new Knight(new Player());
		playerArcher = new Archer(new Player());
		
		mainQuests = new ArrayList<>(database.getMainQuests());
		knightQuests = new ArrayList<>(database.getKnightQuests());
		archerQuests = new ArrayList<>(database.getArcherQuests());
		
		mainAndKnightQuests.addAll(mainQuests);
		mainAndKnightQuests.addAll(knightQuests);
		
		mainAndArcherQuests.addAll(mainQuests);
		mainAndArcherQuests.addAll(archerQuests);
		
		
	}
	
	@Test
	public void testQuestingSimulator_WhenPlayer_ShouldSucceed() {
			
				simulator.startQuesting(player);
				assertTrue(player.getQuestLog().getCompletedQuests().containsAll(mainQuests));

	
	}
	
	
	@Test
	public void testQuestingSimulator_WhenPlayerKnight_ShouldSucceed() {

				simulator.startQuesting(playerKnight);
				assertTrue(playerKnight.getQuestLog().getCompletedQuests().containsAll(mainAndKnightQuests));

				
	}
	
	@Test
	public void testQuestingSimulator_WhenPlayerArcher_ShouldSucceed() {
		
				simulator.startQuesting(playerArcher);
				assertTrue(playerArcher.getQuestLog().getCompletedQuests().containsAll(mainAndArcherQuests));

		
	}


	
	
	
}
