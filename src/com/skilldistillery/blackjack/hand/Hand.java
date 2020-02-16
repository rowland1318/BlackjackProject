package com.skilldistillery.blackjack.hand;

import java.util.*;

import com.skilldistillery.blackjack.cards.Card;

public abstract class Hand {
	// F I E L D S
	
	protected List<Card> cards;
	
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
		
	public List<Card> getHand() {
		
		List<Card> cardsDefensive = new ArrayList<>();
		cardsDefensive.addAll(cards);
		return cardsDefensive;
	}
	@Override
	public String toString() {
		return "" + cards;
	}
	
}
