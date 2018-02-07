package blackjack.controller;

import java.util.List;
import java.util.ArrayList;
import blackjack.model.*;
public class BlackJackController 
{
	private List<Card> deck;
	
	public BlackJackController()
	{
		deck = new ArrayList<Card>();
		String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
		for(String suit : suits)
		{
			for(int worth = 1; worth <= 13; worth++)
			{
				deck.add(new Card(worth, suit));
			}
		}
	}
	
	public void runGamePlay()
	{
		printDeck();
	}
	
	public void printDeck()
	{
		for(Card card: deck)
		{
			System.out.println(card);
		}
	}
	public void shuffleDeck()
	{
		
	}
}
