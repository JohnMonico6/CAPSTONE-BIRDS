package com.birdworld.client;

import java.util.ArrayList;
import java.util.Collections;

import com.birdworld.client.Pile;


/**
 * Constructor Class that creates a DrawHand object.
 * 
 * @authors Luke Humphryes, John Monico.
 * @version 1.2
 *
 */
public class DrawHand {
	ArrayList<Card> drawHand;
	final int NEW_CARD_INDEX = 2;
	
	
	/**
	 * Constructs an empty draw hand object.
	 * 
	 */
	public DrawHand() {
		drawHand = new ArrayList<Card>();
	}
	
	
	/**
	 * Adds a card from a specified pile of cards.
	 * 
	 * @param pile The desired pile of cards to draw from.
	 */
	public void addCard(Pile pile) {
		if(drawHand.size() < 3) {
			drawHand.add(pile.draw());
		} else {
			System.out.print("Deck cannot have more than 3 cards.");
		}
	}
	
	
	/**
	 * Removes a card from a specified index of the draw hand.
	 * 
	 * @param index
	 */
	public void removeCard(int index) {
		if(drawHand.size() > 0) {
			drawHand.remove(drawHand.get(index));
		} else {
			System.out.print("Cannot remove a card from empty deck.");
		}
	}
	
	
	/**
	 * Gets the card positioned at a specified index.
	 * 
	 * @param index The position of the desired card.
	 * @return The card locted at the given index.
	 */
	public Card getCard(int index) {
		return drawHand.get(index);
	}
	
	
	/**
	 * 
	 * 
	 * @param index
	 */
	public void switchNewCard(int index) {
		if (index == 0) {
			Collections.swap(drawHand, index, NEW_CARD_INDEX);
			Collections.swap(drawHand, index + 1, index + 2);
		} else {
			Collections.swap(drawHand, index, NEW_CARD_INDEX);
		}
		
	}
	
	
	/**
	 * Gets the amount of cards in the draw hand.
	 * 
	 * @return Returns the amount of cards in draw hand.
	 */
	public int getSize() {
		return drawHand.size();
	}
}
