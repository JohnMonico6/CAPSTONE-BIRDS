package com.birdworld.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


/**
 * Constructor Class that creates a SinglePlayerRound object.
 * 
 * @authors Luke Humphryes, John Monico.
 * @version 1.6
 *
 */
public class SinglePlayerRound {
	private Card playerCard;
	private Card opponentCard;
	private SinglePlayerGame game;
	private boolean playerHasAdvantage;
	private boolean playerHasWon = false;
	private boolean opponentHasWon = false;
	private boolean isDraw = false;
	private ArrayList<String> options = new ArrayList<String>();

	
	/**
	 * Constructs a single player round.
	 * 
	 * @param playerCard The player's played card.
	 * @param game The game which the round occurs in.
	 */
	public SinglePlayerRound(Card playerCard, SinglePlayerGame game) {
		this.playerCard = playerCard;
		this.game = game;
		
		Random random = new Random();  
		
		int n = random.nextInt(game.getOpponent().getDeck().getSize()) + 0;
		
		opponentCard = game.getOpponent().getDeck().getCard(n);
		game.getOpponent().getDeck().removeCard(opponentCard);
		
		
	}
	
	
	/**
	 * Creates four options for the player to choose from. One of them
	 * is the bird that owns the played bird call while the others are
	 * randomly selected.
	 * 
	 */
	public void createOptions() {
		Random random = new Random();
		
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
		Collections.swap(options, 3, random.nextInt(3));
	}
	
	
	/**
	 * Checks if player has selected the correct bird from the four
	 * options given. If the image source of the image matches the one
	 * constructed with the opponents card, then the player is given the
	 * advantage, otherwise, the opponent is given the advantage. 
	 * 
	 * @param optionImgSource The source of the option image selected. 
	 */
	public void checkIfPlayerCorrect(String optionImgSource) {
		if (optionImgSource.contains(opponentCard.getOptionImgSource())) {
			playerHasAdvantage = true;
		} else {
			playerHasAdvantage = false;
		}
	}
	
	
	/**
	 * Compares the opponents score and the player's score of the selected
	 * attribute.
	 * 
	 * @param attributeIndex The position of the selected attribute.
	 */
	public void compareAttributes(int attributeIndex) {
		int playerAttribute = playerCard.getAttribute(attributeIndex);
		int opponentAttribute = opponentCard.getAttribute(attributeIndex);

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

	
	/**
	 * Chooses the attribute with the highest score for the opponent 
	 * should they have the advantage.
	 * 
	 * @return largest The attribute with the highest score.
	 */
	public int opponentChoosesAttribute() {
		int[] array = opponentCard.getAttributes();
		
		int largest = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[largest] ) largest = i;
		}
		return largest;
	}
	
	
	/**
	 * Gets playerHasWon.
	 * 
	 * @return playerHasWon.
	 */
	public boolean getPlayerHasWon() {
		return playerHasWon;
	}
	
	
	/**
	 * Gets opponentHasWon.
	 * 
	 * @return opponentHasWon.
	 */
	public boolean getOpponentHasWon() {
		return opponentHasWon;
	}
	
	
	/**
	 * Gets isDraw.
	 * 
	 * @return isDraw.
	 */
	public boolean getIsDraw() {
		return isDraw;
	}
	
	
	/**
	 * Gets array of options.
	 * 
	 * @return options The array of options.
	 */
	public ArrayList getOptions() {
		return options;
	}
	
	
	/**
	 * Gets the opponent's played card for the round.
	 * 
	 * @return opponentCard The opponents played card.
	 */
	public Card getOpponentCard() {
		return opponentCard;
	}
	
	
	/**
	 * Gets the player's played card for the round.
	 * 
	 * @return playerCard The player's played card.
	 */
	public Card getPlayerCard() {
		return playerCard;
	}
	
	
	/**
	 * Gets playerHasAdvantage.
	 * 
	 * @return playerHasAdvantage.
	 */
	public boolean getPlayerAdvantage() {
		return playerHasAdvantage;
	}
	
	
	/**
	 * Gives the player the advantage.
	 * 
	 */
	public void givePlayerAdvantage() {
		playerHasAdvantage = true;
	}
	
	
	/**
	 * Gives the opponent the advantage.
	 * 
	 */
	public void giveOpponentAdvantage() {
		playerHasAdvantage = false;
	}
}