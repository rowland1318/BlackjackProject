package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.players.BlackjackDealer;
import com.skilldistillery.blackjack.players.BlackjackPlayer;

public class BlackjackApp {

	// F I E L D S
	BlackjackPlayer player = new BlackjackPlayer();
	BlackjackDealer dealer = new BlackjackDealer();
	Scanner kb = new Scanner(System.in);

	// M E T H O D S

	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		app.displayInitialMenu();
	}
	
	
	public void displayInitialMenu() {
		System.out.println("Welcome to the Blackjack Table!");
		boolean keepPlaying = true;
		while(keepPlaying) {
			try {
				System.out.println("Would you like to be dealt into the game?");
				System.out.println("1. Be Dealt In \n2. Leave the Table");
				int userChoice = kb.nextInt();
				switch(userChoice) {
				case 1:
					gamePlay();
					break;
				case 2:
					System.out.println("Good, I didn't want you at my table anyways");
					System.exit(0);
					break;
				default:
					System.out.println("Please enter either 1 or 2");
					kb.hasNextInt();
				}
			} catch (Exception e) {
				System.out.println("Please enter either 1 or 2");
			}
		}
		
	} // end of displayMenu Method

	public void gamePlay() {
		//dealing the cards
		dealer.dealToPlayer(player);
		player.printPlayerHand();
		dealer.dealToDealer(dealer.getDeck().dealCard()); 
		System.out.println("Dealer has been dealt the:\n[Hidden]");
		dealer.dealToPlayer(player);
		dealer.dealToDealer(dealer.getDeck().dealCard());
		player.printPlayerHand();
		dealer.printDealerHandHidden();
		System.out.println("Player total is " + player.getPlayerHand().getHandValue());
		System.out.println("Dealer total is " + dealer.getDealerHand().getHandValue());
		
		if(!player.getPlayerHand().blackjackCheck() && !dealer.getDealerHand().blackjackCheck()) {
			playerInternalMenu();
		}
		if(player.getPlayerHand().blackjackCheck() || dealer.getDealerHand().blackjackCheck()) {
			winnerCheck();
		} else {
			System.out.println("Goodbye Peasant");
			System.exit(0);
		}

	} // end of gamePlay Method
	
	public void winnerCheck() {
		if(dealer.getDealerHand().blackjackCheck()) {
			System.out.println("You get nothing! You lose! Good day, sir!");
		}
		if(player.getPlayerHand().blackjackCheck()) {
			System.out.println("BLACKJACK! That was unexpected. . . ");
		}
		if(dealer.getDealerHand().bustCheck()) {
			System.out.println("The Dealer Busted, which means you lucked out this time scrub.");
			playAgain();
		}
		if(dealer.getDealerHand().getHandValue() == player.getPlayerHand().getHandValue()) {
			System.out.println("Looks like we have a tie here boys");
			playAgain();
		}
	} //end of winnerCheck Method
	
	public void playAgain() {
		System.out.println("Thank you for playing Blackjack at my table, have a mediocre day!");
		dealer.getDealerHand().clear();
		player.getPlayerHand().clear();
		dealer.getDeck(); //unable to reach the create deck
		displayInitialMenu();
	}
	
	
	public void playerInternalMenu() {
	boolean hitAgain = true;
	while (hitAgain) {
		try {
			System.out.println("1. Hit \n2. Stay \n3. Quit");
			int hitOrStay = kb.nextInt();
			switch (hitOrStay) {
			case 1:
				//dealer hits them with another card
				dealer.dealToPlayer(player);
				player.printPlayerHand();
				System.out.println("Player total is now: " + player.getPlayerHand().getHandValue());
				checkPlayerHand();
				break;
			case 2:
				dealer.getDealerHand();
				dealerHandPlay();
				checkDealerHand();
				break;
			case 3:
				System.out.println("Exiting Game");
				System.exit(0);
				break;
			default:
				System.out.println("Please enter a number 1-3");
				kb.hasNextInt();
			}
		} catch (Exception e) {
			System.out.println("Please enter a number 1-3");
		}
	} 
	}
	
	public void dealerHandPlay() {
		while(!dealer.getDealerHand().bustCheck() && (!(dealer.getDealerHand().getHandValue() == 21))) {
			do {
				if (dealer.dealerUnder17() && !dealer.getDealerHand().bustCheck()) {
					System.out.println("Dealer asks for another card");

					dealer.dealToDealer(dealer.getDeck().dealCard());
					dealer.printDealerBothCards();
					System.out.println("Dealer's total is now :  " + dealer.getDealerHand());
				}
				if (!dealer.dealerUnder17() && !dealer.getDealerHand().bustCheck()) {
					System.out.println("Dealer has decided to stay");
					System.out.println("Dealer's total is still :  " + dealer.getDealerHand());
					playerInternalMenu();
				}
			} while (dealer.getDealerHand().bustCheck() || (dealer.getDealerHand().getHandValue() == 21));
			winnerCheck();
		}
	}
	
	public void checkPlayerHand() {
		if (player.getPlayerHand().bustCheck() || player.getPlayerHand().blackjackCheck()) {
			winnerCheck();
		}
	}
	
	public void checkDealerHand() {
		if(dealer.getDealerHand().bustCheck() || dealer.getDealerHand().blackjackCheck()) {
			winnerCheck();
		}
	}


}
