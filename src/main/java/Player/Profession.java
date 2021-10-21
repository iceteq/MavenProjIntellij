package Player;

import equipment.Weapon;

/**
 * Profession kan vara Knight eller Archer
 */
public abstract class Profession extends Decorator  {


	public static final double INITIAL_KNIGHT_DAMAGE = 10;
	public static final double INITIAL_BARBARIAN_DAMAGE = 15;

	public static final int KNIGHT_MAXHEALTH_INCREASE_PER_LEVEL = 30;
	public static final int ARCHER_MAXHEALTH_INCREASE_PER_LEVEL = 15;

	public static final int KNIGHT_INITIAL_MAXHEALTH = 300;
	public static final int ARCHER_INITIAL_MAXHEALTH = 300;


    public Profession(Character ch) {
        super(ch);
    }
    	
	@Override
	public QuestLog getQuestLog() {
		return questLog;
	}

	@Override
	public int getMaxHealth() {
		return character.getMaxHealth();
	}

	@Override
	public int getLevel() {
		return character.getLevel();
	}

	@Override
	public void setLevel(int level){
		character.setLevel(level);
	};

	@Override
    public Weapon getWeapon(){
    	return character.getWeapon();
	};

	@Override
	public double getDamage() {
		return character.getDamage();
	}

	@Override
	public void setDamage(double newDamage) {
		character.setDamage(newDamage);
	}

	@Override
	public void setMaxHealth(int i) {
		character.setMaxHealth(i);
	}

	@Override
	public void setWeapon(Weapon weapon){
		character.setWeapon(weapon);
	};

	protected abstract void setMaxHealthWithRegardsToLevel(); // how health is adjusted is a responsibility of each concrete profession


}
