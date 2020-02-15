package com.skilldistillery.blackjack.cards;

public class Card {
	// F I E L D S
	
	private Rank rank;
	private Suit suit;
	
	// M E T H O D S 
	
	public Card(Rank rank, Suit suit) {
		super();
		this.rank = rank;
		this.suit = suit;
	}
	
	public int getValue() {
		return rank.getValue();
	}

	  @Override
	  public String toString() {
	    StringBuilder builder = new StringBuilder();
	    builder.append(rank); //rank.getValue() would print numeric
	    builder.append(" of ");
	    builder.append(suit);
	    return builder.toString();
	  }
	  
	  
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

	
	

	
}
