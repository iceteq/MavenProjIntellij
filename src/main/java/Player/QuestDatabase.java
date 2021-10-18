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
		for(int i = 0; i < 10; i++)
			this.mainQuests.add(new Quest("MainQuest" + String.valueOf(i), QuestType.ALL));
	}
	
	private void createKnightQuests() {
		for(int i = 0; i < 10; i++)
			this.knightQuests.add(new Quest("KnightQuest" + String.valueOf(i), QuestType.KNIGHT));
	}
	
	private void createArcherQuests() {
		for(int i = 0; i < 10; i++)
			this.archerQuests.add(new Quest("ArcherQuest" + String.valueOf(i), QuestType.ARCHER));
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
}
