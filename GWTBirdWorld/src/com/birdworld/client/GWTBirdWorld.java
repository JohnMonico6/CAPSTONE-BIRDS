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
	boolean roundInProgress = false;

	//Create images
	Image cardLeft = new Image();
	Image cardMiddle = new Image();
	Image cardRight = new Image();
	Image deckCard1 = new Image();
	Image deckCard2 = new Image(); 
	Image deckCard3 = new Image(); 
	Image deckCard4 = new Image(); 
	Image deckCard5 = new Image(); 
	Image opponentCard1 = new Image();
	Image opponentCard2 = new Image();
	Image opponentCard3 = new Image();
	Image opponentCard4 = new Image();
	Image opponentCard5 = new Image(); 
	Image playerPlayedCard = new Image();
	Image opponentPlayedCard = new Image(); 
	Image pile = new Image();
	   
	   
	//Initialize player
	Player player1 = new Player("TheLegend27");
	   
	//Initialize SinglePlayerRound
	SinglePlayerGame game = new SinglePlayerGame(player1);
	
	//Create button
	Button playBtn = new Button("Play!");	   
	   
	public void onModuleLoad() {
	   
		//Format draw cards
		cardLeft.setWidth("200px");
		cardLeft.setHeight("auto");
		cardMiddle.setWidth("200px");
		cardMiddle.setHeight("auto");
		cardRight.setWidth("200px");
		cardRight.setHeight("auto");
	   
		//Format deck cards
		deckCard1.setWidth("120px");
		deckCard1.setHeight("180px");
		deckCard2.setWidth("120px");
		deckCard2.setHeight("180px");
		deckCard3.setWidth("120px");
		deckCard3.setHeight("180px");
		deckCard4.setWidth("120px");
		deckCard4.setHeight("180px");
		deckCard5.setWidth("120px");
	   	deckCard5.setHeight("180px");
	   
	   	//Format opponent cards
	   	opponentCard1.setWidth("120px");
	   	opponentCard1.setHeight("180px");
	   	opponentCard2.setWidth("120px");
	   	opponentCard2.setHeight("180px");
	   	opponentCard3.setWidth("120px");
	   	opponentCard3.setHeight("180px");
	   	opponentCard4.setWidth("120px");
	   	opponentCard4.setHeight("180px");
	   	opponentCard5.setWidth("120px");
	   	opponentCard5.setHeight("180px");
	   	
	   	//Format played cards 
	   	playerPlayedCard.setWidth("120px");
	   	playerPlayedCard.setHeight("180px");
	   	opponentPlayedCard.setWidth("120px");
	   	opponentPlayedCard.setHeight("180px");
	   	opponentPlayedCard.setUrl("images/BackOfCardUpright.png");
	   	
	   	//Format pile
	   	pile.setWidth("120px");
	   	pile.setHeight("180px");
	   	pile.setUrl("images/BackOfCard.png");
	   
	   	playBtn.addStyleName("PlayButton");
	   	playBtn.setWidth("100px");
	   
	   	/**
	   	 * Add a clickListener to the button.
	   	 */
	   	playBtn.addClickHandler(new ClickHandler() {
	   		@Override
	   		public void onClick(ClickEvent event) {	        	 
			   
	   			Document.get().getElementById("GameTitleScreen").getStyle().setDisplay(Display.NONE);
	   			Document.get().getElementById("PlayButton").getStyle().setDisplay(Display.NONE);
	   			
	   			Document.get().getElementById("Pile").getStyle().setDisplay(Display.BLOCK);
	   			Document.get().getElementById("GameBoard").getStyle().setDisplay(Display.BLOCK);
	   			Document.get().getElementById("CardLeft").getStyle().setDisplay(Display.BLOCK);
	   			Document.get().getElementById("CardMiddle").getStyle().setDisplay(Display.BLOCK);
	   			Document.get().getElementById("CardRight").getStyle().setDisplay(Display.BLOCK);
			   
	   			updateScreen();
	   		}
	   	});
	   
	   	drawCardClicked(cardLeft, 0);
		   
	   	drawCardClicked(cardMiddle, 1);
		   
	   	drawCardClicked(cardRight, 2);
	   	
	   	deckCardClicked(deckCard1, 0);
	   	
	   	deckCardClicked(deckCard2, 1);
	   	
	   	deckCardClicked(deckCard3, 2);
	   	
	   	deckCardClicked(deckCard4, 3);
	   	
	   	deckCardClicked(deckCard5, 4);
	   
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
	   	VerticalPanel opponentCard1Panel = new VerticalPanel();
	   	VerticalPanel opponentCard2Panel = new VerticalPanel();
	   	VerticalPanel opponentCard3Panel = new VerticalPanel();
	   	VerticalPanel opponentCard4Panel = new VerticalPanel();
	   	VerticalPanel opponentCard5Panel = new VerticalPanel();
	   	VerticalPanel playerPlayedCardPanel = new VerticalPanel();
	   	VerticalPanel opponentPlayedCardPanel = new VerticalPanel();
	   	VerticalPanel pilePanel = new VerticalPanel();
	   	
	   
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
	   	opponentCard1Panel.add(opponentCard1);
	   	opponentCard2Panel.add(opponentCard2);
	   	opponentCard3Panel.add(opponentCard3);
	   	opponentCard4Panel.add(opponentCard4);
	   	opponentCard5Panel.add(opponentCard5);
	   	playerPlayedCardPanel.add(playerPlayedCard);
	   	opponentPlayedCardPanel.add(opponentPlayedCard);
	   	pilePanel.add(pile);
	   
	   	//Add objects to panel.
	   	RootPanel.get("PlayButton").add(playBtnPanel);
	   	RootPanel.get("CardLeft").add(cardLeftPanel);
	   	RootPanel.get("CardMiddle").add(cardMiddlePanel);
	   	RootPanel.get("CardRight").add(cardRightPanel); 
	   	RootPanel.get("DeckCard1").add(deckCard1Panel);
	   	RootPanel.get("DeckCard2").add(deckCard2Panel);
	   	RootPanel.get("DeckCard3").add(deckCard3Panel);
	   	RootPanel.get("DeckCard4").add(deckCard4Panel);
	   	RootPanel.get("DeckCard5").add(deckCard5Panel); 
	   	RootPanel.get("OpponentCard1").add(opponentCard1Panel);
	   	RootPanel.get("OpponentCard2").add(opponentCard2Panel);
	   	RootPanel.get("OpponentCard3").add(opponentCard3Panel);
	   	RootPanel.get("OpponentCard4").add(opponentCard4Panel);
	   	RootPanel.get("OpponentCard5").add(opponentCard5Panel);
	   	RootPanel.get("PlayerPlayedCard").add(playerPlayedCardPanel);
	   	RootPanel.get("OpponentPlayedCard").add(opponentPlayedCardPanel); 
	   	RootPanel.get("Pile").add(pilePanel);
	}
   
	/**
	 * Updates the screen when cards have moved or changed.
	 */
	public void updateScreen() {
		
		//Update drawhand card images.
		cardLeft.setUrl(game.getDrawHand().getCard(0).getImgSource());
		cardMiddle.setUrl(game.getDrawHand().getCard(1).getImgSource());
		cardRight.setUrl(game.getDrawHand().getCard(2).getImgSource());
	   
		//Update player deck card images
		deckCard1.setUrl(player1.getDeck().getCard(0).getImgSource());
		deckCard2.setUrl(player1.getDeck().getCard(1).getImgSource());
		deckCard3.setUrl(player1.getDeck().getCard(2).getImgSource());
		deckCard4.setUrl(player1.getDeck().getCard(3).getImgSource());
		deckCard5.setUrl(player1.getDeck().getCard(4).getImgSource());
	   
		//Update used when the drawing phase is over.
		if (game.getDrawingStatus() == false) {
			
			//Make drawhand cards disapear.
			Document.get().getElementById("CardLeft").getStyle().setDisplay(Display.NONE);
			Document.get().getElementById("CardMiddle").getStyle().setDisplay(Display.NONE);
			Document.get().getElementById("CardRight").getStyle().setDisplay(Display.NONE);
				 
			//Show opponent cards.
			Document.get().getElementById("OpponentCard1").getStyle().setDisplay(Display.BLOCK);
			Document.get().getElementById("OpponentCard2").getStyle().setDisplay(Display.BLOCK);
			Document.get().getElementById("OpponentCard3").getStyle().setDisplay(Display.BLOCK);
			Document.get().getElementById("OpponentCard4").getStyle().setDisplay(Display.BLOCK);
			Document.get().getElementById("OpponentCard5").getStyle().setDisplay(Display.BLOCK);
			
			//Setup the computer.
			game.buildComputerDeck();
			
			//Test for opponent deck.
			opponentCard1.setUrl(game.getOpponent().getDeck().getCard(0).getImgSource());
			opponentCard2.setUrl(game.getOpponent().getDeck().getCard(1).getImgSource());
			opponentCard3.setUrl(game.getOpponent().getDeck().getCard(2).getImgSource());
			opponentCard4.setUrl(game.getOpponent().getDeck().getCard(3).getImgSource());
			opponentCard5.setUrl(game.getOpponent().getDeck().getCard(4).getImgSource());
			
			
			//Setup card images.
			opponentCard1.setUrl("images/BackOfCard.png");
			opponentCard2.setUrl("images/BackOfCard.png");
			opponentCard3.setUrl("images/BackOfCard.png");
			opponentCard4.setUrl("images/BackOfCard.png");
			opponentCard5.setUrl("images/BackOfCard.png");
			
			/*Check cards in deck.
			Window.alert(player1.getDeck().getCard(0).getName() + '\n'
					+ player1.getDeck().getCard(1).getName() + '\n'
					+ player1.getDeck().getCard(2).getName() + '\n'
					+ player1.getDeck().getCard(3).getName() + '\n'
					+ player1.getDeck().getCard(4).getName() + '\n');
			*/
		}
   	}
   
	/**
	 * Add card to logical deck when clicked.
	 * @param card The card clicked.
	 * @param index The position of the card in the drawhand.
	 */
	public void drawCardClicked(Image card, final int index) {
		//add a clickListener to CardRight
		card.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				game.playerSelectedCard(index); 
				updateScreen();
			}
		});
	}
	
	/**
	 * Add card to logical deck when clicked.
	 * @param card The card clicked.
	 * @param index The position of the card in the drawhand.
	 */
	public void deckCardClicked(Image card, final int index) {
		//add a clickListener to CardRight
		card.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (game.getDrawingStatus() == false && roundInProgress == false) {					
					switch(index) {
						case 0: 
							Document.get().getElementById("DeckCard1").getStyle().setDisplay(Display.NONE);
							break;
							
						case 1: 
							Document.get().getElementById("DeckCard2").getStyle().setDisplay(Display.NONE);
							break;
							
						case 2:
							Document.get().getElementById("DeckCard3").getStyle().setDisplay(Display.NONE);
							break;
							
						case 3:
							Document.get().getElementById("DeckCard4").getStyle().setDisplay(Display.NONE);
							break;
							
						case 4:
							Document.get().getElementById("DeckCard5").getStyle().setDisplay(Display.NONE);
							break;
					}
					
					SinglePlayerRound round = new SinglePlayerRound(player1.getDeck().getCard(index), game);
					playerPlayedCard.setUrl(player1.getDeck().getCard(index).getImgSource());
					
					Document.get().getElementById("PlayerPlayedCard").getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("OpponentPlayedCard").getStyle().setDisplay(Display.BLOCK);
					opponentPlayedCard.setUrl(round.getOpponentCard().getImgSource());
					
					switch(game.getOpponent().getDeck().getCardPositon(round.getOpponentCard())) {
						case 0: 
							Document.get().getElementById("OpponentCard1").getStyle().setDisplay(Display.NONE);
							break;
							
						case 1: 
							Document.get().getElementById("OpponentCard2").getStyle().setDisplay(Display.NONE);
							break;
							
						case 2:
							Document.get().getElementById("OpponentCard3").getStyle().setDisplay(Display.NONE);
							break;
							
						case 3:
							Document.get().getElementById("OpponentCard4").getStyle().setDisplay(Display.NONE);
							break;
							
						case 4:
							Document.get().getElementById("OpponentCard5").getStyle().setDisplay(Display.NONE);
							break;
					}
					
					roundInProgress = true;
				}
			}
		});
	}
}