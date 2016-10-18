// ------ IMPORT STATEMENTS ------
import java.util.Scanner;

class Game {
    
	// -------- FIELDS ---------
    private Human hPlayer;
    private RandomComputer comp;
    private Scanner uInput = new Scanner(System.in);
    
    public Game(){
    }

    public void startGame(){
        String pName;
        
        System.out.println("----- Welcome to Card Game -----");
        System.out.print("Please Enter Your Name: ");
        pName = uInput.nextLine();
        
        hPlayer = new Human(pName);
        
        System.out.println("Which Computer Player Will Be Your Opponent?");
        System.out.println("1. Easy Difficulty");
        System.out.println("2. Hard Difficulty");
        int compType = uInput.nextInt();
        
        if(compType == 1){
            System.out.println("");
        }
        else{
            comp = new RandomComputer("Comp");
        }
            
        createCard();
        playRound();
    }
    
    void createCard(){
        Card card1 = new Card("Tiamat", 6, "dnd");
        Card card2 = new Card("Drizzt", 6, "dnd");
        
        hPlayer.addToDeck(card1);
        comp.addToDeck(card2);
    }
    
    public void playRound(){
       Card pCard = hPlayer.delFromDeck(); 
       Card cCard = comp.delFromDeck();
       
       System.out.print("Choose an Attribute No: ");
       int choice = uInput.nextInt();
       
       System.out.println(pCard.getAttr(choice));
       System.out.println(cCard.getAttr(choice));

       
       uInput.close();
    }

    
    /*public String printCards(){
        
    }*/
}
