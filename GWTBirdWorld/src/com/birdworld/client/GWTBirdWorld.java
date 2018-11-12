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

import java.util.Random;

import com.birdworld.client.Player;
import com.google.gwt.media.client.Audio;


/**
 * Class that runs the main javascript functions written in java
 * for play.html.
 * 
 * @authors Luke Humphryes, John Monico.
 * @version 1.11
 *
 */
public class GWTBirdWorld implements EntryPoint {
	
	//Global variables
	boolean roundInProgress = false;
	boolean popupActive = true;
	int handSize = 4;
	final int NUM_OF_ATTRIBUTES = 5;
	enum CardType{DECK, DRAW, PLAYER, OPPONENT};

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
	Image option1 = new Image();
	Image option2 = new Image();
	Image option3 = new Image();
	Image option4 = new Image();
	Image birdAttributeSelector = new Image();
	Image opponentCardComparison = new Image();
	Image playerCardComparison = new Image();
	Image opponentRepeatSoundIcon = new Image();
	Image helpIcon = new Image();
	
	//Create HTML objects
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
	
	//Initialize Button
	Button continueBtn = new Button("Continue!");
	Button playBtn = new Button("Play!");
	
	//Initialize Audio files
	Audio audio = Audio.createIfSupported();

	//Initialize player
	Player player = new Player();
	   
	//Initialize SinglePlayerGame
	SinglePlayerGame game = new SinglePlayerGame(player);
	
	//Initialize SinglePlayerRound
	SinglePlayerRound round;
	
	   
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
	   	
	   	//Format Card Guessors
	   	option1.setWidth("168px");
	   	option1.setHeight("150px");
	   	option2.setWidth("168px");
	   	option2.setHeight("150px");
	   	option3.setWidth("168px");
	   	option3.setHeight("150px");
	   	option4.setWidth("168px");
	   	option4.setHeight("150px");
	   	
	   	//Format Attribute Selections
	   	attribute1.setWidth("113px");
	   	attribute1.setHeight("13px");
	   	attribute1.setStyleName("selectableAttribute");
	   	attribute2.setWidth("113px");
	   	attribute2.setHeight("13px");
	   	attribute2.setStyleName("selectableAttribute");
	   	attribute3.setWidth("113px");
	   	attribute3.setHeight("13px");
	   	attribute3.setStyleName("selectableAttribute");
	   	attribute4.setWidth("113px");
	   	attribute4.setHeight("13px");
	   	attribute4.setStyleName("selectableAttribute");
	   	attribute5.setWidth("113px");
	   	attribute5.setHeight("13px");
	   	attribute5.setStyleName("selectableAttribute");
	   	
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
	   	birdAttributeSelector.setWidth("120px");
	   	birdAttributeSelector.setHeight("180px");
	   
	   	//Format Play Button
	   	playBtn.addStyleName("PlayButton");
	   	playBtn.setWidth("100px");
	   	
	   	//Format Continue Button
	   	continueBtn.setStyleName("GWTContinueButton");
	   	continueBtn.setWidth("120px");
	   	continueBtn.setHeight("40px");
	   	
	   	//Format Comparison Cards
	   	opponentCardComparison.setWidth("120px");
	   	opponentCardComparison.setHeight("180px");
	   	playerCardComparison.setWidth("120px");
	   	playerCardComparison.setHeight("180px");
	   	
	   	//Format sound icon
	   	opponentRepeatSoundIcon.setWidth("110px");
	   	opponentRepeatSoundIcon.setHeight("110px");
	   	opponentRepeatSoundIcon.setUrl("images/replay.png");
	   	
	   	//Format helpIcon
	   	helpIcon.setWidth("50px");
	   	helpIcon.setHeight("auto");
	   	helpIcon.setUrl("images/Information.png");
	   	helpIcon.setStyleName("Information");
	   
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
	   	VerticalPanel option1Panel = new VerticalPanel();
	   	VerticalPanel option2Panel = new VerticalPanel();
	   	VerticalPanel option3Panel = new VerticalPanel();
	   	VerticalPanel option4Panel = new VerticalPanel();
	   	VerticalPanel birdAttributeSelectorPanel = new VerticalPanel();
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
		VerticalPanel soundIconPanel = new VerticalPanel();
		VerticalPanel continueBtnPanel = new VerticalPanel();
		VerticalPanel helpIconPanel = new VerticalPanel();
	   
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
	   	option1Panel.add(option1);
	   	option2Panel.add(option2);
	   	option3Panel.add(option3);
	   	option4Panel.add(option4);
	   	birdAttributeSelectorPanel.add(birdAttributeSelector);
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
	   	soundIconPanel.add(opponentRepeatSoundIcon);
	   	continueBtnPanel.add(continueBtn);
	   	helpIconPanel.add(helpIcon);
	   
