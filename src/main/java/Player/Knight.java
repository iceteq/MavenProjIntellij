package Player;

/**
 *
 */
public class Knight extends Profession {

    public Knight(Character ch) {
        super(ch);
        character.setHealth(character.getHealth() * 2);
    }

    public int getHealth(){
        return character.getHealth();
    }
    public int getDamage(){
        return character.getDamage();
    }

    @Override
    public void setDamage(int newDamage) {
        
    }

    @Override
    public void setHealth(int newHealth) {
        character.setHealth(newHealth);
    }





}
