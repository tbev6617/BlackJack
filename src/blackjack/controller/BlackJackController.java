package blackjack.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import blackjack.view.BlackJackFrame;

import blackjack.model.Card;

public class BlackJackController 
{
	private List<Card> deck;
	List<Card> userCards;
	List<Card> dealerCards;
	Scanner input = new Scanner(System.in);
	BlackJackFrame frame = new BlackJackFrame(this);
	
	public BlackJackController()
	{
		deck = new ArrayList<Card>();
		resetDeck();
		printDeck();
		
		userCards = new ArrayList<Card>();
		dealerCards = new ArrayList<Card>();
	}
	
	public void start()
	{
		System.out.println("Welcome to Blackjack");
		boolean quit = false;
		while(quit == false)
		{
			runGamePlay();
			System.out.println("Continue Playing?");
			if(!isYes())
			{
				quit = true;
			}
		}
		System.out.println("Thanks for playing! Come back soon!");
	}
	
	public void runGamePlay()
	{
		System.out.println("[INSERT GAMEPLAY HERE]");
	}
	
	public int cardsWorth(ArrayList<Card> cards)
	{
		int cardsWorth = 0;
		int numAces = 0;
		
		for(Card card : cards)
		{
			cardsWorth += card.getWorth();
			if (card.getWorth() == 1)
			{
				numAces++;
			}
		}
		
		if(numAces > 0 && cardsWorth < 12)
		{
			numAces--;
			cardsWorth += 10;
		}
		
		if(cardsWorth > 21)
		{
			cardsWorth = 0;
		}
		
		return cardsWorth;
	}
	
	public void resetDeck()
	{
		deck.clear();
		String[] suits = {"Hearts", "Clubs", "Diamonds", "Spades"};
		for(String suit : suits)
		{
			for(int worth = 1; worth <= 13; worth++)
			{
				deck.add(new Card(worth, suit));
			}
		}
		Collections.shuffle(deck);
	}
	
	public void printDeck()
	{
		for(Card card: deck)
		{
			System.out.println(card);
		}
	}
	
	public boolean isYes()
	{
		System.out.println("Type \"Yes\" or \"No:\"");
		if(input.nextLine().toLowerCase().contains("y"))
		{
			return true;
		}
		return false;
	}
}
