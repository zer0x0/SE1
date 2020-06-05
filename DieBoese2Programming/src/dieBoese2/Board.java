package dieBoese2;

import java.util.Scanner;

/**
 * 
 * @author Floris Wittner, Nicolas Biundo, Ian Reeves
 * @version 1.0.1
 * @date 06.06.2020
 *
 */
public class Board {

	int zugcounter = 1;
	boolean currentPlayer = true;

	private char boardstate[][];
//    private boolean whoWon; // evtl = currentPlayer ?? - standardmäßig auf true, muss also nicht mehr im Konstruktor übergeben werden. whoWon wird aufgerufen nachdem der winning move gespielt wird!
	private boolean isRunning = true;

	// getBoardstate, setBoardstate für Testing
	public char[][] getBoardstate() {
		return boardstate;
	}

	public void setBoardstate(char boardstate[][]) {
		this.boardstate = boardstate;
	}
	
	Board(int size) {
		boardstate = new char[size][size];
		for (int i = 0; i < boardstate.length; i++) {
			for (int j = 0; j < boardstate[0].length; j++) {
				boardstate[i][j] = ' ';
			}
		}
	}
	/**
	 * 
	 * 
	 * prints out the actual Board
	 * 
	 */

	protected void printBoard() {
		int counter = boardstate.length - 1;
		System.out.print("    ");
		for (int i = 65; i < 65 + boardstate.length; i++) {
			System.out.print((char) i + "  ");
		}
		System.out.println();
		while (counter >= 0) {
			if (counter < 9) {
				System.out.print(counter + 1 + "  ");
			} else {
				System.out.print(counter + 1 + " ");
			}
			for (int i = 0; i < boardstate.length; i++) {
				System.out.print("[" + boardstate[i][counter] + "]");
			}
			System.out.print(" ");
			System.out.print(counter + 1);
			counter--;
			System.out.println();
		}
		System.out.print("    ");
		for (int i = 65; i < 65 + boardstate.length; i++) {
			System.out.print((char) i + "  ");
		}
	}

	public static void main(String[] args) {
		Board board = new Board(16);
		board.printBoard();
		// Menu menu1 = new Menu();
		Scanner sc = new Scanner(System.in);
		// board.printBoard();
		do {
			board.placeFigure(sc.nextLine(), board.getSymbol());
			// menu1.cls();
		} while (board.isRunning());
		sc.close();
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

		int[] coords = convertCoordinate(coordinate);
		int x = coords[0];
		int y = coords[1];

		if (x > this.boardstate.length || x < 0 || y > this.boardstate[0].length || y < 0) {
			System.out.println("Diese Koordinate liegt nicht auf dem Spielbrett");
			return false;
		}
		if (this.boardstate[x - 1][y - 1] == ' ')
			return true;
		else {
			System.out.println("Das Feld " + coordinate + " ist schon belegt. Geben sie ein neues Feld ein.");
			return false;
		}
	}

	boolean isRunning() {
		return isRunning;
	}

	/**
	 * convert the coordinate from String to an int[]
	 * 
	 * int [0] --> X-Axis = 1, 2, 3 // int [1] --> Y-Axis = a, b, c
	 * 
	 * 
	 * @param coordinate
	 * @return int[]
	 * 
	 */
	protected int[] convertCoordinate(String coordinate) {

		coordinate = coordinate.toLowerCase();
		int[] coords = new int[2];
		int firstChar, secondChar, thirdChar;

		if ((int) coordinate.charAt(0) < 96) {
			// der erste char ist eine Zahl!
			if (coordinate.length() == 3) { // Bsp 12a
				firstChar = (int) coordinate.charAt(0) - 48;
				secondChar = (int) coordinate.charAt(1) - 48;
				thirdChar = (int) coordinate.charAt(2) - 96;

				coords[0] = thirdChar;
				coords[1] = firstChar * 10 + secondChar;
			} else if (coordinate.length() == 2) { // Bsp 1a
				firstChar = (int) coordinate.charAt(0) - 48;
				secondChar = (int) coordinate.charAt(1) - 96;

				coords[0] = secondChar;
				coords[1] = firstChar;
			}

		} else {
			// Der erste char ist ein Buchstabe!
			if (coordinate.length() == 3) { // Bsp a12
				firstChar = (int) coordinate.charAt(0) - 96;
				secondChar = (int) coordinate.charAt(1) - 48;
				thirdChar = (int) coordinate.charAt(2) - 48;

				coords[0] = firstChar;
				coords[1] = secondChar * 10 + thirdChar;
			} else if (coordinate.length() == 2) { // a1
				firstChar = (int) coordinate.charAt(0) - 96;
				secondChar = (int) coordinate.charAt(1) - 48;

				coords[0] = firstChar;
				coords[1] = secondChar;
			}
		}

		return coords;
	}
	/**
	 * 
	 * 
	 * @return true if a player1 has won, false if player2 won
	 * 
	 */

