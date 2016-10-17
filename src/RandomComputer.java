
public class RandomComputer extends Player {

	public RandomComputer(String pName) {
		super(pName);
		// TODO Auto-generated constructor stub
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
