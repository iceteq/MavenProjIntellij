import java.util.ArrayList;

public class Player {
	private int health;
	private int mana;
	private int armor;
	private PlayerClass playerClass;
	private ArrayList<Equipment> playersEquipment = new ArrayList<>();
	Player(PlayerClass playerClass) {
		this.playerClass = playerClass;
//		this.health = playerClass.getHealth();
//		this.mana = playerClass.getMana();
//		this.armor = playerClass.getArmor();
		// test, eclipse, anton
	}
	
	public void equipArmor(Equipment armorToEquip) {
		this.playersEquipment.add(armorToEquip);
	}
	
}
