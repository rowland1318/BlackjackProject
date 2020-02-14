package com.skilldistillery.blackjack.hand;

import java.util.*;

import com.skilldistillery.blackjack.cards.Card;

public abstract class Hand {
	// F I E L D S
	
	private List<Card> cards;
	
	// M E T H O D S 
	
	public Hand() {
		cards = new ArrayList<Card>();
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public void clear() {
		cards = new ArrayList<Card>();
	}
	
	public abstract int getHandValue();

	@Override
	public String toString() {
		return "Hand - cards: " + cards;
	}
	
}
