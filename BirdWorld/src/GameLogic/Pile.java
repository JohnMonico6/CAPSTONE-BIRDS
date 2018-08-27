package GameLogic;

import java.util.ArrayList;
import java.util.Collections;

public class Pile {
	ArrayList<Card> pile;
	int numOfCards = 10;
	
	/**
	 * 
	 * Currently all cards are hard coded.
	 * In future set code to draw cards from server.
	 * 
	 */
	public Pile() {
		pile = new ArrayList<Card>();
		
		
		//CURRENTLY ALL BIRD CARDS ARE HARDCODED FOR MVP
		int[] birdAtr = {1, 2, 3, 4, 5};
		
		Card wattleBird = new Card("Wattle Bird", birdAtr, "images/WattleBird.png");
		Card wedgeTailEagle = new Card("Wedge-Tail Eagle", birdAtr, "images/WedgeTailEagle.png");
		Card easternBristleBird = new Card("Eastern Bristle Bird", birdAtr, "images/EasternBristleBird.png");
		Card australianMagpie = new Card("Australian Magpie", birdAtr, "images/Australian Magpie.PNG");
		Card budgerigar = new Card("Budgerigar", birdAtr, "images/Budgerigar.PNG");
		Card bushTurkey = new Card("Bush Turkey", birdAtr, "images/Bush Turkey.PNG");
		Card bushStoneTurkey = new Card("Bush-Stone Curlew", birdAtr, "images/Bush-Stone Curlew.PNG");
		Card channelBilledCuckoo = new Card("Channel-Billed Cuckoo", birdAtr, "images/Channel-Billed Cuckoo.PNG");
		Card commonKoel = new Card("Common Koel", birdAtr, "images/Common Koel.PNG");
		Card commonMyna = new Card("Common Myna", birdAtr, "images/Common Myna.PNG");
		Card crestedPidgeon = new Card("Crested Pidgeon", birdAtr, "images/Crested Pidgeon.PNG");
		Card crimsonRosella = new Card("Crimson Rosella", birdAtr, "images/Crimson Rosella.PNG");
		Card easternWhipbird = new Card("Eastern Whipbird", birdAtr, "images/Eastern Whipbird.PNG");
		Card galah = new Card ("Galah", birdAtr, "images/Galah.PNG");
		Card guidainFinch = new Card("Gouldain Finch", birdAtr, "images/Gouldian Finch.PNG");
		Card greyButcherbird = new Card("Grey Bitcherbird", birdAtr, "images/Grey Butcherbird.PNG");
		Card hoodedPlover = new Card("Hooded Plover", birdAtr, "images/Hooded Plover.PNG");
		Card kookaburra = new Card("Kookaburra", birdAtr, "images/Kookaburra.PNG");
		Card magpieLark = new Card("Magpie Lark", birdAtr, "images/Magpie Lark.PNG");
		Card noisyMiner = new Card("Noisy Miner", birdAtr, "images/Noisy Minder.PNG");
		Card rainbowBeeEater = new Card("Rainbow Bee-Eater", birdAtr, "images/Rainbow Bee-Eater.PNG");
		Card rainbowLorikeet = new Card("Rainbow Lorikeet", birdAtr, "images/Rainbow Lorikeet.PNG");
		Card satinBowerBird = new Card("Satin Bowerbird", birdAtr, "images/Satin Bowerbird.PNG");
		Card scarletRobin = new Card("Scarlet Robin", birdAtr, "images/Scarlet Robin.PNG");
		Card shortTailedShearwater = new Card("Short Tailed Shearwater", birdAtr, "images/Short-Tailed Shearwater.PNG");
		Card spurWingedPlover = new Card("Spur-Winged Plover", birdAtr, "images/Spur-Winged Plover.PNG");
		Card suburbFairywren = new Card("Suburn Fairy Wren", birdAtr,"images/Suberb Fairywren.PNG");
		Card sulphurCrestedCockatoo = new Card("Sulphur Crested Cockatoo", birdAtr, "images/Sulphur Crested Cockatoo.PNG");
		Card superbLurebird = new Card("Superb Lurebird", birdAtr, "images/Superb Lurebird.PNG");
		Card tawnyFrogmouth = new Card("Tawny Frogmouth", birdAtr, "images/Tawny Frogmouth.PNG");
		Card torresianCrow = new Card("Torresian Crow", birdAtr, "images/Torresian Crow.PNG");
		Card welcomeSwallow = new Card("Welcome Swallow", birdAtr, "images/Welcome Swallow.PNG");
		
		//Adding all cards to the pile
		pile.add(wattleBird);
		pile.add(easternBristleBird);
		pile.add(wedgeTailEagle);
		pile.add(australianMagpie);
		pile.add(budgerigar);
		pile.add(bushTurkey);
		pile.add(bushStoneTurkey);
		pile.add(channelBilledCuckoo);
		pile.add(commonKoel);
		pile.add(commonMyna);
		pile.add(crestedPidgeon);
		pile.add(crimsonRosella);
		pile.add(easternWhipbird);
		pile.add(galah);
		pile.add(guidainFinch);
		pile.add(greyButcherbird);
		pile.add(hoodedPlover);
		pile.add(kookaburra);
		pile.add(magpieLark);
		pile.add(noisyMiner);
		pile.add(rainbowBeeEater);
		pile.add(rainbowLorikeet);
		pile.add(satinBowerBird);
		pile.add(scarletRobin);
		pile.add(shortTailedShearwater);
		pile.add(spurWingedPlover);
		pile.add(suburbFairywren);
		pile.add(sulphurCrestedCockatoo);
		pile.add(superbLurebird);
		pile.add(tawnyFrogmouth);
		pile.add(torresianCrow);
		pile.add(welcomeSwallow);
		
	}
	
	public void shuffle() {
		Collections.shuffle(pile);
	}
	
	public Card draw() {
		Card drawnCard;
		
		Collections.shuffle(pile);
		drawnCard = pile.get(0);
		pile.remove(drawnCard);
		
		return drawnCard;
	}
}
