
public class Player {
    
    private final String P_NAME;
    private Card[] deck;
    private static int bottom;
    private static int top;
    
    public Player(String pName){
        this.P_NAME = pName;
    }
    
    void addToDeck(Card cardToAdd){
        deck[bottom] = cardToAdd;
    }
    Card delFromDeck(Card cardToDel){
        cardToDel = deck[top];
        return cardToDel;
    }

    String getPName();
    
    
        
}
