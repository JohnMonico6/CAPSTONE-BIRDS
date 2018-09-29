package com.birdworld.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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
		
		Card wattleBird = new Card("Wattle Bird", birdAtr, "images/WattleBird.png", "images/wattle_bird_option.png", "BirdSounds/little_wattlebird.mp3");
		Card wedgeTailEagle = new Card("Wedge-Tail Eagle", birdAtr, "images/WedgeTailEagle.png", "images/wedge-tailed_eagle_option.png", "BirdSounds/wedge-tailed_eagle.mp3");
		Card easternBristleBird = new Card("Eastern Bristle Bird", birdAtr, "images/EasternBristleBird.png", "images/eastern_bristlebird_option.png", "BirdSounds/eastern_bristlebird.mp3");
		Card australianMagpie = new Card("Australian Magpie", birdAtr, "images/Australian Magpie.PNG", "images/australian_magpie_option.png", "BirdSounds/australian_magpie.mp3");
		Card budgerigar = new Card("Budgerigar", birdAtr, "images/Budgerigar.PNG", "images/budgerigar_option.png", "BirdSounds/budgerigar.mp3");
		Card bushTurkey = new Card("Bush Turkey", birdAtr, "images/Bush Turkey.PNG", "images/bush_turkey_option.png", "BirdSounds/Brushturkey");
		Card bushStoneTurkey = new Card("Bush-Stone Curlew", birdAtr, "images/Bush-Stone Curlew.PNG", "images/bush-stone_curlew_option.png", "BirdSounds/Bush Stone-curlew");
		Card channelBilledCuckoo = new Card("Channel-Billed Cuckoo", birdAtr, "images/Channel-Billed Cuckoo.PNG", "images/channel-billed_cuckoo_option.png", "BirdSounds/Channel-billed Cuckoo");
		Card commonKoel = new Card("Common Koel", birdAtr, "images/Common Koel.PNG", "images/common_koel_option.png", "BirdSounds/Eastern Koel");
		Card commonMyna = new Card("Common Myna", birdAtr, "images/Common Myna.PNG", "images/common_myna_option.png", "BirdSounds/common_myna.mp3");
		Card crestedPidgeon = new Card("Crested Pidgeon", birdAtr, "images/Crested Pigeon.PNG", "images/crested_pigeon_option.png", "BirdSounds/Crested Pigeon");
		Card crimsonRosella = new Card("Crimson Rosella", birdAtr, "images/Crimson Rosella.PNG", "images/crimson_rosella_option.png", "BirdSounds/crimson_rosella.mp3");
		Card easternWhipbird = new Card("Eastern Whipbird", birdAtr, "images/Eastern Whipbird.PNG", "images/eastern_whipbird_option.png", "BirdSounds/");
		Card galah = new Card ("Galah", birdAtr, "images/Galah.PNG", "images/galah_option.png", "BirdSounds/galah.mp3");
		Card guidainFinch = new Card("Gouldain Finch", birdAtr, "images/Gouldian Finch.PNG", "images/gouldian_finch_option.png", "BirdSounds/Gouldian Finch");
		Card greyButcherbird = new Card("Grey Bitcherbird", birdAtr, "images/Grey Butcherbird.PNG", "images/grey_butcherbird_option.png", "BirdSounds/Grey Butcherbird");
		Card hoodedPlover = new Card("Hooded Plover", birdAtr, "images/Hooded Plover.PNG", "images/hooded_plover_option.png", "BirdSounds/Hooded Plover");
		Card kookaburra = new Card("Kookaburra", birdAtr, "images/Kookaburra.PNG", "images/laughing_kookaburra_option.png", "BirdSounds/laughing_kookaburra.mp3");
		Card magpieLark = new Card("Magpie Lark", birdAtr, "images/Magpie Lark.PNG", "images/magpie-lark_option.png", "BirdSounds/magpie-lark.mp3");
		Card noisyMiner = new Card("Noisy Miner", birdAtr, "images/Noisy Miner.PNG", "images/noisy_miner_option.png", "BirdSounds/noisy-miner.mp3");
		Card rainbowBeeEater = new Card("Rainbow Bee-Eater", birdAtr, "images/Rainbow Bee-Eater.PNG", "images/rainbow_bee-eater_option.png", "BirdSounds/Rainbow Bee-eater");
		Card rainbowLorikeet = new Card("Rainbow Lorikeet", birdAtr, "images/Rainbow Lorikeet.PNG", "images/rainbow_lorikeet_option.png", "BirdSounds/rainbow_lorikeet.mp3");
		Card satinBowerBird = new Card("Satin Bowerbird", birdAtr, "images/Satin Bowerbird.PNG", "images/satin_bowerbird_option.png", "BirdSounds/satin_bowerbird.mp3");
		Card scarletRobin = new Card("Scarlet Robin", birdAtr, "images/Scarlet Robin.PNG", "images/scarlet_robin_option.png", "BirdSounds/Scarlet Robin");
		Card shortTailedShearwater = new Card("Short Tailed Shearwater", birdAtr, "images/Short-Tailed Shearwater.PNG", "images/short-tailed_shearwater_option.png", "short-tailed_shearwater.mp3");
		Card spurWingedPlover = new Card("Spur-Winged Plover", birdAtr, "images/Spur-Winged Plover.PNG", "images/spur-winged_plover_option.png", "BirdSounds/Masked Lapwing");
		Card suburbFairywren = new Card("Suburn Fairy Wren", birdAtr,"images/Suberb Fairywren.PNG", "images/superb_fairywren_option.png", "BirdSounds/superb_fairywren.mp3");
		Card sulphurCrestedCockatoo = new Card("Sulphur Crested Cockatoo", birdAtr, "images/Sulphur Crested Cockatoo.PNG", "images/sulphur-crested_cockatoo_option.png", "BirdSounds/sulphur-crested_cockatoo.mp3");
		Card superbLurebird = new Card("Superb Lurebird", birdAtr, "images/Superb Lurebird.PNG", "images/superb_lyrebird_option.png", "BirdSounds/superb_lyrebird.mp3");
		Card tawnyFrogmouth = new Card("Tawny Frogmouth", birdAtr, "images/Tawny Frogmouth.PNG", "images/tawny_frogmouth_option.png", "BirdSounds/tawny_frogmouth.mp3");
		Card torresianCrow = new Card("Torresian Crow", birdAtr, "images/Torresian Crow.PNG", "images/torresian_crow_option.png", "BirdSounds/torresian_crow.mp3");
		Card welcomeSwallow = new Card("Welcome Swallow", birdAtr, "images/Welcome Swallow.PNG", "images/welcome_swallow_option.png", "BirdSounds/Welcome Swallow");
		
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
	
	public Card draw() {
		Card drawnCard;
		
		Random random = new Random();  
		
		int n = random.nextInt(pile.size()) + 0;

		drawnCard = pile.get(n);
		pile.remove(drawnCard);
		
		return drawnCard;
	}
	
	public Card getCard(int index) {
		return pile.get(index);
	}
}
