package GameLogic;

import java.util.ArrayList;
import java.util.Collections;

public class Pile {
	ArrayList<Card> pile;
	int numOfCards = 10;
	
	/**
	 * 
	 * Currently all cards are hard coded.
	 * In future set code to draw cards from server.
	 * 
	 */
	public Pile() {
		pile = new ArrayList<Card>();
		
		int[] birdAtr = {1, 2, 3, 4, 5};
		
		Card wattleBird = new Card("Wattle Bird", birdAtr, "images/WattleBird.png");
		Card wedgeTailEagle = new Card("Wedge-Tail Eagle", birdAtr, "images/WedgeTailEagle.png");
		Card easternBristleBird = new Card("Eastern Bristle Bird", birdAtr, "images/EasternBristleBird.png");
		
		pile.add(wattleBird);
		pile.add(easternBristleBird);
		pile.add(wedgeTailEagle);
	}
	
	public void shuffle() {
		Collections.shuffle(pile);
	}
	
	public Card draw() {
		Card drawnCard;
		
		Collections.shuffle(pile);
		drawnCard = pile.get(0);
		pile.remove(drawnCard);
		
		return drawnCard;
	}
}
