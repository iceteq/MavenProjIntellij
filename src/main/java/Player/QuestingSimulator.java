package Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class QuestingSimulator {
    //
    //	private ArrayList<ArrayList<Quest>> toReturn = new ArrayList<>();
    //
    //
    //	public ArrayList<ArrayList<Quest>> runAcceptFirstQuestFailsTwiceAndPasses(Character npc, Character player, Quest... quests) {
    //
    //
    //		ArrayList<Quest> mainQuests = new ArrayList<>(Arrays.asList(quests));
    //
    //		Quest mainQuest01 = mainQuests.get(0);
    //
    //		npc.addQuestToNPC(mainQuest01);
    //
    //		player.acceptQuest(npc.getNPCQuest(mainQuest01));
    //
    //		player.setQuestFailed(mainQuest01, true);
    //
    //		if(player.getQuestFailed(mainQuest01) && mainQuest01.isCheckPoint())
    //			player.setQuestFailed(mainQuest01, false);
    //
    //		player.setQuestFailed(mainQuest01, true);
    //
    //		if(player.getQuestFailed(mainQuest01) && mainQuest01.isCheckPoint())
    //			player.setQuestFailed(mainQuest01, false);
    //
    //		player.completeQuest(mainQuest01);
    //
    //		toReturn.add(player.getQuestLog().getCompletedQuests());
    //		toReturn.add(player.getQuestLog().getAcceptedQuests());
    //		toReturn.add(npc.getQuestLog().getNPCQuests());
    //
    //		return toReturn;
    //
    //
    //	}
    //
    //
    //	public ArrayList<ArrayList<Quest>> runGetToCheckPointFailAndFailBackToFirstMainQuest(Character npc, Character player, Quest... quests) {
    //
    //		ArrayList<Quest> mainQuests = new ArrayList<>(Arrays.asList(quests));
    //
    //		Quest mainQuest01 = mainQuests.get(0);
    //		Quest mainQuest02 = mainQuests.get(1);
    //		Quest mainQuest03 = mainQuests.get(2);
    //
    //		npc.addQuestToNPC(mainQuest01);
    //		npc.addQuestToNPC(mainQuest02);
    //		npc.addQuestToNPC(mainQuest03);
    //
    //		player.acceptQuest(npc.getNPCQuest(mainQuest01));
    //		player.completeQuest(npc.getNPCQuest(mainQuest01));
    //
    //		player.acceptQuest(npc.getNPCQuest(mainQuest02));
    //		player.completeQuest(npc.getNPCQuest(mainQuest02));
    //
    //		player.acceptQuest(npc.getNPCQuest(mainQuest03));
    //		player.setQuestFailed(mainQuest03, true);
    //
    //		if(player.getQuestFailed(mainQuest03) && !mainQuest02.isCheckPoint()) {
    //
    //			player.removeAcceptedQuestIfFailed(mainQuest03);
    //			player.removeCompletedQuest(mainQuest02);
    //			player.setQuestFailed(mainQuest03, false);
    //		}
    //		else {
    //
    //			//			player.removeAcceptedQuestIfFailed(mainQuest03);
    //			//			player.setQuestFailed(mainQuest03, false);
    //
    //		}
    //
    //		player.acceptQuest(npc.getNPCQuest(mainQuest02));
    //		player.setQuestFailed(mainQuest02, true);
    //
    //		if(player.getQuestFailed(mainQuest02) && !mainQuest01.isCheckPoint()) {
    //
    //			//			player.removeAcceptedQuestIfFailed(mainQuest02);
    //			//			player.removeCompletedQuest(mainQuest01);
    //			//			player.setQuestFailed(mainQuest02, false);
    //
    //		}
    //		else {
    //
    //			player.removeAcceptedQuestIfFailed(mainQuest02);
    //			player.setQuestFailed(mainQuest02, false);
    //
    //		}
    //
    //
    //		toReturn.add(player.getQuestLog().getCompletedQuests());
    //		toReturn.add(player.getQuestLog().getAcceptedQuests());
    //		toReturn.add(npc.getQuestLog().getNPCQuests());
    //
    //		return toReturn;
    //
    //	}
    //
    //
    //	public ArrayList<ArrayList<Quest>> runPlayerKnightCompletesMainAndKnightQuestLines(Character npc, Character playerKnight, Quest... quests) {
    //
    //
    //		ArrayList<Quest> mainAndKnightQuests = new ArrayList<>(Arrays.asList(quests));
    //
    //
    //		Quest mainQuest01 = mainAndKnightQuests.get(0);
    //		Quest mainQuest02 = mainAndKnightQuests.get(1);
    //		Quest mainQuest03 = mainAndKnightQuests.get(2);
    //		Quest mainQuest04 = mainAndKnightQuests.get(3);
    //		Quest mainQuest05 = mainAndKnightQuests.get(4);
    //		Quest knightQuest01 = mainAndKnightQuests.get(5);
    //		Quest knightQuest02 = mainAndKnightQuests.get(6);
    //		Quest knightQuest03= mainAndKnightQuests.get(7);
    //
    //		npc.addQuestToNPC(mainQuest01);
    //		npc.addQuestToNPC(mainQuest02);
    //		npc.addQuestToNPC(mainQuest03);
    //		npc.addQuestToNPC(mainQuest04);
    //		npc.addQuestToNPC(mainQuest05);
    //		npc.addQuestToNPC(knightQuest01);
    //		npc.addQuestToNPC(knightQuest02);
    //		npc.addQuestToNPC(knightQuest03);
    //
    //
    //
    //		playerKnight.acceptQuest(npc.getNPCQuest(mainQuest01));
    //		playerKnight.completeQuest(npc.getNPCQuest(mainQuest01));
    //
    //		playerKnight.acceptQuest(npc.getNPCQuest(mainQuest02));
    //		playerKnight.completeQuest(npc.getNPCQuest(mainQuest02));
    //
    //		playerKnight.acceptQuest(npc.getNPCQuest(mainQuest03));
    //		playerKnight.completeQuest(npc.getNPCQuest(mainQuest03));
    //
    //		playerKnight.acceptQuest(npc.getNPCQuest(knightQuest01));
    //		playerKnight.completeQuest(npc.getNPCQuest(knightQuest01));
    //
    //		playerKnight.acceptQuest(npc.getNPCQuest(knightQuest02));
    //		playerKnight.completeQuest(npc.getNPCQuest(knightQuest02));
    //
    //		playerKnight.acceptQuest(npc.getNPCQuest(knightQuest03));
    //		playerKnight.completeQuest(npc.getNPCQuest(knightQuest03));
    //
    //		playerKnight.acceptQuest(npc.getNPCQuest(mainQuest04));
    //		playerKnight.completeQuest(npc.getNPCQuest(mainQuest04));
    //
    //		playerKnight.acceptQuest(npc.getNPCQuest(mainQuest05));
    //		playerKnight.completeQuest(npc.getNPCQuest(mainQuest05));
    //
    //
    //		toReturn.add(playerKnight.getQuestLog().getCompletedQuests());
    //		toReturn.add(playerKnight.getQuestLog().getAcceptedQuests());
    //		toReturn.add(npc.getQuestLog().getNPCQuests());
    //
    //		return toReturn;
    //
    //	}

    private Random random = new Random();
    private QuestDatabase database = new QuestDatabase();


    private int index;

    private ArrayList<Quest> mainQuests = new ArrayList<>(database.getMainQuests());
    private ArrayList<Quest> knightQuests = new ArrayList<>(database.getKnightQuests());
    private ArrayList<Quest> archerQuests = new ArrayList<>(database.getArcherQuests());
    private ArrayList<Quest> fullQuestLine = new ArrayList<>(mainQuests);


    public void startQuesting(Character player) {

        if (player.getTypeOfCharacter().contains("Knight")) {

            fullQuestLine.addAll(knightQuests);

        } else if (player.getTypeOfCharacter().contains("Archer")) {

            fullQuestLine.addAll(archerQuests);

        }


        boolean failed;
        Quest mainQuest01 = database.getMainQuests().get(0);


        int number = random.nextInt(2);

        if (number == 1) {
            failed = false;

//			printQuestStatus(player);
//			System.out.println("Start Passed: " + mainQuest01.getName());
//			System.out.println("----------------");

            runIfPassed(player, failed, mainQuest01);
        } else {
            failed = true;

//			printQuestStatus(player);
//			System.out.println("Start Failed: " + mainQuest01.getName());
//			System.out.println("----------------");

            runIfFailed(player, failed, mainQuest01);
        }


    }

    public void runIfPassed(Character player, boolean failed, Quest quest) {

        Quest nextQuest = null;

        player.completeQuest(quest);

        if (player.getQuestLog().getCompletedQuests().containsAll(fullQuestLine)) {
//			System.out.println("Finished!");
            return;
        }


        failed = hasFailed(failed);

        nextQuest = setAndGetNextQuest(player, quest, nextQuest);

        runIfPassedOrFailed(player, failed, nextQuest);


    }

    public void runIfFailed(Character player, boolean failed, Quest quest) {

        Quest previousQuest = null;

        previousQuest = setAndGetPreviousQuest(player, quest, previousQuest);


        if (previousQuest.isCheckPoint()) {
            previousQuest = quest;
        }
        if (player.getQuestLog().getCompletedQuests().contains(previousQuest)) {
            player.removeCompletedQuest(previousQuest);
        }


        failed = hasFailed(failed);


        runIfPassedOrFailed(player, failed, previousQuest);

    }


    private boolean hasFailed(boolean failed) {
        int number = random.nextInt(3);

        if (number == 0)
            failed = true;
        else if (number == 1)
            failed = false;
        else
            failed = false;

        return failed;
    }

    private void runIfPassedOrFailed(Character player, boolean failed, Quest quest) {
        if (failed) {

//			printQuestStatus(player);
//			System.out.println("Failed: "  + quest.getName());
//			System.out.println("-----------------");

            runIfFailed(player, failed, quest);

        } else {

//			printQuestStatus(player);
//			System.out.println("Passed: "  + quest.getName());
//			System.out.println("-----------------");

            runIfPassed(player, failed, quest);
        }
    }

    private Quest setAndGetNextQuest(Character player, Quest quest, Quest nextQuest) {

        if (quest.equals(database.getMainQuests().get(2)) && player.getTypeOfCharacter().contains("Knight")) {

            nextQuest = database.getKnightQuests().get(0);

        } else if (quest.equals(database.getMainQuests().get(2)) && player.getTypeOfCharacter().contains("Archer")) {

            nextQuest = database.getArcherQuests().get(0);

        } else if (quest.getQuestType().name().equals("KNIGHT")) {

            index = database.getKnightQuests().indexOf(quest);

            if (index == 2)
                nextQuest = database.getMainQuests().get(3);
            else
                nextQuest = database.getKnightQuests().get(index + 1);

        } else if (quest.getQuestType().name().equals("ARCHER")) {

            index = database.getArcherQuests().indexOf(quest);

            if (index == 2)
                nextQuest = database.getMainQuests().get(3);
            else
                nextQuest = database.getArcherQuests().get(index + 1);

        } else {

            index = database.getMainQuests().indexOf(quest);

            if (index == 4)
                nextQuest = database.getMainQuests().get(index);
            else
                nextQuest = database.getMainQuests().get(index + 1);

        }

        return nextQuest;

    }

    private Quest setAndGetPreviousQuest(Character player, Quest quest, Quest previousQuest) {

        if (quest.equals(database.getKnightQuests().get(0))) {

            previousQuest = database.getMainQuests().get(2);

        } else if (quest.equals(database.getArcherQuests().get(0))) {

            previousQuest = database.getMainQuests().get(2);

        } else if (quest.getQuestType().name().equals("KNIGHT")) {

            index = database.getKnightQuests().indexOf(quest);
            previousQuest = database.getKnightQuests().get(index - 1);

        } else if (quest.getQuestType().name().equals("ARCHER")) {

            index = database.getArcherQuests().indexOf(quest);
            previousQuest = database.getArcherQuests().get(index - 1);

        } else {

            index = database.getMainQuests().indexOf(quest);

            if (index == 0)
                previousQuest = database.getMainQuests().get(index);
            else if (index == 3 && player.getTypeOfCharacter().contains("Knight"))
                previousQuest = database.getKnightQuests().get(2);
            else if (index == 3 && player.getTypeOfCharacter().contains("Archer"))
                previousQuest = database.getArcherQuests().get(2);
            else
                previousQuest = database.getMainQuests().get(index - 1);

        }

        return previousQuest;


    }

    private void printQuestStatus(Character player) {
        System.out.println("Completed: ");
        player.getQuestLog().printCompletedQuests();
    }
}
