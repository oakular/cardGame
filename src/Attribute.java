
/*  Author: Callum Warrilow (201068703)
 *  for a Card and includes methods to get information on attribute.
 *  Date: 5/11/16
 */

/**  Class Desc: Attribute Class of Card Game that creates attribute. */
public class Attribute {

    // -------- FIELDS --------
    /** Holds name of Attribute object */
    private final String A_NAME;
    /** Holds reference number of Attribute object */
    private final int A_REF_NUM;
    /** Holds value of Attribute object */
    private final int VAL;

    // ---------- CONSTRUCTOR ----------
    /** Constructor to create Attribute object.
     * Assigns the name, reference number and value
     * passed as parameters to the instance.
     * @param rNum - Reference number of the Attribute.
     * @param aName - Name of the Attribute.
     * @param val - Value of the Attribute.
     */
    public Attribute(int rNum, String aName, int val){
        this.A_REF_NUM = rNum;
        this.A_NAME = aName;
        this.VAL = val;
        }

    /** Method to return Attribute value.
     * @return The value of the attribute upon which the method
     * is called.
     * */
    int getVal(){
        return VAL;
    } // end of getVal() method

    /** Method to return the reference number of the attribute.
     * @return Return the reference number of the object upon which
     * the method was called.
     */
    int getAttrNum(){
        return A_REF_NUM;
    }

    /** Method to override toString() to print out
     * Attribute fields in a specific format.
     * Overrides {@link Object#toString toString} method to print
     * Attribute fields.
     * @return The String showing the fields
     * of the Attribute upon which the method is called.
     */
    @Override
    public String toString(){
        return ((A_NUM +1) + ". " + A_NAME + "=\t" + VAL);
    } // end of toString() method
} // end of Attribute Class
