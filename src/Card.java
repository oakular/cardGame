// ------ IMPORT STATEMENTS ------
import java.util.Random;

class Card {
    
	// -------- FIELDS ---------
    private final String NAME;
    private Attribute[] attrArray;
    
    // ---------- CONSTRUCTOR ----------
    public Card(String name, int attrNum, String gameType){
        this.NAME = name;
        
        setAttr(attrNum, gameType);
        
    } // end of CONSTRUCTOR

    // ----- method to return the name of the card
    public String getName(){
        return NAME;
    } // end of getName() method
    
    // ----- method to set attributes for the card
    void setAttr(int attrNum, String gameType){
		attrArray = new Attribute[attrNum];
		String[] attrName = new String[attrNum];
        Random rand = new Random();

    	if(gameType == "dnd"){
    		attrName[0] = "STR";
    		attrName[1] = "DEX";
    		attrName[2] = "CON";
    		attrName[3] = "INT";
    		attrName[4] = "WIS";
    		attrName[5] = "CHA";
    	} // end of if statement

        for(int i = 0; i < attrNum; i++){
        	int val = rand.nextInt(9) + 0;
        	attrArray[i] = new Attribute(attrName[i], val);
        } // end of for loop
    } // end of setAttr() method

    // ----- method to return a specfic attribute
    public Attribute getAttr(int attr){
        return attrArray[attr];
    } // end of getAttr() method
} // end of Card class