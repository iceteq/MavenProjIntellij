package Player;

import equipment.Weapon;

public abstract class BasicCharacter implements Character {
    int health;
    double damage;
    Weapon weapon;

    public BasicCharacter(int health) {
        this.health = health;
        this.damage = 100.0;
    }

    public BasicCharacter() {
        this(0);
    }

    public int getHealth() {
        return this.health;
    }
    public double getDamage() {
        return this.damage;
    }

    @Override
    public void setHealth(int newHealth) {
        this.health = newHealth;
    }
    @Override
    public void setDamage(double newDamage) {
        this.damage = newDamage;
    }

    @Override
    public String toString() {
        return "BasicCharacter{}";
    }
}
