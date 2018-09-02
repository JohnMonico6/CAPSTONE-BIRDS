package com.birdworld.client;
public class Card {
	
	private String birdName;
	private int[] attributes = new int[5];
	private String imgSource;
	
	public Card(String birdName, int[] attributes, String imgSource) {
		this.birdName = birdName;
		this.attributes = attributes;
		this.imgSource = imgSource;
	}
	
	public String getName() {
		return birdName;
	}
	
	public int getBirdAttribute(int index) {
		return attributes[index];
	}
	
	public String getImgSource() {
		return imgSource;
	}
}
