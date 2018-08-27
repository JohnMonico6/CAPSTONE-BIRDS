package GameLogic;

import java.util.ArrayList;

public class DrawHand {
	ArrayList<Card> drawHand;
	
	public DrawHand() {
		drawHand = new ArrayList<Card>();
	}
	
	public void addCard(Pile pile) {
		if(drawHand.size() < 3) {
			drawHand.add(pile.draw());
			System.out.print(drawHand.size());
		} else {
			System.out.print("Deck cannot have more than 3 cards.");
		}
	}
	
	public void removeCard(int index) {
		if(drawHand.size() > 0) {
			drawHand.remove(drawHand.get(index));
		} else {
			System.out.print("Cannot remove a card from empty deck.");
		}
	}
	
	public Card getCard(int index) {
		return drawHand.get(index);
	}
	
	public String[] displayCards(){
		String[] images = new String[3];
		int index = 0;
		
		for (Card card : drawHand) {
			images[index] = card.getImgSource();
		}
		
		return images;
	}
}