	boolean whoWon() {
		return currentPlayer;
	}
	/**
	 * 
	 * @param coordinate, symbol
	 * Checks if there are 5 same symbols in a row
	 * 
	 */
	protected void checkWin(String coordinate, char symbol) {

		int[] coords = convertCoordinate(coordinate);
		int y = coords[0] - 1;
		int x = coords[1] - 1;

		// check vertical
		for (int i = 0; i < 5; i++) {

			int matches = 0;
			// therefore we check 4 times starting at x-4 if there are 4 matches in a row
			for (int j = 4; j >= 0; j--) {
				int offset = i - j;
				// System.out.println(matches + "+" + j + "+" + symbol + "+" + i);
				// dont forget to stay inside the bounds of the board
				if (y + offset >= 0 && y + offset < boardstate.length) {
					if (boardstate[y + offset][x] == symbol) {
						matches++;
					}
				}
				if (matches == 5) {
					isRunning = false;
					if (this.whoWon()) {
						System.out.println("Spieler 1 hat gewonnen!");
					} else {
						System.out.println("Spieler 2 hat gewonnen!");
					}
				}
			}
		}

		// check horizontal
		// we have to check everything from -5 to the left, until +5 to the right
		for (int i = 0; i < 5; i++) {

			int matches = 0;
			// therefore we check 4 times starting at x-4 if there are 4 matches in a row
			for (int j = 4; j >= 0; j--) {
				int offset = i - j;
				// dont forget to stay inside the bounds of the board
				if (x + offset >= 0 && x + offset < boardstate.length) {
					if (boardstate[y][x + offset] == symbol) {
						matches++;
					}
				}
			}
			// if we find 5 machtes, we return true. otherwise we start looking for 4
			// matches on the next position
			if (matches == 5) {
				isRunning = false;
				if (this.whoWon()) {
					System.out.println("Spieler 1 hat gewonnen!");
				} else {
					System.out.println("Spieler 2 hat gewonnen!");
				}
			}

		}
		// check diagonal
		// simular to the horizontal check, you have to check everything around the last
		// coin diagonally from -5 to +5
		for (int i = 0; i < 5; i++) {
			int matches2 = 0;
			int matches = 0;
			for (int j = 4; j >= 0; j--) {
				int offset = i - j;
				// now not only 1 variable changes but both, since we move diagonally (this one
				// is the slash check /)
				// don't forget to stay in bounds
				if (x + offset >= 0 && x + offset < boardstate.length && y + offset < boardstate.length
						&& y + offset >= 0) {
					if (boardstate[y + offset][x + offset] == symbol) {
						matches++;
					}
				}
				// this one is the backslash check \
				// don't forget to stay in bounds
				if (x + offset >= 0 && x + offset < boardstate.length && y - offset < boardstate.length
						&& y - offset >= 0) {
					if (boardstate[y - offset][x + offset] == symbol) {
						matches2++;
					}

				}
			}

			// if there is a diagonal / or \ match, we return true
			if (matches == 5 || matches2 == 5) {
				isRunning = false;
				if (this.whoWon()) {
					System.out.println("Spieler 1 hat gewonnen!");
				} else {
					System.out.println("Spieler 2 hat gewonnen!");
				}
			}
		}
	}
	/**
	 * 
	 * @param coordinate, symbol
	 * checks, if units should be deleted with the last move
	 * 
	 */