	   	//Add the panels to the div in the html file
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
	   	RootPanel.get("Option1").add(option1Panel);
	   	RootPanel.get("Option2").add(option2Panel);
	   	RootPanel.get("Option3").add(option3Panel);
	   	RootPanel.get("Option4").add(option4Panel);
	   	RootPanel.get("SelectableAttribute1").add(attribute1Panel);
	   	RootPanel.get("SelectableAttribute2").add(attribute2Panel);
	   	RootPanel.get("SelectableAttribute3").add(attribute3Panel);
	   	RootPanel.get("SelectableAttribute4").add(attribute4Panel);
	   	RootPanel.get("SelectableAttribute5").add(attribute5Panel);
	   	RootPanel.get("BirdAttributeSelector").add(birdAttributeSelectorPanel);
	   	RootPanel.get("DeckCardSound1").add(deckCardSound1Panel);
	   	RootPanel.get("DeckCardSound2").add(deckCardSound2Panel);
	   	RootPanel.get("DeckCardSound3").add(deckCardSound3Panel);
	   	RootPanel.get("DeckCardSound4").add(deckCardSound4Panel);
	   	RootPanel.get("DeckCardSound5").add(deckCardSound5Panel);
	   	RootPanel.get("DrawCardSound1").add(drawCardSound1Panel);
	   	RootPanel.get("DrawCardSound2").add(drawCardSound2Panel);
	   	RootPanel.get("DrawCardSound3").add(drawCardSound3Panel);
	   	RootPanel.get("PlayerPlayedCardSound").add(playerPlayedCardSoundPanel);
	   	RootPanel.get("PlayerCardComparison").add(playerCardComparisonPanel);
	   	RootPanel.get("OpponentCardComparison").add(opponentCardComparisonPanel);
	   	RootPanel.get("SoundIcon").add(soundIconPanel);
	   	RootPanel.get("ContinueButton").add(continueBtnPanel);
	   	RootPanel.get("HelpIcon").add(helpIconPanel);
	   	
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
	   	
	   	//Check if attribute has been clicked
	   	attributeClicked(attribute1, 0);
	   	attributeClicked(attribute2, 1);
	   	attributeClicked(attribute3, 2);
	   	attributeClicked(attribute4, 3);
	   	attributeClicked(attribute5, 4);
	   	
	   	//Check if sound button clicked
	   	soundButtonClicked(deckCardSound1, 0, CardType.DECK);
	   	soundButtonClicked(deckCardSound2, 1, CardType.DECK);
	   	soundButtonClicked(deckCardSound3, 2, CardType.DECK);
	   	soundButtonClicked(deckCardSound4, 3, CardType.DECK);
	   	soundButtonClicked(deckCardSound5, 4, CardType.DECK);
	   	soundButtonClicked(drawCardSound1, 0, CardType.DRAW);
	   	soundButtonClicked(drawCardSound2, 1, CardType.DRAW);
	   	soundButtonClicked(drawCardSound3, 2, CardType.DRAW);
	   	soundButtonClicked(playerPlayedCardSound, 0, CardType.PLAYER);
	   	
	   	//Check if sound button is clicked.
	   	opponentRepeatSoundIconClicked();
	   	
	   	//Check if play button is clicked.
	   	playBtnClicked();
	   	
	   	//Check if continue button is clicked.
	   	continueBtnClicked();
	   	
