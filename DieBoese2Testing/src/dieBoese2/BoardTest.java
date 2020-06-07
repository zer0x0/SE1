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

	final int BOARD_MAX_SIZE = 19;
	final int BOARD_MIN_SIZE = 15;

	private static char[][] makeHelpState(Board board) {
		char[][] helpstate = new char[board.getBoardstate().length][board.getBoardstate()[0].length];
		for (int i = 0; i < helpstate.length; i++)
			for (int j = 0; j < helpstate[i].length; j++)
				helpstate[i][j] = ' ';
		;
		return helpstate;
	}

	/**
	 * Test-ID Board1
	 */
	@Test
	public void printBoardTest1() {
		Board board;
		for (int i = BOARD_MIN_SIZE; i <= BOARD_MAX_SIZE; i++) {
			board = new Board(i);
			board.printBoard();
		}

	}

	/**
	 * Test-ID Board2
	 */
	@Test
	public void printBoardTest2() {
		Board board;
		for (int i = BOARD_MIN_SIZE; i <= BOARD_MAX_SIZE; i++) {
			board = new Board(i);
			char[][] helpstate = makeHelpState(board);
			helpstate[0][0] = 'X';
			helpstate[helpstate.length - 1][0] = 'X';
			helpstate[0][helpstate[0].length - 1] = 'X';
			helpstate[helpstate.length - 1][helpstate[0].length - 1] = 'X';
			helpstate[3][8] = 'X';
			helpstate[8][11] = 'X';
			board.setBoardstate(helpstate);
			board.printBoard();
		}
	}

	/**
	 * Test-ID Board3
	 */
	@Test
	public void printBoardTest3() {
		Board board;
		for (int i = BOARD_MIN_SIZE; i <= BOARD_MAX_SIZE; i++) {
			board = new Board(i);
			char[][] helpstate = makeHelpState(board);
			for (int j = 0; j < helpstate.length; j++) {
				for (int k = 0; k < helpstate[j].length; k++) {
					helpstate[j][k] = 'X';
				}
			}
			board.setBoardstate(helpstate);
			board.printBoard();
		}
	}

	/**
	 * Test-ID Board7
	 */
	@Test
	public void isValidMoveTest1() {
		Board board;
		for (int i = BOARD_MIN_SIZE; i <= BOARD_MAX_SIZE; i++) {
			board = new Board(i);
			assertTrue(board.isValidMove("a1"));
		}
	}

	/**
	 * Test-ID Board8
	 */
	@Test
	public void isValidMoveTest2() {
		Board board;
		for (int i = BOARD_MIN_SIZE; i <= BOARD_MAX_SIZE; i++) {
			board = new Board(i);
			char[][] helpstate = makeHelpState(board);
			helpstate[2][3] = 'B';
			helpstate[5][2] = 'B';
			helpstate[7][14] = 'B';
			helpstate[8][5] = 'B';
			helpstate[10][10] = 'B';
			helpstate[13][1] = 'B';
			board.setBoardstate(helpstate);
			assertFalse(board.isValidMove("c4"));
		}
	}

	/**
	 * Test-ID Board9
	 */
	@Test
	public void isValidMoveTest3() {
		Board board = new Board(BOARD_MIN_SIZE);
		assertFalse(board.isValidMove("a35"));
		assertFalse(board.isValidMove("z2"));
		assertFalse(board.isValidMove("z35"));
		assertFalse(board.isValidMove("ab"));
		assertFalse(board.isValidMove(""));
		assertFalse(board.isValidMove("b"));
		assertFalse(board.isValidMove("4"));
		assertFalse(board.isValidMove("55"));
	}

	/**
	 * Test-ID Board9-1
	 */
	@Test
	public void isValidMoveTest4() {
		Board board = new Board(BOARD_MIN_SIZE);
		assertFalse(board.isValidMove("a16"));
		board = new Board(BOARD_MAX_SIZE);
		assertTrue(board.isValidMove("a16"));
	}

//	/**
//	 * Test-ID Board15
//	 */
//	@Test
//	public void isRunningTest1() {
//		Board board = new Board(BOARD_MIN_SIZE);
//		board.isRunning = true;
//		assertTrue(board.isRunning());
//	}

