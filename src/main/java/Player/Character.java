package Player;

import equipment.Weapon;

public interface Character {

    int getHealth();
    void setHealth(int newHealth);
    
    double getDamage();
    void setDamage(double newDamage);
    void setWeapon(Weapon weapon);
    
    void levelUp();
    int getLevel();
    void setLevel(int level);
    
    QuestLog getQuestLog();
    void setQuestLogForThisCharacter();
    void addCompletedQuestForThisPlayer(Quest completedQuest);
    void addQuestToAcceptForThisPlayer(Quest questToAccept);
    String getTypeOfCharacter();
    boolean isNPC();



  


}
