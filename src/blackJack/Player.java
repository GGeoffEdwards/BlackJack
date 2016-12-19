package blackJack;

public class Player {
	
	private String name;
	Hand hand;
	
	public Player(String name) {
		this.name = name;
		this.hand = new Hand();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
