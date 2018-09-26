package com.birdworld.client;
public class Card {
	
	private String birdName;
	private int[] attributes = new int[5];
	private String cardImgSource;
	private String optionImgSource;
	
	public Card(String birdName, int[] attributes, String cardImgSource, String optionImgSource) {
		this.birdName = birdName;
		this.attributes = attributes;
		this.cardImgSource = cardImgSource;
		this.optionImgSource = optionImgSource;
	}
	
	public String getName() {
		return birdName;
	}
	
	public int getBirdAttribute(int index) {
		return attributes[index];
	}
	
	public String getCardImgSource() {
		return cardImgSource;
	}
	
	public String getOptionImgSource() {
		return optionImgSource;
	}
}
