import java.util.Random;

class Card {
    
    private final String NAME;
    private Attribute[] attrArray;

    public Card(String name, int attrNum, String gameType){
        this.NAME = name;
        
        setAttr(attrNum, gameType);
        
    }

    public String getName(){
        return NAME;
    }
    
    void setAttr(int attrNum, String gameType){
        String[] attrName = new String[attrNum];
        Random rand = new Random();

    	if(gameType == "dnd"){
    		attrName[0] = "STR";
    		attrName[1] = "DEX";
    		attrName[2] = "CON";
    		attrName[3] = "INT";
    		attrName[4] = "WIS";
    		attrName[5] = "CHA";
    	}

        for(int i = 0; i < attrNum; i++){
        	int val = rand.nextInt(9) + 0;
        	attrArray[i] = new Attribute(attrName[i], val);
        }
    }

    public Attribute getAttr(int attr){
        return attrArray[attr];
    }
}