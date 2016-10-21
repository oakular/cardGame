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
	
	// ----- method to return Attribute Value
	int getVal(){
		return VAL;
	} // end of getVal() method
	
	int getAttrNum(){
		return A_NUM;
	}
	
	// ----- method to override toString() to print out
	// Attribute Values in a specific format
	@Override
	public String toString(){
		return ((A_NUM +1) + ". " + A_NAME + "=\t" + VAL);
	} // end of toString() method
} // end of Attribute Class
