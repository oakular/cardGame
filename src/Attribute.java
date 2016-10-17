import java.util.Random;

public class Attribute {
	
	private final String A_NAME;
	private final int VAL;
	
	public Attribute(String aName, int val){
		this.A_NAME = aName;
		this.VAL = val;	
		}
	
	int getVal(){
		return VAL;
	}

}