	   	//Check if help icon is clicked.
	   	helpIconClicked();
	}
	
   
	/**
	 * Updates the screen when cards have moved or changed.
	 * 
	 */
	public void updateScreen() {
		
		//Update drawhand card images.
		cardLeft.setUrl(game.getDrawHand().getCard(0).getCardImgSource());
		cardMiddle.setUrl(game.getDrawHand().getCard(1).getCardImgSource());
		cardRight.setUrl(game.getDrawHand().getCard(2).getCardImgSource());
	   
		//Update player deck card images
		deckCard1.setUrl(player.getDeck().getCard(0).getCardImgSource());
		deckCard2.setUrl(player.getDeck().getCard(1).getCardImgSource());
		deckCard3.setUrl(player.getDeck().getCard(2).getCardImgSource());
		deckCard4.setUrl(player.getDeck().getCard(3).getCardImgSource());
		deckCard5.setUrl(player.getDeck().getCard(4).getCardImgSource());
	   
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
	 * Add card to deck when draw card clicked.
	 * 
	 * @param card The card clicked.
	 * @param index The position of the card in the drawhand.
	 */
	public void drawCardClicked(Image card, final int index) {
		//add a clickListener to draw cards.
		card.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				audio.pause();
				
				//Make deck card appear when draw card is selected.
				switch(player.getDeck().getSize()) {
					case 0: 
						Document.get().getElementById("DeckCard1").getStyle().setDisplay(Display.BLOCK);
						break;
							
					case 1: 
						Document.get().getElementById("DeckCard2").getStyle().setDisplay(Display.BLOCK);
						break;
							
					case 2:
						Document.get().getElementById("DeckCard3").getStyle().setDisplay(Display.BLOCK);
						break;
							
					case 3:
						Document.get().getElementById("DeckCard4").getStyle().setDisplay(Display.BLOCK);
						break;
							
					case 4:
						Document.get().getElementById("DeckCard5").getStyle().setDisplay(Display.BLOCK);
						break;
				}
				
				game.playerSelectedCard(index); 
				updateScreen();
				
				//Update popup help message.
				Document.get().getElementById("myPopup").setInnerText("Choose a card from your deck to challenge your opponent with.");
			}
		});
	}
	
	
	/**
	 * Play the selected card against the opponent. Play opponent's
	 * bird call upon selection. Create the four options and make a
	 * card from the opponents hand hidden.
	 * 
	 */
	public void deckCardClicked(Image card, final int index) {
		//add a clickListener to card.
		card.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				audio.pause();
				
				//Update popup help message.
				Document.get().getElementById("myPopup").setInnerText("Select from the four options on the right which bird you think is on the opponent's card based on the bird call. If you're correct, you'll score a point. If you're incorrect, your opponent will get a point instead.");
				
				//If the drawing phase and a round is not occuring, make the deck card
				//lose visibility when selected.
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
					
					round = new SinglePlayerRound(player.getDeck().getCard(index), game);
					playerPlayedCard.setUrl(player.getDeck().getCard(index).getCardImgSource());
					
					Document.get().getElementById("PlayerPlayedCard").getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("OpponentPlayedCard").getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("SoundIcon").getStyle().setDisplay(Display.BLOCK);
					
					Document.get().getElementById("Option1").getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("Option2").getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("Option3").getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("Option4").getStyle().setDisplay(Display.BLOCK);
					
					round.createOptions();
					option1.setUrl(round.getOptions().get(0).toString());
					option2.setUrl(round.getOptions().get(1).toString());
					option3.setUrl(round.getOptions().get(2).toString());
					option4.setUrl(round.getOptions().get(3).toString());
					//opponentPlayedCard.setUrl(round.getOpponentCard().getCardImgSource()); Tester for opponent card
					
					//Remove visibility of opponent card from hand to give the illusion that
					//a card has been played from their hand.
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
					
					//Play opponent played card audio
					audio.setSrc(round.getOpponentCard().getAudioSource());
					audio.play();
					
					roundInProgress = true;
				}
			}
		});
	}
	
	
	public void optionClicked(final Image option) {
		//Add a clickListener to option.
		option.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				audio.pause();
				
				Document.get().getElementById("Option1").getStyle().setDisplay(Display.NONE);
				Document.get().getElementById("Option2").getStyle().setDisplay(Display.NONE);
				Document.get().getElementById("Option3").getStyle().setDisplay(Display.NONE);
				Document.get().getElementById("Option4").getStyle().setDisplay(Display.NONE);
				
				Document.get().getElementById("BristleBird").getStyle().setDisplay(Display.BLOCK);
				Document.get().getElementById("SpeechBubble").getStyle().setDisplay(Display.BLOCK);
				
				round.checkIfPlayerCorrect(option.getUrl());
				
				if (round.getPlayerAdvantage() == true) {
					game.getPlayer().increaseScore();
					Document.get().getElementById("PlayerScore").setInnerText(Integer.toString(game.getPlayer().getScore()));
					
					Document.get().getElementById("OptionCorrect").getStyle().setDisplay(Display.BLOCK);
				} else {
					game.getOpponent().increaseScore();
					Document.get().getElementById("OpponentScore").setInnerText(Integer.toString(game.getOpponent().getScore()));
					
					Document.get().getElementById("OptionIncorrect").getStyle().setDisplay(Display.BLOCK);
				}
				
				//Create bird message.
				Timer delayAttributeSelection = new Timer() {
					public void run() {
						Document.get().getElementById("BristleBird").getStyle().setDisplay(Display.NONE);
						Document.get().getElementById("SpeechBubble").getStyle().setDisplay(Display.NONE);
						Document.get().getElementById("OptionCorrect").getStyle().setDisplay(Display.NONE);
						Document.get().getElementById("OptionIncorrect").getStyle().setDisplay(Display.NONE);
						
						Document.get().getElementById("Blackbox").getStyle().setDisplay(Display.BLOCK);
						
						if (round.getPlayerAdvantage() == true) {
							//Window.alert("Correct!"); Tester for correct answer.
							birdAttributeSelector.setUrl(round.getPlayerCard().getCardImgSource());
							Document.get().getElementById("BirdAttributeSelector").getStyle().setDisplay(Display.BLOCK);
							
							//Update popup help message.
							Document.get().getElementById("myPopup").setInnerText("Select one of your bird's attributes. If the attribute's score is higher than your opponent's, you score a point!");
						} else { 
							//Window.alert("Wrong!"); Tester for wrong answer.
							//Update popup help message.
							Document.get().getElementById("myPopup").setInnerText("Opponent chose an attribute. Comparing scores...");
							
							playerCardVsOpponentCard(round.opponentChoosesAttribute());
						}
				    }
				};
				
				delayAttributeSelection.schedule(1500);
			}
		});
	}
	
	
	/**
	 * Compare player and opponent attributes when attribute is selected.
	 * Only possible if the player has selected the correct bird call.
	 * 
	 * @param attribute The attribute object clicked.
	 * @param attributeIndex The index of the selected attribute.
	 */
	public void attributeClicked(HTML attribute, final int attributeIndex) {
		//add a clickListener to player attributes.
		attribute.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				//Window.alert("Clicked!"); Tester to see if clickevent responding.
				
				//Update popup help message.
				Document.get().getElementById("myPopup").setInnerText("You chose an attribute. Comparing scores...");
				
				playerCardVsOpponentCard(attributeIndex);
			}
				
		});
	}
	
	
	/**
	 * Compares selected opponent and player attribute.
	 * The player with highest attribute wins the round.
	 * Meter animation plays when the display for the meter
	 * and arrows are changed to "BLOCK". Bird appears with message
	 * and the interface is returned to the state before a round begins.
	 * 
	 * @param attributeIndex The index of the selected attribute. 
	 */
	public void playerCardVsOpponentCard(final int attributeIndex) {
		round.compareAttributes(attributeIndex);
		
		//Setup comparison interface 
		Document.get().getElementById("PlayerCardComparison").getStyle().setDisplay(Display.BLOCK);
		Document.get().getElementById("OpponentCardComparison").getStyle().setDisplay(Display.BLOCK);
		Document.get().getElementById("BirdAttributeSelector").getStyle().setDisplay(Display.NONE);
		Document.get().getElementById("Meter").getStyle().setDisplay(Display.BLOCK);
		
		//Set the selected bird card images to the comparison cards.
	   	opponentCardComparison.setUrl(round.getOpponentCard().getCardImgSource());
	   	playerCardComparison.setUrl(round.getPlayerCard().getCardImgSource());
		
	   	//Play the appropriate arrow animation to use for the player's card. 
		switch(round.getPlayerCard().getAttribute(attributeIndex)) {
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

	   	//Play the appropriate arrow animation to use for the opponent's card.
		switch(round.getOpponentCard().getAttribute(attributeIndex)) {
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
		
		//Highlight the appropriate attribute on the opponent and player's card.
		switch(attributeIndex) {
			case 0:
				Document.get().getElementById("PlayerSelectedAttribute1").getStyle().setDisplay(Display.BLOCK);
				Document.get().getElementById("OpponentSelectedAttribute1").getStyle().setDisplay(Display.BLOCK);
				break;
			case 1:
				Document.get().getElementById("PlayerSelectedAttribute2").getStyle().setDisplay(Display.BLOCK);
				Document.get().getElementById("OpponentSelectedAttribute2").getStyle().setDisplay(Display.BLOCK);
				break;
			case 2:
				Document.get().getElementById("PlayerSelectedAttribute3").getStyle().setDisplay(Display.BLOCK);
				Document.get().getElementById("OpponentSelectedAttribute3").getStyle().setDisplay(Display.BLOCK);
				break;
			case 3:
				Document.get().getElementById("PlayerSelectedAttribute4").getStyle().setDisplay(Display.BLOCK);
				Document.get().getElementById("OpponentSelectedAttribute4").getStyle().setDisplay(Display.BLOCK);
				break;
			case 4: 
				Document.get().getElementById("PlayerSelectedAttribute5").getStyle().setDisplay(Display.BLOCK);
				Document.get().getElementById("OpponentSelectedAttribute5").getStyle().setDisplay(Display.BLOCK);
				break;
		}
		
		//Create bird message timer.
		Timer delayBirdMessage = new Timer() {
			public void run() {
				Document.get().getElementById("BristleBird").getStyle().setDisplay(Display.BLOCK);
				Document.get().getElementById("SpeechBubble").getStyle().setDisplay(Display.BLOCK);
				
				Document.get().getElementById("PlayerScore").setInnerText(Integer.toString(game.getPlayer().getScore()));
				Document.get().getElementById("OpponentScore").setInnerText(Integer.toString(game.getOpponent().getScore()));
				
				if (round.getPlayerHasWon() == true) {
					Document.get().getElementById("WinMessage").getStyle().setDisplay(Display.BLOCK);
					
					//Update popup help message.
					Document.get().getElementById("myPopup").setInnerText("Your attribute's score was higher than your opponent's! You score a point. Click the continue button to start a new round.");
				} else if (round.getOpponentHasWon() == true) {
					Document.get().getElementById("LoseMessage").getStyle().setDisplay(Display.BLOCK);
					
					//Update popup help message.
					Document.get().getElementById("myPopup").setInnerText("Your opponent's attribute score was higher than yours! Opponent scores a point. Click the continue button to start a new round.");
				} else {
					Document.get().getElementById("DrawMessage").getStyle().setDisplay(Display.BLOCK);
					
					//Update popup help message.
					Document.get().getElementById("myPopup").setInnerText("The attribute scores were equal! Both players score a point. Click the continue button to start a new round.");
				}
		    }
		};
		
		//Create timer to wipe bird message.
		Timer wipeBirdMessage = new Timer() {
			public void run() {
				Document.get().getElementById("BristleBird").getStyle().setDisplay(Display.NONE);
				Document.get().getElementById("SpeechBubble").getStyle().setDisplay(Display.NONE);
				Document.get().getElementById("WinMessage").getStyle().setDisplay(Display.NONE);
				Document.get().getElementById("LoseMessage").getStyle().setDisplay(Display.NONE);
				Document.get().getElementById("DrawMessage").getStyle().setDisplay(Display.NONE);
				
				Document.get().getElementById("ContinueButton").getStyle().setDisplay(Display.BLOCK);
		    }
		};
		
		//Play bird message after 3500 milliseconds.
		delayBirdMessage.schedule(3500);
		
		//Wipe bird message after 5000 milliseconds.
		wipeBirdMessage.schedule(5000);
	}
	
	/**
	 * Create game space when the "play button" is clicked.
	 * 
	 */
	public void playBtnClicked() {
	   	playBtn.addClickHandler(new ClickHandler() {
	   		@Override
	   		public void onClick(ClickEvent event) {	        	 
			   
	   			Document.get().getElementById("GameTitleScreen").getStyle().setDisplay(Display.NONE);
	   			Document.get().getElementById("PlayButton").getStyle().setDisplay(Display.NONE);
	   			
	   			Document.get().getElementById("GameBoard").getStyle().setDisplay(Display.BLOCK);
	   			Document.get().getElementById("CardLeft").getStyle().setDisplay(Display.BLOCK);
	   			Document.get().getElementById("CardMiddle").getStyle().setDisplay(Display.BLOCK);
	   			Document.get().getElementById("CardRight").getStyle().setDisplay(Display.BLOCK);
			   
	   			updateScreen();
	   		}
	   	});
	}
	
	/**
	 * Return interface to original state when continueBtn is
	 * clicked. If no one has won, start another round.
	 * 
	 */
	public void continueBtnClicked() {
		//add a clickListener to player attributes.
		continueBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				//Window.alert("Clicked!"); Tester to see if clickevent responding.
				roundInProgress = false;
	
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
				Document.get().getElementById("PlayerSelectedAttribute1").getStyle().setDisplay(Display.NONE);
				Document.get().getElementById("PlayerSelectedAttribute2").getStyle().setDisplay(Display.NONE);
				Document.get().getElementById("PlayerSelectedAttribute3").getStyle().setDisplay(Display.NONE);
				Document.get().getElementById("PlayerSelectedAttribute4").getStyle().setDisplay(Display.NONE);
				Document.get().getElementById("PlayerSelectedAttribute5").getStyle().setDisplay(Display.NONE);
				Document.get().getElementById("OpponentSelectedAttribute1").getStyle().setDisplay(Display.NONE);
				Document.get().getElementById("OpponentSelectedAttribute2").getStyle().setDisplay(Display.NONE);
				Document.get().getElementById("OpponentSelectedAttribute3").getStyle().setDisplay(Display.NONE);
				Document.get().getElementById("OpponentSelectedAttribute4").getStyle().setDisplay(Display.NONE);
				Document.get().getElementById("OpponentSelectedAttribute5").getStyle().setDisplay(Display.NONE);
				Document.get().getElementById("PlayerPlayedCard").getStyle().setDisplay(Display.NONE);
				Document.get().getElementById("OpponentPlayedCard").getStyle().setDisplay(Display.NONE);
				Document.get().getElementById("ContinueButton").getStyle().setDisplay(Display.NONE);
				
				//Update popup help message.
				Document.get().getElementById("myPopup").setInnerText("Choose a card from your deck to challenge your opponent with.");
				
				game.checkForVictory();
				if (game.getPlayer().isWinner() && game.getOpponent().isWinner()){
					//Window.alert("It's a draw!");
					Document.get().getElementById("BristleBird").getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("SpeechBubble").getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("TieNoVictory").getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("RefreshButton").getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("myPopup").setInnerText("Stalemate! Thanks for playing");
				} else if (game.getOpponent().isWinner()){ 
					//Window.alert("Computer has won");
					Document.get().getElementById("BristleBird").getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("SpeechBubble").getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("ComputerVictory").getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("RefreshButton").getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("myPopup").setInnerText("Better luck next time. Thanks for playing.");
				} else if (game.getPlayer().isWinner()){
					//Window.alert("Player has won");
					Document.get().getElementById("BristleBird").getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("SpeechBubble").getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("PlayerVictory").getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("RefreshButton").getStyle().setDisplay(Display.BLOCK);
					Document.get().getElementById("myPopup").setInnerText("Congratulations! Thanks for playing.");
				}
			}		
		});
	}
	
	/**
	 * Toggle popup message when help icon is clicked.
	 * 
	 */
	public void helpIconClicked() {
		//add a clickListener to player attributes.
		helpIcon.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (popupActive == true) {
					Document.get().getElementById("myPopup").getStyle().setDisplay(Display.NONE);
					popupActive = false;
				} else {
					Document.get().getElementById("myPopup").getStyle().setDisplay(Display.BLOCK);
					popupActive = true;
				}
			}
		});
	}
	
	
	/**
	 * Play the appropriate bird call when sound button is clicked.
	 * 
	 * @param soundButton The sound button that was clicked.
	 * @param cardIndex The index of the card that owns the button.
	 * @param cardType The type of card that owns the button (deck card or draw card).
	 */
	public void soundButtonClicked(HTML soundButton, final int cardIndex, final CardType cardType) {
		//add a clickListener to deck
		soundButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				switch(cardType) {
					case DECK:
						audio.setSrc(game.getPlayer().getDeck().getCard(cardIndex).getAudioSource());
						audio.play();
						break;
						
					case DRAW:
						audio.setSrc(game.getDrawHand().getCard(cardIndex).getAudioSource());
						audio.play();
						break;
						
					case PLAYER:
						audio.setSrc(round.getPlayerCard().getAudioSource());
						audio.play();
						break;
					
					default:
						break;
				}
			}
		});
	}
	
	
	/**
	 * Play the appropriate bird call when a sound icon is clicked.
	 * 
	 */
	public void opponentRepeatSoundIconClicked() {
		//add a clickListener to CardRight
		opponentRepeatSoundIcon.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				audio.setSrc(round.getOpponentCard().getAudioSource());
				audio.play();
			}
		});
	}
}