package Player;

import equipment.Weapon;
import quest.Quest;
import quest.QuestLog;

public interface Character {

    int getMaxHealth();

    void setWeapon(Weapon weapon);

    double getDamage();

    void setDamage(double newDamage);

    void setMaxHealthWithRegardToLevel();

    int getLevel();

    void setLevelAndOtherStats(int level);

    void setLevel(int level);

    QuestLog getQuestLog();

    void addQuestToNPC(Quest quest);

    void removeCompletedQuest(Quest quest);

    Quest getNPCQuest(Quest quest);

    void completeQuest(Quest completedQuest);

    void acceptQuest(Quest questToAccept);

    String getTypeOfCharacter();

    boolean isNPC();

    boolean getQuestFailed(Quest quest);

    void setQuestFailed(Quest quest, boolean trueOrFalse);

    void removeAcceptedQuestIfFailed(Quest quest);


    Weapon getWeapon();

    void setMaxHealth(int i);

}
