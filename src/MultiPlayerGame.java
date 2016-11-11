/*  Author: Callum Warrilow (201068703)
 *  Class Desc: MultiPlayer implementation of Game class to
 *  play Card game between several human and computer players.
 *  Date: 5/11/16
 */

// ------ IMPORT STATEMENTS ------
import java.util.Scanner;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.ArrayList;
import java.util.Iterator;

class MultiPlayerGame implements Game {

    // -------- FIELDS ---------
    private List<Player> players = new ArrayList<Player>();
    private Scanner uInput = new Scanner(System.in);

    public MultiPlayerGame(){

    } // end of CONSTRUCTOR

    // ---- method to create players and ask for
    // computer difficulty
    public int startGame(){
        int pNum;
        int cNum;

        System.out.println("----- Welcome to Card Game -----");
        System.out.println("Please enter the number of Human players:");
        pNum = uInput.nextInt();
        System.out.println("Please enter the number of Computer players:");
        cNum = uInput.nextInt();

        addPlayers(pNum, cNum);
        createCard();

        return 0;
    } // end of startGame() method

    private void addPlayers(int pNum, int cNum){
        int count = 0;

        while(count != pNum){
            System.out.println("Please Enter Player " + (count+1) + "  Name: ");
            String pName = uInput.nextLine();
            Human player = new Human(pName);
            players.add(player);

            count++;
        } // end of for loop

        count = 0; // reset value of count

        while(count != cNum){
            System.out.println("What is the Difficulty of COMP" + (count+1) + "? ");
            System.out.println("1. Easy Difficulty");
            System.out.println("2. Medium Difficulty");
            System.out.println("3. Hard Difficulty");
            System.out.print("Enter a Number: ");
            int difficulty = uInput.nextInt();

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
        } // end of for loop
    } // end of addPlayers() method

    //----- method to create cards and assign them to decks
    private void createCard(){
        CopyOnWriteArrayList<Card> cardList = new CopyOnWriteArrayList<>();
        Iterator<Card> cardDealer = cardList.iterator();

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

        while(cardDealer.hasNext()){
            Card cardToDeal = cardDealer.next();
            for(Player playerToDeal : players){
                playerToDeal.deck.add(cardToDeal);
                cardDealer.remove();
            } // end of for loop
        } // end of while loop

        players.get(0).deck.forEach(System.out::println);
    } // end of createCard() method
} // end of MultiPlayerGame Class
