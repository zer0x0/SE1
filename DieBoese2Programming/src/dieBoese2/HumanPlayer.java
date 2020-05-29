package dieBoese2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 
 * @author Floris Wittner
 * @version 0.1.1
 * @date 29.05
 *
 */
public class HumanPlayer extends Player {
  String myMove;
	public HumanPlayer(char figure){
		super(figure);
 }
	String readInput() {
		String coordinate;
		var in = new BufferedReader(new InputStreamReader(System.in));
		try {
			coordinate = in.readLine();
		// ACHTUNG könnte Endlosschleife werden
		} catch (IOException e) {
			return readInput();  

		}
			setMyMove(coordinate);
			return coordinate;
		
	}
	private void setMyMove( String myMove) {
		this.myMove = myMove;
	}
	
	public String getMyMove()
	{   
		return myMove;
		
		}
	private void printGiveMeMove() {}

	@Override
	protected void blockSpace(Board board) {
		System.out.println("Welches Feld wollen Sie blockieren?");
		readInput();
		 if(board.isValidMove(getMyMove())) {
			 board.placeFigure(getMyMove(), 'B');
		 } else {
			 
			System.out.println("Dieses Feld kann nicht blockiert werden.");
			blockSpace(board);
		 }
		 }
	

	@Override
	protected void makeMove(Board board) {
		System.out.println("Auf welches Feld wollen Sie einen Stein legen?");
		readInput();
		 if(board.isValidMove(getMyMove())) {
			 board.placeFigure(getMyMove(), figure);
		 } else {
			 System.out.println("Sie können kein Stein auf dieses Feld legen.");
			 makeMove(board);
		 }
	}
	}