	protected void checkDeleted(String coordinate, char symbol) {

		String geschlagen = "\n" + "Es wurden Figuren geschlagen!" + "\n" + "\n"
				+ "||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||" + "\n";

		int[] coords = convertCoordinate(coordinate);
		int x = coords[0] - 1;
		int y = coords[1] - 1;

		char enemysymbol = ' ';
		if (symbol == 'X') {
			enemysymbol = 'O';
		} else {
			enemysymbol = 'X';
		}

		// horizontal links
		if (x - 3 >= 0 && boardstate[x - 3][y] == symbol && boardstate[x - 2][y] == enemysymbol
				&& boardstate[x - 1][y] == enemysymbol) {

			boardstate[x - 1][y] = ' ';
			boardstate[x - 2][y] = ' ';
			System.out.println(geschlagen);
			this.printBoard();
		}
		// horizontal rechts
		if (x + 3 < boardstate.length && boardstate[x + 3][y] == symbol && boardstate[x + 1][y] == enemysymbol
				&& boardstate[x + 2][y] == enemysymbol) {
			boardstate[x + 1][y] = ' ';
			boardstate[x + 2][y] = ' ';
			System.out.println(geschlagen);
			this.printBoard();
		}
		// vertikal unten
		if (y - 3 >= 0 && boardstate[x][y - 3] == symbol && boardstate[x][y - 1] == enemysymbol
				&& boardstate[x][y - 2] == enemysymbol) {
			boardstate[x][y - 1] = ' ';
			boardstate[x][y - 2] = ' ';
			System.out.println(geschlagen);
			this.printBoard();
		}
		// vertikal oben
		if (y + 3 < boardstate.length && boardstate[x][y + 3] == symbol && boardstate[x][y + 1] == enemysymbol
				&& boardstate[x][y + 2] == enemysymbol) {
			boardstate[x][y + 1] = ' ';
			boardstate[x][y + 2] = ' ';
			System.out.println(geschlagen);
			this.printBoard();
		}

		// diagonal unten links --> oben rechts
		if (x + 3 < boardstate.length && y + 3 < boardstate.length && boardstate[x + 3][y + 3] == symbol
				&& boardstate[x + 1][y + 1] == enemysymbol && boardstate[x + 2][y + 2] == enemysymbol) {
			boardstate[x + 1][y + 1] = ' ';
			boardstate[x + 2][y + 2] = ' ';
			System.out.println(geschlagen);
			this.printBoard();
		}

		// diagonal oben rechts --> unten links
		if (x - 3 >= 0 && y - 3 >= 0 && boardstate[x - 3][y - 3] == symbol && boardstate[x - 1][y - 1] == enemysymbol
				&& boardstate[x - 2][y - 2] == enemysymbol) {
			boardstate[x - 1][y - 1] = ' ';
			boardstate[x - 2][y - 2] = ' ';
			System.out.println(geschlagen);
			this.printBoard();
		}

		// diagonal unten rechts --> oben links
		if (x - 3 >= 0 && y + 3 < boardstate.length && boardstate[x - 3][y + 3] == symbol
				&& boardstate[x - 1][y + 1] == enemysymbol && boardstate[x - 2][y + 2] == enemysymbol) {
			boardstate[x - 1][y + 1] = ' ';
			boardstate[x - 2][y + 2] = ' ';
			System.out.println(geschlagen);
			this.printBoard();
		}

		// diagonal oben links --> unten rechts
		if (x + 3 < boardstate.length & y - 3 >= 0 && boardstate[x + 3][y - 3] == symbol
				&& boardstate[x + 1][y - 1] == enemysymbol && boardstate[x + 2][y - 2] == enemysymbol) {
			boardstate[x + 1][y - 1] = ' ';
			boardstate[x + 2][y - 2] = ' ';
			System.out.println(geschlagen);
			this.printBoard();
		}

	}
	/**
	 * 
	 * @param coordinate, symbol
	 * places the symbol into the array and gives the parameters to both of the "check"-Methods
	 * 
	 */

