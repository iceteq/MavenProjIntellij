package Player;

public interface Character {

    int getHealth();
    int getDamage();
    void setDamage(int newDamage);
    void setHealth(int newHealth);
    QuestLog getQuestLog();
    void setQuestLogForThisCharacter();
    


}
