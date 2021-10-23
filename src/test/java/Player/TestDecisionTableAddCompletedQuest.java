package Player;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Player.Quest.QuestType;

class TestDecisionTableAddCompletedQuest {

	//addCompletedQuest() is called from within completeQuest().
	
		//Decison table for addCompletedQuest; R1.
		@Test
		public void addCompletedQuest_ShouldThrowException_When_CharacterIsNPC() {
			
			Character npc = new NPC();
			
			ArrayList<Object> testObjects = new ArrayList<>();
			testObjects.add(QuestType.ALL);
			testObjects.add(10);
			
			Quest testQuest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);
			
			assertThrows(IllegalArgumentException.class, () -> {
				
				npc.completeQuest(testQuest);

			});		
			 
		}
		
		//Decison table for addCompletedQuest; R2.
		@Test
		public void addCompletedQuest_ShouldThrowException_When_QuestIsAlreadyInList() {
			
			Character player = new Player();

			ArrayList<Object> testObjects = new ArrayList<>();
			testObjects.add(QuestType.ALL);
			testObjects.add(10);
			
			Quest testQuest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);
			
			player.completeQuest(testQuest);
			
			assertThrows(IllegalArgumentException.class, () -> {

				player.completeQuest(testQuest);

			});	
			
		}
		
		//Decison table for addCompletedQuest; R3.
		@Test
		public void addCompletedQuest_ShouldSucceed_When_CharacterIsPlayer_QuestIsNotInList_QuestTypeIsAll() {
			
			Character player = new Player();
			
			
			ArrayList<Object> testObjects = new ArrayList<>();
			testObjects.add(QuestType.ALL);
			testObjects.add(10);
			
			Quest testQuest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla",false);
			
			player.completeQuest(testQuest);
			
			assertEquals(testQuest, player.getQuestLog().getCompletedQuests().get(0));
			
		}
		
		
		//Decison table for addCompletedQuest; R4.
		@Test
		public void addCompletedQuest_ShouldThrowException_When_CharacterIsPlayer_QuestTypeIsKnight() {

			Character player = new Player();

			ArrayList<Object> testObjects = new ArrayList<>();
			testObjects.add(QuestType.KNIGHT);
			testObjects.add(10);

			Quest testQuest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla",false);

			assertThrows(IllegalArgumentException.class, () -> {
				
				player.completeQuest(testQuest);
				
			});
		}
		
		//Decison table for addCompletedQuest; R5.
		@Test
		public void addCompletedQuest_ShouldThrowException_When_CharacterIsPlayer_QuestTypeIsArcher() {

			Character player = new Player();


			ArrayList<Object> testObjects = new ArrayList<>();
			testObjects.add(QuestType.ARCHER);
			testObjects.add(10);

			Quest testQuest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);


			assertThrows(IllegalArgumentException.class, () -> {

				player.completeQuest(testQuest);

			});

		}
		
		//Decison table for addCompletedQuest; R6.
		@Test
		public void addCompletedQuest_ShouldSucceed_When_CharacterTypeIsKnight_QuestTypeIsAll() {

			Character playerKnight = new Knight(new Player());

			ArrayList<Object> testObjectsKnight = new ArrayList<>();
			testObjectsKnight.add(QuestType.ALL);
			testObjectsKnight.add(10);

			Quest testQuest = new Quest("TestQuest", testObjectsKnight, 1000, 10, "TestQuest  blablabla", false);
			playerKnight.completeQuest(testQuest);

			assertEquals(testQuest, playerKnight.getQuestLog().getCompletedQuests().get(0));

		}
		
		//Decison table for addCompletedQuest; R7.
		@Test
		public void addCompletedQuest_ShouldSucceed_When_CharacterTypeIsKnight_QuestTypeIsKnight() {

			Character playerKnight = new Knight(new Player());

			ArrayList<Object> testObjects = new ArrayList<>();
			testObjects.add(QuestType.KNIGHT);
			testObjects.add(10);

			Quest testQuest = new Quest("TestQuest", testObjects, 1000, 10, "TestQuest  blablabla", false);
			
			playerKnight.completeQuest(testQuest);

			assertEquals(testQuest, playerKnight.getQuestLog().getCompletedQuests().get(0));
		}
		
		
		//Decison table for addCompletedQuest; R8.
		@Test
		public void addCompletedQuest_ShouldThrowException_When_CharacterTypeIsKnight_QuestTypeIsArcher() {

			Character playerKnight = new Knight(new Player());

			ArrayList<Object> testObjectsArcher = new ArrayList<>();
			testObjectsArcher.add(QuestType.ARCHER);
			testObjectsArcher.add(10);

			Quest testQuest = new Quest("TestQuest", testObjectsArcher, 1000, 10, "TestQuest  blablabla", false);
			

			assertThrows(IllegalArgumentException.class, () -> {
				
				playerKnight.completeQuest(testQuest);
				
			});
		}

		
		//Decison table for addCompletedQuest; R9.
		@Test
		public void addCompletedQuest_ShouldSuceed_When_CharacterTypeIsArcher_QuestTypeIsAll() {

			Character playerArcher = new Archer(new Player());

			ArrayList<Object> testObjectsArcher = new ArrayList<>();
			testObjectsArcher.add(QuestType.ARCHER);
			testObjectsArcher.add(10);

			Quest testQuest = new Quest("TestQuest", testObjectsArcher, 1000, 10, "TestQuest  blablabla", false);
			
			playerArcher.completeQuest(testQuest);
			
			assertEquals(testQuest, playerArcher.getQuestLog().getCompletedQuests().get(0));
					
		}
		
		//Decison table for addCompletedQuest; R10.
		@Test
		public void addCompletedQuest_ShouldThrowException_When_CharacterTypeIsKnight_QuestTypeIsArcher_() {

			Character playerKnight = new Knight(new Player());

			ArrayList<Object> testObjectsArcher = new ArrayList<>();
			testObjectsArcher.add(QuestType.ARCHER);
			testObjectsArcher.add(10);

			Quest testQuest = new Quest("TestQuest", testObjectsArcher, 1000, 10, "TestQuest  blablabla", false);

			assertThrows(IllegalArgumentException.class, () -> {

				playerKnight.completeQuest(testQuest);

			});
			
		}

		//Decison table for addCompletedQuest; R11.
		@Test
		public void addCompletedQuest_ShouldSucceed_When_CharacterTypeIsArcher_QuestTypeIsArcher() {

			Character playerArcher = new Archer(new Player());

			ArrayList<Object> testObjectsArcher = new ArrayList<>();
			testObjectsArcher.add(QuestType.ARCHER);
			testObjectsArcher.add(10);

			Quest testQuest = new Quest("TestQuest", testObjectsArcher, 1000, 10, "TestQuest  blablabla", false);

			playerArcher.completeQuest(testQuest);
			
			assertEquals(testQuest, playerArcher.getQuestLog().getCompletedQuests().get(0));

		}

		
	

}
