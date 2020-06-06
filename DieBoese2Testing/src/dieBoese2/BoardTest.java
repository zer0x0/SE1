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
		Board board = new Board(boardWidth);
		for (int i = 15; i < 20; i++) {
			board = new Board(i);
			board.printBoard();
		}

	}

	/**
	 * Test-ID Board2
	 */
	@Test
	public void printBoardTest2() {
		Board board = new Board(boardWidth);
		char[][] helpstate = new char[board.getBoardstate().length][board.getBoardstate()[0].length];
		helpstate[0][0] = 'X';
		helpstate[helpstate.length - 1][0] = 'X';
		helpstate[0][helpstate[0].length - 1] = 'X';
		helpstate[helpstate.length - 1][helpstate[0].length - 1] = 'X';
		helpstate[3][8] = 'X';
		helpstate[8][11] = 'X';
		board.setBoardstate(helpstate);
		board.printBoard();
	}

	/**
	 * Test-ID Board3
	 */
	@Test
	public void printBoardTest3() {
		Board board = new Board(boardWidth);
		char[][] helpstate = new char[board.getBoardstate().length][board.getBoardstate()[0].length];
		for (int i = 0; i < helpstate.length; i++) {
			for (int j = 0; j < helpstate[i].length; j++) {
				helpstate[i][j] = 'X';
			}
		}
		board.setBoardstate(helpstate);
		board.printBoard();
	}

	/**
	 * Test-ID Board7
	 */
	@Test
	public void isValidMoveTest1() {
		Board board = new Board(boardWidth);
		assertTrue(board.isValidMove("a1"));
	}

	/**
	 * Test-ID Board8
	 */
	@Test
	public void isValidMoveTest2() {
		Board board = new Board(boardWidth);
		char[][] helpstate = new char[board.getBoardstate().length][board.getBoardstate()[0].length];
		helpstate[2][3] = 'B';
		helpstate[5][2] = 'B';
		helpstate[7][14] = 'B';
		helpstate[8][5] = 'B';
		helpstate[10][10] = 'B';
		helpstate[13][1] = 'B';
		board.setBoardstate(helpstate);
		assertFalse(board.isValidMove("c4"));
	}

	/**
	 * Test-ID Board9
	 */
	@Test
	public void isValidMoveTest3() {
		Board board = new Board(boardWidth);
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
		Board board = new Board(boardWidth);
		board.isRunning = true;
		assertTrue(board.isRunning());
	}

	/**
	 * Test-ID Board16
	 */
	@Test
	public void isRunningTest2() {
		Board board = new Board(boardWidth);
		board.isRunning = false;
		assertFalse(board.isRunning());
	}

	/**
	 * Test-ID Board17
	 */
	@Test
	public void whoWonTest1() {
		Board board = new Board(boardWidth);
		board.whoWon = true;
		assertTrue(board.whoWon());
	}

	/**
	 * Test-ID Board18
	 */
	@Test
	public void whoWonTest2() {
		Board board = new Board(boardWidth);
		board.whoWon = false;
		assertFalse(board.whoWon());
	}

	/**
	 * Test-ID Board33
	 */
	@Test
	public void convertCoordinatesTest1() {
		Board board = new Board(boardWidth);
		int[] expected = { 0, 0 };
		assertTrue(Arrays.equals(board.convertCoordinate("a1"), expected));
		expected[0] = 0;
		expected[1] = 14;
		assertTrue(Arrays.equals(board.convertCoordinate("a15"), expected));
		expected[0] = 14;
		expected[1] = 0;
		assertTrue(Arrays.equals(board.convertCoordinate("o1"), expected));
		expected[0] = 14;
		expected[1] = 14;
		assertTrue(Arrays.equals(board.convertCoordinate("o15"), expected));
		expected[0] = 0;
		expected[1] = 0;
		assertTrue(Arrays.equals(board.convertCoordinate("A1"), expected));
		expected[0] = 0;
		expected[1] = 14;
		assertTrue(Arrays.equals(board.convertCoordinate("A15"), expected));
		expected[0] = 14;
		expected[1] = 0;
		assertTrue(Arrays.equals(board.convertCoordinate("O1"), expected));
		expected[0] = 14;
		expected[1] = 14;
		assertTrue(Arrays.equals(board.convertCoordinate("O15"), expected));
	}

	/**
	 * Test-ID Board34
	 */
	@Test
	public void convertCoordinatesTest2() {
		Board board = new Board(boardWidth);
		int[] expected = { 15, 33 };
		assertTrue(Arrays.equals(board.convertCoordinate("p34"), expected));
		expected[0] = 0;
		expected[1] = 21;
		assertTrue(Arrays.equals(board.convertCoordinate("a22"), expected));
		expected[0] = 18;
		expected[1] = 1;
		assertTrue(Arrays.equals(board.convertCoordinate("s2"), expected));
	}

	/**
	 * Test-ID Board35
	 */
	@Test
	public void convertCoordinatesTest3() {
		Board board = new Board(boardWidth);
		int[] expected = { 0, 0 };
		assertTrue(Arrays.equals(board.convertCoordinate("1a"), expected));
		expected[0] = 0;
		expected[1] = 14;
		assertTrue(Arrays.equals(board.convertCoordinate("15a"), expected));
		expected[0] = 14;
		expected[1] = 0;
		assertTrue(Arrays.equals(board.convertCoordinate("1o"), expected));
		expected[0] = 14;
		expected[1] = 14;
		assertTrue(Arrays.equals(board.convertCoordinate("15o"), expected));
	}

	/**
	 * Test-ID Board36-1
	 */
	@Test(expected = Exception.class)
	public void convertCoordinatesTest4() {
		Board board = new Board(boardWidth);
		board.convertCoordinate("1234");
	}

	/**
	 * Test-ID Board36-2
	 */
	@Test(expected = Exception.class)
	public void convertCoordinatesTest5() {
		Board board = new Board(boardWidth);
		board.convertCoordinate("hallo");
	}

	/**
	 * Test-ID Board36-3
	 */
	@Test(expected = Exception.class)
	public void convertCoordinatesTest6() {
		Board board = new Board(boardWidth);
		board.convertCoordinate("-23a");
	}

	/**
	 * Test-ID Board36-4
	 */
	@Test(expected = Exception.class)
	public void convertCoordinatesTest7() {
		Board board = new Board(boardWidth);
		board.convertCoordinate("f-3");
	}
}
