package com.birdworld.client;

import java.util.ArrayList;
import java.util.Random;


/**
 * Constructor Class that creates a Player object.
 * 
 * @authors Luke Humphryes, John Monico.
 * @version 1.6
 *
 */
public class Player {
	private String name;
	private Deck deck;
	private int score;
	private boolean winner;
	
	
	/**
	 * Constructs a player object.
	 * 
	 */
	public Player() {
		score = 0;
		winner = false;
		
		deck = new Deck();
	}
	
	
	/**
	 * Increases the player's score.
	 * 
	 */
	public void increaseScore() {
		score++;
	}
	
	
	/**
	 * Gets the players deck of cards.
	 * 
	 * @return deck The players deck of cards.
	 */
	public Deck getDeck() {
		return deck;
	}
	
	
	/**
	 * Gets the player's score.
	 * 
	 * @return score Returns the player's score.
	 */
	public int getScore() {
		return score;
	}
	
	
	/**
	 * Adds a card to the players deck.
	 * 
	 * @param card The desired card to add to the player's deck.
	 */
	public void addCardToDeck(Card card) {
		deck.addCard(card);
	}
	
	
	/**
	 * Remove specified card from player's deck.
	 * 
	 * @param card
	 */
	public void removeCardFromDeck(Card card) {
		if (deck.isEmpty() == false) {
			deck.removeCard(card);
		} else {
			System.out.print("Cannot remove card from empty deck.");
		}
	}
	
	
	/**
	 * Specify that the player has won the game.
	 * 
	 */
	public void makeWinner() {
		winner = true;
	}
	
	
	/**
	 * Check if player has won the game.
	 * 
	 * @return
	 */
	public boolean isWinner() {
		return winner;
	}
}