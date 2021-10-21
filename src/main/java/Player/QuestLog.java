package Player;
import java.util.ArrayList;

import Player.Quest.QuestType;

public class QuestLog {
	
	private ArrayList<Quest> mainQuests = new ArrayList<>();
	private ArrayList<Quest> knightQuests = new ArrayList<>();
	private ArrayList<Quest> archerQuests = new ArrayList<>();
	private ArrayList<Quest> completedQuests = new ArrayList<>();
	private ArrayList<Quest> acceptedQuests = new ArrayList<>();
	
	
	QuestLog() {

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

	public ArrayList<Quest> getCompletedQuests() {
		return new ArrayList<>(completedQuests);
	}
	
	public ArrayList<Quest> getAcceptedQuests() {
		return new ArrayList<>(acceptedQuests);
	}
	
	
	public void setQuestLog(Character character) {
		
		QuestDatabase database = new QuestDatabase();
		
		if(character.isNPC())
			throw new IllegalArgumentException("Character must be a player");
		
		if(character.getTypeOfCharacter().equals("class Player.Player"))  
			this.mainQuests = database.getMainQuests();
			
		else if(character.getTypeOfCharacter().equals("class Player.Knight"))
			this.knightQuests = database.getKnightQuests();
		
		else if(character.getTypeOfCharacter().equals("class Player.Archer"))
			this.archerQuests = database.getArcherQuests();	
			
	}


	public void addCompletedQuest(Quest completedQuest, Character character) {
		
		if(character.isNPC())
			throw new IllegalArgumentException("Character must be a player");
		
		if(character.getQuestLog().getCompletedQuests().contains(completedQuest))
			throw new IllegalArgumentException("This quest is already in completedQuests");
		
		if(completedQuest.getQuestType().name().equals("ALL")) {
			this.completedQuests.add(completedQuest);
		}
		else if(completedQuest.getQuestType().name().equals("KNIGHT") && character.getTypeOfCharacter().contains("Knight")) {
			this.completedQuests.add(completedQuest);
		}
		else if(completedQuest.getQuestType().name().equals("ARCHER") && character.getTypeOfCharacter().contains("Archer")) {
			this.completedQuests.add(completedQuest);
		}
		else {
			throw new IllegalArgumentException("Quest-type doesn't match class-type");
		}
			
	}
	
	public void addToAcceptedQuests(Quest questToAccept, Character character) {
		
		ArrayList<Object> copyOfRequirements = new ArrayList<>(questToAccept.getRequirements());
		ArrayList<Object> questRequirements = new ArrayList<>(copyOfRequirements);
		int levelRequirement = 0;
		QuestType questTypeRequirement = null;

		for(Object o: copyOfRequirements) {
			if(o instanceof Integer) {
				levelRequirement = (int) o;
				questRequirements.remove(o);
			}
			else if(o instanceof QuestType) {
				questTypeRequirement = (QuestType) o;
				questRequirements.remove(o);
			}
		}
		
		if(this.completedQuests.containsAll(questRequirements) && character.getLevel() == levelRequirement) {
			if(questTypeRequirement.name().equals("ALL")) {
				this.acceptedQuests.add(questToAccept);
			}	
			else if(questTypeRequirement.name().equals("KNIGHT") && character.getTypeOfCharacter().contains("Knight")) {
				this.acceptedQuests.add(questToAccept);
			}
			else if(questTypeRequirement.name().equals("ARCHER") && character.getTypeOfCharacter().contains("Archer")) {
				this.acceptedQuests.add(questToAccept);
			}	
		}
		else {
			throw new IllegalStateException("Player does not meet requirements");
		}
	}
	
	
	
}
