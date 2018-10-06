
package com.birdworld.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SinglePlayerRound {
	private Card playerCard;
	private Card opponentCard;
	private SinglePlayerGame game;
	private boolean playerHasAdvantage;
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
		ArrayList<String> newOptions = new ArrayList<String>();
		
		for (int i = 0; i < 3; i++) {
			
			
			int n = random.nextInt(game.getPile().pile.size()) + 0;
			
			String dummyUrl = game.getPileCard(n).getOptionImgSource();
			
			
			while (options.contains(dummyUrl)) {
				n = random.nextInt(game.getPile().pile.size()) + 0;
				
				String newUrl = game.getPileCard(n).getOptionImgSource();
				
				if (newUrl != dummyUrl) {
					dummyUrl = game.getPileCard(n).getOptionImgSource();
					break;
				}
			}
	
			options.add(dummyUrl);
		}	
		options.add(opponentCard.getOptionImgSource());
		Collections.swap(options, 3, random.nextInt(4));
	}
	
	public void checkIfPlayerCorrect(String optionImgSource) {
		if (optionImgSource.contains(opponentCard.getOptionImgSource())) {
			playerHasAdvantage = true;
		} else {
			playerHasAdvantage = false;
		}
	}
	
	public ArrayList getOptions() {
		return options;
	}
	
	public Card getOpponentCard() {
		return opponentCard;
	}
	
	public Card getPlayerCard() {
		return playerCard;
	}
	
	public boolean getPlayerAdvantage() {
		return playerHasAdvantage;
	}
	
	public void givePlayerAdvantage() {
		playerHasAdvantage = true;
	}
	
	public void giveOpponentAdvantage() {
		playerHasAdvantage = false;
	}
}