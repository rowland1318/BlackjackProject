package com.skilldistillery.blackjack.players;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.hand.BlackjackHand;

public class BlackjackPlayer extends Player {
	private BlackjackHand hand;
	
	public BlackjackPlayer() {
		hand = new BlackjackHand();
	}
	
	public void hit(Card card) {
		hand.addCard(card);
	}
	
	public boolean stay() {
		return false;
	}
	
	public BlackjackHand getPlayerHand() {
		return hand;
	}

	public void printPlayerHand() {
		System.out.println("Player has been dealt the:\n" + hand.toString());
	}
	
}
