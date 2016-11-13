/*  Author: Callum Warrilow (201068703)
 *  Date: 5/11/16
 */

// ------ IMPORT STATEMENTS ------
import java.util.Random;

/**  Class Desc: RandomComputer subclass of Player that implements methods
 *  in Player superclass. */
public class RandomComputer extends Player {

    // ---------- CONSTRUCTOR ----------
    /** Constructor to create RandomComputer object.
     * @param pName - The name of the RandomComputer. */
    public RandomComputer(String pName) {
        super(pName);
    } // end of CONSTRUCTOR

    /** Method override to choose an attribute at random.
     * Uses {@link Random Random} to choose numbers between
     * 0 and 5 to pick a an attribute by its reference number.
     * @return The attribute reference number that is chosen
     * at random. */
    @Override
    public int chooseAttr(){
        Random rand = new Random();

        // take a random number between 0 and 5
        int compChoice = rand.nextInt(5) + 0;

        System.out.println("COMP chooses " + compChoice);

        return compChoice;
    } // end of chooseAttr() method
} // end of RandomComputer Class
