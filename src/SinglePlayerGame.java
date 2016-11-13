/*  Author: Callum Warrilow (201068703)
 *  Date: 5/11/16
 */

/**
 *  Class Desc: SinglePlayer implementation of Game class to
 *  play Card game between a human and computer player only.
 */

// ------ IMPORT STATEMENTS ------
import java.util.Scanner;

class SinglePlayerGame implements Game {

    // -------- FIELDS ---------
    /** Uses {@link Human} class to create a human player. */
    private Human hPlayer;     private Player comp;
    /** Uses {@link Scanner} class to create scanner for input. */
    private Scanner uInput = new Scanner(System.in);

    // ----- CONSTRUCTOR -----
    /** Constructor to create instance of Singleplayer game and then have
        startGame() called on it by Main class
      */
    public SinglePlayerGame(){
    } // end of CONSTRUCTOR

    /** Method to create {@link Player Players} and ask for
        computer difficulty.
      */
    public int startGame(){
        String pName;

        System.out.print("Please Enter Your Name: ");
        pName = uInput.nextLine();

        // instantiate players
        addPlayers(pName);

        // assign cards to decks
        createCard();

        // delay text output to terminal
        delay(2000);

        System.out.println("\n----- START GAME -----\n");
        playRound(0);

        uInput.close();

        return 0;
    } // end of startGame() method

    /** Method to create {@link Player Players} by asking
        for names and difficulty.
        @param pName - the Human player's name
      */
    private void addPlayers(String pName){
        hPlayer = new Human(pName);

        System.out.println("Welcome " + hPlayer.getPName() + "\n");

        delay(2000);

        // instantiate computer based on difficulty
        System.out.println("Which Computer Player Will Be Your Opponent?");
        System.out.println("1. Easy Difficulty");
        System.out.println("2. Medium Difficulty");
        System.out.println("3. Hard Difficulty");
        System.out.print("Enter a Number: ");
        int compType = uInput.nextInt();

        // -- switch statement to select
        // computer difficulty
        switch(compType){
        case 1: // EASY
            System.out.println("This Feature IS NOT HERE");
            break;
        case 2: // MEDIUM
            RandomComputer randComp = new RandomComputer("COMP");
            comp = randComp;
            break;
        case 3: // HARD
            SmartComputer smartComp = new SmartComputer("COMP");
            comp = smartComp;
            break;
        } // end of switch statement
    } // end of addPlayers() method

    /** Method to create {@link Card Cards} and assign them to decks.
      */
    private void createCard(){
        Card[] cardDealer = new Card[10];
        cardDealer[0] = new Card("Tiamat", 6, "dnd");
        cardDealer[1] = new Card("Drizzt Do'Urden", 6, "dnd");
        cardDealer[2] = new Card("Acercerak", 6, "dnd");
        cardDealer[3] = new Card("Bruenor", 6, "dnd");
        cardDealer[4] = new Card("Akar Kessel", 6, "dnd");
        cardDealer[5] = new Card("King Snurre", 6, "dnd");
        cardDealer[6] = new Card("Count Von Strahd", 6, "dnd");
        cardDealer[7] = new Card("Xanathar", 6, "dnd");
        cardDealer[8] = new Card("Wulfgar", 6, "dnd");
        cardDealer[9] = new Card("Regis", 6, "dnd");

        // --- for loop to iterate through cardDealer array
        // and assign cards to each player's deck
        for(int i = 0; i < 10; i++){
            hPlayer.deck.add(cardDealer[i]);
            comp.deck.add(cardDealer[++i]);
        } // end of for loop
    } // end of createCard() method

    /** Method containing game procedure.
     * Makes calls to {@link printCard(Card) printCard()},
     * and {@link compare(Card, Card, int)} methods.
     * @param roundNum - the round number for this turn of play
     */
    private void playRound(int roundNum){
        int choice;

        // print round number
        System.out.println("---- ROUND " + (roundNum+1) + " ----");
        System.out.println("------------------");

        // print out Human player's deck
        System.out.println("YOUR DECK= ");
        hPlayer.deck.forEach(System.out::println);
        System.out.println("------------------\n");

        delay(2000);

        // Take cards from player and computer's decks
        Card hCard = hPlayer.deck.remove();
        Card cCard = comp.deck.remove();

        // print the player's card name and attributes
        printCard(hCard);

        delay(2000);

        // check whose turn it is
        if(roundNum % 2 == 0){
            // HUMAN CHOICE
            choice = hPlayer.chooseAttr();
            choice--;       // make choice reference array position
        }else{
            // COMPUTER CHOICE
            System.out.println(comp.getPName() + " is choosing...");
            delay(3000);

            // allows SmartComputer to choose best attribute
            // by giving it access to attribute values
            if(comp instanceof SmartComputer)
                comp.setCurrentCard(cCard);

            choice = comp.chooseAttr();
            System.out.println(comp.getPName() + " chose Attr: " + choice);
        } // end of if-else statement

        // CARD COMPARISON
        compare(hCard, cCard, choice);

        // --- while loop to  check for empty decks and
        // if none continue play
        while(hPlayer.deck.size() != 0 && comp.deck.size() != 0){
            roundNum++;
            playRound(roundNum);

        // break loop if a player has no cards left
        if(hPlayer.deck.size() == 0 || comp.deck.size() == 0)
            break;
        } // end of while loop

        // DETERMINE WINNER
        if(hPlayer.deck.size() == 0)
            System.out.println("YOU LOSE");
        else
            System.out.println("YOU WIN");
    } // end of playRound() method

    /** Method to print Player Card Details to Screen using
     * the {@link Card#getAttr() getAttr() method}.
     * @param hCard - the current card in the Human player's hand
     */
    private void printCard(Card hCard){
        System.out.println(hCard); // print card name
        System.out.println("------------------");
        for(int i=0; i < 6; i++) // print card attributes
            System.out.println("|" + hCard.getAttr(i) + "|");
        System.out.println("------------------\n");
    } // end of printCard() method

    /** Method to compare cards and reassign to winner's deck.
     * Obtains values for each card by {@link Card#getAttr(int) getAttr()}
     *  and {@link Attribute#getVal() methods}
     * @param hCard - the current card in the Human player's hand
     * @param cCard - the current card in the Computer player's hand
     * @param choice - the choice of attribute made by whose turn it is
     */
    private void compare(Card hCard, Card cCard, int choice){
        // ---------- COMPARE CARDS ----------
        if(hCard.getAttr(choice).getVal() == cCard.getAttr(choice).getVal()){
            System.out.println("DRAW");
            comp.deck.add(cCard);
            hPlayer.deck.add(hCard);
        }else if(hCard.getAttr(choice).getVal() < cCard.getAttr(choice).getVal()){
            System.out.println("FAIL");
            comp.deck.add(cCard);
            comp.deck.add(hCard);
        }else{
            System.out.println("SUCCESS");
            hPlayer.deck.add(hCard);
            hPlayer.deck.add(cCard);
        } // end of CARD COMPARISON

        System.out.println("\n------------------");
        delay(3000);
    } // end of compare() method

    /** Method to delay terminal output.
     * Utilises the {@link Thread#sleep(int) sleep} method
     * @param millis - the number of milliseconds to delay execution by
     */
    private static void delay(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException exp) {
        }
    } // end of delay() method
} // end of SinglePlayerGame Class
