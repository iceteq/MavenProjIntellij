package Player;

/**
 *
 */
public class Knight extends Profession {

    public Knight(Character ch) {
        super(ch);
    }

    public int getHealth(){
        return character.getHealth();
    }

    @Override
    public void setHealth(int newHealth) {
        character.setHealth(newHealth);
    }
}
