/*  Author: Callum Warrilow (201068703)
 *  Date: 5/11/16
 */

// ------ IMPORT STATEMENTS ------
import java.util.Scanner;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.ArrayList;
import java.util.Iterator;

 /**  Class Desc: MultiPlayer implementation of Game class to
 *  play Card game between several human and computer players. */
class MultiPlayerGame implements Game {

    // -------- FIELDS ---------
    /** Holds each {@link Player Player} in the game. */
    private List<Player> players = new ArrayList<Player>();
    /** {@link Scanner Scanner} for User Input. */
    private Scanner uInput = new Scanner(System.in);

    // ---------- CONSTRUCTOR ----------
    /** Constructor to instantiate MultiPlayerGame
     * and call {@link MultiPlayerGame#startGame() startGame()}
     * method on. */
    public MultiPlayerGame(){
    } // end of CONSTRUCTOR

    /** Method to create players and ask for computer difficulty.
     * Asks for user input and calls
     * {@link MultiPlayerGame#addPlayers() addPlayers()},
     * {@link MultiPlayerGame#playRound() playRound()} and
     * {@link MultiPlayerGame#createCard() createCard()} methods. */
    public void startGame(){
        int pNum;
        int cNum;

        // INTRODUCE GAME
        System.out.println("Please enter the number of Human players:");
        pNum = uInput.nextInt();
        System.out.println("Please enter the number of Computer players:");
        cNum = uInput.nextInt();

        // create human and computer players
        addPlayers(pNum, cNum);

        // assign cards to decks
        createCard();

        playRound(0, 1);
    } // end of startGame() method

    // ---- method to create players by asking
    // for names and difficulty
    private void addPlayers(int pNum, int cNum){
        int count = 0;

        // --- while loop to ask for Player names
        // number of players is reached
        while(count != pNum){
            System.out.println("Please Enter Player " + (count+1) + "  Name: ");
            String pName = uInput.nextLine();
            Human player = new Human(pName);
            players.add(player);

            count++;
        } // end of while loop

        count = 0; // reset value of count

        // --- while loop to ask for difficulty of
        // each computer player
        while(count != cNum){
            System.out.println("What is the Difficulty of COMP" + (count+1) + "? ");
            System.out.println("1. Easy Difficulty");
            System.out.println("2. Medium Difficulty");
            System.out.println("3. Hard Difficulty");
            System.out.print("Enter a Number: ");
            int difficulty = uInput.nextInt();

            // -- switch statement to select
            // computer difficulty
            switch(difficulty){
            case 1:
                System.out.println("This Feature IS NOT HERE");
                break;
            case 2:
                RandomComputer randComp = new RandomComputer("COMP");
                players.add(randComp);
                break;
            case 3:
                SmartComputer smartComp = new SmartComputer("COMP");
                players.add(smartComp);
                break;
            } // end of switch statement

            count++;
        } // end of while loop
    } // end of addPlayers() method

    /** Method to create cards and assign them to decks.
     * Adds cards to a CopyOnWriteArrayList (which is thread)
     * friendly and assigns {@link Card Cards} to {@link Player Players}. */
    private void createCard(){
        CopyOnWriteArrayList<Card> cardList = new CopyOnWriteArrayList<>();
        Player playerToDeal;
        int playerItr = 0;

        // create cards
        cardList.add(new Card("Tiamat", 6, "dnd"));
        cardList.add(new Card("Drizzt Do'Urden", 6, "dnd"));
        cardList.add(new Card("Acercerak", 6, "dnd"));
        cardList.add(new Card("Bruenor", 6, "dnd"));
        cardList.add(new Card("Akar Kessel", 6, "dnd"));
        cardList.add(new Card("King Snurre", 6, "dnd"));
        cardList.add(new Card("Count Von Strahd", 6, "dnd"));
        cardList.add(new Card("Xanathar", 6, "dnd"));
        cardList.add(new Card("Wulfgar", 6, "dnd"));
        cardList.add(new Card("Regis", 6, "dnd"));

        // --- for loop to assign Cards to Players
        for(Card cardToDeal : cardList){
            // checks if playerItr has reached the
            // maximum number of players
            if(playerItr == 4)
                playerItr = 0;

            playerToDeal = players.get(playerItr);
            assignCard(cardToDeal, playerToDeal);
            cardList.remove(cardToDeal);

            playerItr++;
        } // end of for loop
    } // end of createCard() method

    /** Method to assign {@link Card Cards} to {@link Player Players}
     * in turn.
     * Assigns the Card to the Player objects that are passed as
     * parameters.
     * @param assignCard - The Card to be assigned
     * @param assignPlayer - The player to whom the Card is assigned */
    private void assignCard(Card assignCard, Player assignPlayer){
        assignPlayer.deck.add(assignCard);
    } // end of assignCard() method

    /** Method to carry out the game procedure.
     * Plays a round and makes call to compare cards method.
     * @param playerRef - The reference number for the {@link Player}
     * whose turn it is.
     * @param roundNum - The round number. */
    private void playRound(int playerRef, int roundNum){
        int choice;

        // print round number
        System.out.println("---- ROUND " + (roundNum+1) + " ----");
        System.out.println("------------------");

        int idx; // index integer for cycling through players list

        // --- for loop to print out Human decks
        for(idx = 0; idx < 2; idx++){
            System.out.println(players.get(idx).getPName() + "\'S DECK= ");
            players.get(idx).deck.forEach(System.out::println);
            System.out.println("------------------\n");
        } // end of for loop
        // remove Cards from each deck
    } // end of playRound() method
} // end of MultiPlayerGame Class
