package blackJack;

public class Card {
	
		private Rank rank;
		private Suit suit;
		private int value;

		
		public Card(Rank rank, Suit suit) {
			this.rank = rank;
			this.suit = suit;
			this.value = rank.getValue();
		}

		public Rank getRank() {
			return rank;
		}

		public Suit getSuit() {
			return suit;
		}

		public int getValue() {
			return value;
		}

		public void printCard(){
			System.out.println(rank + " of " + suit);
		}

}
