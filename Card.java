/**
 * Zhiwei Hu
 * zhiweihu@brandeis.edu
 * Oct 16, 2020
 * PA05
 * COSI 12B
 */
public class Card {
	/**
	 * 
	 * @param args is the command line parameter required for the signature of the method
	 * @param suit is a specific property of a poker card
	 * @param color is the color of the card
	 * @param value is the number of the card
	 * 
	 * @constructor Card() is used to initialize a Card object, which takes value and suit as input parameters
	 * 
	 * @method getValue() gets the value of the card
	 * @method getColor() gets the color of the card
	 * @method getSuit() gets the suit of the card
	 * @method toString() return the information about the card following a specific rule
	 */
	String suit;
	String color;
	int value;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Card a = new Card(1, "Hearts");
		String b = a.toString();
		int value = a.getValue();
		String color = a.getColor();
		String suit = a.getSuit();
		System.out.println(b + " " + value + " " + color + " " + suit);*/
	}
	
	//Constructor Card is used to initialize a Card object, which takes value and suit as input parameters
	public Card(int value, String suit) {
		this.value = value;
		this.suit = suit;

	}
	
	//getValue() gets the value of the card
	public int getValue() {
		return value;
	}
	
	//getColor() gets the color of the card
	public String getColor() {
		if (suit.equals("Hearts") || suit.equals("Diamonds")) {
			return "red";
		} else {
			return "black";
		}
	}
	
	//getSuit() gets the suit of the card
	public String getSuit() {
		return suit;
	}
	
	//toString() return the information about the card following a specific rule
	public String toString() {
		if (value == 1) {
			return "Ace of " + suit;
		} else if (value == 11) {
			return "Jack of " + suit;
		} else if (value == 12) {
			return "Queen of " + suit;
		} else if (value == 13) {
			return "King of " + suit;
		}
		return value + " of " + suit;
	}
	


	

}
