# Casino-Simulation
Designing a program that allows people to play the card games War at the terminal against the computer. Two classes were created

# Card class
The class representing a single card in a deck. Every card has three properties. The first 
is a “suit,” which is either “Hearts”, “Diamonds,” “Spades”, or “Clubs”. A card also has a color, 
where Hearts and Diamonds are red, and Spades and Clubs are black. Finally, each card has a value 
from 1-13 (inclusive). Some values have special names: the 1 is an Ace, 11 is a Jack, 12 is a Queen, 
and 13 is a King.

# Deck class
In an entire deck, there are 52 cards, each of the 13 values for the four different suits. As a user of the class, all you have to do is pick cards from the deck, and then discard them once you’re done with them. 

# Inside Deck class:
Deck(): This method will initialize the deck - creating an array of each of the 52 possible 
cards. After generating them, shuffling process will be executed (shuffling 
method is defined below). This method should also initialize a discard pile array, 
which currently has nothing in it. 

public void shuffle(): This method shuffles all of the items in the deck. 

public Card drawNextCard(): This method will give player the next card in the deck. Initially, this will be the card at index 0, then index 1, then index 2… up until index 51. After index 51, drawNextCard should take all of the cards in the discard pile, put them in the deck array, empty the discard pile, shuffle them, and then return the first one.

public void discard(Card c): This method will add the card into the discard pile. Initially it will add the card to the first index of the discard pile, then the second index, etc…

# Simple War Game
The rules here is a bit simpler than usual, but the object is to have a card with a higher 
value than the dealer. The user makes a bet. Then, both the user and the computer draw a card. If 
the user’s card has a larger value than the computer’s card, then the user wins, and gets the value 
of their bet added to their total. Otherwise, the computer wins, and the user loses their bet. After 
each round, discard the cards. Keep playing until the user runs out of money, or until they say 
they don’t want to play anymore. If player is out of money, they can choose to borrow money from casino o r simply quit, if they choose to borrow money, the debt will be presented when they quit







