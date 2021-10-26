package Player;

import quest.Quest;
import quest.QuestLog;

/*
211016 19:49:49
Just nu finns det "profession" som dekorerar
men det går även att lägga till "race" senare.

Nu är det i alla fall möjligt att kombinera på det här sättet:
new Knight(new NPC())
new Knight(new Player())
new Archer(new NPC())
new Archer(new Player())

 */
public abstract class Decorator implements Character {

    Character character;
    QuestLog questLog;
    String knightOrArcher;
    
    public Decorator(Character character){
        this.character = character;
        this.questLog = new QuestLog();
        this.knightOrArcher = this.getClass().toString();

    }
    
    @Override 
    public QuestLog getQuestLog() {
    	return this.questLog;
    }

    
    @Override
	public void addQuestToNPC(Quest quest) {
		this.questLog.addQuestToNPC(quest);
	}
    
	public Quest getNPCQuest(Quest quest) {
		return this.questLog.getNPCQuest(quest, this);
	}
    
	@Override
	public boolean getQuestFailed(Quest quest) {
		return this.questLog.getQuestFailed(quest);
	}
	
	@Override
	public void setQuestFailed(Quest quest, boolean trueOrFalse) {
		this.questLog.setQuestFailed(quest, trueOrFalse, this);
	}
	
    @Override
    public void completeQuest(Quest completedQuest) {
    	this.questLog.addCompletedQuest(completedQuest, this);
    }
    
    @Override
	public void removeCompletedQuest(Quest quest) {
		this.questLog.removeCompletedQuestFromPlayer(quest, this);
	}
    
	@Override
	public void removeAcceptedQuestIfFailed(Quest quest) {
		this.questLog.removeFailedQuestFromPlayer(quest, this);
	}
	
    @Override
	public void acceptQuest(Quest questToAccept) {
		this.questLog.addToAcceptedQuests(questToAccept, this);
	}
    @Override 
    public String getTypeOfCharacter() {
    	return knightOrArcher;
    }
    
    @Override
    public boolean isNPC() {
    	return character.isNPC();
    }

    public abstract void setLevel(int level);
}
