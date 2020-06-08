package dieBoese2;

import static org.junit.Assert.*;
import org.junit.Test;


 /*
  *  @author Sarah
  *  @date 07.06.20
  */
 
 
public class BoardTest2 {

	final int BOARD_MAX_SIZE = 19;
	final int BOARD_MIN_SIZE = 15;

	String coordinate = "1a";
	char symbol = 'X';
	
	/*
	 * Test-ID w1 
	 */
	@Test
	public void checkWin1() {
		Board board = new Board(BOARD_MAX_SIZE);
		board.checkWin(coordinate, symbol);
		assertTrue(board.isRunning());

	}
	
	/*
	 * Test-ID w2
	 */
	@Test
	public void checkWin2() {
		Board board = new Board(BOARD_MAX_SIZE);
		board.checkWin(coordinate, symbol);
		assertFalse(!board.isRunning());
	}

	/*
	 * Test-ID w3
	 */
	@Test
	public void checkWin3() {
		Board board = new Board(BOARD_MIN_SIZE);
		board.checkWin(coordinate, symbol);
		assertFalse(!board.isRunning());

	}

	/*
	 * Test-ID w4
	 */
	@Test
	public void checkWin4() {
		Board board = new Board(BOARD_MIN_SIZE);
		board.checkWin(coordinate, symbol);
		assertTrue(board.isRunning());

	}

	/*
	 * Test-ID w5
	 */
	@Test(expected = Exception.class)
	public void checkWin5() {
		coordinate = "16a";
		Board board = new Board(BOARD_MIN_SIZE);
		board.checkWin(coordinate, symbol);
		assertTrue(board.isRunning());
	}

	/*
	 * Test-ID w6
	 */
	@Test(expected = Exception.class)
	public void checkWin7() {
		coordinate = "20a";
		Board board = new Board(BOARD_MAX_SIZE);
		board.checkWin(coordinate, symbol);
		assertTrue(board.isRunning());
	}

	/*
	 * Test-ID d1
	 */
	@Test
	public void checkDeleted1() {
		Board board = new Board(BOARD_MAX_SIZE);
		board.checkDeleted(coordinate, symbol);
		assertTrue(board.isRunning());
	}

	/*
	 * Test-ID d2
	 */
	@Test
	public void checkDeleted2() {
		Board board = new Board(BOARD_MAX_SIZE);
		board.checkDeleted(coordinate, symbol);
		assertFalse(!board.isRunning());
	}

	/*
	 * Test-ID d3
	 */
	@Test
	public void checkDeleted3() {
		Board board = new Board(BOARD_MIN_SIZE);
		board.checkDeleted(coordinate, symbol);
		assertTrue(board.isRunning());
	}

	/*
	 * Test-ID d4
	 */
	@Test
	public void checkDeleted4() {
		Board board = new Board(BOARD_MIN_SIZE);
		board.checkDeleted(coordinate, symbol);
		assertFalse(!board.isRunning());
	} 
	
	/*
	 * Test-ID d5
	 */
	@Test(expected = Exception.class)
	public void checkDeleted5() {
		coordinate = "20a";
		Board board = new Board(BOARD_MAX_SIZE);
		board.checkDeleted(coordinate, symbol);
		assertTrue(board.isRunning());
	}

	/*
	 * Test-ID d6
	 */
	@Test(expected = Exception.class)
	public void checkDeleted6() {
		coordinate = "16a";
		Board board = new Board(BOARD_MIN_SIZE);
		board.checkDeleted(coordinate, symbol);
		assertTrue(board.isRunning());
	}

	/*
	 * Test-ID p1
	 */
	@Test
	public void placeFigure1() {
		Board board = new Board(BOARD_MAX_SIZE);
		board.placeFigure(coordinate, symbol);
		assertFalse(!board.isRunning());
	}
	
	/*
	 * Test-ID p2
	 */
	@Test
	public void placeFigure2() {
		Board board = new Board(BOARD_MAX_SIZE);
		board.placeFigure(coordinate, symbol);
		assertTrue(board.isRunning());
	}
 
}