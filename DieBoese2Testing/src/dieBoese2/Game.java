package dieBoese2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author Thanh Tran 1921390
 * @version 0.1.3
 */
public class Game {

	public Player p1, p2;
	public Board board;

	public Game() {
		Menu menu = new Menu();
		// menu settings
		menu.menuLoop();

		/**
		 * generates the Players (first PvP)
		 */
		p1 = new HumanPlayer('X');
		p2 = new HumanPlayer('O');

		/**
		 * creates the Board with desired size
		 */
		board = new Board(menu.getBoardSize());
	}

	protected static String readInput() {
		Scanner sc = new Scanner(System.in);
		String input;

		input = sc.next();

		return input;
	}
}