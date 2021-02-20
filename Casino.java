/**
 * Zhiwei Hu
 */
import java.util.*;

public class Casino {
	/**
	 * 
	 * @param args is the command line parameter required for the signature of the method
	 * @param balance is amount of money that player still has
	 * @param debt is the total amount of money that player borrows from dealer.
	 * @param bet is the amount of money that player put into this round
	 * @param betString is the amount of money that player put into this round, but in String data type
	 * @param moneyBorrowed is the amount of money that player borrows from dealer in a single time.
	 * @param moneyBorrowedStr is the amount of money that player borrows from dealer in a single time, but in String data type
	 * 
	 * @method enterValidBet first determine if the player's input is less than 0 or larger than current balance or it is not a number at all, 
	 *         if so, it will ask player to enter again. If the input is a number that is valid, then this method will convert the input string
	 *         into a integer and return it as the bet
	 * @method ifContinue asks player if they want to continue
	 * @method ifBorrow takes player's answer and see if they need to borrow money
	 * @method ifIsNum will determine if the player's input is a 'String-form' integer, if not, it will return false, otherwise return true.
	 * @method convertStrToNum will convert the valid input string into a integer and return the integer
	 * @method moneyBorrowed first determine if the player's input is less than 0 or it is not a number at all, if so, it will ask player to enter again.
	 *         If the input is is valid, then this method will convert the input string into a integer and return it as the bet
	 * 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int balance = 10000;
		int debt = 0;
		String betString = "0";
		Scanner userInput = new Scanner(System.in);
		System.out.println("Let's play! Your inital balance is 10000");//Every player's initial balance is 10000
		Deck deck = new Deck();//Create a deck object to get ready for playing
		
		do {
			int bet = 0;
			bet = enterValidBet(bet, balance, userInput, betString);
			
			Card userCard = deck.drawNextCard();
			Card dealerCard = deck.drawNextCard();
			System.out.println("Your card is " + userCard.toString() + ". Dealer's card is " + dealerCard.toString() + ".");
			
			if (userCard.value > dealerCard.value) {//the person whose card has larger value will win this round
				balance = balance + bet;
				System.out.println("you win this round, your remaining balance is " + balance);
			} else {
				balance = balance - bet;
				System.out.println("You lost this round, your remaining balance is: " + balance);
			}
			
			deck.discard(userCard);
			deck.discard(dealerCard);
			
			if (balance == 0) {//When balance is 0, dealer will ask player if they want to borrow monry
				System.out.println("Your balance is now 0, do you want to borrow money from us to continue playing?");
				//String ifBorrow = userInput.next();
				if (ifBorrow(userInput) == true) {
					int moneyBorrowed = 0;
					String moneyBorrowedStr = "0";
					moneyBorrowed = moneyBorrowed(moneyBorrowed, userInput, moneyBorrowedStr);
					debt = debt + moneyBorrowed;
					balance = moneyBorrowed;
					/*do {
						if (moneyBorrowed < 0 || ifIsNum(moneyBorrowedStr) == false) {
							System.out.println("The input is invalid, try again.");
						}
						System.out.println("Please enter how much money you want to borrow: ");
						moneyBorrowedStr = userInput.next();
						moneyBorrowed = convertStrToNum(moneyBorrowedStr);
					} while (moneyBorrowed < 0 || ifIsNum(moneyBorrowedStr) == false);*/
				}
			}
			
		} while (balance > 0 && ifContinue(userInput) == true);
		
		System.out.println("The game is over." + " Your remaining balance is " + balance + ". Your debt is " + debt + ". Thank you for your visit.");
		/*
		for (int i = 0; i < deck.discardPile.length; i++) {
			System.out.println(deck.currentDeck[i]);
		}*/
	}
	
	//enterValidBet() first determine if the player's input is less than 0 or larger than current balance or it is not a number at all.
	//If so, it will ask player to enter again. If the input is a number that is valid, then this method will convert the input string
	//into a integer and return it as the bet
	public static int enterValidBet(int bet, int balance, Scanner userInput, String betString) {
		do {
			if (bet < 0 || bet > balance || ifIsNum(betString) == false) {
				System.out.println("Your bet is invalid or larger than your remaining balance, try again.");
			}
		System.out.print("Please enter your bet:");
		betString = userInput.next();
		bet = convertStrToNum(betString);//userInput.nextInt();
		} while (bet < 0 || bet > balance || ifIsNum(betString) == false);
		return bet;
	}
	
	//ifContinue() asks player if they want to continue
	public static boolean ifContinue(Scanner userInput) {
		System.out.println("Do you want to continue? Please answer Yes or No or any word that starts with Y/y/N/n");
		String userAnswer = userInput.next();
		if (userAnswer.charAt(0) == 'y' || userAnswer.charAt(0) == 'Y') {
			return true;
		}
		return false;
	}
	
	//ifBorrow takes player's answer and see if they need to borrow money
	public static boolean ifBorrow(Scanner userInput) {
		String userAnswer = userInput.next();
		if (userAnswer.charAt(0) == 'y' || userAnswer.charAt(0) == 'Y') {
			return true;
		}
		return false;
	}
	
	//ifIsNum will determine if the player's input is a 'String-form' integer, if not, it will return false, otherwise return true.
	public static boolean ifIsNum(String a) {
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) < 48 || a.charAt(i) > 57) {
				return false;
			}
		}
		return true;
	}
	
	//convertStrToNum will convert the valid input string into a integer and return the integer
	public static int convertStrToNum(String a) {
		int res = 0;
		for (int i = a.length() - 1; i >= 0; i--) {
			int single = (int)(a.charAt(i) - 48);
			for (int j = 0; j < a.length() - i - 1; j++) {
				single = single * 10;
			}
			res = res + single;
		}
		//int out = (int)res;
		return res;
	}
	
	//moneyBorrowed first determine if the player's input is less than 0 or it is not a number at all, if so, it will ask player to enter again.
	//If the input is is valid, then this method will convert the input string into a integer and return it as the bet
	public static int moneyBorrowed(int moneyBorrowed, Scanner userInput, String moneyBorrowedStr) {
		do {
			if (moneyBorrowed < 0 || ifIsNum(moneyBorrowedStr) == false) {
				System.out.println("The input is invalid, try again.");
			}
			System.out.println("Please enter how much money you want to borrow: ");
			moneyBorrowedStr = userInput.next();
			moneyBorrowed = convertStrToNum(moneyBorrowedStr);
		} while (moneyBorrowed < 0 || ifIsNum(moneyBorrowedStr) == false);
		return moneyBorrowed;
	}
	
	

}
