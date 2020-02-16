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
					initialDealingOfHands();
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

	public void initialDealingOfHands() {
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
//		System.out.println("Dealer total is " + dealer.getDealerHand().getHandValue()); display when testing
		
		
		// checking for blackjack
		// if no one has blackjack then display internal menu for player to hit or stay
		if(!player.getPlayerHand().isBlackjack() && !dealer.getDealerHand().isBlackjack()) {
			playerInternalMenu();
		}
		// if there is a blackjack then go to winnerCheck to display the correct sysout
		if(player.getPlayerHand().isBlackjack() || dealer.getDealerHand().isBlackjack()) {
			winnerCheck();
		} 

	} // end of gamePlay Method
	
	public void winnerCheck() {
		if(dealer.getDealerHand().isBlackjack()) {
			System.out.println("Dealer has Blackjack! You get nothing! You lose! Good day, sir!");
		}
		if(player.getPlayerHand().isBlackjack()) {
			System.out.println("BLACKJACK! That was unexpected. . . ");
		}
		if(dealer.getDealerHand().isBust()) {
			System.out.println("The Dealer Busted, which means you lucked out this time scrub.");
		}
		if(player.getPlayerHand().isBust()) {
			System.out.println("You done busted!");
		}
		if(dealer.getDealerHand().getHandValue() == player.getPlayerHand().getHandValue()) {
			System.out.println("Looks like we have a tie here boys");
		}
		playAgain();
	} //end of winnerCheck Method
	
	public void playAgain() {
		System.out.println("Thank you for playing Blackjack at my table, would you like to play again?");
		System.out.println("Type Y for yes or N for no");
		String yesOrNo = kb.nextLine();
		if(yesOrNo.equalsIgnoreCase("Y")) {
			dealer.getDealerHand().clear();
			player.getPlayerHand().clear();
			dealer.getDeck(); //unable to reach the create deck
			displayInitialMenu();
		} else if (yesOrNo.equalsIgnoreCase("N")) {
			System.out.println("Have a mediocre day!");
			System.exit(0);
		}
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
		while(!dealer.getDealerHand().isBust() && (!(dealer.getDealerHand().getHandValue() == 21))) {
			do {
				if (dealer.dealerUnder17() && !dealer.getDealerHand().isBust()) {
					System.out.println("Dealer asks for another card");
					dealer.dealToDealer(dealer.getDeck().dealCard());
					dealer.printDealerBothCards();
					System.out.println("Dealer's total is now :  " + dealer.getDealerHand().getHandValue());
					winnerCheck();
				}
				if (!dealer.dealerUnder17() && !dealer.getDealerHand().isBust()) {
					System.out.println("Dealer has decided to stay");
					System.out.println("Dealer's total is still :  " + dealer.getDealerHand().getHandValue());
					winnerCheck();
				}
			} while (dealer.getDealerHand().isBust() || (dealer.getDealerHand().getHandValue() == 21));
			winnerCheck();
			if (player.getPlayerHand().getHandValue() > dealer.getDealerHand().getHandValue()) {
				System.out.println("Looks like you win this one partner");
			}
			if (player.getPlayerHand().getHandValue() < dealer.getDealerHand().getHandValue()) {
				System.out.println("Looks like you just weren't good enough this time, no surprise");
			}
		}
	}
	
	public void checkPlayerHand() {
		if (player.getPlayerHand().isBust() || player.getPlayerHand().isBlackjack()) {
			winnerCheck();
		}
	}
	
	public void checkDealerHand() {
		if(dealer.getDealerHand().isBust() || dealer.getDealerHand().isBlackjack()) {
			winnerCheck();
		}
	}


}