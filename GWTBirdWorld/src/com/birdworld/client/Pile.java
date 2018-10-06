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
		int[] wattlebirdStats = {2, 2, 3, 3, 3};
		int[] wedgeTailedEagleStats = {3, 5, 4, 4, 4};
		int[] easternBristleBirdStats = {5, 1, 3, 2, 4};
		int[] australianMagpieStats = {2, 3, 3, 3, 4};
		int[] budgerigarStats = {1, 2, 3, 3, 2};
		int[] brusnTurkeyStats = {1, 5, 2, 2, 4};
		int[] bushStoneCurlewStats = {1, 3, 2, 4, 2};
		int[] channelBilledCuckooStats = {1, 4, 1, 5, 1};
		int[] commonKoelStats = {3, 3, 3, 5, 1};
		int[] commonMynaStats = {2, 2, 3, 3, 4};
		int[] crestedPigeonStats = {2, 2, 3, 3, 2};
		int[] crimsonRosellaStats = {1, 2, 5, 3, 2};
		int[] easternWhipbirdStats = {3, 2, 3, 1, 3};
		int[] galahStats = {1, 2, 4, 3, 2};
		int[] gouldianStats = {2, 1, 5, 3, 1};
		int[] greyButcherbirdStats = {4, 2, 2, 2, 4};
		int[] hoodedPloverStats = {2, 2, 2, 2, 4};
		int[] laughingKookaburraStats = {2, 3, 3, 3, 5};
		int[] magpieLarkStats = {4, 2, 3, 3, 3};
		int[] noisyMinerStats = {2, 2, 3, 3, 5};
		int[] rainbowBeeEaterStats = {5, 2, 5, 4, 2};
		int[] rainbowLorikeetStats = {1, 3, 5, 4, 2};
		int[] satinBowerBirdStats = {1, 3, 3, 3, 3};
		int[] scarletRobinStats = {3, 1, 4, 2, 2};
		int[] shortTailedShearwaterStats = {1, 4, 1, 4, 2};
		int[] maskedLapwingStats = {2, 3, 2, 2, 5};
		int[] superbFairywrenStats = {3, 1, 4, 3, 1};
		int[] sulphurCrestedCockatooStats = {1, 4, 4, 1, 2};
		int[] superbLyrebirdStats = {1, 4, 3, 2, 3};
		int[] tawnyFrogmouthStats = {4, 2, 2, 1, 1};
		int[] torresianCrowStats = {3, 3, 1, 3, 4};
		int[] welcomeSwallowStats = {5, 2, 4, 4, 2};
		
		Card wattleBird = new Card("Wattlebird", wattlebirdStats, "images/Wattlebird.png", "images/wattle_bird_option.png", "BirdSounds/little_wattlebird.mp3");
		Card wedgeTailEagle = new Card("Wedge-Tail Eagle", wedgeTailedEagleStats, "images/Wedge-Tailed Eagle.png", "images/wedge-tailed_eagle_option.png", "BirdSounds/wedge-tailed_eagle.mp3");
		Card easternBristleBird = new Card("Eastern Bristle Bird", easternBristleBirdStats, "images/Eastern Bristlebird.png", "images/eastern_bristlebird_option.png", "BirdSounds/eastern_bristlebird.mp3");
		Card australianMagpie = new Card("Australian Magpie", australianMagpieStats, "images/Australian Magpie.png", "images/australian_magpie_option.png", "BirdSounds/australian_magpie.mp3");
		Card budgerigar = new Card("Budgerigar", budgerigarStats, "images/Budgerigar.png", "images/budgerigar_option.png", "BirdSounds/budgerigar.mp3");
		Card brushTurkey = new Card("Brush Turkey", brusnTurkeyStats, "images/Brush Turkey.png", "images/bush_turkey_option.png", "BirdSounds/Brushturkey");
		Card bushStoneTurkey = new Card("Bush-Stone Curlew", bushStoneCurlewStats, "images/Bush-Stone Curlew.png", "images/bush-stone_curlew_option.png", "BirdSounds/Bush Stone-curlew");
		Card channelBilledCuckoo = new Card("Channel-Billed Cuckoo", channelBilledCuckooStats, "images/Channel-Billed Cuckoo.png", "images/channel-billed_cuckoo_option.png", "BirdSounds/Channel-billed Cuckoo");
		Card commonKoel = new Card("Common Koel", commonKoelStats, "images/Common Koel.png", "images/common_koel_option.png", "BirdSounds/Eastern Koel");
		Card commonMyna = new Card("Common Myna", commonMynaStats, "images/Common Myna.png", "images/common_myna_option.png", "BirdSounds/common_myna.mp3");
		Card crestedPidgeon = new Card("Crested Pidgeon", crestedPigeonStats, "images/Crested Pigeon.png", "images/crested_pigeon_option.png", "BirdSounds/Crested Pigeon");
		Card crimsonRosella = new Card("Crimson Rosella", crimsonRosellaStats, "images/Crimson Rosella.png", "images/crimson_rosella_option.png", "BirdSounds/crimson_rosella.mp3");
		Card easternWhipbird = new Card("Eastern Whipbird", easternWhipbirdStats, "images/Eastern Whipbird.png", "images/eastern_whipbird_option.png", "BirdSounds/Eastern Whipbird.mp3");
		Card galah = new Card ("Galah", galahStats, "images/Galah.png", "images/galah_option.png", "BirdSounds/galah.mp3");
		Card gouldianFinch = new Card("Gouldain Finch", gouldianStats, "images/Gouldian Finch.png", "images/gouldian_finch_option.png", "BirdSounds/Gouldian Finch");
		Card greyButcherbird = new Card("Grey Bitcherbird", greyButcherbirdStats, "images/Grey Butcherbird.png", "images/grey_butcherbird_option.png", "BirdSounds/Grey Butcherbird");
		Card hoodedPlover = new Card("Hooded Plover", hoodedPloverStats, "images/Hooded Plover.png", "images/hooded_plover_option.png", "BirdSounds/Hooded Plover");
		Card kookaburra = new Card("Kookaburra", laughingKookaburraStats, "images/Laughing Kookaburra.png", "images/laughing_kookaburra_option.png", "BirdSounds/laughing_kookaburra.mp3");
		Card magpieLark = new Card("Magpie Lark", magpieLarkStats, "images/Magpie Lark.png", "images/magpie-lark_option.png", "BirdSounds/magpie-lark.mp3");
		Card noisyMiner = new Card("Noisy Miner", noisyMinerStats, "images/Noisy Miner.png", "images/noisy_miner_option.png", "BirdSounds/noisy-miner.mp3");
		Card rainbowBeeEater = new Card("Rainbow Bee-Eater", rainbowBeeEaterStats, "images/Rainbow Bee-Eater.png", "images/rainbow_bee-eater_option.png", "BirdSounds/Rainbow Bee-eater");
		Card rainbowLorikeet = new Card("Rainbow Lorikeet", rainbowLorikeetStats, "images/Rainbow Lorikeet.png", "images/rainbow_lorikeet_option.png", "BirdSounds/rainbow_lorikeet.mp3");
		Card satinBowerBird = new Card("Satin Bowerbird", satinBowerBirdStats, "images/Satin Bowerbird.png", "images/satin_bowerbird_option.png", "BirdSounds/satin_bowerbird.mp3");
		Card scarletRobin = new Card("Scarlet Robin", scarletRobinStats, "images/Scarlet Robin.png", "images/scarlet_robin_option.png", "BirdSounds/Scarlet Robin");
		Card shortTailedShearwater = new Card("Short Tailed Shearwater", shortTailedShearwaterStats, "images/Short-Tailed Shearwater.png", "images/short-tailed_shearwater_option.png", "BirdSounds/short-tailed_shearwater.mp3");
		Card maskedLapwing = new Card("Masked Lapwing", maskedLapwingStats, "images/Masked Lapwing.png", "images/spur-winged_plover_option.png", "BirdSounds/Masked Lapwing");
		Card superbFairywren = new Card("Superb Fairywren", superbFairywrenStats,"images/Superb Fairywren.png", "images/superb_fairywren_option.png", "BirdSounds/superb_fairywren.mp3");
		Card sulphurCrestedCockatoo = new Card("Sulphur Crested Cockatoo", sulphurCrestedCockatooStats, "images/Sulphur Crested Cockatoo.png", "images/sulphur-crested_cockatoo_option.png", "BirdSounds/sulphur-crested_cockatoo.mp3");
		Card superbLyrebird = new Card("Superb Lyrebird", superbLyrebirdStats, "images/Superb Lyrebird.png", "images/superb_lyrebird_option.png", "BirdSounds/superb_lyrebird.mp3");
		Card tawnyFrogmouth = new Card("Tawny Frogmouth", tawnyFrogmouthStats, "images/Tawny Frogmouth.png", "images/tawny_frogmouth_option.png", "BirdSounds/tawny_frogmouth.mp3");
		Card torresianCrow = new Card("Torresian Crow", torresianCrowStats, "images/Torresian Crow.png", "images/torresian_crow_option.png", "BirdSounds/torresian_crow.mp3");
		Card welcomeSwallow = new Card("Welcome Swallow", welcomeSwallowStats, "images/Welcome Swallow.png", "images/welcome_swallow_option.png", "BirdSounds/Welcome Swallow");
		
		//Adding all cards to the pile
		pile.add(wattleBird);
		pile.add(easternBristleBird);
		pile.add(wedgeTailEagle);
		pile.add(australianMagpie);
		pile.add(budgerigar);
		pile.add(brushTurkey);
		pile.add(bushStoneTurkey);
		pile.add(channelBilledCuckoo);
		pile.add(commonKoel);
		pile.add(commonMyna);
		pile.add(crestedPidgeon);
		pile.add(crimsonRosella);
		pile.add(easternWhipbird);
		pile.add(galah);
		pile.add(gouldianFinch);
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
		pile.add(maskedLapwing);
		pile.add(superbFairywren);
		pile.add(sulphurCrestedCockatoo);
		pile.add(superbLyrebird);
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
