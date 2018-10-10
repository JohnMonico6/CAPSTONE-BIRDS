package com.birdworld.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.Visibility;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.birdworld.client.Player;
import com.google.gwt.media.client.Audio;

public class GWTBirdWorld implements EntryPoint {
	boolean roundInProgress = false;
	int handSize = 4;

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
	Image option1 = new Image();
	Image option2 = new Image();
	Image option3 = new Image();
	Image option4 = new Image();
	Image birdSkillSelector = new Image();
	Image opponentCardComparison = new Image();
	Image playerCardComparison = new Image();
	
	HTML attribute1 = new HTML();
	HTML attribute2 = new HTML();
	HTML attribute3 = new HTML();
	HTML attribute4 = new HTML();
	HTML attribute5 = new HTML();	
	HTML deckCardSound1 = new HTML();
	HTML deckCardSound2 = new HTML();
	HTML deckCardSound3 = new HTML();
	HTML deckCardSound4 = new HTML();
	HTML deckCardSound5 = new HTML();	
	HTML drawCardSound1 = new HTML();
	HTML drawCardSound2 = new HTML();
	HTML drawCardSound3 = new HTML();
	HTML playerPlayedCardSound = new HTML();
	
	//Initialize Audio files
	Audio audio = Audio.createIfSupported();

	//Initialize player
	Player player1 = new Player("TheLegend27");
	   
	//Initialize SinglePlayerGame
	SinglePlayerGame game = new SinglePlayerGame(player1);
	
	//Initialize SinglePlayerRound
	SinglePlayerRound round;
	
	//Create button
	Button playBtn = new Button("Play!");
	
	//Create label
	
	   
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
	   	opponentPlayedCard.setUrl("images/backOppCard.png");
	   	
	   	//Format Card Guessors
	   	option1.setWidth("auto"); //THESE VALUES NEED TO BE TWEAKED ONCE WE GET THE ACTUAL DIMENSIONS
	   	option1.setHeight("150px");
	   	option2.setWidth("auto");
	   	option2.setHeight("150px");
	   	option3.setWidth("auto");
	   	option3.setHeight("150px");
	   	option4.setWidth("auto");
	   	option4.setHeight("150px");
	   	
	   	//Format Attribute Selections
	   	attribute1.setWidth("113px");
	   	attribute1.setHeight("13px");
	   	attribute1.setStyleName("attribute");
	   	attribute2.setWidth("113px");
	   	attribute2.setHeight("13px");
	   	attribute2.setStyleName("attribute");
	   	attribute3.setWidth("113px");
	   	attribute3.setHeight("13px");
	   	attribute3.setStyleName("attribute");
	   	attribute4.setWidth("113px");
	   	attribute4.setHeight("19px");
	   	attribute4.setStyleName("attribute");
	   	attribute5.setWidth("113px");
	   	attribute5.setHeight("13px");
	   	attribute5.setStyleName("attribute");
	   	
	   	//Format Deck Card Sounds
	   	deckCardSound1.setWidth("28px");
	   	deckCardSound1.setHeight("20px");
	   	deckCardSound1.setStyleName("deckCardSound");
	   	deckCardSound2.setWidth("28px");
	   	deckCardSound2.setHeight("20px");
	   	deckCardSound2.setStyleName("deckCardSound");
	   	deckCardSound3.setWidth("28px");
	   	deckCardSound3.setHeight("20px");
	   	deckCardSound3.setStyleName("deckCardSound");
	   	deckCardSound4.setWidth("28px");
	   	deckCardSound4.setHeight("20px");
	   	deckCardSound4.setStyleName("deckCardSound");
	   	deckCardSound5.setWidth("28px");
	   	deckCardSound5.setHeight("20px");
	   	deckCardSound5.setStyleName("deckCardSound");
	   	
	   	//Format Draw Card Sounds
	   	drawCardSound1.setWidth("46px");
	   	drawCardSound1.setHeight("35px");
	   	drawCardSound1.setStyleName("drawCardSound");
	   	drawCardSound2.setWidth("46px");
	   	drawCardSound2.setHeight("35px");
	   	drawCardSound2.setStyleName("drawCardSound");
	   	drawCardSound3.setWidth("46px");
	   	drawCardSound3.setHeight("35px");
	   	drawCardSound3.setStyleName("drawCardSound");
	   	
	   	//Format Player Played Card
	   	playerPlayedCardSound.setWidth("28px");
	   	playerPlayedCardSound.setHeight("20px");
	   	playerPlayedCardSound.setStyleName("playerPlayedCardSound");

	   	//Format Stat Selector 
	   	birdSkillSelector.setWidth("120px");
	   	birdSkillSelector.setHeight("180px");
	   	
