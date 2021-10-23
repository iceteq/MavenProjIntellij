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
    void setQuestLogForPlayer();
    void addQuestToNPC(Quest quest);
    void removeCompletedQuest(Quest quest);
    Quest getNPCQuest(Quest quest);
    void completeQuest(Quest completedQuest);
    void acceptQuest(Quest questToAccept);
    String getTypeOfCharacter();
    boolean isNPC();
    boolean getQuestFailed(Quest quest);
    void setQuestFailed(Quest quest, boolean trueOrFalse);
    void removeFailedQuestFromPlayer(Quest quest);


    Weapon getWeapon();

    void setMaxHealth(int i);

}
