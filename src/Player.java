
public class Player {
    
    private final String P_NAME;
    protected Card[] deck;
    protected static int bottom;
    protected static int top;
    
    public Player(String pName){
        this.P_NAME = pName;
    }
    
    void addToDeck(Card cardToAdd){
        deck[bottom] = cardToAdd;
    }
    Card delFromDeck(){
        Card cardToDel = deck[top];
        return cardToDel;
    }

    String getPName(){
    	return P_NAME;
    }
    
}
