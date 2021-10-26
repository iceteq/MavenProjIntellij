package Player;

import java.util.ArrayList;

import Player.Quest.QuestType;

public class QuestLog {

    private ArrayList<Quest> completedQuests = new ArrayList<>();
    private ArrayList<Quest> acceptedQuests = new ArrayList<>();
    private ArrayList<Quest> npcQuests = new ArrayList<>();


    QuestLog() {

    }

    public ArrayList<Quest> getCompletedQuests() {
        return new ArrayList<>(completedQuests);
    }

    public ArrayList<Quest> getAcceptedQuests() {
        return new ArrayList<>(acceptedQuests);
    }

    public boolean getQuestFailed(Quest quest) {
        return quest.isQuestFailed();
    }

    public void setQuestFailed(Quest quest, boolean trueOrFalse, Character character) {

        if (character.isNPC())
            throw new IllegalArgumentException("Character must be a player");

        for (Quest q : acceptedQuests) {
            if (q == quest)
                q.setQuestFailed(trueOrFalse);
        }
    }

    public void removeFailedQuestFromPlayer(Quest quest, Character character) {

        if (character.isNPC())
            throw new IllegalArgumentException("Character must be a player");

        if (quest.isQuestFailed() && acceptedQuests.contains(quest))
            acceptedQuests.remove(quest);

    }

    public void addQuestToNPC(Quest quest) {
        this.npcQuests.add(quest);
    }

    public ArrayList<Quest> getNPCQuests() {
        return new ArrayList<>(npcQuests);
    }

    public Quest getNPCQuest(Quest quest, Character character) {

        if (!(character.isNPC()))
            throw new IllegalArgumentException("Character must be an NPC");

        for (Quest q : this.getNPCQuests()) {
            if (q == quest)
                return q;
        }

        throw new IllegalArgumentException("No quest with that name found in npcQuests");
    }


    public void addCompletedQuest(Quest quest, Character character) {

        if (character.isNPC())
            throw new IllegalArgumentException("Character must be a player");

        if (character.getQuestLog().getCompletedQuests().contains(quest))
            throw new IllegalArgumentException("This quest is already in completedQuests");


        if (character.getTypeOfCharacter().contains("Knight")) {

            if (quest.getQuestType().name().equals("ALL")) {
                this.completedQuests.add(quest);
            } else if (quest.getQuestType().name().equals("KNIGHT")) {
                this.completedQuests.add(quest);
            } else {
                throw new IllegalArgumentException("Character type is Knight. Quest type is Archer");
            }

        } else if (character.getTypeOfCharacter().contains("Archer")) {

            if (quest.getQuestType().name().equals("ALL")) {
                this.completedQuests.add(quest);
            } else if (quest.getQuestType().name().equals("ARCHER")) {
                this.completedQuests.add(quest);
            } else {
                throw new IllegalArgumentException("Character type is Archer. Quest type is Knight");
            }

        } else {

            if (quest.getQuestType().name().equals("ALL")) {
                this.completedQuests.add(quest);
            } else {
                throw new IllegalArgumentException("Character is of no Class. Quest type is of "
                        + quest.getQuestType().name() + " type");
            }

        }

        acceptedQuests.remove(quest);


    }

    public void removeCompletedQuestFromPlayer(Quest quest, Character character) {

        if (character.isNPC())
            throw new IllegalArgumentException("Character must be  player");
        else if (completedQuests.contains(quest))
            completedQuests.remove(quest);
        else
            throw new IllegalArgumentException("Quest not in completedQuests");

    }

    public void addToAcceptedQuests(Quest questToAccept, Character character) {

        ArrayList<Object> copyOfRequirements = new ArrayList<>(questToAccept.getRequirements());
        ArrayList<Object> questRequirements = new ArrayList<>(copyOfRequirements);
        int levelRequirement = 0;
        QuestType questTypeRequirement = null;

        for (Object o : copyOfRequirements) {
            if (o instanceof Integer) {
                levelRequirement = (int) o;
                questRequirements.remove(o);
            } else if (o instanceof QuestType) {
                questTypeRequirement = (QuestType) o;
                questRequirements.remove(o);
            }
        }

        if (this.completedQuests.containsAll(questRequirements) && character.getLevel() == levelRequirement) {
            if (questTypeRequirement.name().equals("ALL")) {
                this.acceptedQuests.add(questToAccept);
            } else if (questTypeRequirement.name().equals("KNIGHT") && character.getTypeOfCharacter().contains("Knight")) {
                this.acceptedQuests.add(questToAccept);
            } else if (questTypeRequirement.name().equals("ARCHER") && character.getTypeOfCharacter().contains("Archer")) {
                this.acceptedQuests.add(questToAccept);
            }
        } else {
            throw new IllegalStateException("Player doesn't meet requirements");
        }
    }

    public void printAcceptedQuests() {
        for (Quest q : acceptedQuests) {
            System.out.println(q.getName());
        }
    }

    public void printCompletedQuests() {
        for (Quest q : completedQuests) {
            System.out.println(q.getName());
        }
    }


}
