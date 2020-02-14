package com.skilldistillery.blackjack.players;

import com.skilldistillery.blackjack.cards.Deck;
import com.skilldistillery.blackjack.hand.Hand;

public class BlackjackDealer extends BlackjackPlayer {
	private Deck deck;
	private Hand hand;
	
	public BlackjackDealer(Deck deck) {
		super();
		this.deck = deck;
	}

}
