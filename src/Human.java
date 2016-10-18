
public class Human extends Player {

	// ----- CONSTRUCTOR -----
	public Human(String pName) {
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

}
