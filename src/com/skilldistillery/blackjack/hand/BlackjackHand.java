package com.skilldistillery.blackjack.hand;

import com.skilldistillery.blackjack.cards.Card;

public class BlackjackHand extends Hand {
	
	// F I E L D S
	
	
	// M E T H O D S 
	
	public BlackjackHand() {
		super();
	}

	@Override
	public int getHandValue() {
		int handValue = 0;
		for (Card card : cards) {
			handValue += card.getValue();
		}
		return handValue;
	}
	
	public boolean isBlackjack() {
		if(this.getHandValue() == 21) {
			return true;
		} else {
			return false;	
		}
	}
	
	public boolean isBust() {
		if(this.getHandValue() > 21) {
			return true;
		} else {
			return false;
		}
	}

}
