package com.skilldistillery.blackjack.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	// F I E L D S
	
	private List<Card> cards;
	
	// M E T H O D S 
	
	public Deck() {
		cards = createDeck();
	}
	
	private List<Card> createDeck() {
		cards = new ArrayList<>(52);
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				cards.add(new Card(rank, suit));
			}
		}
		return cards;
	}
	
	public int checkDeckSize() {
		return cards.size();
	}
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public Card dealCard() {
		return cards.remove(0);
	}
	
}
