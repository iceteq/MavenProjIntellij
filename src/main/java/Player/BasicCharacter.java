package Player;

import equipment.Armor;
import equipment.Weapon;

public abstract class BasicCharacter implements Character {

	public static final double INITIAL_BASICCHARACTER_DAMAGE = 5;
	public static final double INITIAL_BASICCHARACTER_DEFENSE = 0;
	public static final int INITIAL_LEVEL = 1;
    
    QuestLog questLog;
    Weapon weapon;
    Armor armor;
    String className;
    boolean NPC;
    double damage;
    int health;
    double defense;
    int level;
    

    public BasicCharacter(int health) {

        this.health = health;
        this.questLog = new QuestLog();
        this.damage = 100.0;
        
        if(this instanceof NPC)
        	this.NPC = true;
        
        this.className = this.getClass().toString();
        

        this.questLog = new QuestLog();
        this.damage = INITIAL_BASICCHARACTER_DAMAGE;
        this.defense = INITIAL_BASICCHARACTER_DEFENSE;
        this.level = INITIAL_LEVEL;

    }

    public BasicCharacter() {
        this(0);
    }

    public int getHealth() {
        return this.health;
    }
    public double getDamage() {
        return this.damage;
    }

    @Override
    public void setHealth(int newHealth) {
        this.health = newHealth;
    }
    
    @Override
    public void setDamage(double newDamage) {
        this.damage = newDamage;
    }

    @Override
    public String toString() {
        return "BasicCharacter{}";
    }
    
    @Override
	public QuestLog getQuestLog() {
		return questLog;
	}
	
	@Override
	public void setQuestLogForThisCharacter() {
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
		return this.className;
	}
	

	@Override
    public void setLevel(int level){
        this.level = level;
    }

    @Override
    public void levelUp() {
        this.level++;
    }


    @Override
    public int getLevel() {
        return this.level;
    }
    
    @Override 
    public boolean isNPC() {
		return NPC;
    }

    
}