	   	//Format pile
	   	pile.setWidth("120px");
	   	pile.setHeight("180px");
	   	pile.setUrl("images/BackOfCard.png");
	   
	   	//Format Play Button
	   	playBtn.addStyleName("PlayButton");
	   	playBtn.setWidth("100px");
	   	
	   	//Format Comparison Cards
	   	opponentCardComparison.setWidth("120px");
	   	opponentCardComparison.setHeight("180px");
	   	playerCardComparison.setWidth("120px");
	   	playerCardComparison.setHeight("180px");
	   
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
	   	
	   	//Check if draw card has been clicked.
	   	drawCardClicked(cardLeft, 0);
	   	drawCardClicked(cardMiddle, 1);   
	   	drawCardClicked(cardRight, 2);
	  
	   	//Check if deck card has been clicked
	   	deckCardClicked(deckCard1, 0);
	   	deckCardClicked(deckCard2, 1);
	   	deckCardClicked(deckCard3, 2);
	   	deckCardClicked(deckCard4, 3);
	   	deckCardClicked(deckCard5, 4);
	   	
	   	//Check if option has been clicked
	   	optionClicked(option1);
	   	optionClicked(option2);
	   	optionClicked(option3);
	   	optionClicked(option4);
	   	
	   	//Check if attribute has benn clicked
	   	attributeClicked(attribute1, 0);
	   	attributeClicked(attribute2, 1);
	   	attributeClicked(attribute3, 2);
	   	attributeClicked(attribute4, 3);
	   	attributeClicked(attribute5, 4);
	   	
	   	//Check if sound button clicked
	   	deckSoundButtonClicked(deckCardSound1, 0);
	   	deckSoundButtonClicked(deckCardSound2, 1);
	   	deckSoundButtonClicked(deckCardSound3, 2);
	   	deckSoundButtonClicked(deckCardSound4, 3);
	   	deckSoundButtonClicked(deckCardSound5, 4);
	   	
	   	drawSoundButtonClicked(drawCardSound1, 0);
	   	drawSoundButtonClicked(drawCardSound2, 1);
	   	drawSoundButtonClicked(drawCardSound3, 2);
	   	
	   	opponentCardClicked();
	   	
	   	playerCardClicked();
	   
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
	   	VerticalPanel option1Panel = new VerticalPanel();
	   	VerticalPanel option2Panel = new VerticalPanel();
	   	VerticalPanel option3Panel = new VerticalPanel();
	   	VerticalPanel option4Panel = new VerticalPanel();
	   	VerticalPanel birdSkillSelectorPanel = new VerticalPanel();
	   	VerticalPanel attribute1Panel = new VerticalPanel();
	   	VerticalPanel attribute2Panel = new VerticalPanel();
	   	VerticalPanel attribute3Panel = new VerticalPanel();
	   	VerticalPanel attribute4Panel = new VerticalPanel();
	   	VerticalPanel attribute5Panel = new VerticalPanel();
	   	VerticalPanel deckCardSound1Panel = new VerticalPanel();
	   	VerticalPanel deckCardSound2Panel = new VerticalPanel();
	   	VerticalPanel deckCardSound3Panel = new VerticalPanel();
	   	VerticalPanel deckCardSound4Panel = new VerticalPanel();
	   	VerticalPanel deckCardSound5Panel = new VerticalPanel();
	   	VerticalPanel drawCardSound1Panel = new VerticalPanel();
	   	VerticalPanel drawCardSound2Panel = new VerticalPanel();
	   	VerticalPanel drawCardSound3Panel = new VerticalPanel();
		VerticalPanel playerPlayedCardSoundPanel = new VerticalPanel();
		VerticalPanel playerCardComparisonPanel = new VerticalPanel();
		VerticalPanel opponentCardComparisonPanel = new VerticalPanel();
	   
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
	   	option1Panel.add(option1);
	   	option2Panel.add(option2);
	   	option3Panel.add(option3);
	   	option4Panel.add(option4);
	   	birdSkillSelectorPanel.add(birdSkillSelector);
	   	attribute1Panel.add(attribute1);
	   	attribute2Panel.add(attribute2);
	   	attribute3Panel.add(attribute3);
	   	attribute4Panel.add(attribute4);
	   	attribute5Panel.add(attribute5);
	   	deckCardSound1Panel.add(deckCardSound1);
	   	deckCardSound2Panel.add(deckCardSound2);
	   	deckCardSound3Panel.add(deckCardSound3);
	   	deckCardSound4Panel.add(deckCardSound4);
	   	deckCardSound5Panel.add(deckCardSound5);
	   	drawCardSound1Panel.add(drawCardSound1);
	   	drawCardSound2Panel.add(drawCardSound2);
	   	drawCardSound3Panel.add(drawCardSound3);
	   	playerPlayedCardSoundPanel.add(playerPlayedCardSound);
	   	playerCardComparisonPanel.add(playerCardComparison);
	   	opponentCardComparisonPanel.add(opponentCardComparison);
	   
