package Player;

public class Player extends CharacterDecorator {
	
	public Player(Character c) {
		super(c);
		c.changeHealth(100);
	}

	@Override
	public String getDescription() {
		return this.character.getDescription() + "Player.";
	}

	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return this.character.getHealth();
	}

	@Override
	public void changeHealth(int newHealth) { //Här skulle man kunna passera en metod(från t.ex. magi-klassen) som tar spelarens nuvarande hälsa och beräknar ett nytt värde efter att skada har gjorts
		this.character.changeHealth(newHealth);
		
	}





}
