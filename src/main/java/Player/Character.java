package Player;

import equipment.Weapon;

public interface Character {

    int getMaxHealth();
    void setMaxHealth(int newHealth);
    
    void setWeapon(Weapon weapon);
    
    double getDamage();
    void setDamage(double newDamage);

    int getLevel();
    void setLevel(int level);
    
    QuestLog getQuestLog();
    void setQuestLogForThisCharacter();
    void addCompletedQuestForThisPlayer(Quest completedQuest);
    void addQuestToAcceptForThisPlayer(Quest questToAccept);
    String getTypeOfCharacter();
    boolean isNPC();



  


}
