package GameLogic;

import java.util.ArrayList;
import GameLogic.Card;

public class Deck {
	ArrayList<Card> deck;
	
	public Deck() {
		deck = new ArrayList<Card>();
	}
	
	public void addCard(Card card) {
		deck.add(card);
	}
	
	public void deleteCard(Card card) {
		deck.remove(card);
	}
}
