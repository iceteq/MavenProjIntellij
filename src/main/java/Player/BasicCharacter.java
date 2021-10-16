package Player;

public abstract class BasicCharacter implements Character {
    int health;

    public BasicCharacter(int health) {
        this.health = health;
    }

    public BasicCharacter() {
        this(0);
    }

    public int getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(int newHealth) {
        this.health = newHealth;
    }

    @Override
    public String toString() {
        return "BasicCharacter{}";
    }
}
