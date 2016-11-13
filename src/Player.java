/*  Author: Callum Warrilow (201068703)
 *  Class Desc: Player superclass implements methods for creating
 *  and interacting with deck of cards in Card Game.
 *  Date: 5/11/16
 */

// ------ IMPORT STATEMENTS ------
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Player extends LinkedList{

    // -------- FIELDS --------
    /** Holds the Player's name. */
    protected final String P_NAME;
    /** Holds the Player's deck of {@link Card Cards} */
    protected Queue<Card> deck;
    /** Holds the deckSize */
    protected int deckSize;

    // ----- CONSTRUCTOR -----
    /** Constructor to create Player object
     * @param pName - The name of the Player. */
    public Player(String pName){
        this.P_NAME = pName;

        deck = new LinkedList<Card>();
    } // end of CONSTRUCTOR

    /** Method to set the current value to the
     * card in the player's hand.
     * Required for the SmartComputer subclass
     * @param current - The card currently in play
     * for the player upon which the method is called. */
    void setCurrentCard(Card current){

    }
    /** Method to allow player to choose attribute from card
     * @return The choice of attribute by the player. */
    public int chooseAttr(){
        int choice;
        Scanner attrChoice = new Scanner(System.in);

        // --- do-while loop to ensure that the player's
        // choice is within the number range of the attributes
        do{
        System.out.print("\nChoose an Attribute No: ");
        choice = attrChoice.nextInt();
        }while(choice > 6 || choice < 1);

        return choice;
    } // end of chooseAttr() method

    /** Method to return player name. */
    String getPName(){
        return P_NAME;
    } // end of deckIsEmpty() method
}
