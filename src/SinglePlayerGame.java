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
    private Human hPlayer;
    /** Uses {@link Player} class to create a computer player. */
    private Player comp;
    /** Uses {@link Scanner} class to create scanner for input. */
    private Scanner uInput = new Scanner(System.in);
    /** A boolean to set the dumbComputer mode
     * to <code>true</code> or <code>false</code>. */
    boolean dumbComputer = false;

    // ----- CONSTRUCTOR -----
    /** Constructor to create instance of Singleplayer game and then have
        startGame() called on it by Main class
      */
    public SinglePlayerGame(){
    } // end of CONSTRUCTOR

    /** Method to create {@link Player Players} and ask for
        computer difficulty.
      */
    public void startGame(){
        String pName;

        System.out.print("Please Enter Your Name: ");
        pName = uInput.nextLine();

        // instantiate players
        addPlayers(pName);

        System.out.println("Which genre would you like to play?");
        System.out.println("1. Dungeons & Dragons Characters");
        System.out.println("2. Cars");
        int gameType = uInput.nextInt();

        // assign cards to decks
        createCard(gameType);

        // wait text output to terminal
        wait(2000);

        System.out.println("\n----- START GAME -----\n");
        playRound(0);

        uInput.close();

    } // end of startGame() method

    /** Method to create {@link Player Players} by asking
        for names and difficulty.
        @param pName - the Human player's name
      */
    private void addPlayers(String pName){
        hPlayer = new Human(pName);

        System.out.println("Welcome " + hPlayer.getPName() + "\n");

        wait(2000);

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
            dumbComputer = true;
            RandomComputer dumbComp = new RandomComputer("COMP");
            comp = dumbComp;
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
     * Takes the chosen genre of card and uses for loop to iterate
     * through the deck and assign cards evenly among the two players.
     * @param genre - The genre of cards to play the game with.
      */
    private void createCard(int genre){
        Card[] cardDealer = new Card[10];

        if(genre == 1){ // DND CHARACTERS
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
        }else{ // CARS
        cardDealer[0] = new Card("Porsche", 6, "cars");
        cardDealer[1] = new Card("Ferrari", 6, "cars");
        cardDealer[2] = new Card("Renault", 6, "cars");
        cardDealer[3] = new Card("Corvette", 6, "cars");
        cardDealer[4] = new Card("Ford", 6, "cars");
        cardDealer[5] = new Card("Mercedes", 6, "cars");
        cardDealer[6] = new Card("Volkswagon", 6, "cars");
        cardDealer[7] = new Card("Toyota", 6, "cars");
        cardDealer[8] = new Card("Vauxhall", 6, "cars");
        cardDealer[9] = new Card("Citroen", 6, "cars");
        }

        // --- for loop to iterate through cardDealer array
        // and assign cards to each player's deck
        for(int i = 0; i < 10; i++){
            hPlayer.deck.add(cardDealer[i]);
            comp.deck.add(cardDealer[++i]);
        } // end of for loop
    } // end of createCard() method

    /** Method containing game procedure.
     * Makes calls to {@link printCard(Card) printCard()},
     * and {@link compare(Card, Card, int), compare()} methods.
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

        wait(2000);

        // Take cards from player and computer's decks
        Card hCard = hPlayer.deck.remove();
        Card cCard = comp.deck.remove();

        // print the Human's card name and attributes
        printCard(hCard);

        wait(2000);

        // check whose turn it is
        if(roundNum % 2 == 0){
            // HUMAN CHOICE
            choice = hPlayer.chooseAttr();
            choice--;       // make choice reference array position
        }else{
            System.out.println(comp.getPName() + " is choosing...");
            wait(3000);

            // COMPUTER CHOICE
            if(dumbComputer == true){
                choice = 3;
            }else{
                // allows SmartComputer to choose best attribute
                // by giving it access to attribute values
                if(comp instanceof SmartComputer)
                    comp.setCurrentCard(cCard);

                choice = comp.chooseAttr();
                } // end of if-else statement

            System.out.println(comp.getPName() + " chose Attr: " + (choice-1));
        } // end of if-else statement

        // CARD COMPARISON
        compare(hCard, cCard, choice);

        // --- while loop to  check for empty decks and
        // if none continue play
        while(hPlayer.deck.size() != 0 && comp.deck.size() != 0){
            // break loop if a player has no cards left
            if(hPlayer.deck.size() == 0 || comp.deck.size() == 0)
                break;

            // otherwise continue play
            roundNum++;
            playRound(roundNum);
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
            System.out.println("YOU LOSE THE ROUND");
            System.out.println("COMP GAINS THE CARD: " + hCard.getName());
            comp.deck.add(cCard);
            comp.deck.add(hCard);
        }else{
            System.out.println("YOU WIN THE ROUND");
            System.out.println("YOU GAIN THE CARD: " + cCard.getName());
            hPlayer.deck.add(hCard);
            hPlayer.deck.add(cCard);
        } // end of CARD COMPARISON

        System.out.println("\n------------------");
        wait(3000);
    } // end of compare() method

    /** Method to delay terminal output.
     * Utilises the {@link Thread#sleep(int) sleep} method
     * @param millis - the number of milliseconds to wait execution by
     */
    private static void wait(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException exp) {
        }
    } // end of wait() method
} // end of SinglePlayerGame Class
