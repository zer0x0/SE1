package dieBoese2;

import java.util.Scanner;

/**
 * 
 * @author Floris Wittner 1921233
 *  @version 1.0.0
 *  
 *   */
public abstract class Player {
	char figure;

Player(char figure) {
	 this.figure = figure;
 }
 protected Board blockSpace(Board board) {
	
	 
	System.out.println("Welches Feld wollen Sie blockieren?");
	 if(board.isValidMove) {
		board.changeField(getMyMove(),)
	}else 
	{
	System.out.println("Dieses Feld, kann nicht blockiert werden, wählen Sie ein neues Feld aus");
	
	}
	
	 return board;
	 
 }
 protected Board makeMove(Board board) {
	 if(board.isValidMove) {
			
		}else 
		{
			
		}
		 
		 return board;
	 
 }
 private void printGiveMeMove() {
	 
 }
}
