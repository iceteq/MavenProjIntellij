package Player;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Player.Quest.QuestType;

class TestDecisonTableAddToAcceptedQuests {


	//Decision table R1a.
	@Test
	public void addToAcceptedQuests_ShouldSucceed_When_Player_And_MeetsRequirements() {

		Character player = new Player();

		player.setLevelAndOtherStats(10);


		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ALL);
		testObjects.add(10);

		Quest requirementQuest1 = new Quest("RequirementQuest1", testObjects, 100, 10, "RequirementQuest1 blablabla", false);
		Quest requirementQuest2 = new Quest("RequirementQuest2", testObjects, 100, 10, "RequirementQuest2 blablabla", false);
		Quest requirementQuest3 = new Quest("RequirementQuest3", testObjects, 100, 10, "RequirementQuest3 blablabla", false);

		player.completeQuest(requirementQuest1);
		player.completeQuest(requirementQuest2);
		player.completeQuest(requirementQuest3);

		ArrayList<Object> testObjects1 = new ArrayList<>();
		testObjects1.add(QuestType.ALL);
		testObjects1.add(10);
		testObjects1.add(requirementQuest1);
		testObjects1.add(requirementQuest2);
		testObjects1.add(requirementQuest3);

		Quest testQuest = new Quest("TestQuest", testObjects1, 1000, 10, "TestQuest  blablabla", false);

		player.acceptQuest(testQuest);


