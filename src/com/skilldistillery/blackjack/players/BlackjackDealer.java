package com.skilldistillery.blackjack.players;

import com.skilldistillery.blackjack.cards.Card;
import com.skilldistillery.blackjack.cards.Deck;
import com.skilldistillery.blackjack.hand.BlackjackHand;

public class BlackjackDealer extends BlackjackPlayer {
	private Deck deck;
	private BlackjackHand hand;
	
	public BlackjackDealer() {
		deck = new Deck();
		hand = new BlackjackHand();
	}
	
	public void dealToDealer(Card card) {
		hand.addCard(deck.dealCard());
	}
	
	public void dealToPlayer(BlackjackPlayer player) {
		player.getPlayerHand().addCard(deck.dealCard());
	}
	
	public Deck getDeck() {
		return deck;
	}
	
	public BlackjackHand getDealerHand() {
		return hand;
	}
	
	public void printDealerHandHidden() {
		System.out.println("Dealer has been dealt the:\n[Hidden] "+ hand.getHand().get(1));
	}
	
	public void printDealerBothCards() {
		System.out.println("Dealer has been dealt the:\n" + hand.toString());
	}
	
}
