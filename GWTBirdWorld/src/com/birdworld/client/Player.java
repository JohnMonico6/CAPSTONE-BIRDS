package com.birdworld.client;

import java.util.ArrayList;
import java.util.Random;

public class Player {
	private String name;
	private Deck deck;
	private int score;
	private boolean winner;
	private int attributeIndex;
	
	final private int NUM_OF_ATTRIBUTES = 5;
	
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
	}
	
	public void makeLoser() {
		winner = false;
		//System.out.print("Player is winner.");
	}
	
	public boolean isWinner() {
		return winner;
		//System.out.print("Player is winner.");
	}
	
	public void randomlySelectAttribute() {
		Random random = new Random();
		int newIndex = random.nextInt(NUM_OF_ATTRIBUTES - 1) + 0;

		attributeIndex = newIndex;
	}
}