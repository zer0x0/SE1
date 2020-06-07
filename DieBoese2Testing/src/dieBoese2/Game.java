package dieBoese2;

import java.util.Scanner;

/**
 * @author Thanh Tran 1921390
 * @version 0.2.1
 */
public class Game {

	protected Player p1, p2;
	protected Board board;
	protected Menu menu;

	public Game() {
		menu = new Menu();
		// menu settings
		menu.menuLoop();

		/**
		 * generates the Players (PvP or PvAI)
		 */
		generatePlayers(menu.getPvPorPvAI());


		/**
		 * creates the Board with desired size
		 */
		board = new Board(menu.getBoardSize());
	}

	protected void generatePlayers(boolean getPvPorAI){

		p1 = new HumanPlayer('X');

		if(getPvPorAI)
			p2 = new HumanPlayer('O');
		else
			p2 = new AI('O',menu.getDifficulty());
	}

	protected static String readInput() {
		Scanner sc = new Scanner(System.in);
		String input;

		input = sc.next();
		sc.close();

		return input;
	}
}