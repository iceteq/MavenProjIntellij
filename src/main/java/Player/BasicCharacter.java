package Player;

import equipment.Armor;
import equipment.Weapon;

public abstract class BasicCharacter implements Character {

	
    
    QuestLog questLog;
    Weapon weapon;
    String playerOrNPC;
    double damage;
    int health;


    public static final double INITIAL_BASICCHARACTER_DAMAGE = 5;
    public static final double INITIAL_BASICCHARACTER_DEFENSE = 0;
    public static final int INITIAL_LEVEL = 1;



    Armor armor;
    double defense;
    int level;


    public BasicCharacter(int health) {

        this.health = health;
        this.questLog = new QuestLog();
        this.damage = 100.0;
        if(this instanceof Player)
        	this.playerOrNPC = "PLAYER";
        else
        	this.playerOrNPC = "NPC";

        this.health = health;
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
	public String getTypeOfCharacter() {
		return this.playerOrNPC;
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

    
}
