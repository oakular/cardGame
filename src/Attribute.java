
/*  Author: Callum Warrilow (201068703)
 *  Class Desc: Attribute Class of Card Game that creates attribute
 *  for a Card and includes methods to get information on attribute.
 *  Date: 5/11/16
 */

public class Attribute {

	// -------- FIELDS --------
	private final String A_NAME;
	private final int A_NUM;
	private final int VAL;

    // ---------- CONSTRUCTOR ----------
	public Attribute(int aNum, String aName, int val){
		this.A_NUM = aNum;
		this.A_NAME = aName;
		this.VAL = val;
		}

	// ---- method to return Attribute Value
	int getVal(){
		return VAL;
	} // end of getVal() method

    // ---- method to return the number of the attribute
    // in a list of attributes (not its value)
	int getAttrNum(){
		return A_NUM;
	}

	// ---- method to override toString() to print out
	// Attribute Values in a specific format
	@Override
	public String toString(){
		return ((A_NUM +1) + ". " + A_NAME + "=\t" + VAL);
	} // end of toString() method
} // end of Attribute Class
