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
		app.run();
	}

	private void run() {
		System.out.println("Welcome to Blackjack!");
		dealer.dealToPlayer(player);
		player.printPlayerHand();
		dealer.dealToDealer(dealer.getDeck().dealCard()); 
		System.out.println("Dealer has been dealt card [Hidden]");
		dealer.dealToPlayer(player);
		dealer.dealToDealer(dealer.getDeck().dealCard());
		player.printPlayerHand();
		dealer.printDealerHand();
		System.out.println("Player total is " + player.getPlayerHand().getHandValue());
//		System.out.println("Dealer total is " + dealer.getDealerHand().getHandValue());

		
		
//		if (dealer.getDealerHand().isBlackjack()) {
//		System.out.println("Dealer Blackjack! You are a loser!");
//		System.exit(0);
//	}
//
//	if (player.getPlayerHand().isBlackjack()) {
//		System.out.println("Blackjack! You are a winner!");
//		System.exit(0);
//	}
//
//	boolean hitAgain = true;
//	while (hitAgain) {
//		System.out.println("1. Hit");
//		System.out.println("1. Stay");
//		int hitOrStay = kb.nextInt();
//		switch (hitOrStay) {
//		case 1:
//			dealer.dealToPlayer(player);
//			player.getPlayerHand();
//			System.out.println("Your total is " + player.getPlayerHand().getHandValue());
//			hitAgain = player.getPlayerHand().isBust();
//			if (player.getPlayerHand().isBlackjack()) {
//				System.out.println("Blackjack!");
//				System.exit(0);
//			}
//			if (hitAgain == false) {
//				System.exit(0);
//			}
//			
//		case 2:
//			dealer.getDealerHand();
//			System.out.println("Dealer's total is: " + dealer.getDealerHand().getHandValue());
//			
//			while (dealer.getDealerHand().getHandValue() <= 17) {
//				dealer.dealToDealer(dealer.getDeck().dealCard());
//				dealer.printDealerHand();
//				System.out.println("Dealer's total is: " + dealer.getDealerHand().getHandValue());
//				hitAgain = dealer.getDealerHand().isBust();
//			}
//			
//			hitAgain = player.stay();
//		}
//	}
	}
}
