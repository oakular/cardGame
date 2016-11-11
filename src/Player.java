/*  Author: Callum Warrilow (20106703)
 *  Class Desc: Player superclass implements methods for creating
 *  and interacting with deck of cards in Card Game.
 *  Date: 5/11/16
 */

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
    } // end of CONSTRUCTOR

    void getCurrentCard(Card current){
	}

    public int chooseAttr(){
    	int choice;
    	Scanner attrChoice = new Scanner(System.in);

    	do{
    	System.out.print("\nChoose an Attribute No: ");
    	choice = attrChoice.nextInt();
    	}while(choice > 6 || choice < 1);

		return choice;
    } // end of chooseAttr() method
    // ----- method to return player name
    String getPName(){
    	return P_NAME;
    } // end of deckIsEmpty() method

}
