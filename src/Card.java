/*  Author: Callum Warrilow (201068703)
 *  Date: 5/11/16
 */

// ------ IMPORT STATEMENTS ------
import java.util.Random;

/** Class Desc: Card Class of Card Game that creates a card and holds
 *  attributes of that card.
 */
class Card {

    // -------- FIELDS ---------
    /** Holds Card name. */
    private final String NAME;

    /** Uses {@link Attribute Attribute} to
     * create an array of {@link Attribute Attribute}.
     */
    private Attribute[] attrArray;

    // ---------- CONSTRUCTOR ----------
    /** Constructor to create Card as an object.
     * @param name - the name of the Card
     * @param attrNum - the number of attributes on the Card
     * @param gameType - the type/genre of game the Card is playable in
     */
    public Card(String name, int attrNum, String gameType){
        this.NAME = name;

        // give card attributes values
        setAttr(attrNum, gameType);

    } // end of CONSTRUCTOR

    /** Method to return the name of the Card.
     * @return Name of the Card */
    public String getName(){
        return NAME;
    } // end of getName() method

    /** Method to set attributes for the card.
     * Assigns Attributes to the card based on the game type given.
     * @param attrNum - the number of attributes on the Card
     * @param gameType - the type/genre of game the Card is playable in
     */
    void setAttr(int attrNum, String gameType){
        attrArray = new Attribute[attrNum];
        String[] attrName = new String[attrNum];
        Random rand = new Random();

        // CHOOSE GAME TYPE
        if(gameType == "dnd"){
            attrName[0] = "STR";
            attrName[1] = "DEX";
            attrName[2] = "CON";
            attrName[3] = "INT";
            attrName[4] = "WIS";
            attrName[5] = "CHA";
        }else{
            attrName[0] = "SPEED";
            attrName[1] = "HORSEPWR";
            attrName[2] = "TORQUE";
            attrName[3] = "PRICE";
            attrName[4] = "STYLE";
            attrName[5] = "SAFETY";
        } // end of if-else statement

        // --- for loop to add random values to
        // attributes
        for(int i = 0; i < attrNum; i++){
            int val = rand.nextInt(9) + 0;
            attrArray[i] = new Attribute(i, attrName[i], val);
        } // end of for loop
    } // end of setAttr() method

    /** Method to return a specific attribute.
     * Returns the Attribute name based on the attribute number
     * passed as a parameter.
     * @param attr - the attr number for which the name is to be returned
     * @return Name of the attribute passed as a parameter
     */
    public Attribute getAttr(int attr){
        return attrArray[attr];
    } // end of getAttr() method

    /** Method override to print Card Name in specified format.
     * Overrides {@link Object#toString toString} method to print
     * Card name.
     * @return The name of the card upon which the method is called.
     */
    @Override
    public String toString(){
        return (NAME);
    } // end of toString() method
} // end of Card class
