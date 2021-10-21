package Player;

import javax.swing.plaf.basic.BasicIconFactory;

class Player extends BasicCharacter {


	@Override
	public String toString() {
		return "Player{}";
	}

	@Override
	public void setLevel(int level) {
		this.level = level;
		setMaxHealthWithRegardsToLevel();
	}

	private void setMaxHealthWithRegardsToLevel() {
		this.maxHealth = 300 + this.getLevel() * 5;
	}

}
