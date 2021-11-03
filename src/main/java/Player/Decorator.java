package Player;

import quest.Quest;
import quest.QuestLog;

/*
211016 19:49:49
Just nu finns det "profession" som dekorerar
men det går även att lägga till "race" senare.

Nu är det i alla fall möjligt att kombinera på det här sättet:
new Knight(new NPC())
new Knight(new Player())
new Archer(new NPC())
new Archer(new Player())

 */
public abstract class Decorator implements Character {

    Character character;
    String knightOrArcher;

    public Decorator(Character character) {
        this.character = character;
        this.knightOrArcher = this.getClass().toString();

    }

    @Override
    public QuestLog getQuestLog() {
        return character.getQuestLog();
    }


    @Override
    public void addQuestToNPC(Quest quest) {
        character.getQuestLog().addQuestToNPC(quest);
    }

    public Quest getNPCQuest(Quest quest) {
        return character.getQuestLog().getNPCQuest(quest, character);
    }

    @Override
    public void completeQuest(Quest completedQuest) {
        character.getQuestLog().addCompletedQuest(completedQuest, this);
    }

    @Override
    public void removeCompletedQuest(Quest quest) {
        character.getQuestLog().removeCompletedQuestFromPlayer(quest, character);

    }


    @Override
    public void acceptQuest(Quest questToAccept) {
        character.getQuestLog().addToAcceptedQuests(questToAccept, this);

    }

    @Override
    public String getTypeOfCharacter() {
        String type = character.getTypeOfCharacter();
        type = knightOrArcher;
        return type;
    }

    @Override
    public boolean isNPC() {
        return character.isNPC();
    }

    public abstract void setLevel(int level);
}
