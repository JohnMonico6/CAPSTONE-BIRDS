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
	
	public void isWinner() {
		winner = true;
	}
}
