package equipment;
public class Weapon extends Equipment {

	public enum WeaponType {ONEHANDEDSWORD(0.80), ONEHANDEDMACE(1.00), ONEHANDEDAXE(1.20), 
		TWOHANDEDSWORD(1.50), TWOHANDEDMACE(1.75), TWOHANDEDAXE(2.00); //Shield?/AttackSpeed?
		
		
		private double weaponDamageModifier;
		
		private WeaponType(double weaponDamageModifier) {
			this.weaponDamageModifier = weaponDamageModifier;
		}

		public double getWeaponDamageModifier() {
			return weaponDamageModifier;
		}
	
	}
	
	private static final double BASE_DAMAGE = 100.00;
	private WeaponType type;
	private double weaponDamage;

	public Weapon(WeaponType type, double mathRandom) {
		this(type, "randomname", mathRandom);
	}

	public Weapon(WeaponType type, String name) {
		this(type, name, Math.random());
	}

	// math random is for unit testing, to control
	public Weapon(WeaponType type, String name, double mathRandom) {
		super(name);
		this.type = type;
		this.weaponDamage = initializeWeaponDamageValue(mathRandom);
	}

	public WeaponType getWeaponType() {
		return this.type;
	}



	private double initializeWeaponDamageValue(double mathRandom) {
		return BASE_DAMAGE * this.type.getWeaponDamageModifier() + (1 + mathRandom * 50); //playerLevel kan också komma in här på lämpligt sätt.
		
	}

	public double getWeaponDamage() {
		return weaponDamage;
	}
}


