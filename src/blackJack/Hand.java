package blackJack;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	List <Card> hand;
	
	public Hand() {
		hand = new ArrayList<>();
	}
	
	public void printHand(){
		for (Card card : hand){
			card.printCard();
		}
	}
	
	public void dealerShow() {
		Card dealerShow = hand.get(0);
		dealerShow.printCard();
	}
	
	public void addCardToHand(Card card){
		hand.add(card);
	}
	
	public void hit() {
		int i = hand.size() - 1;
		Card hit = hand.get(i);
		hit.printCard();
	}
	
	public int handValue(){
		int handValue = 0;
		for (Card card : hand){
			handValue = handValue + card.getValue();
		}
	//	System.out.println("test hand value " + handValue);
		return handValue;
	}
}