		assertEquals(testQuest, player.getQuestLog().getAcceptedQuests().get(0));


	}

	//Decision table R1a.
	@Test
	public void addToAcceptedQuests_ShouldSucceed_When_PlayerIsKnight_And_MeetsRequirements() {

		Character playerKnight = new Knight(new Player());

		playerKnight.setLevelAndOtherStats(10);


		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.KNIGHT);
		testObjects.add(10);

		Quest requirementQuest1 = new Quest("RequirementQuest1", testObjects, 100, 10, "RequirementQuest1 blablabla", false);
		Quest requirementQuest2 = new Quest("RequirementQuest2", testObjects, 100, 10, "RequirementQuest2 blablabla", false);
		Quest requirementQuest3 = new Quest("RequirementQuest3", testObjects, 100, 10, "RequirementQuest3 blablabla", false);

		playerKnight.completeQuest(requirementQuest1);
		playerKnight.completeQuest(requirementQuest2);
		playerKnight.completeQuest(requirementQuest3);

		ArrayList<Object> testObjects1 = new ArrayList<>();
		testObjects1.add(QuestType.KNIGHT);
		testObjects1.add(10);
		testObjects1.add(requirementQuest1);
		testObjects1.add(requirementQuest2);
		testObjects1.add(requirementQuest3);

		Quest testQuest = new Quest("TestQuest", testObjects1, 1000, 10, "TestQuest  blablabla", false);

		playerKnight.acceptQuest(testQuest);


		assertEquals(testQuest, playerKnight.getQuestLog().getAcceptedQuests().get(0));


	}

	//Decision table R1b.
	@Test
	public void addToAcceptedQuests_ShouldSucceed_When_PlayerIsArcher_And_MeetsRequirements() {

		Character playerArcher = new Archer(new Player());

		playerArcher.setLevelAndOtherStats(10);


		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ARCHER);
		testObjects.add(10);

		Quest requirementQuest1 = new Quest("RequirementQuest1", testObjects, 100, 10, "RequirementQuest1 blablabla", false);
		Quest requirementQuest2 = new Quest("RequirementQuest2", testObjects, 100, 10, "RequirementQuest2 blablabla", false);
		Quest requirementQuest3 = new Quest("RequirementQuest3", testObjects, 100, 10, "RequirementQuest3 blablabla", false);

		playerArcher.completeQuest(requirementQuest1);
		playerArcher.completeQuest(requirementQuest2);
		playerArcher.completeQuest(requirementQuest3);

		ArrayList<Object> testObjects1 = new ArrayList<>();
		testObjects1.add(QuestType.ARCHER);
		testObjects1.add(10);
		testObjects1.add(requirementQuest1);
		testObjects1.add(requirementQuest2);
		testObjects1.add(requirementQuest3);

		Quest testQuest = new Quest("TestQuest", testObjects1, 1000, 10, "TestQuest  blablabla", false);

		playerArcher.acceptQuest(testQuest);


		assertEquals(testQuest, playerArcher.getQuestLog().getAcceptedQuests().get(0));


	}

	//Decision table R2.
	@Test
	public void addToAcceptedQuests_ShouldThrowException_When_PlayerDoesntMeetLevelRequirements() {

		Character playerKnight = new Knight(new Player());

		playerKnight.setLevelAndOtherStats(15);


		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ALL);
		testObjects.add(20);

		Quest requirementQuest1 = new Quest("RequirementQuest1", testObjects, 100, 10, "RequirementQuest1 blablabla", false);
		Quest requirementQuest2 = new Quest("RequirementQuest2", testObjects, 100, 10, "RequirementQuest2 blablabla", false);
		Quest requirementQuest3 = new Quest("RequirementQuest3", testObjects, 100, 10, "RequirementQuest3 blablabla", false);

		playerKnight.completeQuest(requirementQuest1);
		playerKnight.completeQuest(requirementQuest2);
		playerKnight.completeQuest(requirementQuest3);

		ArrayList<Object> testObjects1 = new ArrayList<>();
		testObjects1.add(QuestType.ALL);
		testObjects1.add(20);
		testObjects1.add(requirementQuest1);
		testObjects1.add(requirementQuest2);
		testObjects1.add(requirementQuest3);

		Quest testQuest = new Quest("TestQuest", testObjects1, 1000, 10, "TestQuest  blablabla", false);



		assertThrows(IllegalStateException.class, () -> {
			playerKnight.acceptQuest(testQuest);
		});

	}

	//Decision table addToAcceptedQuests; R5.
	@Test
	public void addToAcceptedQuests_ShouldThrowException_When_PlayerDoesntMeetQuestRequirements() {

		Character playerKnight = new Knight(new Player());

		playerKnight.setLevelAndOtherStats(10);


		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ALL);
		testObjects.add(10);

		Quest requirementQuest1 = new Quest("RequirementQuest1", testObjects, 100, 10, "RequirementQuest1 blablabla", false);
		Quest requirementQuest2 = new Quest("RequirementQuest2", testObjects, 100, 10, "RequirementQuest2 blablabla", false);
		Quest requirementQuest3 = new Quest("RequirementQuest3", testObjects, 100, 10, "RequirementQuest3 blablabla", false);

		playerKnight.completeQuest(requirementQuest1);
		playerKnight.completeQuest(requirementQuest2);


		ArrayList<Object> testObjects1 = new ArrayList<>();
		testObjects1.add(QuestType.ALL);
		testObjects1.add(10);
		testObjects1.add(requirementQuest1);
		testObjects1.add(requirementQuest2);
		testObjects1.add(requirementQuest3);

		Quest testQuest = new Quest("TestQuest", testObjects1, 1000, 10, "TestQuest  blablabla", false);



		assertThrows(IllegalStateException.class, () -> {
			playerKnight.acceptQuest(testQuest);
		});

	}

	//Decision table addToAcceptedQuests; R6.
	@Test
	public void addToAcceptedQuests_ShouldThrowException_When_PlayerDoesntMeetLevelAndQuestRequirements() {

		Character playerKnight = new Knight(new Player());

		playerKnight.setLevelAndOtherStats(15);


		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(QuestType.ALL);
		testObjects.add(20);

		Quest requirementQuest1 = new Quest("RequirementQuest1", testObjects, 100, 10, "RequirementQuest1 blablabla", false);
		Quest requirementQuest2 = new Quest("RequirementQuest2", testObjects, 100, 10, "RequirementQuest2 blablabla", false);
		Quest requirementQuest3 = new Quest("RequirementQuest3", testObjects, 100, 10, "RequirementQuest3 blablabla", false);

		playerKnight.completeQuest(requirementQuest1);
		playerKnight.completeQuest(requirementQuest2);


		ArrayList<Object> testObjects1 = new ArrayList<>();
		testObjects1.add(QuestType.ALL);
		testObjects1.add(50);
		testObjects1.add(requirementQuest1);
		testObjects1.add(requirementQuest2);
		testObjects1.add(requirementQuest3);

		Quest testQuest = new Quest("TestQuest", testObjects1, 1000, 10, "TestQuest  blablabla", false);



		assertThrows(IllegalStateException.class, () -> {
			playerKnight.acceptQuest(testQuest);
		});

	}
	//Decision table addToAcceptedQuests; R3,R4,R7,R8. When class/quest type missmatch, throw assertion from addCompletedQuest().
	//Tested in Junit class TestDecisionTableAddCompletedQuests.


}
