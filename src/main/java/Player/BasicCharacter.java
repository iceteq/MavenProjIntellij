package Player;

import equipment.Armor;
import equipment.Weapon;

public abstract class BasicCharacter implements Character {

	public static final double INITIAL_BASICCHARACTER_DAMAGE = 5;
	public static final double INITIAL_BASICCHARACTER_DEFENSE = 0;
	public static final int INITIAL_BASICCHARACTER_HEALTH = 300;
	public static final int INITIAL_LEVEL = 1;
    
    QuestLog questLog;
    Weapon weapon;
    Armor armor;
    String className;
    boolean NPC;
    double damage;
    int maxHealth;
    double defense;
    int level;
    

    public BasicCharacter() {

        this.maxHealth = INITIAL_BASICCHARACTER_HEALTH;
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

    @Override
    public int getMaxHealth() {
        return this.maxHealth;
    }

    @Override
    public double getDamage() {
        return this.damage;
    }

    @Override
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
        this.damage = weapon.getWeaponDamage();
    }

    @Override
    public Weapon getWeapon() {
        return this.weapon;
    }

    @Override
    public void setMaxHealth(int i) {
        this.maxHealth = i;
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
    public void setLevelAndOtherStats(int level){
        this.level = level;
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
