/**
 * <p>Card class simulates a card in a deck of cards.  
 * A card has a value and a suit.</p>
 * @author Bob Wilson
 * @version Oct 20, 2006
 */

public class Card
{
	public static final int NBR_VALUES = 5;
	public static final int NBR_SUITS = 4;
  
	private static final String [] values =
	{
		"Ace",
		"King",
		"Queen",
		"Jack",
		"Ten"
	};
  
	private static final String [] suits =
   {
		"Spades",
		"Hearts",
		"Diamonds",
		"Clubs"
   };
  
	private String value;
	private String suit;
  
	/** <p>the constructor method instantiates the card.</p>
	 * @param the String value of the card, e.g. "Ace", "King", etc.
	 * @param the String value of the suit, e.g. "Spades", "Hearts", etc.
	 */

	public Card(String value, String suit)
	{
		this.value = value;
		this.suit = suit;
	}
  
	/** <p>get the value of the card.</p>
	 * @ return the integer value of the card (0 to NBR_VALUES - 1)
	 * @param not used
	 */

	public int getValue()
	{
		for (int i = 0; i < values.length; i++)
			if (values[i].equals(value))
				return i;
		return -1;
	}
  
	/** <p>get the suit of the card.</p>
	 * @ return the integer suit of the card (0 to NBR_SUITS - 1)
	 * @param not used
	 */

	public int getSuit()
	{
		for (int i = 0; i < suits.length; i++)
			if (suits[i].equals(suit))
				return i;
		return -1;
	}
  
	/** <p>tostring method returns the value and suit of the card.</p>
	 * @return a string containing the value and the suit of the card.
	 */

	public String toString()
	{
		return value + " of " + suit;
	}
  
	/** <p>test main method for this class.</p>
	 * @param not used
	 */

	public static void main(String[] args)
	{
		Card aceOfSpades = new Card("Ace", "Spades");
		System.out.println(aceOfSpades);
		Card tenOfClubs = new Card("Ten", "Clubs");
		System.out.println(tenOfClubs);
    
		System.out.println(aceOfSpades.getValue() + ", " + aceOfSpades.getSuit());
		System.out.println(tenOfClubs.getValue() + ", " + tenOfClubs.getSuit());
	}
}