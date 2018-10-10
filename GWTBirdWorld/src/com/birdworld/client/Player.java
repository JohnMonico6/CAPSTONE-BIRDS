package com.birdworld.client;

import java.util.ArrayList;

public class Player {
	private String name;
	private Deck deck;
	private int score;
	private boolean winner;
	
	public Player(String name) {
		this.name = name;
		score = 0;
		winner = false;
		
		deck = new Deck();
	}
	
	public String getName() {
		return name;
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
		//System.out.print("Player is winner.");
<<<<<<< HEAD
=======
	}
	
	public void makeLoser() {
		winner = false;
		//System.out.print("Player is winner.");
	}
	
	public boolean isWinner() {
		return winner;
		//System.out.print("Player is winner.");
>>>>>>> bfe58d0155c72af02bcd23f95bd09fc60e43edb4
	}
	
	public void makeLoser() {
		winner = false;
		//System.out.print("Player is winner.");
	}
	
	public boolean isWinner() {
		return winner;
		//System.out.print("Player is winner.");
	}
}