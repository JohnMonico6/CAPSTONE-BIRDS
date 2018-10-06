package com.birdworld.client;

import com.birdworld.client.Pile;

public class Computer {
	private int score;
	private Deck deck;
	private boolean winner;
	
	public Computer() {
		score = 0;
		winner = false;
		
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
	
	public void addCardToDeck(Card card) {
		deck.addCard(card);
	}
	
	public void removeCardFromDeck(Card card) {
		if (deck.isEmpty() == false) {
			deck.removeCard(card);
		} else {
			System.out.print("Cannot remove card from empty deck.");
		}
	}
	
	public void makeWinner() {
		winner = true;
		//System.out.print("Computer is winner.");
	}
	
	public boolean isWinner() {
		return winner;
		//System.out.print("Player is winner.");
	}
}
