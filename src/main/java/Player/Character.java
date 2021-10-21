package Player;

import equipment.Weapon;

public interface Character {

    int getMaxHealth();
    
    void setWeapon(Weapon weapon);
    
    double getDamage();
    void setDamage(double newDamage);

    int getLevel();
    void setLevelAndOtherStats(int level);
    
    QuestLog getQuestLog();
    void setQuestLogForThisCharacter();
    void addCompletedQuestForThisPlayer(Quest completedQuest);
    void addQuestToAcceptForThisPlayer(Quest questToAccept);
    String getTypeOfCharacter();
    boolean isNPC();


    Weapon getWeapon();

    void setMaxHealth(int i);
}
