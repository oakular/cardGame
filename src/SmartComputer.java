
class SmartComputer extends Player {
	
	private Card current;

	public SmartComputer(String pName) {
		super(pName);
	}

	void getCurrentCard(Card current){
		this.current = current;
		
	}
	
	// ----- method overrider to find highest attribute value
	// and choose that attribute
	@Override
	public int chooseAttr(){
		
		Attribute currentAttr = current.getAttr(0);
		int maxVal = currentAttr.getVal();
		int bestAttr = currentAttr.getAttrNum();

		for(int i = 1; i < 6; i++){
			currentAttr = current.getAttr(i);
			int attrVal = currentAttr.getVal();
			if(maxVal < attrVal){
				bestAttr = currentAttr.getAttrNum();
				maxVal = attrVal;
			} // end of if statement
		} // end of for loop
			
		return bestAttr;
	} // end of chooseAttr() method
}
