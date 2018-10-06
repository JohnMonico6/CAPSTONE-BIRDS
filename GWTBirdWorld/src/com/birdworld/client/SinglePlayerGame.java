package com.birdworld.client;

import java.util.Random;

public class SinglePlayerGame {
	private Pile pile;
	private DrawHand drawHand;
	private Player player;
	private Player computer;
	private boolean drawingInProgress;
	private final int MAX_DECK_SIZE = 5;
	private boolean gameOver = false;
	
	public SinglePlayerGame(Player player) {
		pile = new Pile();
		drawHand = new DrawHand();
		computer = new Player("Bird Master");
		
		this.player = player;
		
		drawHand.addCard(pile);
		drawHand.addCard(pile);
		drawHand.addCard(pile);
		
		drawingInProgress = true;
	}
	
	public DrawHand getDrawHand() {
		return drawHand;
	}
	
	public void playerSelectedCard(int index) {
		player.addCardToDeck(drawHand.getCard(index));
		
		drawHand.removeCard(index);
		drawHand.addCard(pile);
		drawHand.switchNewCard(index);
		
		if (player.getDeck().isFull() == true) {
			drawingInProgress = false;
		}
	}
	
	public void checkForVictory() {
		boolean playerDeckEmpty = player.getDeck().isEmpty();
		boolean computerDeckEmpty = computer.getDeck().isEmpty();
		if (computerDeckEmpty == true) {
			if (player.getScore() < computer.getScore()) {
				computer.makeWinner();
				//Display Computer is Winner
				//System.out.print('PLAYER HAS WON!');
			} else if (player.getScore() > computer.getScore()) {
				player.makeWinner();
				//Display Player is Winner
				//System.out.print('PLAYER HAS WON!');
			} else if (player.getScore() == computer.getScore()){
				player.makeWinner();
				computer.makeWinner();
			}
		}
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Player getOpponent() {
		return computer;
	}
	
	public boolean getDrawingStatus() {
		return drawingInProgress;
	}
	
	public Pile getPile() {
		return pile;
	}
	
	public Card getPileCard(int index) {
		return pile.getCard(index);
	}
	
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