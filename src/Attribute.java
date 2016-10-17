import java.util.Random;

public class Attribute {
	
	private final String A_NAME;
	private final int VAL;
	private Random rand = new Random();
	
	public Attribute(String aName){
		this.A_NAME = aName;
		VAL = rand.nextInt(9) + 0;
	}
	
	int getVal(){
		return VAL;
	}

}
