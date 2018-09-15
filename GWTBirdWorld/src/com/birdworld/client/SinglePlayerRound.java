package com.birdworld.client;

import java.util.Random;

public class SinglePlayerRound {
	private Card playerCard;
	private Card opponentCard;
	private SinglePlayerGame game;

	public SinglePlayerRound(Card playerCard, SinglePlayerGame game) {
		this.playerCard = playerCard;
		
		Random random = new Random();  
		
		int n = random.nextInt(game.getOpponent().getDeck().getSize() - 1) + 0;
		
		opponentCard = game.getOpponent().getDeck().getCard(n);
	}
	
	public Card getOpponentCard() {
		return opponentCard;
	}
}