	   	//Adding the panels to the div in the html file
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
	   	RootPanel.get("Option1").add(option1Panel);
	   	RootPanel.get("Option2").add(option2Panel);
	   	RootPanel.get("Option3").add(option3Panel);
	   	RootPanel.get("Option4").add(option4Panel);
	   	RootPanel.get("Attribute1").add(attribute1Panel);
	   	RootPanel.get("Attribute2").add(attribute2Panel);
	   	RootPanel.get("Attribute3").add(attribute3Panel);
	   	RootPanel.get("Attribute4").add(attribute4Panel);
	   	RootPanel.get("Attribute5").add(attribute5Panel);
	   	RootPanel.get("BirdAttributeSelector").add(birdSkillSelectorPanel);
	   	RootPanel.get("DeckCardSound1").add(deckCardSound1Panel);
	   	RootPanel.get("DeckCardSound2").add(deckCardSound2Panel);
	   	RootPanel.get("DeckCardSound3").add(deckCardSound3Panel);
	   	RootPanel.get("DeckCardSound4").add(deckCardSound4Panel);
	   	RootPanel.get("DeckCardSound5").add(deckCardSound5Panel);
	   	RootPanel.get("DrawCardSound1").add(drawCardSound1Panel);
	   	RootPanel.get("DrawCardSound2").add(drawCardSound2Panel);
	   	RootPanel.get("DrawCardSound3").add(drawCardSound3Panel);
	   	RootPanel.get("PlayerPlayedCardSound").add(playerPlayedCardSoundPanel);
	   	RootPanel.get("PlayerCardComparison").add(playerCardComparison);
	   	RootPanel.get("OpponentCardComparison").add(opponentCardComparison);
	}
   
	/**
	 * Updates the screen when cards have moved or changed.
	 */
	public void updateScreen() {
		
		//Update drawhand card images.
		cardLeft.setUrl(game.getDrawHand().getCard(0).getCardImgSource());
		cardMiddle.setUrl(game.getDrawHand().getCard(1).getCardImgSource());
		cardRight.setUrl(game.getDrawHand().getCard(2).getCardImgSource());
	   
		//Update player deck card images
		deckCard1.setUrl(player1.getDeck().getCard(0).getCardImgSource());
		deckCard2.setUrl(player1.getDeck().getCard(1).getCardImgSource());
		deckCard3.setUrl(player1.getDeck().getCard(2).getCardImgSource());
		deckCard4.setUrl(player1.getDeck().getCard(3).getCardImgSource());
		deckCard5.setUrl(player1.getDeck().getCard(4).getCardImgSource());
	   
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
			opponentCard1.setUrl(game.getOpponent().getDeck().getCard(0).getCardImgSource());
			opponentCard2.setUrl(game.getOpponent().getDeck().getCard(1).getCardImgSource());
			opponentCard3.setUrl(game.getOpponent().getDeck().getCard(2).getCardImgSource());
			opponentCard4.setUrl(game.getOpponent().getDeck().getCard(3).getCardImgSource());
			opponentCard5.setUrl(game.getOpponent().getDeck().getCard(4).getCardImgSource());
			
			
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
	
	public void attributeClicked(HTML attribute, final int index) {
		//add a clickListener to CardRight
		attribute.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				//Window.alert("Clicked!");
				round.compareAttributes(index);
				
				Document.get().getElementById("BirdAttributeSelector").getStyle().setDisplay(Display.NONE);
				//Document.get().getElementById("Blackbox").getStyle().setDisplay(Display.NONE);
				Document.get().getElementById("Meter").getStyle().setDisplay(Display.BLOCK);
				Document.get().getElementById("PlayerCardComparison").getStyle().setDisplay(Display.BLOCK);
				Document.get().getElementById("OpponentCardComparison").getStyle().setDisplay(Display.BLOCK);
				
			   	opponentCardComparison.setUrl(round.getOpponentCard().getCardImgSource());
			   	playerCardComparison.setUrl(round.getPlayerCard().getCardImgSource());
				
				switch(round.getPlayerCard().getBirdAttribute(index)) {
					case 1:
						Document.get().getElementById("PlayerArrow1").getStyle().setDisplay(Display.BLOCK);
						break;
					case 2:
						Document.get().getElementById("PlayerArrow2").getStyle().setDisplay(Display.BLOCK);
						break;
					case 3:
						Document.get().getElementById("PlayerArrow3").getStyle().setDisplay(Display.BLOCK);
						break;
					case 4:
						Document.get().getElementById("PlayerArrow4").getStyle().setDisplay(Display.BLOCK);
						break;
					case 5: 
						Document.get().getElementById("PlayerArrow5").getStyle().setDisplay(Display.BLOCK);
						break;
				}
				
				switch(round.getOpponentCard().getBirdAttribute(index)) {
					case 1:
						Document.get().getElementById("OpponentArrow1").getStyle().setDisplay(Display.BLOCK);
						break;
					case 2:
						Document.get().getElementById("OpponentArrow2").getStyle().setDisplay(Display.BLOCK);
						break;
					case 3:
						Document.get().getElementById("OpponentArrow3").getStyle().setDisplay(Display.BLOCK);
						break;
					case 4:
						Document.get().getElementById("OpponentArrow4").getStyle().setDisplay(Display.BLOCK);
						break;
					case 5: 
						Document.get().getElementById("OpponentArrow5").getStyle().setDisplay(Display.BLOCK);
						break;
				}
				
				Timer delayBirdMessage = new Timer() {
					public void run() {
						Document.get().getElementById("BristleBird").getStyle().setDisplay(Display.BLOCK);
						Document.get().getElementById("SpeechBubble").getStyle().setDisplay(Display.BLOCK);
						
						if (round.getPlayerHasWon() == true) {
							Document.get().getElementById("WinMessage").getStyle().setDisplay(Display.BLOCK);
						} else if (round.getOpponentHasWon() == true) {
							Document.get().getElementById("LoseMessage").getStyle().setDisplay(Display.BLOCK);
						} else {
							Document.get().getElementById("DrawMessage").getStyle().setDisplay(Display.BLOCK);
						}
				    }
				};
				
				delayBirdMessage.schedule(3500);
				
				Timer delaySetup = new Timer() {
					public void run() {
						roundInProgress = false;
						
						Document.get().getElementById("PlayerScore").setInnerText(Integer.toString(game.getPlayer().getScore()));
						Document.get().getElementById("OpponentScore").setInnerText(Integer.toString(game.getOpponent().getScore()));
						
						Document.get().getElementById("BristleBird").getStyle().setDisplay(Display.NONE);
						Document.get().getElementById("SpeechBubble").getStyle().setDisplay(Display.NONE);
						Document.get().getElementById("WinMessage").getStyle().setDisplay(Display.NONE);
						Document.get().getElementById("LoseMessage").getStyle().setDisplay(Display.NONE);
						Document.get().getElementById("DrawMessage").getStyle().setDisplay(Display.NONE);
						Document.get().getElementById("Meter").getStyle().setDisplay(Display.NONE);
						Document.get().getElementById("PlayerCardComparison").getStyle().setDisplay(Display.NONE);
						Document.get().getElementById("OpponentCardComparison").getStyle().setDisplay(Display.NONE);
						Document.get().getElementById("Blackbox").getStyle().setDisplay(Display.NONE);
						Document.get().getElementById("PlayerArrow1").getStyle().setDisplay(Display.NONE);
						Document.get().getElementById("PlayerArrow2").getStyle().setDisplay(Display.NONE);
						Document.get().getElementById("PlayerArrow3").getStyle().setDisplay(Display.NONE);
						Document.get().getElementById("PlayerArrow4").getStyle().setDisplay(Display.NONE);
						Document.get().getElementById("PlayerArrow5").getStyle().setDisplay(Display.NONE);
						Document.get().getElementById("OpponentArrow1").getStyle().setDisplay(Display.NONE);
						Document.get().getElementById("OpponentArrow2").getStyle().setDisplay(Display.NONE);
						Document.get().getElementById("OpponentArrow3").getStyle().setDisplay(Display.NONE);
						Document.get().getElementById("OpponentArrow4").getStyle().setDisplay(Display.NONE);
						Document.get().getElementById("OpponentArrow5").getStyle().setDisplay(Display.NONE);
						Document.get().getElementById("PlayerPlayedCard").getStyle().setDisplay(Display.NONE);
						Document.get().getElementById("OpponentPlayedCard").getStyle().setDisplay(Display.NONE);
						
						if (true){ 
							game.checkForVictory();
							if (game.getPlayer().isWinner() && game.getOpponent().isWinner()){
								//Window.alert("It's a draw!");
								Document.get().getElementById("BristleBird").getStyle().setDisplay(Display.BLOCK);
								Document.get().getElementById("SpeechBubble").getStyle().setDisplay(Display.BLOCK);
								Document.get().getElementById("TieNoVictory").getStyle().setDisplay(Display.BLOCK);
							} else if (game.getOpponent().isWinner()){ 
								//Window.alert("Computer has won");
								Document.get().getElementById("BristleBird").getStyle().setDisplay(Display.BLOCK);
								Document.get().getElementById("SpeechBubble").getStyle().setDisplay(Display.BLOCK);
								Document.get().getElementById("ComputerVictory").getStyle().setDisplay(Display.BLOCK);
							} else if (game.getPlayer().isWinner()){
								//Window.alert("Player has won");
								Document.get().getElementById("BristleBird").getStyle().setDisplay(Display.BLOCK);
								Document.get().getElementById("SpeechBubble").getStyle().setDisplay(Display.BLOCK);
								Document.get().getElementById("PlayerVictory").getStyle().setDisplay(Display.BLOCK);
							}
						}
				    }
				};
				
				delaySetup.schedule(5000);
			}
		});
	}
	
	public void deckSoundButtonClicked(HTML soundButton, final int index) {
		//add a clickListener to CardRight
		soundButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				audio.setSrc(game.getPlayer().getDeck().getCard(index).getAudioSource());
				audio.play();
			}
		});
	}
	
	public void drawSoundButtonClicked(HTML soundButton, final int index) {
		//add a clickListener to CardRight
		soundButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				audio.setSrc(game.getDrawHand().getCard(index).getAudioSource());
				audio.play();
			}
		});
	}
	
	public void opponentCardClicked() {
		//add a clickListener to CardRight
		opponentPlayedCard.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				audio.setSrc(round.getOpponentCard().getAudioSource());
				audio.play();
			}
		});
	}
	
	public void playerCardClicked() {
		//add a clickListener to CardRight
		playerPlayedCardSound.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				audio.setSrc(round.getPlayerCard().getAudioSource());
				audio.play();
			}
		});
	}
	
	public void optionClicked(final Image option) {
		//add a clickListener to CardRight
		option.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				round.checkIfPlayerCorrect(option.getUrl());
				if (round.getPlayerAdvantage() == true){
					//Window.alert("Correct!");
					audio.pause();
					birdSkillSelector.setUrl(round.getPlayerCard().getCardImgSource());
					Document.get().getElementById("BirdAttributeSelector").getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("Blackbox").getStyle().setDisplay(Display.BLOCK);
					
					Document.get().getElementById("Option1").getStyle().setDisplay(Display.NONE);
					Document.get().getElementById("Option2").getStyle().setDisplay(Display.NONE);
					Document.get().getElementById("Option3").getStyle().setDisplay(Display.NONE);
					Document.get().getElementById("Option4").getStyle().setDisplay(Display.NONE);
				} else { 
					//Window.alert("Wrong!");
				}
			}
		});
	}
	
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
					
					round = new SinglePlayerRound(player1.getDeck().getCard(index), game);
					playerPlayedCard.setUrl(player1.getDeck().getCard(index).getCardImgSource());
					
					Document.get().getElementById("PlayerPlayedCard").getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("OpponentPlayedCard").getStyle().setDisplay(Display.BLOCK);
					
					Document.get().getElementById("Option1").getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("Option2").getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("Option3").getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("Option4").getStyle().setDisplay(Display.BLOCK);
					
					round.createOptions();
					option1.setUrl(round.getOptions().get(0).toString());
					option2.setUrl(round.getOptions().get(1).toString());
					option3.setUrl(round.getOptions().get(2).toString());
					option4.setUrl(round.getOptions().get(3).toString());
					opponentPlayedCard.setUrl(round.getOpponentCard().getCardImgSource());
					
					switch(handSize) {
						case 0: 
							Document.get().getElementById("OpponentCard1").getStyle().setDisplay(Display.NONE);
							handSize--;
							break;
							
						case 1: 
							Document.get().getElementById("OpponentCard2").getStyle().setDisplay(Display.NONE);
							handSize--;
							break;
							
						case 2:
							Document.get().getElementById("OpponentCard3").getStyle().setDisplay(Display.NONE);
							handSize--;
							break;
							
						case 3:
							Document.get().getElementById("OpponentCard4").getStyle().setDisplay(Display.NONE);
							handSize--;
							break;
							
						case 4:
							Document.get().getElementById("OpponentCard5").getStyle().setDisplay(Display.NONE);
							handSize--;
							break;
					}
					
					//round.removePlayedCardsFromDecks();
					
					roundInProgress = true;
				}
			}
		});
	}
}