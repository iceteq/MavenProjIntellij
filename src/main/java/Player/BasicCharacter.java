package Player;

import equipment.Weapon;
import quest.Quest;
import quest.QuestLog;

public abstract class BasicCharacter implements Character {

    public static final double INITIAL_BASICCHARACTER_DAMAGE = 5;
    public static final double INITIAL_BASICCHARACTER_DEFENSE = 0;
    public static final int INITIAL_BASICCHARACTER_HEALTH = 300;
    public static final int BASICCHARACTER_MAXHEALTH_INCREASE_PER_LEVEL = 5;
    public static final int INITIAL_LEVEL = 1;

    QuestLog questLog;
    Weapon weapon;
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

        if (this instanceof NPC)
            this.NPC = true;

        this.className = this.getClass().toString();

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
        this.damage = INITIAL_BASICCHARACTER_DAMAGE + weapon.getWeaponDamage();
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
    public QuestLog getQuestLog() {
        return questLog;
    }

    @Override
    public void addQuestToNPC(Quest quest) {
        this.questLog.addQuestToNPC(quest);
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
    public void acceptQuest(Quest questToAccept) {
        this.questLog.addToAcceptedQuests(questToAccept, this);
    }

    @Override
    public Quest getNPCQuest(Quest quest) {
        return this.questLog.getNPCQuest(quest, this);
    }

    @Override
    public String getTypeOfCharacter() {
        return this.className;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public void setLevelAndOtherStats(int level) {
        this.setLevel(level);
        setMaxHealthWithRegardToLevel();
    }

    @Override
    public void setMaxHealthWithRegardToLevel() {
        this.setMaxHealth(INITIAL_BASICCHARACTER_HEALTH + (this.getLevel() * BASICCHARACTER_MAXHEALTH_INCREASE_PER_LEVEL));
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
