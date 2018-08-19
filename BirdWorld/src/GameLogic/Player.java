package GameLogic;

public class Player {
	private String name;
	private Deck deck;
	private Pile pile;
	private DrawHand drawHand;
	private int score;
	private int maxDrawHandSize = 3;
	
	public Player(String name) {
		this.name = name;
		
		deck = new Deck();
		pile = new Pile();
		drawHand = new DrawHand();
		
		drawHand.addCard(pile);
		drawHand.addCard(pile);
		drawHand.addCard(pile);
		
	}
	
	public void increaseScore() {
		score++;
	}
	
	public Deck getDeck() {
		return deck;
	}
	
	public DrawHand getDrawHand() {
		return drawHand;
	}
	
	public int getScore() {
		return score;
	}
}
