package Player;

import equipment.Weapon;

public abstract class BasicCharacter implements Character {
	
    
    QuestLog questLog;
    Weapon weapon;
    String playerOrNPC;
    double damage;
    int health;


    public BasicCharacter(int health) {
        this.health = health;
        this.questLog = new QuestLog();
        this.damage = 100.0;
        if(this instanceof Player)
        	this.playerOrNPC = "PLAYER";
        else
        	this.playerOrNPC = "NPC";
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
    
}
