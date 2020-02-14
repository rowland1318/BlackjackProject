package com.skilldistillery.blackjack.hand;

public class BlackjackHand extends Hand {
	
	// F I E L D S
	
	// M E T H O D S 
	
	public BlackjackHand() {
		super();
	}

	@Override
	public int getHandValue() {
		return 0;
	}
	
	public boolean isBlackjack() {
		// write the logic for cards = 21 first time
		return false;
	}
	
	public boolean isBust() {
		//write logic for bust
		return false;
	}

}
