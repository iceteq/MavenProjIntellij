package Player;

import equipment.Weapon;
import quest.Quest;
import quest.QuestLog;

public interface Character {

    void setName(String name);

    int getMaxHealth();

    void setWeapon(Weapon weapon);

    double getDamage();

    void setDamage(double newDamage);

    void setMaxHealthWithRegardToLevel();

    int getLevel();
    
    void setMaxHealth(int i);

    void setLevelAndOtherStats(int level);

    void setLevel(int level);
    
    Weapon getWeapon();

    QuestLog getQuestLog();

    void addQuestToNPC(Quest quest);

    void removeCompletedQuest(Quest quest);

    Quest getNPCQuest(Quest quest);

    void completeQuest(Quest completedQuest);

    void acceptQuest(Quest questToAccept);

    String getTypeOfCharacter();

    boolean isNPC();
    
    

    

}
