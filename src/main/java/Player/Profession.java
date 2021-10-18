package Player;

/**
 * Profession kan vara Knight eller Archer
 */
public abstract class Profession extends Decorator  {
	QuestLog questLog;
    public Profession(Character ch) {
        super(ch);
        this.questLog = new QuestLog();
          
        
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

}
