/*  Author: Callum Warrilow (20106703)
 *  Date: 5/11/16
 */

/**  Class Desc: SmartComputer subclass of Player that implements methods
 *  in Player superclass. */
class SmartComputer extends Player {

    // -------- FIELDS ---------
    /** Holds the current {@link Card Card} the Computer is using in a round. */
    private Card current;

    // ---------- CONSTRUCTOR ----------
    /** Constructor to create the SmartComputer object.
     * @param pName - The name of the SmartComputer. */
    public SmartComputer(String pName) {
        super(pName);
    } // end of CONSTRUCTOR

    /** Method to set the {@link Card Card} the player is using in a round.
     * @param current - The Card the Computer is using in the round in which
     * the method is called. */
    void setCurrentCard(Card current){
        this.current = current;
    } // end of setCurrentCard() method

    /** Method override to find highest {@link Attribute Attribute} value and
     * choose that {@link Attribute Attribute}.
     * Method iterates through the values of each {@link Attribute Attribute}
     * for the {@link Card Card} upon which the method is called
     * and returns the choice of the {@link Attribute Attribute}
     * with the highest value.
     * @return The reference number of the highest valued
     * {@link Attribute Attribute}. */
    @Override
    public int chooseAttr(){

        Attribute currentAttr = current.getAttr(0);
        int maxVal = currentAttr.getVal();
        int bestAttr = currentAttr.getAttrNum();

        // --- for loop to find the highest valued attribute
        for(int i = 1; i < 6; i++){
            currentAttr = current.getAttr(i);
            int attrVal = currentAttr.getVal();
            if(maxVal < attrVal){
                bestAttr = currentAttr.getAttrNum();
                maxVal = attrVal;
            } // end of if statement
        } // end of for loop

        return bestAttr;
    } // end of chooseAttr() method
} // end of SmartComputer Class
