package equipment;

public class Armor extends Equipment {
	
	public enum ArmorType {PLATE(1.00), MAIL(0.75), LEATHER(0.5), CLOTH(0.25);
		
		private double armorTypeModifier;

		private ArmorType(double armorTypeModifier) {
			this.armorTypeModifier = armorTypeModifier;
		}

		public double getArmorTypeModifier() {
			return armorTypeModifier;
		}
	
	}
	
	public enum ArmorPiece {HEAD(1.15), SHOULDERS(1.15), GLOVES(1.05), BOOTS(1.05), BELT(1.05), LEGS(1.25), CHEST(1.3); //Shield?
		
		private double armorPieceModifier;
		
		private ArmorPiece(double armorPieceModifier) {
			this.armorPieceModifier = armorPieceModifier;
		}

		public double getArmorPieceModifier() {
			return armorPieceModifier;
		}		
	
	} 
	
	private static final double BASE_ARMOR_VALUE = 1000.00;
	private ArmorType type;
	private ArmorPiece piece;
	private double armorValue;
	
	public Armor(String name, ArmorType type, ArmorPiece piece) {
		super(name);
		this.type = type;
		this.piece = piece;
		this.armorValue = initialiseArmorValue();
	}

	public ArmorType getType() {
		return type;
	}

	public ArmorPiece getPiece() {
		return piece;
	}
	
	private double initialiseArmorValue() {
		return BASE_ARMOR_VALUE * this.type.getArmorTypeModifier() * this.piece.getArmorPieceModifier() + ( 100 + Math.random() * 500); //playerLevel kan också komma in här på lämpligt sätt.
	}

	public double getArmorValue() {
		return armorValue;
	}
}
