import java.util.Random;

public class RandomComputer extends Player {

    // ---------- CONSTRUCTOR ----------
	public RandomComputer(String pName) {
		super(pName);
	} // end of CONSTRUCTOR
	
	// ----- method to choose an attribute at random
	@Override
	public int chooseAttr(){
		Random rand = new Random();
		int compChoice = rand.nextInt(5) + 0;

		System.out.println("COMP chooses " + compChoice);
		
		return compChoice;
	} // end of chooseAttr() method
} // end of RandomComputer Class
