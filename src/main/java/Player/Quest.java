package Player;

import java.util.ArrayList;

public class Quest {
	
	public enum QuestType {ALL, KNIGHT, ARCHER}
	
	
	private ArrayList<String> rewards = new ArrayList<>();
	private String name;
	private QuestType type;
	
	
	
	Quest(String name, QuestType classType) {
		this.name = name;
		this.type = classType;
	}

	public String getName() {
		return name;
	}

	public QuestType getClassType() {
		return type;
	}
}
