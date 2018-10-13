package com.birdworld.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SinglePlayerRound {
	private Card playerCard;
	private Card opponentCard;
	private SinglePlayerGame game;
	private boolean playerHasAdvantage;
	private boolean playerHasWon = false;
	private boolean opponentHasWon = false;
	private boolean isDraw = false;
	private ArrayList<String> options = new ArrayList<String>();

	public SinglePlayerRound(Card playerCard, SinglePlayerGame game) {
		this.playerCard = playerCard;
		this.game = game;
		
		Random random = new Random();  
		
		int n = random.nextInt(game.getOpponent().getDeck().getSize()) + 0;
		
		opponentCard = game.getOpponent().getDeck().getCard(n);
		game.getOpponent().getDeck().removeCard(opponentCard);
		
		
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
	
	public void compareAttributes(int attributeIndex) {
		int playerAttribute = playerCard.getBirdAttribute(attributeIndex);
		int opponentAttribute = opponentCard.getBirdAttribute(attributeIndex);

		if (playerAttribute > opponentAttribute) {
			playerHasWon = true;	
			game.getPlayer().increaseScore();
		} else if (playerAttribute < opponentAttribute) {
			opponentHasWon = true;
			game.getOpponent().increaseScore();
		} else if (playerAttribute == opponentAttribute) {
			game.getPlayer().increaseScore();
			game.getOpponent().increaseScore();
		}
	}
	
	public void removePlayedCardsFromDecks() {
		game.getPlayer().getDeck().removeCard(playerCard);
		game.getOpponent().getDeck().removeCard(opponentCard);
	}
	
	public boolean getPlayerHasWon() {
		return playerHasWon;
	}
	
	public boolean getOpponentHasWon() {
		return opponentHasWon;
	}
	
	public boolean getIsDraw() {
		return isDraw;
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