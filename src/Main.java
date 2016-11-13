/*  Author: Callum Warrilow (20106703)
 *  Date: 5/11/16
 */

/** Class Desc: Main Class of Card Game to instantiate new
 * game. */

import java.util.Scanner;

public class Main {

    // ----------- MAIN METHOD ------------
    /** Main method to start {@link Game Game} and choose
     * game type. */
    public static void main(String[] args){

        Scanner gameTypeInput = new Scanner(System.in);
        Game game;

        System.out.println("----- Welcome to Card Game -----");
        System.out.println("Single Player or Multiplayer: ");
        System.out.println("1. Single Player");
        System.out.println("2. Multiplayer");
        int gameType = gameTypeInput.nextInt();

        if(gameType == 1){
            game = new SinglePlayerGame();
        }else{
            game = new MultiPlayerGame();
        }

        // create game object and start game
        game.startGame();

        gameTypeInput.close();
    } // end of main() method
} // end of Main Class
