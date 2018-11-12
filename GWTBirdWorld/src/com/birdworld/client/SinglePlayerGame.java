package com.birdworld.client;

import java.util.Random;


/**
 * Constructor Class that creates a SinglePlayerGame object.
 * 
 * @authors Luke Humphryes, John Monico.
 * @version 1.3
 *
 */
public class SinglePlayerGame {
	private Pile pile;
	private DrawHand drawHand;
	private Player player;
	private Player computer;
	private boolean drawingInProgress;
	private boolean gameOver = false;
	
	
	/**
	 * Constructs a single player game.
	 * 
	 * @param player The user.
	 */
	public SinglePlayerGame(Player player) {
		pile = new Pile();
		drawHand = new DrawHand();
		computer = new Player();
		
		this.player = player;
		
		drawHand.addCard(pile);
		drawHand.addCard(pile);
		drawHand.addCard(pile);
		
		drawingInProgress = true;
	}
	
	
	/**
	 * Gets the game's draw hand.
	 * 
	 * @return drawHand Returns the game's draw hand.
	 */
	public DrawHand getDrawHand() {
		return drawHand;
	}
	
	
	/**
	 * Adds the card selected from the draw hand to the player's deck
	 * and removes it from the draw hand.
	 * 
	 * @param index The position of the selected draw hand card.
	 */
	public void playerSelectedCard(int index) {
		player.addCardToDeck(drawHand.getCard(index));
		
		drawHand.removeCard(index);
		drawHand.addCard(pile);
		drawHand.switchNewCard(index);
		
		if (player.getDeck().isFull() == true) {
			drawingInProgress = false;
		}
	}
	
	
	/**
	 * If the game is over, then check to see if the player or opponent
	 * has won or if it is a draw.
	 * 
	 */
	public void checkForVictory() {
		//The game is over when the player and opponent's decks are empty.
		boolean playerDeckEmpty = player.getDeck().isEmpty();
		boolean computerDeckEmpty = computer.getDeck().isEmpty();
		if (computerDeckEmpty == true) {
			if (player.getScore() < computer.getScore()) {
				computer.makeWinner();
			} else if (player.getScore() > computer.getScore()) {
				player.makeWinner();
			} else if (player.getScore() == computer.getScore()){
				player.makeWinner();
				computer.makeWinner();
			}
		}
	}
	
	
	/**
	 * Gets the player.
	 * 
	 * @return player The player.
	 */
	public Player getPlayer() {
		return player;
	}
	
	
	/**
	 * Gets the computer.
	 * 
	 * @return computer The computer.
	 */
	public Player getOpponent() {
		return computer;
	}
	
	
	/**
	 * Get the drawing status.
	 * 
	 * @return drawingInProgress The progress of the game's drawing phase.
	 */
	public boolean getDrawingStatus() {
		return drawingInProgress;
	}
	
	
	/**
	 * Gets the game's pile of cards.
	 * 
	 * @return pile The pile of cards.
	 */
	public Pile getPile() {
		return pile;
	}
	
	
	/**
	 * Gets a card from the game's pile at a specified position.
	 * 
	 * @param index The position of the desired card.
	 * @return The card at the specified index.
	 */
	public Card getPileCard(int index) {
		return pile.getCard(index);
	}
	
	
	/**
	 * Builds a full deck of randomly drawn cards from the pile 
	 * for the computer.
	 * 
	 */
	public void buildComputerDeck() {
		while (computer.getDeck().isFull() == false) {
			Random random = new Random();  
			
			int n = random.nextInt(drawHand.getSize()) + 0;
			
			computer.addCardToDeck(drawHand.getCard(n));
			drawHand.removeCard(n);
			drawHand.addCard(pile);
		}
	}
}