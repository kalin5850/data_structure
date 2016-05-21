/**
 * <p>Deck class simulates a shortened deck of cards (20 cards vs 52)</p>
 * @author Bob Wilson
 * @version Oct 20, 2006
 */
import java.util.*;

public class Deck
{
	Card [] deck;

	/** <p>the constructor method instantiates the deck with 20 cards
	 * in a pseudo-random order.  It takes no parameters.</p>
	 */
  
	public Deck()
	{
		deck = new Card[Card.NBR_VALUES * Card.NBR_SUITS];
    
		deck[ 0] = new Card("Ten", "Spades");
		deck[ 1] = new Card("Jack", "Diamonds");
		deck[ 2] = new Card("Ten", "Hearts");
		deck[ 3] = new Card("Ten", "Diamonds");
		deck[ 4] = new Card("Queen", "Hearts");
		deck[ 5] = new Card("Queen", "Spades");
		deck[ 6] = new Card("King", "Spades");
		deck[ 7] = new Card("Queen", "Diamonds");
		deck[ 8] = new Card("Ace", "Hearts");
		deck[ 9] = new Card("Jack", "Spades");
		deck[10] = new Card("Ace", "Clubs");
		deck[11] = new Card("Ace", "Spades");
		deck[12] = new Card("King", "Diamonds");
		deck[13] = new Card("King", "Clubs");
		deck[14] = new Card("Queen", "Clubs");
		deck[15] = new Card("King", "Hearts");
		deck[16] = new Card("Ace", "Diamonds");
		deck[17] = new Card("Jack", "Clubs");
		deck[18] = new Card("Jack", "Hearts");
		deck[19] = new Card("Ten", "Clubs");
	}
  
	/** <p>tostring method returns a list of the cards in the deck in order.</p>
	 * @return a string containing all of the card values and suits in order
	 */

	public String toString()
	{
		String s = "";
		for(Card c : deck)
			s += c.toString() + "\n";
		return s;
	}
  
	/** <p>sort method performs a radix sort on the cards by value and suit.</p>
	 */

	@SuppressWarnings("unchecked")
	public void sort()
	{
		// radix sort by value first (least significant field)
		Queue<Card>[] sortValue = (LinkedList<Card>[]) new LinkedList[5];
		for (int i = 0; i < sortValue.length; i++){
			sortValue[i] = new LinkedList<Card>();
		}
		for (int i = 0; i < deck.length; i++){
			sortValue[deck[i].getValue()].offer(deck[i]);
		}
		for (int i = 0, j = 0; i < sortValue.length; i++){
			Queue<Card> temp = sortValue[i];
			while(!temp.isEmpty()){
				deck[j] = temp.poll();
				j++;
			}
		}

		// radix sort by suit last (most significant field)
		Queue<Card>[] sortSuit = (LinkedList<Card>[]) new LinkedList[4];
		for (int i = 0; i < sortSuit.length; i++){
			sortSuit[i] = new LinkedList<Card>();
		}
		for (int i = 0; i < deck.length; i++){
			sortSuit[deck[i].getSuit()].offer(deck[i]);
		}
		for (int i = 0, j = 0; i < sortSuit.length; i++){
			Queue<Card> temp = sortSuit[i];
			while (!temp.isEmpty()){
				deck[j] = temp.poll();
				j++;
			}
		}
	}
  
	/** <p>test main method for this class.</p>
	 * @param not used
	 */

	public static void main(String [] args)
	{
		Deck myDeck = new Deck();
		System.out.println(myDeck);
    
		myDeck.sort();
		System.out.println(myDeck);
	}
}