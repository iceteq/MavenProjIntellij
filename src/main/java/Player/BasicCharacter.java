package Player;

public abstract class BasicCharacter implements Character {
	
    int health;
    int damage;
    QuestLog questLog;
    
    public BasicCharacter(int health) {
        this.health = health;
        this.questLog = new QuestLog();

    }

    public BasicCharacter() {
        this(0);
    }

    public int getHealth() {
        return this.health;
    }
    public int getDamage() {
        return this.damage;
    }

    @Override
    public void setHealth(int newHealth) {
        this.health = newHealth;
    }
    @Override
    public void setDamage(int newDamage) {
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
