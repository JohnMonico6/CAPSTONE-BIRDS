package com.birdworld.client;

import java.util.ArrayList;
import java.util.Collections;

import com.birdworld.client.Pile;

public class DrawHand {
	ArrayList<Card> drawHand;
	final int NEW_CARD_INDEX = 2;
	
	public DrawHand() {
		drawHand = new ArrayList<Card>();
	}
	
	public void addCard(Pile pile) {
		if(drawHand.size() < 3) {
			drawHand.add(pile.draw());
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
	
	public void switchNewCard(int index) {
		if (index == 0) {
			Collections.swap(drawHand, index, NEW_CARD_INDEX);
			Collections.swap(drawHand, index + 1, index + 2);
		} else {
			Collections.swap(drawHand, index, NEW_CARD_INDEX);
		}
		
	}
	
	public int getSize() {
		return drawHand.size();
	}
}
