package dieBoese2;

import java.awt.Point;

/**
 * 
 * @author Floris Wittner
 * @version 0.1.2.
 * @date 02.06.2019
 *
 */
public class Board {
	char boardstate[][];

	Board() {
		boardstate = new char[15][15];
	}

	Board(int size) {
		boardstate = new char[size][size];

	}

	public static void main(String[] args) throws WrongInputException {
		Board board = new Board();

		String test = "a12";
//			System.out.println((int) test.charAt(1));
//			System.out.println(board.boardstate.length);
		System.out.println(board.convertCoordinate("1a"));
		System.out.println(board.convertCoordinate("a1"));
		System.out.println(board.convertCoordinate("a13"));
		System.out.println(board.convertCoordinate("13b"));

	}

	protected boolean isValidMove(String coordinate) {

		// keine richtige koordinate &&
		// außerhalb des Spielfelds -> convert überprüft, fehler rückmeldung muss noch
		// erfastt werden

		// besetzt

		try {
			if (this.boardstate[this.convertCoordinate(coordinate).x][this.convertCoordinate(coordinate).y] == ' ')
				return true;
			else {
				System.out.println("Dieses Feld ist schon belegt. Geben sie ein neues Feld ein.");
				return false;
			}
		} catch (WrongInputException e) {
			System.out.println("Falsche Eingabe bitte geben sie eine gültige Koordinate ein.");
			return false;
		}
	}

	/**
	 * convert the coordinate from String to a Point
	 * 
	 * @param coordinate
	 * @return Point
	 * @throws WrongInputException
	 */
	protected Point convertCoordinate(String coordinate) throws WrongInputException {

		int x = 0, y = 0;
		int firstChar, secondChar, thirdChar;
		Point xy = new Point();

		coordinate = coordinate.toLowerCase();

		if (coordinate.length() == 3) {
			firstChar = (int) coordinate.charAt(0) - 48;
			secondChar = (int) coordinate.charAt(1) - 48;
			thirdChar = (int) coordinate.charAt(2) - 48;
			if (firstChar <= this.boardstate.length && firstChar >= 0) {

				y = firstChar * 10 + secondChar;
				x = thirdChar;

			} else if (firstChar > 48 && firstChar <= this.boardstate.length + 48) {
				y = secondChar * 10 + thirdChar;
				x = firstChar;

			}
		} else if (coordinate.length() == 2) {
			firstChar = (int) coordinate.charAt(0) - 48;
			secondChar = (int) coordinate.charAt(1) - 48;
			if (firstChar <= this.boardstate.length && firstChar >= 0) {
				System.out.println("test1");
				y = firstChar;
				x = secondChar;
			} else if (firstChar > 48 && firstChar <= this.boardstate.length + 48) {
				System.out.println("test2");
				y = secondChar;
				x = firstChar;
			}
		} else {
			throw new WrongInputException();
		}

		System.out.println(x + "  " + y);
		xy.setLocation(x - 48, y);
		return xy;

	}
}

class WrongInputException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}