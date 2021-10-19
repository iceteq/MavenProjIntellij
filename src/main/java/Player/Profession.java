package Player;

/**
 * Profession kan vara Knight eller Archer
 */
public abstract class Profession extends Decorator  {


	public static final double INITIAL_KNIGHT_DAMAGE = 10;
	public static final double INITIAL_BARBARIAN_DAMAGE = 15;




    public Profession(Character ch) {
        super(ch);
    
    }
    	
	@Override
	public QuestLog getQuestLog() {
		// TODO Auto-generated method stub
		return questLog;
	}

	@Override
	public void levelUp() {
		character.setLevel(character.getLevel() + 1);
	}

	@Override
	public int getLevel() {
		return character.getLevel();
	}

	public abstract void setLevel(int level);


	
	@Override
	public String getTypeOfCharacter() {
		// TODO Auto-generated method stub
		return character.getTypeOfCharacter();
	}


}
