package game;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private List<Card> cards;
	int cardsLeft = 52;
	public Deck() 
	{  
		for(int i=1;i<=13;i++) {
			for(int j=1;j<=4;j++)
			{
				cards.add(new Card(i,j));
			}
		}
	}
	 public void shuffle() {
		 
	        Collections.shuffle(cards);
	 }
	 
	 public List<Card> getDeck(){
			return cards;
		}
		
	public Card deal()
	{
		Card card = cards.get(0);
		cardsLeft -= 1; 
		cards.remove(0);
		return card;
	}
	
	public int cardsLeft() {
		return cardsLeft;
	}
	
	
	
}
