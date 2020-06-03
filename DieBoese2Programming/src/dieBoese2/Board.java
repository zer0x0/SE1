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



	Board(int size) {
		boardstate = new char[size][size];
		for(int i = 0; i < boardstate.length; i++) {
			for(int j = 0; j < boardstate[0].length; j++) {
				boardstate[i][j] = ' ';
			}
		}

	}

	public static void main(String[] args) {
		Board board = new Board(15);

		String test = "a12";
//			System.out.println((int) test.charAt(1));
//			System.out.println(board.boardstate.length);
		System.out.println(board.isValidMove("1a"));
		System.out.println(board.isValidMove("a13"));
		System.out.println(board.isValidMove("17bd"));
		System.out.println(board.isValidMove("z7"));
		System.out.println(board.isValidMove("t"));

	}

	/**
	 * 
	 * @param coordinate
	 * @return true if a figure could be set at coordinate; false if not
	 * 
	 */
	protected boolean isValidMove(String coordinate) {

		// keine richtige koordinate &&
		// außerhalb des Spielfelds -> convert überprüft, fehler rückmeldung muss noch
		// erfastt werden

		// besetzt

		Point point = this.convertCoordinate(coordinate);
		if (point == null) {
			System.out.println("Falsche Eingabe bitte geben sie eine gültige Koordinate ein.");
			return false;
		}
		if (point.x > this.boardstate.length || point.x < 0 || point.y > this.boardstate[0].length || point.y < 0) {
			System.out.println("Diese Koordinate liegt nicht auf dem Spielbrett");
			return false;
		}
		if (this.boardstate[point.x][point.y] == ' ')
			return true;
		else {
			System.out.println("Dieses Feld ist schon belegt. Geben sie ein neues Feld ein.");
			return false;
		}
	}

	/**
	 * convert the coordinate from String to a Point
	 * 
	 * @param coordinate
	 * @return Point
	 * 
	 */
	protected Point convertCoordinate(String coordinate) {

		int x = 0, y = 0;
		int firstChar, secondChar, thirdChar;
		

		coordinate = coordinate.toLowerCase();
		// wenn coordinate aus 2 Ziffer und 1 Buchstabe besteht
		if (coordinate.length() == 3) {
			firstChar = (int) coordinate.charAt(0) - 48;
			secondChar = (int) coordinate.charAt(1) - 48;
			thirdChar = (int) coordinate.charAt(2) - 48;
			if (firstChar <= this.boardstate.length) {

				y = firstChar * 10 + secondChar;
				x = thirdChar;

			} else if (firstChar > 48) {
				y = secondChar * 10 + thirdChar;
				x = firstChar;

			}
			// wenn coordinate aus 1 Ziffer und 1 Buchstabe besteht
		} else if (coordinate.length() == 2) {
			firstChar = (int) coordinate.charAt(0) - 48;
			secondChar = (int) coordinate.charAt(1) - 48;
			if (firstChar <= this.boardstate.length) {
				
				y = firstChar;
				x = secondChar;
			} else if (firstChar > 48) {
				
				y = secondChar;
				x = firstChar;
			}
			// falls String keine vernünftige Koordinate ist //ist das ein unschöne Lösung?
		} else {
			return null;
		}

		Point point = new Point(x - 48, y);
		
		return point;

	}
}
