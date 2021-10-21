package Player;

import java.util.ArrayList;
import java.util.Arrays;

import Player.Quest.QuestType;

public class QuestDatabase {
	
	private ArrayList<Quest> mainQuests = new ArrayList<>();
	private ArrayList<Quest> knightQuests  = new ArrayList<>(); 
	private ArrayList<Quest> archerQuests = new ArrayList<>();
	
	QuestDatabase() {
		createMainQuests();
		createKnightQuests();
		createArcherQuests();
	}
	
	private void createMainQuests() {
		//Här kan man skriva egna quests istället(eller tillsammans) med dom autogenererade 
		for(int i = 0; i < 10; i++)
			this.mainQuests.add(new Quest("MainQuest" + String.valueOf(i), createTestObjects(QuestType.ALL, 10), 100, 10, "MainQuest blablabla"));
		
		Quest requirementQuest1 = new Quest("RequirementQuest1", createTestObjects(QuestType.ALL, 10), 100, 10, "RequirementQuest1 blablabla");
		Quest requirementQuest2 = new Quest("RequirementQuest2", createTestObjects(QuestType.ALL, 10), 100, 10, "RequirementQuest2 blablabla");
		Quest requirementQuest3 = new Quest("RequirementQuest3", createTestObjects(QuestType.ALL, 10), 100, 10, "RequirementQuest3 blablabla");
		
		this.mainQuests.add(requirementQuest1);
		this.mainQuests.add(requirementQuest2);
		this.mainQuests.add(requirementQuest3);
		
		this.mainQuests.add(new Quest("TestQuest", createTestObjects(QuestType.ALL, 10, requirementQuest1, requirementQuest2, requirementQuest3), 100, 10, "TestQuest blablabla"));
		
		
	}
	
	private void createKnightQuests() {
		//Här kan man skriva egna quests istället(eller tillsammans) med dom autogenererade 
		for(int i = 0; i < 10; i++)
			this.knightQuests.add(new Quest("KnightQuest" + String.valueOf(i), createTestObjects(QuestType.KNIGHT, 10), 100, 10, "KnightQuest blablabla"));
	}
	
	private void createArcherQuests() {
		//Här kan man skriva egna quests istället(eller tillsammans) med dom autogenererade 
		for(int i = 0; i < 10; i++)
			this.archerQuests.add(new Quest("ArcherQuest" + String.valueOf(i), createTestObjects(QuestType.ARCHER, 10), 100, 10, "ArcherQuest blablabla"));
	}
	
	
	public ArrayList<Quest> getMainQuests() {
		return new ArrayList<>(mainQuests);
	}
	
	public ArrayList<Quest> getKnightQuests() {
		return new ArrayList<>(knightQuests);
	}
	
	public ArrayList<Quest> getArcherQuests() {
		return new ArrayList<>(archerQuests);
	}
	
	private ArrayList<Object> createTestObjects(QuestType questType, int level, Quest... requirementQuests) {
		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(questType);
		testObjects.add(level);
		testObjects.addAll(Arrays.asList(requirementQuests));
		return testObjects;
	}

}
