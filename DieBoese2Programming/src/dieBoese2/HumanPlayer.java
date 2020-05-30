package dieBoese2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.sun.jdi.Method;

import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * 
 * @author Floris Wittner
 * @version V 0.2.1
 * @date 29.05
 *       <p>
 *       </
 *       <p>
 *       This class is subclass from {@link Player}
 *       <p>
 *       </
 *       <p>
 *       {@link HumanPlayer} can {@link #blockSpace(Board)} and
 *       {@link #makeMove(Board)}
 *       <p>
 *       </
 *       <p>
 *       It also has a getter Method {@link #getMyMove()}
 *
 */
public class HumanPlayer extends Player {
	private String myMove;

	/**
	 * 
	 * @param figure X or O
	 * @category constructor
	 */
	public HumanPlayer(char figure) {
		super(figure);
	}

	/**
	 * will be remove is just for testing here.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		HumanPlayer p1 = new HumanPlayer('X');
		System.out.println(p1.getMyMove());
	}

	/**
	 * 
	 * @return myMove
	 * @category getter
	 */
	public String getMyMove() {
		return myMove;
	}

	/**
	 * HumanPlayer block field {@link #myMove} If input is
	 * {@link board#isValidMove(myMove) not valid} he has to give a other input.
	 */
	@Override
	protected void blockSpace(Board board) {
		System.out.println("Welches Feld wollen Sie blockieren?");
		myMove = Game.readInput();
		if (board.isValidMove(myMove)) {
			board.placeFigure(myMove, 'B');
		} else {
			System.out.println("Dieses Feld kann nicht blockiert werden.");
			blockSpace(board);
		}
	}

	/**
	 * HumanPlayer set his figure at {@link #myMove} after it was read with
	 * {@link Game#readInput() }. If input is {@link board#isValidMove(myMove) not
	 * valid} he has to give a other input.
	 */
	@Override
	protected void makeMove(Board board) {
		System.out.println("Auf welches Feld wollen Sie einen Stein legen?");
		myMove = Game.readInput();
		if (board.isValidMove(myMove)) {
			board.placeFigure(myMove, figure);
		} else {
			System.out.println("Sie können kein Stein auf dieses Feld legen.");
			makeMove(board);
		}
	}
}