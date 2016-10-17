import java.util.Scanner;


class Game {
    
    public void startGame(){
    	Scanner uInput = new Scanner(System.in);
    	String pName;
    	
    	System.out.println("----- Welcome to Card Game -----");
        System.out.print("Please Enter Your Name: ");
        pName = uInput.nextLine();
        
        System.out.println("Which Computer Player Will Be Your Opponent?");
        System.out.println("1. Easy Difficulty");
        System.out.println("1. Hard Difficulty");
        
        uInput.close();
    }
    
    void createCard(){
    	Card card1 = new Card("Tiamat", 6, "dnd");
    	Card card2 = new Card("Drizzt", 6, "dnd");
    }
    
    public void playRound(){
    	
    }

    public Card getCard(){
        
    }
    
    public String printCards(){
        
    }
}
