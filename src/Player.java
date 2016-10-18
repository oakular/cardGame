import java.util.Queue;
import java.util.ArrayList;

public class Player {
    
	// -------- FIELDS --------
    protected final String P_NAME;
    protected Card[] deck;
    protected int deckSize;
    protected static int bottom = 0;
    protected static int top;
    
    // ----- CONSTRUCTOR -----
    public Player(String pName){
        this.P_NAME = pName;
        
        deck = new Card[deckSize];
    } // end of CONSTRUCTOR
    
    // ----- method to add a card to player's deck
    void addToDeck(Card cardToAdd){
        deck[bottom] = cardToAdd;
    } // end of addToDeck() method

    // ----- method to remove card from player's deck
    Card delFromDeck(){
    	if(deckIsEmpty()){
    		System.out.println("DECK IS EMPTY");
    		return null;
		}else{
			Card cardToDel = deck[top];
			return cardToDel;
    	} // end of if-else statement
    } // end of delFromDeck() method
    
    // ----- method to check if deck is empty
    boolean deckSize(){
    	return (deckSize == 0);
    } // end of deckIsEmpty() method

    // ----- method to return player name
    String getPName(){
    	return P_NAME;
    } // end of deckIsEmpty() method
    
}
