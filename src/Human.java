
public class Human implements Player {

	private Card[] deck;
	private int bottom;
	private int top;

	@Override
	public void addToDeck() {
		Card cardToAdd = Game.getCard();
		deck[bottom] = cardToAdd;

	}

	@Override
	public void delFromDeck() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getPName() {
		// TODO Auto-generated method stub
		return null;
	}

}
