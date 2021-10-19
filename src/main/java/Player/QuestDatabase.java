package Player;

import java.util.ArrayList;

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
			this.mainQuests.add(new Quest("MainQuest" + String.valueOf(i), createTestObjects(QuestType.ALL), 100, 10, "MainQuest blablabla"));
	}
	
	private void createKnightQuests() {
		//Här kan man skriva egna quests istället(eller tillsammans) med dom autogenererade 
		for(int i = 0; i < 10; i++)
			this.knightQuests.add(new Quest("KnightQuest" + String.valueOf(i), createTestObjects(QuestType.KNIGHT), 100, 10, "KnightQuest blablabla"));
	}
	
	private void createArcherQuests() {
		//Här kan man skriva egna quests istället(eller tillsammans) med dom autogenererade 
		for(int i = 0; i < 10; i++)
			this.archerQuests.add(new Quest("ArcherQuest" + String.valueOf(i), createTestObjects(QuestType.ARCHER), 100, 10, "ArcherQuest blablabla"));
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
	
	private ArrayList<Object> createTestObjects(QuestType questType) {
		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(questType);
		testObjects.add(10);
		return testObjects;
	}
}
