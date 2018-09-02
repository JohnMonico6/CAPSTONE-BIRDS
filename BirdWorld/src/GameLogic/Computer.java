package GameLogic;

public class Computer {
	private int score;
	private Deck deck;
	
	public Computer() {
		score = 0;
		
		this.deck = new Deck();
	}
	
	public void increaseScore() {
		score++;
	}
	
	public Deck getDeck() {
		return deck;
	}
	
	public int getScore() {
		return score;
	}
	
	public void drawCard(Pile pile) {
		Card drawnCard = pile.draw();
		
		deck.addCard(drawnCard);
	}
	
	public void removeCard(Card card) {
		deck.removeCard(card);
	}
}
