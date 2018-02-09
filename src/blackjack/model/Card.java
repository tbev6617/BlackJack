package blackjack.model;

public class Card 
{
	private String name;
	private int worth;
	public Card(int worth, String suit)
	{
		this.worth = worth;
		
		switch(worth)
		{
		case 1:
			name = "A";
			break;
		case 11:
			name = "J";
			this.worth = 10;
			break;
		case 12:
			name = "Q";
			this.worth = 10;
			break;
		case 13:
			name = "K";
			this.worth = 10;
			break;
		default:
			name = Integer.toString(worth);
			break;
		}
		
		if (suit.equals("Hearts"))
		{
			name += "♡";
		}
		else if (suit.equals("Clubs"))
		{
			name += "♣";
		}
		else if(suit.equals("Diamonds"))
		{
			name += "♢";
		}
		else if(suit.equals("Spades"))
		{
			name += "♠";
		}
		else
		{
			System.out.println("ERROR: INVALID SUIT ENTERED");
		}
	}
	public String toString()
	{
		return name;
	}
	public int getWorth()
	{
		return worth;
	}
}
