package dieBoese2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

    public static void main(String[] args) {
        Game game = new Game();
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
    Menu menu = new Menu();
    //menu settings
    menu.menuloop();

    /**
     * generates the Players
     * (first PvP)
     */

    Player p1 = new HumanPlayer('X');
    Player p2 = new HumanPlayer('O');

    /**
     * creates the Board
     */
    Board board = new Board(menu.getBoardSize);

}