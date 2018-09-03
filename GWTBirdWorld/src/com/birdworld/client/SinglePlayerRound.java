package com.birdworld.client;

public class SinglePlayerRound {
	private Pile pile;
	private DrawHand drawHand;
	private Player player;
	private Player computer;
	
	public SinglePlayerRound(Player player) {
		pile = new Pile();
		drawHand = new DrawHand();
		computer = new Player("Bird Master");
		
		this.player = player;
		
		drawHand.addCard(pile);
		drawHand.addCard(pile);
		drawHand.addCard(pile);
	}
	
	public DrawHand getDrawHand() {
		return drawHand;
	}
	
	public void playerSelectedCard(int index) {
		player.addCardToDeck(drawHand.getCard(index));
		
		drawHand.removeCard(index);
		drawHand.addCard(pile);
	}
	
	public void checkForVictor() {
		boolean playerDeckEmpty = player.getDeck().isEmpty();
		boolean computerDeckEmpty = computer.getDeck().isEmpty();
		
		if (playerDeckEmpty == true && computerDeckEmpty == true) {
			if (player.getScore() < computer.getScore()) {
				computer.isWinner();
			} else if (player.getScore() > computer.getScore()) {
				player.isWinner();
			}
		}
	}
	
	public Player getPlayer() {
		return player;
	}
}