//	/**
//	 * Test-ID Board16
//	 */
//	@Test
//	public void isRunningTest2() {
//		Board board = new Board(BOARD_MIN_SIZE);
//		board.isRunning = false;
//		assertFalse(board.isRunning());
//	}

//	/**
//	 * Test-ID Board17
//	 */
//	@Test
//	public void whoWonTest1() {
//		Board board = new Board(BOARD_MIN_SIZE);
//		board.whoWon = true;
//		assertTrue(board.whoWon());
//	}

//	/**
//	 * Test-ID Board18
//	 */
//	@Test
//	public void whoWonTest2() {
//		Board board = new Board(BOARD_MIN_SIZE);
//		board.whoWon = false;
//		assertFalse(board.whoWon());
//	}

	/**
	 * Test-ID Board33
	 */
	@Test
	public void convertCoordinatesTest1() {
		Board board = new Board(BOARD_MIN_SIZE);
		int[] expected = { 1, 1 };
		assertTrue(Arrays.equals(board.convertCoordinate("a1"), expected));
		expected[0] = 1;
		expected[1] = 15;
		assertTrue(Arrays.equals(board.convertCoordinate("a15"), expected));
		expected[0] = 15;
		expected[1] = 1;
		assertTrue(Arrays.equals(board.convertCoordinate("o1"), expected));
		expected[0] = 15;
		expected[1] = 15;
		assertTrue(Arrays.equals(board.convertCoordinate("o15"), expected));
		expected[0] = 1;
		expected[1] = 1;
		assertTrue(Arrays.equals(board.convertCoordinate("A1"), expected));
		expected[0] = 1;
		expected[1] = 15;
		assertTrue(Arrays.equals(board.convertCoordinate("A15"), expected));
		expected[0] = 15;
		expected[1] = 1;
		assertTrue(Arrays.equals(board.convertCoordinate("O1"), expected));
		expected[0] = 15;
		expected[1] = 15;
		assertTrue(Arrays.equals(board.convertCoordinate("O15"), expected));
	}

	/**
	 * Test-ID Board34
	 */
	@Test(expected = Exception.class)
	public void convertCoordinatesTest2() {
		Board board = new Board(BOARD_MIN_SIZE);
		board.convertCoordinate("p34");
	}

	/**
	 * Test-ID Board35
	 */
	@Test
	public void convertCoordinatesTest3() {
		Board board = new Board(BOARD_MIN_SIZE);
		int[] expected = { 1, 1 };
		assertTrue(Arrays.equals(board.convertCoordinate("1a"), expected));
		expected[0] = 1;
		expected[1] = 15;
		assertTrue(Arrays.equals(board.convertCoordinate("15a"), expected));
		expected[0] = 15;
		expected[1] = 1;
		assertTrue(Arrays.equals(board.convertCoordinate("1o"), expected));
		expected[0] = 15;
		expected[1] = 15;
		assertTrue(Arrays.equals(board.convertCoordinate("15o"), expected));
	}

	/**
	 * Test-ID Board36-1
	 */
	@Test(expected = Exception.class)
	public void convertCoordinatesTest4() {
		Board board = new Board(BOARD_MIN_SIZE);
		board.convertCoordinate("1234");
	}

	/**
	 * Test-ID Board36-2
	 */
	@Test(expected = Exception.class)
	public void convertCoordinatesTest5() {
		Board board = new Board(BOARD_MIN_SIZE);
		board.convertCoordinate("hallo");
	}

	/**
	 * Test-ID Board36-3
	 */
	@Test(expected = Exception.class)
	public void convertCoordinatesTest6() {
		Board board = new Board(BOARD_MIN_SIZE);
		board.convertCoordinate("-23a");
	}

	/**
	 * Test-ID Board36-4
	 */
	@Test(expected = Exception.class)
	public void convertCoordinatesTest7() {
		Board board = new Board(BOARD_MIN_SIZE);
		board.convertCoordinate("f-3");
	}

	/**
	 * Test-ID Board36-5
	 */
	@Test(expected = Exception.class)
	public void convertCoordinatesTest8() {
		Board board = new Board(BOARD_MIN_SIZE);
		board.convertCoordinate("1");
	}

	/**
	 * Test-ID Board36-6
	 */
	@Test(expected = Exception.class)
	public void convertCoordinatesTest9() {
		Board board = new Board(BOARD_MIN_SIZE);
		board.convertCoordinate("");
	}

	/**
	 * Test-ID Board37
	 */
	@Test
	public void blockBoardTest1() {
		Board board;
		for (int i = BOARD_MIN_SIZE; i <= BOARD_MAX_SIZE; i++) {
			board = new Board(i);
			board.blockBoard();
			board.printBoard();
		}

	}

	/**
	 * Test-ID Board38
	 */
	@Test
	public void blockBoardTest2() {
		Board board;
		for (int i = BOARD_MIN_SIZE; i <= BOARD_MAX_SIZE; i++) {
			board = new Board(i);
			char[][] helpstate = makeHelpState(board);
			helpstate[2][6] = 'B';
			helpstate[4][5] = 'B';
			helpstate[8][14] = 'B';
			helpstate[0][12] = 'B';
			helpstate[13][4] = 'B';
			helpstate[7][7] = 'B';
			helpstate[3][4] = 'X';
			helpstate[0][13] = 'O';
			board.setBoardstate(helpstate);
			board.blockBoard();
			board.printBoard();
		}
	}

	/**
	 * Test-ID Board39
	 */
	@Test
	public void blockBoardTest3() {
		Board board;
		for (int i = BOARD_MIN_SIZE; i <= BOARD_MAX_SIZE; i++) {
			board = new Board(i);
			char[][] helpstate = makeHelpState(board);
			helpstate[2][6] = 'B';
			helpstate[4][5] = 'B';
			helpstate[8][14] = 'B';
			helpstate[0][12] = 'B';
			helpstate[13][4] = 'B';
			helpstate[7][7] = 'B';
			helpstate[3][4] = 'X';
			helpstate[0][13] = 'O';
			board.setBoardstate(helpstate);
			board.blockBoard();
			board.blockBoard();
			board.printBoard();
		}
	}

	/**
	 * Test-ID Board40
	 */
	@Test
	public void unblockBoardTest1() {
		Board board;
		for (int i = BOARD_MIN_SIZE; i <= BOARD_MAX_SIZE; i++) {
			board = new Board(i);
			board.blockBoard();
			board.printBoard();
			board.unblockBoard();
			board.printBoard();
		}
	}

	/**
	 * Test-ID Board41
	 */
	@Test
	public void unblockBoardTest2() {
		Board board;
		for (int i = BOARD_MIN_SIZE; i <= BOARD_MAX_SIZE; i++) {
			board = new Board(i);
			char[][] helpstate = makeHelpState(board);
			helpstate[2][6] = 'B';
			helpstate[4][5] = 'B';
			helpstate[8][14] = 'B';
			helpstate[0][12] = 'B';
			helpstate[13][4] = 'B';
			helpstate[7][7] = 'B';
			helpstate[3][4] = 'X';
			helpstate[0][13] = 'O';
			helpstate[0][0] = 'X';
			helpstate[4][13] = 'O';
			board.setBoardstate(helpstate);
			board.blockBoard();
			board.unblockBoard();
			board.printBoard();
		}
	}

	/**
	 * Test-ID Board42
	 */
	@Test
	public void unblockBoardTest3() {
		Board board;
		for (int i = BOARD_MIN_SIZE; i <= BOARD_MAX_SIZE; i++) {
			board = new Board(i);
			char[][] helpstate = makeHelpState(board);
			helpstate[2][6] = 'B';
			helpstate[4][5] = 'B';
			helpstate[8][14] = 'B';
			helpstate[0][12] = 'B';
			helpstate[13][4] = 'B';
			helpstate[7][7] = 'B';
			helpstate[3][4] = 'X';
			helpstate[0][13] = 'O';
			helpstate[0][0] = 'X';
			helpstate[4][13] = 'O';
			helpstate[5][9] = 'X';
			helpstate[6][14] = 'O';
			board.setBoardstate(helpstate);
			board.unblockBoard();
			board.printBoard();
		}
	}
}
