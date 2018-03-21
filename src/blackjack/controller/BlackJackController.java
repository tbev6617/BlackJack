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
			
			//check if they're done
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
		//printDeck();
		playerCards.clear();
		dealerCards.clear();
		
		dealerDraws();
		playerDraws();
		boolean stay = false;
		while(stay == false)
		{
			playerDraws();
			showStats();
			
			//Check for stay or over 21
			if (cardsWorth(playerCards) == 0 || cardsWorth(playerCards) == 21)
			{
				stay = true;
			}
			else if (!isYes(popup.getResponse("Draw another card?")))
			{
				stay = true;
			}
			
		}
		while(cardsWorth(dealerCards) < 17 && cardsWorth(dealerCards) != 0)
		{
			dealerDraws();
			showStats();
		}
		if(cardsWorth(playerCards) > cardsWorth(dealerCards))
		{
			playerWins();
		}
		else if (cardsWorth(dealerCards) > cardsWorth(playerCards))
		{
			dealerWins();
		}
		else
		{
			tie();
		}
	}
	
	public void showStats()
	{
		String text = "";
		
		//Dealer
		text += "Dealer's cards:";
		for(Card card : dealerCards)
		{
			text += " " + card;
		}
		
		if (cardsWorth(dealerCards) == 0)
		{
			text += "(Bust)";
		}
		else
		{
			text += " (Worth " + cardsWorth(dealerCards) + ")";
		}
		
		//You
		text += "\nYour cards:";
		for(Card card : playerCards)
		{
			text += " " + card;
		}
		
		if (cardsWorth(playerCards) == 0)
		{
			text += "(Bust)";
		}
		else
		{
			text += " (Worth " + cardsWorth(playerCards) + ")";
		}
		
		
		popup.displayText(text);
	}
	
	public void playerWins()
	{
		popup.displayText("YOU WIN");
	}
	public void dealerWins()
	{
		popup.displayText("YOU LOSE");
	}
	public void tie()
	{
		popup.displayText("YOU TIE");
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
		popup.displayText("DEALER DRAWS " + deck.get(0));
		dealerCards.add(deck.get(0));
		deck.remove(0);
	}
	
	public void playerDraws()
	{
		popup.displayText("YOU DRAW " + deck.get(0));
		playerCards.add(deck.get(0));
		deck.remove(0);
	}
	
	public boolean isYes(String text)
	{
		text = text.toLowerCase();
		if (text.contains(("y")) || text.equals("") || text.equals("sure"))
		{
			return true;
		}
		return false;
	}
}
