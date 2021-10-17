package Player;

public abstract class BasicCharacter implements Character {
    int health;
    int damage;

    public BasicCharacter(int health) {
        this.health = health;
    }

    public BasicCharacter() {
        this(0);
    }

    public int getHealth() {
        return this.health;
    }
    public int getDamage() {
        return this.damage;
    }

    @Override
    public void setHealth(int newHealth) {
        this.health = newHealth;
    }
    @Override
    public void setDamage(int newDamage) {
        this.damage = newDamage;
    }

    @Override
    public String toString() {
        return "BasicCharacter{}";
    }
}
