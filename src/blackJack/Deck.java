package blackJack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Card> deck;
	int totalCards = 52;

	public Deck() {
		deck = new ArrayList<>(52);
		for (Suit s : Suit.values()) {
			for (Rank r : Rank.values()) {
				deck.add(new Card(r, s));
			}
		}
		shuffleDeck();
	}

	public void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	public void printDeck(){
		for (Card card : deck) {
			card.printCard();			
		}
	}

	public Card dealCard() {
		totalCards --;	
		return deck.remove(0);
	}
	

}