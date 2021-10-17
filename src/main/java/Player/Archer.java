package Player;

public class Archer extends Profession {
    public Archer(Character ch) {
        super(ch);
        character.setDamage(character.getDamage() * 2);
    }

    public int getHealth(){
        return character.getHealth();
    }

    @Override
    public int getDamage() {
        return character.getDamage();
    }

    @Override
    public void setDamage(int newDamage) {
        character.setDamage(newDamage);
    }

    @Override
    public void setHealth(int newHealth) {
        character.setHealth(newHealth);
    }
}
