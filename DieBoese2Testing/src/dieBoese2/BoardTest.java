package dieBoese2;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**
 * 
 * @author Robert
 * @version 1
 *
 */

public class BoardTest {

	int boardWidth = 15;

	/**
	 * Test-ID Board1
	 */
	@Test
	public void printBoardTest1() {
		Board board = new Board(boardWidth, true);
		for (int i = 15; i < 20; i++) {
			board = new Board(i, true);
			board.printBoard();
		}

	}

	/**
	 * Test-ID Board2
	 */
	@Test
	public void printBoardTest2() {
		Board board = new Board(boardWidth, true);
		board.boardstate[0][0] = 'X';
		board.boardstate[board.boardstate.length - 1][0] = 'X';
		board.boardstate[0][board.boardstate[0].length - 1] = 'X';
		board.boardstate[board.boardstate.length - 1][board.boardstate[0].length - 1] = 'X';
		board.boardstate[3][8] = 'X';
		board.boardstate[8][11] = 'X';
		board.printBoard();
	}

	/**
	 * Test-ID Board3
	 */
	@Test
	public void printBoardTest3() {
		Board board = new Board(boardWidth, true);
		for (int i = 0; i < board.boardstate.length; i++) {
			for (int j = 0; j < board.boardstate[i].length; j++) {
				board.boardstate[i][j] = 'X';
			}
		}
		board.printBoard();
	}

	/**
	 * Test-ID Board7
	 */
	@Test
	public void isValidMoveTest1() {
		Board board = new Board(boardWidth, true);
		assertTrue(board.isValidMove("a1"));
	}

	/**
	 * Test-ID Board8
	 */
	@Test
	public void isValidMoveTest2() {
		Board board = new Board(boardWidth, true);
		board.boardstate[2][3] = 'B';
		board.boardstate[5][2] = 'B';
		board.boardstate[7][14] = 'B';
		board.boardstate[8][5] = 'B';
		board.boardstate[10][10] = 'B';
		board.boardstate[13][1] = 'B';
		assertFalse(board.isValidMove("c4"));
	}

	/**
	 * Test-ID Board9
	 */
	@Test
	public void isValidMoveTest3() {
		Board board = new Board(boardWidth, true);
		assertFalse(board.isValidMove("a35"));
		assertFalse(board.isValidMove("z2"));
		assertFalse(board.isValidMove("z35"));
		assertFalse(board.isValidMove("ab"));
		assertFalse(board.isValidMove("b"));
		assertFalse(board.isValidMove("4"));
		assertFalse(board.isValidMove("55"));
	}

	/**
	 * Test-ID Board15
	 */
	@Test
	public void isRunningTest1() {
		Board board = new Board(boardWidth, true);
		board.isRunning = true;
		assertTrue(board.isRunning());
	}

	/**
	 * Test-ID Board16
	 */
	@Test
	public void isRunningTest2() {
		Board board = new Board(boardWidth, true);
		board.isRunning = false;
		assertFalse(board.isRunning());
	}

	/**
	 * Test-ID Board17
	 */
	@Test
	public void whoWonTest1() {
		Board board = new Board(boardWidth, true);
		board.whoWon = true;
		assertTrue(board.whoWon());
	}

	/**
	 * Test-ID Board18
	 */
	@Test
	public void whoWonTest2() {
		Board board = new Board(boardWidth, true);
		board.whoWon = false;
		assertFalse(board.whoWon());
	}

	/**
	 * Test-ID Board33
	 */
	@Test
	public void convertCoordinatesTest1() {
		Board board = new Board(boardWidth, true);
		int[] expected = { 0, 0 };
		assertTrue(Arrays.equals(board.convertCoordinate("a1"), expected));
		int[] expected = { 0, 14 };
		assertTrue(Arrays.equals(board.convertCoordinate("a15"), expected));
		int[] expected = { 14, 0 };
		assertTrue(Arrays.equals(board.convertCoordinate("o1"), expected));
		int[] expected = { 14, 14 };
		assertTrue(Arrays.equals(board.convertCoordinate("o15"), expected));
		int[] expected = { 0, 0 };
		assertTrue(Arrays.equals(board.convertCoordinate("A1"), expected));
		int[] expected = { 0, 14 };
		assertTrue(Arrays.equals(board.convertCoordinate("A15"), expected));
		int[] expected = { 14, 0 };
		assertTrue(Arrays.equals(board.convertCoordinate("O1"), expected));
		int[] expected = { 14, 14 };
		assertTrue(Arrays.equals(board.convertCoordinate("O15"), expected));
	}
	
	/**
	 * Test-ID Board34
	 */
	@Test
	public void convertCoordinatesTest2() {
		Board board = new Board(boardWidth, true);
		int[] expected = { 15, 33 };
		assertTrue(Arrays.equals(board.convertCoordinate("p34"), expected));
		int[] expected = { 0, 21 };
		assertTrue(Arrays.equals(board.convertCoordinate("a22"), expected));
		int[] expected = { 18, 1 };
		assertTrue(Arrays.equals(board.convertCoordinate("s2"), expected));
	}
	
	/**
	 * Test-ID Board35
	 */
	@Test
	public void convertCoordinatesTest3() {
		Board board = new Board(boardWidth, true);
		int[] expected = { 0, 0 };
		assertTrue(Arrays.equals(board.convertCoordinate("1a"), expected));
		int[] expected = { 0, 14 };
		assertTrue(Arrays.equals(board.convertCoordinate("15a"), expected));
		int[] expected = { 14, 0 };
		assertTrue(Arrays.equals(board.convertCoordinate("1o"), expected));
		int[] expected = { 14, 14 };
		assertTrue(Arrays.equals(board.convertCoordinate("15o"), expected));
	}
	
	/**
	 * Test-ID Board36
	 */
	@Test
	public void convertCoordinatesTest4() {
		Board board = new Board(boardWidth, true);
		
	}
}
