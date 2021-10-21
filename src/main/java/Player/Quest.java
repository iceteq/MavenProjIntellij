package Player;

import java.util.ArrayList;

public class Quest {
	
	public enum QuestType {ALL, KNIGHT, ARCHER}
	
	
	private int[] rewards = new int[2];
	private ArrayList<Object> requirements = new ArrayList<>();
	private String name;
	private String questDescription;

	
	
	Quest(String name, ArrayList<Object> requirements, int experience, int currency, String questDescription) {
		this.name = name;
		if(hasValidObjects(requirements))
			this.requirements = new ArrayList<>(requirements);
		this.rewards[0] = experience;
		this.rewards[1] = currency;
		this.questDescription = questDescription;
	
		
	}

	public String getName() {
		return name;
	}

	public int getExperience() {
		return rewards[0];
	}

	public int getCurrency() {
		return rewards[1];
	}
	
	public String toString() {
		return "Name: " + this.name + "\nClassType: " + this.getQuestType().name() + "\nLevel: " + this.getLevel()
				+ "\nExperience: " + this.getExperience() + "\nCurrency: " + this.getCurrency();
	}

	public String getQuestDescription() {
		return questDescription;
	}
	
	public int getLevel() {
		int toReturn = 0;
		for(Object o: requirements) {
			if(o instanceof Integer)
				toReturn = (int) o;
		}
		return toReturn;
	}
	
	public QuestType getQuestType() {
		QuestType toReturn = null;
		for(Object o: requirements) {
			if(o instanceof QuestType)
				toReturn = (QuestType) o;
		}
		return toReturn;
	}
	
	public ArrayList<Object> getRequirements() {
		return new ArrayList<Object>(requirements);
	}
	
	private boolean hasValidObjects(ArrayList<Object> requirements) {
		
		int integerCounter = 0;
		int questTypeCounter = 0;
		int loopCounter = 0;
		
		if(requirements.isEmpty()) {
			
			throw new IllegalStateException("List is empty. Must contain one Integer, one QuestType, and zero or more Quests");
		}
			
		for(Object o: requirements) {
			
			
			if(o instanceof Integer || o instanceof QuestType || o instanceof Quest) {
				//kommer inte på bättre logik för tillfället.
			}
			else {
				throw new IllegalArgumentException("Requirements may only contain one Integer, one QuestType, and zero or more Quests");
			}
			
			if(o instanceof Integer) {
				integerCounter += 1;
				if(integerCounter > 1) {
					throw new IllegalArgumentException("Requirements may only contain one Integer");
				}
			}
			else if(loopCounter == requirements.size() - 1 && integerCounter == 0) {
				throw new IllegalArgumentException("Requirements must contain one Integer");
			}
			
			if(o instanceof QuestType) {
				questTypeCounter += 1;
				if(questTypeCounter > 1) {
					throw new IllegalArgumentException("Requirements may only contain one QuestType");
				}
			}
			else if(loopCounter == requirements.size() - 1 && questTypeCounter == 0) {
				throw new IllegalArgumentException("Requirements must contain one QuestType");
			}
			
			
			loopCounter += 1;
		}
		
		
		return true;
	}

	@Override 
	public boolean equals(Object obj) {
		
		if(this == obj)
			return true;
		
		if(obj == null)
			return false;
		
		if(this.getClass() != obj.getClass())
			return false;
		
		Quest quest = (Quest)obj;
		
		if(this.name == quest.getName())
			if(this.getExperience() == quest.getExperience())
				if(this.getCurrency() == quest.getCurrency())
					if(this.getLevel() == quest.getLevel())
						if(this.getQuestType() == quest.getQuestType())
							if(this.getQuestDescription() == quest.getQuestDescription())
								return true;
		return false;
	}
	

	
}
