
package com.birdworld.client;

import java.util.ArrayList;
import java.util.Random;

public class SinglePlayerRound {
	private Card playerCard;
	private Card opponentCard;
	private SinglePlayerGame game;
	private boolean opponentHasAdvantage = false;
	private boolean playerHasAdvantage = false;
	private ArrayList<String> options = new ArrayList<String>();

	public SinglePlayerRound(Card playerCard, SinglePlayerGame game) {
		this.playerCard = playerCard;
		this.game = game;
		
		Random random = new Random();  
		
		int n = random.nextInt(game.getOpponent().getDeck().getSize()) + 0;
		
		opponentCard = game.getOpponent().getDeck().getCard(n);
	}
	
	public void createOptions() {
		Random random = new Random();  
		
		for (int i = 0; i < 3; i++) {
			
			int n = random.nextInt(game.getPile().pile.size()) + 0;
			
			String dummyUrl = game.getPileCard(n).getOptionImgSource();
			
			/*
			while (options.contains(dummyUrl)) {
				String newUrl = game.getPileCard(n).getOptionImgSource();
				
				if (newUrl != dummyUrl) {
					dummyUrl = game.getPileCard(n).getOptionImgSource();
					break;
				}
			}*/
	
			options.add(dummyUrl);
		}
		
		options.add(opponentCard.getOptionImgSource());
	}
	
	public void checkIfPlayerCorrect(String optionImgSource) {
		if (optionImgSource == opponentCard.getCardImgSource()) {
			playerHasAdvantage = true;
		} else {
			opponentHasAdvantage = true;
		}
	}
	
	public ArrayList getOptions() {
		return options;
	}
	
	public Card getOpponentCard() {
		return opponentCard;
	}
	
	public void givePlayerAdvantage() {
		playerHasAdvantage = true;
	}
	
	public void giveOpponentAdvantage() {
		opponentHasAdvantage = true;
	}
}