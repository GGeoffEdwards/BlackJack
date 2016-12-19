package blackJack;

import java.util.Scanner;

public class Game {
	Scanner kb = new Scanner(System.in);
	Deck deck;
	Player dealer;
	Player player;
	
	
	public Game(){
		menu();
		deck = new Deck();
		game();
	}
	
	public void menu(){
		System.out.println();
		System.out.println("Would you like to play Black Jack?");
		System.out.println("1: Yes");
		System.out.println("2: Quit");	
	
}

	public void game(){
		int YesOrNo = kb.nextInt();
		if(YesOrNo == 1){
			blackJack();
		}
		if(YesOrNo ==2){
			System.out.println("Thank you for playing");
			System.exit(0);
		}
		else{
			menu();
		}
	}
	
	public void blackJack(){
		dealer = new Player("Dealer");
		int dealerValue;
		int playerValue;
		
		player = new Player("Player");
		
		
		dealer.hand.addCardToHand(deck.dealCard());
		player.hand.addCardToHand(deck.dealCard());
		dealer.hand.addCardToHand(deck.dealCard());
		player.hand.addCardToHand(deck.dealCard());		
		dealerValue = dealer.hand.handValue();
		playerValue = player.hand.handValue();
		
		System.out.println("The dealer is showing: ");
		dealer.hand.dealerShow();
		System.out.println(player.getName() + " has the cards:");
		player.hand.printHand();
		System.out.println(player.getName() + " has a value of " + playerValue);
		
		if (playerValue == 21 && dealerValue == 21){
			System.out.println("Sorry the dealer also has Black Jack. You Lose.");
			restart();
		}
		if (playerValue == 21 && dealerValue != 21){
			System.out.println("Black Jack! You win!");
			restart();
		}
		if(playerValue > 21)
			System.out.println("Bust until I figure out how to switch the Ace");
		
		hitStay();
//		System.out.println("What would you like to do?");
//		System.out.println("1: Hit");
//		System.out.println("2. Stay");
//		int hitStay = kb.nextInt();
//		
//		while (hitStay == 1){
//			if (hitStay == 1){
//				System.out.println("You hit. Good Luck.");
//				player.hand.addCardToHand(deck.dealCard());
//				player.hand.hit();		
//				playerValue = player.hand.handValue();
//				System.out.println("Your hand value is now " + playerValue);
//				
//				if (playerValue > 21 ){
//					System.out.println("Sorry you busted. You lose.");
//					restart();
//				}
//				
//				System.out.println("What would you like to do?");
//				System.out.println("1: Hit");
//				System.out.println("2. Stay");
//			}
//		}	
		
//		System.out.println("The dealer has the cards:");
//		dealer.hand.printHand();
//		System.out.println("The Dealer has a value of " + dealerValue );
//		
//		while (true) {
//			if (dealerValue <= 16) {
//				System.out.println("The dealer must hit");
//				dealer.hand.addCardToHand(deck.dealCard());
//				dealer.hand.hit();
//				dealerValue = dealer.hand.handValue();
//				System.out.println("The Dealer has a value of " + dealerValue );
//				
//				if (dealerValue <= 16) {
//					continue;
//				}			
//				if (dealerValue > 21) {
//					System.out.println("Dealer Busts. You win!");
//					restart();
//				} else if (dealerValue == 21 && playerValue < 21) {
//					System.out.println("Dealer has 21. You lose");
//					restart();
//				} else if (dealerValue == playerValue) {
//					System.out.println("Push");
//					restart();
//				}
//
//			}
//			if (dealerValue > 16) {
//				if (dealerValue > playerValue) {
//					System.out.println("Dealer has a higher value. You lose.");
//					restart();
//				} else if (dealerValue == playerValue) {
//					System.out.println("Push");
//					restart();
//				}
//			}
//			if (playerValue > dealerValue) {
//				System.out.println("You win! You had a higher value than the dealer");
//			}
//			restart();
//		}	
	}
	
	
	public void restart(){
		menu();
		deck = new Deck();
		game();
	}
	
	public void hitStay(){
		System.out.println("What would you like to do?");
		System.out.println("1: Hit");
		System.out.println("2. Stay");
		int hitStay = kb.nextInt();
		int playerValue = player.hand.handValue();
		int dealerValue = dealer.hand.handValue();
		
			if (hitStay == 1){
				System.out.println("You hit. Good Luck.");
				player.hand.addCardToHand(deck.dealCard());
				player.hand.hit();		
				playerValue = player.hand.handValue();
				System.out.println("Your hand value is now " + playerValue);
				
				if (playerValue > 21 ){
					System.out.println("Sorry you busted. You lose.");
					restart();
				}
				
				hitStay();		
			}
		
			System.out.println("The dealer has the cards:");
			dealer.hand.printHand();
			System.out.println("The Dealer has a value of " + dealerValue );
			
			while (true) {
				if (dealerValue <= 16) {
					System.out.println("The dealer must hit");
					dealer.hand.addCardToHand(deck.dealCard());
					dealer.hand.hit();
					dealerValue = dealer.hand.handValue();
					System.out.println("The Dealer has a value of " + dealerValue );
					
					if (dealerValue <= 16) {
						continue;
					}			
					if (dealerValue > 21) {
						System.out.println("You Win! Dealer Busts.");
						restart();
					} else if (dealerValue == 21 && playerValue < 21) {
						System.out.println("You lose. Dealer has 21.");
						restart();
					} else if (dealerValue == playerValue) {
						System.out.println("Push");
						restart();
					}

				}
				if (dealerValue > 16) {
					if (dealerValue > playerValue) {
						System.out.println("You lose. Dealer has a higher value than you.");
						restart();
					} else if (dealerValue == playerValue) {
						System.out.println("Push");
						restart();
					}
				}
				if (playerValue > dealerValue) {
					System.out.println("You Win! You had a higher value than the dealer");
				}
				restart();
			}	
	
		}
	}