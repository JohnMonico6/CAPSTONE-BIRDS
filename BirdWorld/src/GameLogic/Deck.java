package GameLogic;

import java.util.ArrayList;
import GameLogic.Card;

public class Deck {
	ArrayList<Card> deck;
	
	public Deck() {
		deck = new ArrayList<Card>();
	}
	
	public boolean isEmpty() {
		if (deck.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void addCard(Card card) {
		deck.add(card);
	}
	
	public void removeCard(Card card) {
		deck.remove(card);
	}
}
