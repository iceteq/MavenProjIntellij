package Player;

public class Archer extends Profession {
    public Archer(Character ch) {
        super(ch);
    }

    public int getHealth(){
        return character.getHealth() + 0;
    }

    @Override
    public void setHealth(int newHealth) {
        character.setHealth(newHealth);
    }
}
