package Player;

import java.util.ArrayList;
import java.util.Arrays;

public class QuestingSimulator {
	
	private ArrayList<ArrayList<Quest>> toReturn = new ArrayList<>();
	
	
	public ArrayList<ArrayList<Quest>> runAcceptFirstQuestFailsTwiceAndPasses(Character npc, Character player, Quest... quests) {
		
		
		ArrayList<Quest> mainQuests = new ArrayList<>(Arrays.asList(quests));
		
		Quest mainQuest01 = mainQuests.get(0);
		
		npc.addQuestToNPC(mainQuest01);
		
		player.acceptQuest(npc.getNPCQuest(mainQuest01));
		
		player.setQuestFailed(mainQuest01, true);
		
		if(player.getQuestFailed(mainQuest01) && mainQuest01.isCheckPoint())
			player.setQuestFailed(mainQuest01, false);
		
		player.setQuestFailed(mainQuest01, true);
		
		if(player.getQuestFailed(mainQuest01) && mainQuest01.isCheckPoint())
			player.setQuestFailed(mainQuest01, false);
		
		player.completeQuest(mainQuest01);
		
		toReturn.add(player.getQuestLog().getCompletedQuests());
		toReturn.add(player.getQuestLog().getAcceptedQuests());
		toReturn.add(npc.getQuestLog().getNPCQuests());
		
		return toReturn;
		
		
	}

	
	public ArrayList<ArrayList<Quest>> runGetToCheckPointFailAndFailBackToFirstMainQuest(Character npc, Character player, Quest... quests) {
		
		ArrayList<Quest> mainQuests = new ArrayList<>(Arrays.asList(quests));
		
		Quest mainQuest01 = mainQuests.get(0);
		Quest mainQuest02 = mainQuests.get(1);
		Quest mainQuest03 = mainQuests.get(2);
		
		npc.addQuestToNPC(mainQuest01);
		npc.addQuestToNPC(mainQuest02);
		npc.addQuestToNPC(mainQuest03);
		
		player.acceptQuest(npc.getNPCQuest(mainQuest01));
		player.completeQuest(npc.getNPCQuest(mainQuest01));
		
		player.acceptQuest(npc.getNPCQuest(mainQuest02));
		player.completeQuest(npc.getNPCQuest(mainQuest02));
		
		player.acceptQuest(npc.getNPCQuest(mainQuest03));
		player.setQuestFailed(mainQuest03, true);

		if(player.getQuestFailed(mainQuest03) && !mainQuest02.isCheckPoint()) {
			
			player.removeFailedQuestFromPlayer(mainQuest03);
			player.removeCompletedQuest(mainQuest02);
			player.setQuestFailed(mainQuest03, false);
		}
		else {
			
			player.removeFailedQuestFromPlayer(mainQuest03);
			player.setQuestFailed(mainQuest03, false);
		
		}
			
		player.acceptQuest(npc.getNPCQuest(mainQuest02));
		player.setQuestFailed(mainQuest02, true);
		
		if(player.getQuestFailed(mainQuest02) && !mainQuest01.isCheckPoint()) {
			
			player.removeFailedQuestFromPlayer(mainQuest02);
			player.removeCompletedQuest(mainQuest01);
			player.setQuestFailed(mainQuest02, false);
			
		}
		else {
			
			player.removeFailedQuestFromPlayer(mainQuest02);
			player.setQuestFailed(mainQuest02, false);
			
		}
		
		
		toReturn.add(player.getQuestLog().getCompletedQuests());
		toReturn.add(player.getQuestLog().getAcceptedQuests());
		toReturn.add(npc.getQuestLog().getNPCQuests());
		
		return toReturn;		
		
	}
	
	
	public ArrayList<ArrayList<Quest>> runPlayerKnightCompletesMainAndKnightQuestLines(Character npc, Character playerKnight, Quest... quests) {
		
		
		ArrayList<Quest> mainAndKnightQuests = new ArrayList<>(Arrays.asList(quests));
		
		
		Quest mainQuest01 = mainAndKnightQuests.get(0);
		Quest mainQuest02 = mainAndKnightQuests.get(1);
		Quest mainQuest03 = mainAndKnightQuests.get(2);
		Quest mainQuest04 = mainAndKnightQuests.get(3);
		Quest mainQuest05 = mainAndKnightQuests.get(4);
		Quest knightQuest01 = mainAndKnightQuests.get(5);
		Quest knightQuest02 = mainAndKnightQuests.get(6);
		Quest knightQuest03= mainAndKnightQuests.get(7);
		
		npc.addQuestToNPC(mainQuest01);
		npc.addQuestToNPC(mainQuest02);
		npc.addQuestToNPC(mainQuest03);
		npc.addQuestToNPC(mainQuest04);
		npc.addQuestToNPC(mainQuest05);
		npc.addQuestToNPC(knightQuest01);
		npc.addQuestToNPC(knightQuest02);
		npc.addQuestToNPC(knightQuest03);
		
		
		
		playerKnight.acceptQuest(npc.getNPCQuest(mainQuest01));
		playerKnight.completeQuest(npc.getNPCQuest(mainQuest01));
		
		playerKnight.acceptQuest(npc.getNPCQuest(mainQuest02));
		playerKnight.completeQuest(npc.getNPCQuest(mainQuest02));
		
		playerKnight.acceptQuest(npc.getNPCQuest(mainQuest03));
		playerKnight.completeQuest(npc.getNPCQuest(mainQuest03));
		
		playerKnight.acceptQuest(npc.getNPCQuest(knightQuest01));
		playerKnight.completeQuest(npc.getNPCQuest(knightQuest01));
		
		playerKnight.acceptQuest(npc.getNPCQuest(knightQuest02));
		playerKnight.completeQuest(npc.getNPCQuest(knightQuest02));
		
		playerKnight.acceptQuest(npc.getNPCQuest(knightQuest03));
		playerKnight.completeQuest(npc.getNPCQuest(knightQuest03));
		
		playerKnight.acceptQuest(npc.getNPCQuest(mainQuest04));
		playerKnight.completeQuest(npc.getNPCQuest(mainQuest04));
		
		playerKnight.acceptQuest(npc.getNPCQuest(mainQuest05));
		playerKnight.completeQuest(npc.getNPCQuest(mainQuest05));
		

		toReturn.add(playerKnight.getQuestLog().getCompletedQuests());
		toReturn.add(playerKnight.getQuestLog().getAcceptedQuests());
		toReturn.add(npc.getQuestLog().getNPCQuests());
		
		return toReturn;	
		
	}
	
}
