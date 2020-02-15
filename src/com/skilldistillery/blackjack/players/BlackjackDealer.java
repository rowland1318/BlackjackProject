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
		hand.addCard(card);
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
	
	public void printDealerHand() {
		System.out.println("Dealer you have the:\n"  + " [Hidden] "+ hand.getHand().get(1));
	}
	
	
	
}
