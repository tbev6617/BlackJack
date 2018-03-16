package blackjack.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


import blackjack.model.Card;
import blackjack.view.PopupDisplay;

public class BlackJackController 
{
	private List<Card> deck;
	private List<Card> playerCards;
	private List<Card> dealerCards;
//	private BlackJackFrame frame = new BlackJackFrame(this);
	private Scanner input;
	private PopupDisplay popup;
	
	public BlackJackController()
	{
		deck = new ArrayList<Card>();
		resetDeck();
		printDeck();
		
		playerCards = new ArrayList<Card>();
		dealerCards = new ArrayList<Card>();
		input = new Scanner(System.in);
		popup = new PopupDisplay();
	}
	
	public void start()
	{
		popup.displayText("Welcome to Blackjack");
		boolean quit = false;
		while(quit == false)
		{
			runGamePlay();
			if(!isYes(popup.getResponse("Continue to next round?")))
			{
				quit = true;
			}
		}
		popup.displayText("Good game! Thanks for playing!");
	}
	
	public void runGamePlay()
	{
		resetDeck();
		playerCards.clear();
		dealerCards.clear();
		
		dealerDraws();
		playerDraws();
		playerDraws();
		boolean stay = false;
		while(stay == false)
		{
			String text = "";
			text += "Dealer's card:";
			for(Card card : dealerCards)
			{
				text += " " + card;
			}
			text += "\nYour cards:";
			for(Card card : playerCards)
			{
				text += " " + card;
			}
			popup.displayText(text);
		}
	}
	
	public int cardsWorth(List<Card> cards)
	{
		int cardsWorth = 0;
		int numAces = 0;
		
		for(int i = 0; i < cards.size(); i++)
		{
			cardsWorth += cards.get(i).getWorth();
			if (cards.get(i).getWorth() == 1)
			{
				numAces++;
			}
		}
		
		if(numAces > 0 && cardsWorth < 12)
		{
			numAces--;
			cardsWorth += 10; //since we added the 1 already
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
	
	public void dealerDraws()
	{
		dealerCards.add(deck.get(0));
		deck.remove(0);
	}
	
	public void playerDraws()
	{
		playerCards.add(deck.get(0));
		deck.remove(0);
	}
	
	public boolean isYes(String text)
	{
		if (text.contains("y") || text.contains(("Y")))
		{
			return true;
		}
		return false;
	}
}
