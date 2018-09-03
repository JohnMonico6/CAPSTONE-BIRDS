package com.birdworld.client;

import java.util.ArrayList;

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
	
	public Card getCard(int index) {
		return deck.get(index);
	}
	
	public boolean isFull() {
		if (deck.size() >= 5) {
			return true;
		} else {
			return false;
		}
	}
}
