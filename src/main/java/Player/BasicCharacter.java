package Player;

import equipment.Weapon;

public abstract class BasicCharacter implements Character {
	
    int health;
    QuestLog questLog;
    double damage;
    Weapon weapon;


    public BasicCharacter(int health) {
        this.health = health;
        this.questLog = new QuestLog();
        this.damage = 100.0;

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
    
}
