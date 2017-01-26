import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class TwoPlayerBlackJack {

	
	private final static Random rand = new Random();
	private DeckOfCards playingDeck;
	//winning value is used so as to not have 21 everywhere
	//as well as for quick change in the future
	private final int WinningValue = 21;
	//used for drawing cards for the players to get cards between 3 and 10
	private final int MIN_HAND_SIZE = 2;
	private final int MAX_HAND_SIZE = 6;
	
	//default constructor
	public TwoPlayerBlackJack()
	{
		playingDeck = new DeckOfCards();
		
	}
	
	//sets the values of the face cards and the ace
	public int getCardValue(Card c)
	{
		if(c.getRank().equals("Jack")||c.getRank().equals("Queen")||c.getRank().equals("King"))
		{
			Integer value = new Integer(10);
			return value;
		}
		else if(c.getRank().equals("Ace"))
		{
			Integer value = new Integer(1);
			return value;
		}
		else
		{
			Integer value = Integer.parseInt(c.getRank());
			return value;
		}
	}
	//calculates the values of the cards given 
	//if there is one or more aces in the hand and the total is less than 12 
	// then the one ace is counted as 11, this is so if there is a large amount of aces in the hand
	// they aren't all counted as 11's and actually simulates a real game being played
	public int computeHandValue(ArrayList<Card> hand)
	{
		int aces = 0;
		int value = 0;
		
		for(Card card: hand)
		{
			value += getCardValue(card);
			if(card.getRank().equals("Ace"))
			{
				aces++;
			}
		}
		
		if((aces >= 1) && (value < 12))
		{
			value += 10;
		}
		
		return value;
	}
	//prints a numeric value for the cards in the hand given
	public String printHandValue(ArrayList<Card> hand)
	{
		String handInfo = "( ";
		
		for(Card card: hand)
		{
			handInfo += card.toShortString() + " ";
		}
		
		return handInfo + ") --> " + computeHandValue(hand);
	}
		
	//checks all possible ways there could be a winner with the random amount of cards drawn
	public int isWinner(ArrayList<Card> hand01, ArrayList<Card> hand02)
	{
		int p1 = computeHandValue(hand01);
		int p2 = computeHandValue(hand02);
		
				
		if((p1 <= WinningValue) && (p2 <= WinningValue) && (p1 > p2))
		{
			return 1;
		}
		else if(p1 == p2)
		{
			return 0;
		}
		else if((p1 <= WinningValue) && (p2 <= WinningValue) && (p1 < p2))
		{
			return -1;
		}
		else if((p1 > WinningValue) && (p2 <= WinningValue))
		{
			return -1;
		}
		else if((p1 <= WinningValue) && (p2 > WinningValue))
		{
			return 1;
		}
		else if((p1 > WinningValue) && (p2 > WinningValue))
		{
			if(p1 > p2)
			{
				return -1;
			}
			if(p1 < p2)
			{
				return 1;
			}
		}
			
		return 0;
	}
	
	public boolean toContinue()
	{

		// Ask a user if he/she would like to play again 
		System.out.print("Would you like to play again (Y/N)?\t");
		Scanner input = new Scanner(System.in);
		boolean playAgain = false;
		if((input.hasNext()&& input.nextLine().equalsIgnoreCase("y")))
		{
			playAgain = true;
		}
		input.close();
		return playAgain;

	}
	
	
		
	public void twoPlayerBlackJack()
	{
		ArrayList<Card> p1 = new ArrayList<Card>();
		ArrayList<Card> p2 = new ArrayList<Card>();
		
		
		
		do{
			
		
			//Get two hands of cards of size between 3 and 10 cards each
			p1 = playingDeck.getHand(this.MIN_HAND_SIZE + rand.nextInt(this.MAX_HAND_SIZE - this.MIN_HAND_SIZE + 1));
			p2 = playingDeck.getHand(this.MIN_HAND_SIZE + rand.nextInt(this.MAX_HAND_SIZE - this.MIN_HAND_SIZE + 1));
			
			//prints out the values of both of the hands
			System.out.println("Hand 1: "+ printHandValue(p1));
			System.out.println("Hand 2: "+ printHandValue(p2));
			
			//Show the winner 
			if(isWinner(p1,p2) == 1)
			{
				System.out.println("The Winner is Player 1");
			}
			else if(isWinner(p1,p2) == 0)
			{
				System.out.println("There is no winner, it is a push");
			}
			else
			{
				System.out.println("The Winner is Player 2");
			}
		}while(toContinue());
		
		
		
		
		
		
	}
	
		
	

}