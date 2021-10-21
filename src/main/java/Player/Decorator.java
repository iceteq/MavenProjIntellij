package Player;

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

    public int getHealth(){
        return character.getHealth();
    }
    
    @Override 
    public QuestLog getQuestLog() {
    	return this.questLog;
    }
    
    @Override
    public void setQuestLogForThisCharacter(){
    	this.questLog.setQuestLog(this);
    }
    
    @Override
    public void addCompletedQuestForThisPlayer(Quest completedQuest) {
    	this.questLog.addCompletedQuest(completedQuest, this);
    }
    
    @Override
	public void addQuestToAcceptForThisPlayer(Quest questToAccept) {
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
}
