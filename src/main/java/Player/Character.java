package Player;

import equipment.Weapon;

public interface Character {

    int getHealth();
    double getDamage();
    void setDamage(double newDamage);
    void setHealth(int newHealth);
    QuestLog getQuestLog();
    void setQuestLogForThisCharacter();
    void setWeapon(Weapon weapon);
<<<<<<< Updated upstream
    String getTypeOfCharacter();

=======

    void levelUp();

    int getLevel();
    void setLevel(int level);
>>>>>>> Stashed changes

}
