package Player;

import equipment.Weapon;

public interface Character {

    int getMaxHealth();
    double getDamage();
    void setDamage(double newDamage);
    void setMaxHealth(int newHealth);
    QuestLog getQuestLog();
    void setQuestLogForThisCharacter();
    void setWeapon(Weapon weapon);

    String getTypeOfCharacter();




    int getLevel();
    void setLevel(int level);


}
