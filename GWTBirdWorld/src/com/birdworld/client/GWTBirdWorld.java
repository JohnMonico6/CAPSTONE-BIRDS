package com.birdworld.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.birdworld.client.Player;

public class GWTBirdWorld implements EntryPoint {

	//create images
	Image cardLeft = new Image();
	Image cardMiddle = new Image();
	Image cardRight = new Image();
	Image deckCard1 = new Image();
	Image deckCard2 = new Image(); 
	Image deckCard3 = new Image(); 
	Image deckCard4 = new Image(); 
	Image deckCard5 = new Image(); 
	   
	//Initialize player
	Player player1 = new Player("TheLegend27");
	   
	//Initialize SinglePlayerRound
	SinglePlayerRound round = new SinglePlayerRound(player1);
	
	//create button
	Button playBtn = new Button("Play!");	   
	   
	public void onModuleLoad() {
	   
	   //Format draw cards
	   cardLeft.setWidth("230px");
	   cardLeft.setHeight("320px");
	   cardMiddle.setWidth("230px");
	   cardMiddle.setHeight("320px");
	   cardRight.setWidth("230px");
	   cardRight.setHeight("320px");
	   
	   //Format deck cards
	   deckCard1.setWidth("172.5px");
	   deckCard1.setHeight("240px");
	   deckCard2.setWidth("172.5px");
	   deckCard2.setHeight("240px");
	   deckCard3.setWidth("172.5px");
	   deckCard3.setHeight("240px");
	   deckCard4.setWidth("172.5px");
	   deckCard4.setHeight("240px");
	   deckCard5.setWidth("172.5px");
	   deckCard5.setHeight("240px");
	   
	   playBtn.addStyleName("PlayButton");
	   playBtn.setWidth("100px");
	   
	   //add a clickListener to the button
	   playBtn.addClickHandler(new ClickHandler() {
		   @Override
		   public void onClick(ClickEvent event) {	        	 
			   
			   Document.get().getElementById("GameTitleScreen").getStyle().setDisplay(Display.NONE);
			   
			   Document.get().getElementById("GameBoard").getStyle().setDisplay(Display.BLOCK);
			   
			   Document.get().getElementById("Deck").getStyle().setDisplay(Display.BLOCK);
	        	 	
			   playBtn.setVisible(false);
			   
			   playBtn.setEnabled(false);
			   
			   Document.get().getElementById("CardLeft").getStyle().setDisplay(Display.BLOCK);
			   Document.get().getElementById("CardMiddle").getStyle().setDisplay(Display.BLOCK);
			   Document.get().getElementById("CardRight").getStyle().setDisplay(Display.BLOCK);
			   
			   updateScreen();
		   }
	   });
	   
	   if (player1.getDeck().isFull() == false) {
		   drawCardClicked(cardLeft, 0);
		   
		   drawCardClicked(cardMiddle, 1);
		   
		   drawCardClicked(cardRight, 2);
	   }
	   
	   //Create Panels for objects
	   VerticalPanel playBtnPanel = new VerticalPanel();
	   VerticalPanel cardLeftPanel = new VerticalPanel();
	   VerticalPanel cardMiddlePanel = new VerticalPanel();
	   VerticalPanel cardRightPanel = new VerticalPanel();
	   VerticalPanel deckCard1Panel = new VerticalPanel();
	   VerticalPanel deckCard2Panel = new VerticalPanel();
	   VerticalPanel deckCard3Panel = new VerticalPanel();
	   VerticalPanel deckCard4Panel = new VerticalPanel();
	   VerticalPanel deckCard5Panel = new VerticalPanel();
	   
	   //Add objects to Panels
	   playBtnPanel.add(playBtn);
	   cardLeftPanel.add(cardLeft);
	   cardMiddlePanel.add(cardMiddle);
	   cardRightPanel.add(cardRight);
	   deckCard1Panel.add(deckCard1);
	   deckCard2Panel.add(deckCard2);
	   deckCard3Panel.add(deckCard3);
	   deckCard4Panel.add(deckCard4);
	   deckCard5Panel.add(deckCard5);
	      
	   RootPanel.get("PlayButton").add(playBtnPanel);
	   RootPanel.get("CardLeft").add(cardLeftPanel);
	   RootPanel.get("CardMiddle").add(cardMiddlePanel);
	   RootPanel.get("CardRight").add(cardRightPanel); 
	   RootPanel.get("DeckCard1").add(deckCard1Panel);
	   RootPanel.get("DeckCard2").add(deckCard2Panel);
	   RootPanel.get("DeckCard3").add(deckCard3Panel);
	   RootPanel.get("DeckCard4").add(deckCard4Panel);
	   RootPanel.get("DeckCard5").add(deckCard5Panel); 
   }
   
   public void updateScreen() {
	   cardLeft.setUrl(round.getDrawHand().getCard(0).getImgSource());
	   cardMiddle.setUrl(round.getDrawHand().getCard(1).getImgSource());
	   cardRight.setUrl(round.getDrawHand().getCard(2).getImgSource());
	   
	   deckCard1.setUrl(player1.getDeck().getCard(0).getImgSource());
	   deckCard2.setUrl(player1.getDeck().getCard(1).getImgSource());
	   deckCard3.setUrl(player1.getDeck().getCard(2).getImgSource());
	   deckCard4.setUrl(player1.getDeck().getCard(3).getImgSource());
	   deckCard5.setUrl(player1.getDeck().getCard(4).getImgSource());
	   
	   if(player1.getDeck().isFull() == true) {
		   Document.get().getElementById("CardLeft").getStyle().setDisplay(Display.NONE);
		   Document.get().getElementById("CardMiddle").getStyle().setDisplay(Display.NONE);
		   Document.get().getElementById("CardRight").getStyle().setDisplay(Display.NONE);
	   }
   }
   
   public void drawCardClicked(Image card, final int index) {
	   //add a clickListener to CardRight
	   card.addClickHandler(new ClickHandler() {
		   @Override
		   public void onClick(ClickEvent event) {
			   round.playerSelectedCard(index);
			   
			   updateScreen();
		   }
	   });
   }
}