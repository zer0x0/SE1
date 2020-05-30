package dieBoese2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author Thanh Tran 1921390
 * @version 0.1.1
 */
public class Game {

    Player p1, p2;
    Board board;

    public Game(){
        Menu menu = new Menu();
        //menu settings
        menu.menuloop();

        /**
         * generates the Players
         * (first PvP)
         */
        p1 = new HumanPlayer('X');
        p2 = new HumanPlayer('O');


        /**
         * creates the Board with desired size
         */
        board = new Board(menu.getBoardSize);
    }


    protected static String readInput() {
        String input;

        try(var in = new BufferedReader(new InputStreamReader(System.in))) {
            input = in.readLine();
            // ACHTUNG könnte Endlosschleife werden
        } catch (IOException e) {
            System.out.println("Eingabe ist falsch!");
            return readInput();
        }
        return input;

    }
}