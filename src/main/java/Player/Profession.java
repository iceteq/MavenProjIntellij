package Player;

/**
 * Profession kan vara Knight eller Archer
 */
public abstract class Profession extends Decorator  {
	
    public Profession(Character ch) {
        super(ch);
    
    }
    	
	@Override
	public QuestLog getQuestLog() {
		// TODO Auto-generated method stub
		return questLog;
	}
	
	@Override
	public void setQuestLogForThisCharacter() {
		this.questLog.setQuestLog(this);
	}
	
	@Override
	public String getTypeOfCharacter() {
		// TODO Auto-generated method stub
		return character.getTypeOfCharacter();
	}


}
