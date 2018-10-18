package com.birdworld.client;
public class Card {
	
	private String birdName;
	private int[] attributes = new int[5];
	private String cardImgSrc;
	private String optionImgSrc;
	private String audioSrc;
	
	public Card(String birdName, int[] attributes, String cardImgSrc, String optionImgSrc, String audioSrc) {
		this.birdName = birdName;
		this.attributes = attributes;
		this.cardImgSrc = cardImgSrc;
		this.optionImgSrc = optionImgSrc;
		this.audioSrc = audioSrc;
	}
	
	public String getName() {
		return birdName;
	}
	
	public int getAttribute(int index) {
		return attributes[index];
	}
	
	public String getCardImgSource() {
		return cardImgSrc;
	}
	
	public String getOptionImgSource() {
		return optionImgSrc;
	}
	
	public String getAudioSource() {
		return audioSrc;
	}
	
	public int[] getAttributes() {
		return attributes;
	}
}
