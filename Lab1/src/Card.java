

public class Card {

	
private String rank;
private char suit;
	//an array for both the suits and ranks so there there is a set amount of combinations
	// also so there can't be any more ranks/suits added to the lists
private static String [] Ranks = {"2","3","4","5","6","7","8","9",
									"10","Jack","Queen","King"};
private static char[] Suits = {'C','H','D','S'};

//default constructor 
	public Card()
	{
		rank = "2";
		suit = 'H';
	}
//second constructor checks for validity of the new values
//if parameters do not work then the defaults are set
	public Card(String newrank, char newsuit)
	{
		if(rankValid(newrank))
			rank = newrank;
		else
			rank = "2";
		if(suitValid(newsuit))
			suit = newsuit;
		else
			suit = 'H';
	}
	//checks validity for rank
	//this is shorten the code in the Card constructor and mutators 
	public Boolean rankValid(String validRank)
	{
		for(String onerank: Ranks)
		{
			if(validRank.equals(onerank))
				return true;
		}
		return false;
	}
	// checks validity for suits 
	//this is shorten the code in the Card constructor and mutators 
	public Boolean suitValid(char validSuit)
	{
		for(char oneSuit: Suits)
		{
			if(validSuit == oneSuit)
				return true;
		}
		return false;
	}
	
	
	
	//returns rank in Sting
	public String getRank()
	{
		return rank;
	}
	//returns suit in char
	public char getSuit()
	{
		return suit;
	}
//if invalid input nothing changes
	public void setRank(String newRank)
	{
		if(rankValid(newRank))
			rank = newRank;
		
	}
//if invalid input nothing changes
	public void setSuit(char newSuit)
	{
		if (suitValid(newSuit))
			suit = newSuit;
	}
	// switches the chars to Strings of the suits
	// before returning the string
	public String toString()
	{
	
		String suitString = null;
		switch (suit){
		case 'C': suitString = "Clubs";
			break;
		case 'H': suitString = "Hearts";
			break;
		case 'D': suitString  = "Diamonds";
			break;
		case 'S': suitString = "Spades";
		
		}
		return rank + " of " + suitString;
			
	}
	//returns a shortened version without switching the suits into the long version
	//used in the game to show the hands of the players
	public String toShortString()
	{
		return "" + this.rank.charAt(0) + this.suit;
	}
	
	//returns the ranks as an array	of String
	public static String[] getPossibleRanks()
	{
		return Ranks;
	}
	
	//returns the suits as an array of char
	public static char[] getPossibleSuits()
	{
		return Suits;
	}
	
}