	void placeFigure(String coordinate, char symbol) {

		int[] coords = convertCoordinate(coordinate);

		if (isValidMove(coordinate)) {
			boardstate[coords[0] - 1][coords[1] - 1] = symbol;

			this.printBoard();
			this.checkDeleted(coordinate, symbol);
			this.checkWin(coordinate, symbol);

			currentPlayer = !currentPlayer;
			zugcounter++;
		}
		if (zugcounter == 3) {
			blockBoard();
		} else if (zugcounter == 4) {
			unblockBoard();
		}
	}
	/**
	 * 
	 * 
	 * Blocks the board for the 3rd move as intended from the customer
	 * 
	 */
	// Randsteine überschreiben bereits gesetzte Steine der ersten 2 Zügen
	// bessere Idee als jedes mal zusätzlicher if-clause der für jeden Stein
	// überprüft ob er leer ist?
	void blockBoard() {

		// "inneres" Viereck
		for (int i = 1; i < boardstate.length - 1; i++) {
			for (int j = 1; j < boardstate.length - 1; j++) {
				if (boardstate[i][j] == ' ') {
					boardstate[i][j] = 'R';
				}
			}
		}
		// gerades Spielfeld
		if (boardstate.length % 2 == 0) {
			if (boardstate[0][boardstate.length / 2] == ' ') {
				boardstate[0][boardstate.length / 2] = 'R';
			}
			if (boardstate[0][boardstate.length / 2 - 1] == ' ') {
				boardstate[0][boardstate.length / 2 - 1] = 'R';
			}
			if (boardstate[boardstate.length - 1][boardstate.length / 2] == ' ') {
				boardstate[boardstate.length - 1][boardstate.length / 2] = 'R';
			}
			if (boardstate[boardstate.length - 1][boardstate.length / 2 - 1] == ' ') {
				boardstate[boardstate.length - 1][boardstate.length / 2 - 1] = 'R';
			}
			if (boardstate[boardstate.length / 2][0] == ' ') {
				boardstate[boardstate.length / 2][0] = 'R';
			}
			if (boardstate[boardstate.length / 2 - 1][0] == ' ') {
				boardstate[boardstate.length / 2 - 1][0] = 'R';
			}
			if (boardstate[boardstate.length / 2][boardstate.length - 1] == ' ') {
				boardstate[boardstate.length / 2][boardstate.length - 1] = 'R';
			}
			if (boardstate[boardstate.length / 2 - 1][boardstate.length - 1] == ' ') {
				boardstate[boardstate.length / 2 - 1][boardstate.length - 1] = 'R';
			}
			// ungerades Spielfeld
		} else {
			if (boardstate[0][(boardstate.length - 1) / 2] == ' ') {
				boardstate[0][(boardstate.length - 1) / 2] = 'R';
			}
			if (boardstate[(boardstate.length - 1) / 2][boardstate.length - 1] == ' ') {
				boardstate[(boardstate.length - 1) / 2][boardstate.length - 1] = 'R';
			}
			if (boardstate[boardstate.length - 1][(boardstate.length - 1) / 2] == ' ') {
				boardstate[boardstate.length - 1][(boardstate.length - 1) / 2] = 'R';
			}
			if (boardstate[(boardstate.length - 1) / 2][0] == ' ') {
				boardstate[(boardstate.length - 1) / 2][0] = 'R';
			}

		}
		this.printBoard();
	}
	/**
	 * 
	 * 
	 * unblocks the board after the 3rd move was succesfully made
	 * 
	 */
	void unblockBoard() {

		for (int i = 0; i < boardstate.length; i++) {
			for (int j = 0; j < boardstate.length; j++) {
				if (boardstate[i][j] == 'R') {
					boardstate[i][j] = ' ';
				}
			}
		}

		this.printBoard();
	}

	char getSymbol() {
		if (currentPlayer) {
			return 'X';
		} else {
			return 'O';
		}
	}

	protected void setEnemyMove() {

	}
}
