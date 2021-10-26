package Player;

import javax.swing.plaf.basic.BasicIconFactory;

class Player extends BasicCharacter {


	@Override
	public String toString() {
		return "Player{}";
	}

	@Override
	public void setLevelAndOtherStats(int level) {
		this.level = level;
		setMaxHealthWithRegardToLevel();
	}



}
