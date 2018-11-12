package com.birdworld.client;

import java.util.ArrayList;


/**
 * Constructor Class that creates a Deck object.
 * 
 * @authors Luke Humphryes, John Monico.
 * @version 1.2
 *
 */
public class Deck {
	ArrayList<Card> deck;
	
	
	/**
	 * Constructs an empty deck of cards.
	 * 
	 */
	public Deck() {
		deck = new ArrayList<Card>();
	}
	
	
	/**
	 * Checks if deck is empty.
	 * 
	 * @return Returns true if deck is empty.
	 */
	public boolean isEmpty() {
		if (deck.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * Adds a specified card to the deck.
	 * 
	 * @param card The desired card to add to the deck.
	 */
	public void addCard(Card card) {
		deck.add(card);
	}
	
	
	/**
	 * Removes a specified card from the deck.
	 * 
	 * @param card The desired card to remove from the deck.
	 */
	public void removeCard(Card card) {
		deck.remove(card);
	}
	
	
	/**
	 * Gets the card at the specified index from the deck.
	 * 
	 * @param index The position to retrieve the card from.
	 * @return The card at the given index.
	 */
	public Card getCard(int index) {
		return deck.get(index);
	}
	
	
	/**
	 * Checks if card is full.
	 * 
	 * @return Returns true if the deck is full.
	 */
	public boolean isFull() {
		if (deck.size() >= 5) {
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * Gets the amount of cards in the deck.
	 * 
	 * @return The amount of cards in the deck.
	 */
	public int getSize() {
		return deck.size();
	}
	
	
	/**
	 * Gets the position of a specified card.
	 * 
	 * @param card The card to find the index of.
	 * @return The index of the specified card.
	 */
	public int getCardPositon(Card card) {
		return deck.indexOf(card);
	}
}