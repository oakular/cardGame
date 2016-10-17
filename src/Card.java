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

    	if(gameType == "dnd"){
    		attrName[0] = "STR";
    		attrName[0] = "DEX";
    		attrName[0] = "CON";
    		attrName[0] = "INT";
    		attrName[0] = "WIS";
    		attrName[0] = "CHA";
    	}

        for(int i = 0; i < attrNum; i++){
        	attrArray[i] = new Attribute(attrName[i]);
        }
    }

    public Attribute getAttr(int attr){
        return attrArray[attr];
    }
}