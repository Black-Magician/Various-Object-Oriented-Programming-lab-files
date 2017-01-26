import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards {

	//an ArrayList is used for the deck because it starts out empty to be filled by the cards in the 
	// resetDeckOfCards() method
	private ArrayList<Card> deck;
	//random variable because it is used to draw cards out of the deck
	private static final Random rand = new Random();
	
	
	//constructor to fill the deck with all of the possible cards
	public DeckOfCards()
	{
		deck = new ArrayList<Card>();
		resetDeckOfCards();		
	}
	
	//removes all leftover cards from the Array List and refills the deck with cards
	public void resetDeckOfCards()
	{
		deck.clear();
		
		String[] ranks = Card.getPossibleRanks();
		char[] suits = Card.getPossibleSuits();
			
		for(int r = 0; r < ranks.length; r++)
		{
			for(int i = 0 ; i < suits.length ; i++)
			{
				Card card = new Card(ranks[r],suits[i]);
				deck.add(card);
			}
		}	
	}
	
	//this is to draw a random card in the deck and to 
	//sort of simulate a shuffled deck to increase fairness in the game
	public Card getCard()
	{
		if(deck.size() == 0)
		{
			this.resetDeckOfCards();	
		}
			
		int	num = rand.nextInt(deck.size());
			
		return deck.remove(num);
	}
		
	//drawing a hand for the game
	public ArrayList<Card> getHand(int size)
	{
		if (size <= 0)
		{
			return null;
		}
		
		ArrayList<Card> hand = new ArrayList<Card>();
		
		for(int i=0; i < size ; i++)
		{
			hand.add(this.getCard());
		}
		return hand;
	}
	
	
	
	
}
