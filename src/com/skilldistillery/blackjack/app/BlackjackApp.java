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
		System.out.println(" Welcome to the Blackjack Table!");
		System.out.println("--------------------------------");
		boolean keepPlaying = true;
		while (keepPlaying) {
			try {
				System.out.println("Would you like to be dealt into the game?");
				System.out.println();
				System.out.println("1. Be Dealt In \n2. Leave the Table");
				int userChoice = kb.nextInt();
				switch (userChoice) {
				case 1:
					initialDealingOfHands();
					break;
				case 2:
					System.out.println("Good, I didn't want you at my table anyways. . . Go on get!");
					System.exit(0);
					break;
				default:
					System.out.println("Please enter either 1 or 2");
					break;
				}
			} catch (Exception e) {
				System.out.println("Please enter either 1 or 2");
				kb.hasNextLine();
			}
		}

	} // end of displayMenu Method

	public void initialDealingOfHands() {
		// dealing the cards
		dealer.dealToPlayer(player);
		player.printPlayerHand();
		dealer.dealToDealer(dealer.getDeck().dealCard());
		System.out.println("Dealer has been dealt the:\n[Hidden]");
		System.out.println();
		dealer.dealToPlayer(player);
		dealer.dealToDealer(dealer.getDeck().dealCard());
		player.printPlayerHand();
		dealer.printDealerHandHidden();
		System.out.println();
		System.out.println("Player total is " + player.getPlayerHand().getHandValue());
//		System.out.println("Dealer total is " + dealer.getDealerHand().getHandValue()); // display when testing
		System.out.println();
		// checking for blackjack
		// if no one has blackjack then display internal menu for player to be given the
		// option hit or stand
		if (!player.getPlayerHand().isBlackjack() && !dealer.getDealerHand().isBlackjack()) {
			playerHitorStand();
		}
		// if there is a blackjack then go to winnerCheck to display the correct sysout
		if (player.getPlayerHand().isBlackjack() || dealer.getDealerHand().isBlackjack()) {
			winnerCheck();
		}

	} // end of gamePlay Method
	
	
	public void playerHitorStand() {
		while (!player.getPlayerHand().isBust()) {
			System.out.println("1. Hit \n2. Stand \n3. Quit");
			try {
				int hitOrStand = kb.nextInt();
				switch (hitOrStand) {
				case 1:
					// dealer hits them with another card
					dealer.dealToPlayer(player);
					player.printPlayerHand();
					System.out.println("Player total is now: " + player.getPlayerHand().getHandValue());
					System.out.println();
					if(player.getPlayerHand().isBust()) {
						winnerCheck();
						break;
					} else if (player.getPlayerHand().isBlackjack()) {
						winnerCheck();
						break;
					} else if (player.getPlayerHand().getHandValue() < 22) {
						continue;
					}
				case 2:
					System.out.println("You stand with a total of: " + player.getPlayerHand().getHandValue());
					System.out.println();
					dealer.getDealerHand();
					dealerHitOrStand();
					break;
				case 3:
					System.out.println("Exiting Game");
					System.exit(0);
					break;
				default:
					System.out.println("Please enter a number 1-3");
					break;
				}
			} catch (Exception e) {
				System.out.println("Please enter a number 1-3");
				kb.hasNextLine();
			}
		}
	}
	
	public void dealerHitOrStand() {
		while (!dealer.getDealerHand().isBust()) {
			if (dealer.getDealerHand().getHandValue() < 17) {
				System.out.println("Dealer asks for hit");
				dealer.dealToDealer(dealer.getDeck().dealCard());
				dealer.printDealerBothCards();
				System.out.println("Dealer's total is now :  " + dealer.getDealerHand().getHandValue());
				System.out.println();
				if (dealer.getDealerHand().isBust()) {
					break;
				}
				continue;
			} else {
				System.out.println("Dealer has decided to stand");
				dealer.printDealerBothCards();
				System.out.println("Dealer's total is : " + dealer.getDealerHand().getHandValue());
				System.out.println();
				break;
			}
		}
		winnerCheck();
	}
	
	
	public void winnerCheck() {
		if (dealer.getDealerHand().isBlackjack()) {
			System.out.println("Dealer has Blackjack! You get nothing! You lose! Good day, sir!");
		}
		if (player.getPlayerHand().isBlackjack()) {
			System.out.println("BLACKJACK! That was unexpected. . . ");
		}
		if (dealer.getDealerHand().isBust()) {
			System.out.println("The Dealer Busted, which means you lucked out this time scrub!");
		}
		if (player.getPlayerHand().isBust()) {
			System.out.println("You done busted!");
		}
		if (dealer.getDealerHand().getHandValue() == player.getPlayerHand().getHandValue()) {
			System.out.println("Looks like we have a tie here boys");
		}
		if (dealer.getDealerHand().getHandValue() < player.getPlayerHand().getHandValue() && !player.getPlayerHand().isBust()) {
			System.out.println("You win, you filthy animal!");
		}
		if (dealer.getDealerHand().getHandValue() > player.getPlayerHand().getHandValue() && !dealer.getDealerHand().isBust()) {
			System.out.println("The house wins! Maybe I'll finally get that raise!");
		}
		playAgain();
	} // end of winnerCheck Method

	public void playAgain() {
		System.out.println();
		System.out.println("Thank you for playing Blackjack at my table!");
		System.out.println();
		dealer.getDealerHand().clear();
		player.getPlayerHand().clear();
		displayInitialMenu();
	}


}