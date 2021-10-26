package quest;

import java.util.ArrayList;
import java.util.Arrays;

import quest.Quest.QuestType;

public class QuestDatabase {
	
	private ArrayList<Quest> mainQuests = new ArrayList<>();
	private ArrayList<Quest> knightQuests  = new ArrayList<>(); 
	private ArrayList<Quest> archerQuests = new ArrayList<>();
	
	public QuestDatabase() {
		createMainQuests();
		createKnightQuests();
		createArcherQuests();
	}
	
	private void createMainQuests() {
		//Här kan man skriva egna quests
		
		Quest mainQuest01 = new Quest("MainQuest01", createTestObjects(QuestType.ALL, 1), 100, 10, "Go do this and that noob", true);
		this.mainQuests.add(mainQuest01);
		Quest mainQuest02 = new Quest("MainQuest02", createTestObjects(QuestType.ALL, 1, mainQuest01), 500, 50, "Go do this and that noob", false);
		this.mainQuests.add(mainQuest02);
		Quest mainQuest03 = new Quest("MainQuest03", createTestObjects(QuestType.ALL, 1, mainQuest01, mainQuest02), 1000, 100, "Go do this and that noob", true);
		this.mainQuests.add(mainQuest03);
		Quest mainQuest04 = new Quest("MainQuest04", createTestObjects(QuestType.ALL, 1, mainQuest01, mainQuest02, mainQuest03), 2000, 200, "Go do this and that noob", true);
		this.mainQuests.add(mainQuest04);
		Quest mainQuest05 = new Quest("MainQuest05", createTestObjects(QuestType.ALL, 1, mainQuest01, mainQuest02, mainQuest03, mainQuest04), 5000, 500, "Go do this and that noob", false);
		this.mainQuests.add(mainQuest05);
		
		 
	}
	
	private void createKnightQuests() {
		//Här kan man skriva egna quests 

		Quest knightQuest01 = new Quest("KnightQuest01", createTestObjects(QuestType.KNIGHT, 1, searchMainQuest("MainQuest01"), searchMainQuest("MainQuest02"), searchMainQuest("MainQuest03")), 100, 10, "Go do this and that noob", false);
		this.knightQuests.add(knightQuest01);
		Quest knightQuest02 = new Quest("KnightQuest02", createTestObjects(QuestType.KNIGHT, 1, searchMainQuest("MainQuest01"), searchMainQuest("MainQuest02"), searchMainQuest("MainQuest03"), knightQuest01), 500, 50, "Go do this and that noob", false);
		this.knightQuests.add(knightQuest02);
		Quest knightQuest03 = new Quest("KnightQuest03", createTestObjects(QuestType.KNIGHT, 1, searchMainQuest("MainQuest01"), searchMainQuest("MainQuest02"), searchMainQuest("MainQuest03"), knightQuest01, knightQuest02), 1000, 100, "Go do this and that noob", false);
		this.knightQuests.add(knightQuest03);
	}
	
	private void createArcherQuests() {
		//Här kan man skriva egna quests
		
		Quest archerQuest01 = new Quest("ArcherQuest01", createTestObjects(QuestType.ARCHER, 1), 100, 10, "Go do this and that noob", false);
		this.archerQuests.add(archerQuest01);
		Quest archerQuest02 = new Quest("ArcherQuest02", createTestObjects(QuestType.ARCHER, 1, searchMainQuest("MainQuest01"), searchMainQuest("MainQuest02"), archerQuest01), 500, 50, "Go do this and that noob", false);
		this.archerQuests.add(archerQuest02);
		Quest archerQuest03 = new Quest("ArcherQuest03", createTestObjects(QuestType.ARCHER, 1, searchMainQuest("MainQuest01"), searchMainQuest("MainQuest02"), archerQuest02), 1000, 100, "Go do this and that noob", false);
		this.archerQuests.add(archerQuest03);
	}
		
	
	private ArrayList<Object> createTestObjects(QuestType questType, int level, Quest... requirementQuests) {
		ArrayList<Object> testObjects = new ArrayList<>();
		testObjects.add(questType);
		testObjects.add(level);
		testObjects.addAll(Arrays.asList(requirementQuests));
		return testObjects;
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
	
	public Quest searchMainQuest(String nameOfQuest) {
		for(Quest q: this.getMainQuests()) {
			if(q.getName().equals(nameOfQuest))
				return q;
		}
		throw new IllegalArgumentException("No quest with that name");
	}
	
}
