package Player;
import java.util.ArrayList;

public class QuestLog {
	
	private ArrayList<Quest> mainQuests = new ArrayList<>();
	private ArrayList<Quest> knightQuests = new ArrayList<>();
	private ArrayList<Quest> archerQuests = new ArrayList<>();
	
	
	QuestLog() {

	}
	
	public void setQuestLog(Character character) {
		
		QuestDatabase database = new QuestDatabase();
		
		if(character.getTypeOfCharacter().equals("PLAYER")) {
			this.mainQuests = database.getMainQuests();
<<<<<<< Updated upstream
			if(character instanceof Knight)
				this.knightQuests = database.getKnightQuests();
			else if(character instanceof Archer)
				this.archerQuests = database.getArcherQuests();
=======
			this.knightQuests = database.getKnightQuests();
			
			
		}
		else if(character instanceof Archer && !(character instanceof NPC)) {
			this.mainQuests = database.getMainQuests();
			this.archerQuests = database.getArcherQuests();
			
>>>>>>> Stashed changes
		}
		else
			throw new IllegalArgumentException("Character must be a player and have a class");
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
