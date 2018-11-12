package com.birdworld.client;


/**
 * Constructor Class that creates a Card object.
 * 
 * @authors Luke Humphryes, John Monico.
 * @version 1.2
 *
 */
public class Card {
	
	private String birdName;
	private int[] attributes = new int[5];
	private String cardImgSrc;
	private String optionImgSrc;
	private String audioSrc;
	
	/**
	 * Constructs a card object.
	 * 
	 * @param birdName The name of the bird.
	 * @param attributes The attributes points assigned to the bird.
	 * @param cardImgSrc The directory for the card's image. 
	 * @param optionImgSrc The directory for the image used for the option.
	 * @param audioSrc The directory for the audio file associated with the bird.
	 */
	public Card(String birdName, int[] attributes, String cardImgSrc, 
			String optionImgSrc, String audioSrc) {
		this.birdName = birdName;
		this.attributes = attributes;
		this.cardImgSrc = cardImgSrc;
		this.optionImgSrc = optionImgSrc;
		this.audioSrc = audioSrc;
	}
	
	
	/**
	 * Gets the name of the bird on the card.
	 * 
	 * @return birdName The name of the bird.
	 */
	public String getName() {
		return birdName;
	}
	
	
	/**
	 * Gets the score of the attribute at the specified index.
	 * 
	 * @param index The index of the desired attribute.
	 * @return attribute[index] The attribute at the specified index.
	 */
	public int getAttribute(int index) {
		return attributes[index];
	}
	
	
	/**
	 * Gets the source of the card's image.
	 * 
	 * @return cardImgSrc The source of the card's image.
	 */
	public String getCardImgSource() {
		return cardImgSrc;
	}
	
	
	/**
	 * Get the source of the bird's option image.
	 * 
	 * @return optionImgSrc The source of the option image.
	 */
	public String getOptionImgSource() {
		return optionImgSrc;
	}
	
	
	/**
	 * Get the source of the card's audio file.
	 * 
	 * @return audioSrc The source of the audio file.
	 */
	public String getAudioSource() {
		return audioSrc;
	}
	
	
	/**
	 * Get all the attribute scores assigned to the card.
	 * 
	 * @return attributes The attribute scores assigned to the card.
	 */
	public int[] getAttributes() {
		return attributes;
	}
}
