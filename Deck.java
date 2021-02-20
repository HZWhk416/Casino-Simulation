/**
 * Zhiwei Hu
 */
import java.util.Random;

public class Deck {
	/**
	 * 
	 * @param args is the command line parameter required for the signature of the method
	 * @param currentDeck is a Card array that is used to draw card from
	 * @param discardPile is a Card array that is used to discard used cards
	 * @param nextindex is the index of the 'about-to-be-drawn' card in the currentDeck array
	 * @param nextindex1 is the index of the 'about-to-be-discard' card in the discardPile array
	 * 
	 * @constructor Deck() is used to initialize the deck, creating an array of each of the 52 possible 
     *              cards, and shuffle them in the currentDeck array. This constructor also initializes
     *              a discard pile array, which currently has nothing in it.
     *              
	 * @method shuffle() shuffles all items in the array into a random order.
	 * @method drawNextCard() gives out the next card in the deck (starting from index 0). However, after index 51, 
     *         this method should take all of the cards in the discard pile, put them in the deck 
     *         array, empty the discard pile, shuffle them, and then return the first one.
	 * @method discard(Card c) adds the card into the discard pile, staring from index 0.
	 */
	Card[] currentDeck;
	Card[] discardPile;
	int nextindex;
	int nextindex1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deck a = new Deck();
		for (int i = 0; i < 52; i++) {
			System.out.println(a.currentDeck[i].toString());
		}
	}
	
	//Deck() is used to initialize the deck, creating an array of each of the 52 possible 
    //cards, and shuffle them in the currentDeck array. This constructor also initializes
    //a discard pile array, which currently has nothing in it.
	public Deck() {
		int index = 0;
		String[] suit = new String[] {"Hearts", "Diamonds", "Spades", "Clubs"};
		currentDeck = new Card[52];
		discardPile = new Card[52];
		for (int i = 1; i < 14; i++) {
			for (int j = 0; j < 4; j++) {
				Card newCard = new Card(i, suit[j]);
				currentDeck[index] = newCard;
				index++;
			}
		}
		shuffle();
	}
	
	//shuffle() shuffles all items in the array into a random order
	public void shuffle() {
		Random rand = new Random();
		for (int i = 51; i >= 0; i--) {
			int j = rand.nextInt(i + 1);
			Card temp = currentDeck[j];
			currentDeck[j] = currentDeck[i];
			currentDeck[i] = temp;
		}
	}
	
	//drawNextCard() gives out the next card in the deck (starting from index 0). However, after index 51, 
    //this method should take all of the cards in the discard pile, put them in the deck 
    //array, empty the discard pile, shuffle them, and then return the first one.
	public Card drawNextCard() {
		if (nextindex > 51) {
			nextindex = 0;
			currentDeck = discardPile.clone();
			discardPile = new Card[52];
			shuffle();
			return currentDeck[nextindex];
		}
		return currentDeck[nextindex++];
	}
	
	//discard(Card c) adds the card into the discard pile, staring from index 0.
	public void discard(Card c) {
		discardPile[nextindex1++] = c;
	}
	


}
