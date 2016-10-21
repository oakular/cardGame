import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Player extends LinkedList{
    
	// -------- FIELDS --------
    protected final String P_NAME;
    protected Queue<Card> deck;
    protected int deckSize;
    protected static int bottom = 0;
    protected static int top;
    
    // ----- CONSTRUCTOR -----
    public Player(String pName){
        this.P_NAME = pName;

        deck = new LinkedList<Card>();
//        deck = new Card[deckSize];
    } // end of CONSTRUCTOR
    
    void getCurrentCard(Card current){
	}

    public int chooseAttr(){
    	Scanner attrChoice = new Scanner(System.in);
    	System.out.print("\nChoose an Attribute No: ");
		return attrChoice.nextInt();
    } // end of chooseAttr() method
    // ----- method to return player name
    String getPName(){
    	return P_NAME;
    } // end of deckIsEmpty() method
    
}
