package dieBoese2;

/**
 * 
 * @author Nasir Ahmad 
 * @version 0.2.1
 *
 */


public class Main {

	public static void main(String[] args) {
		
			Game game = new Game();
		
		for(int i=0;i<3;i++) {
			
			game.p1.blockSpace(game.board);
			game.p2.blockSpace(game.board);
		}
		
		game.p1.makeMove(game.board);
		game.board.printBoard();
		game.p2.makeMove(board);
		game.board.printBoard();
		
		while(game.isRunning()) {
			
			game.p1.makeMove(game.board);
			game.board.printBoard();
			
			if(game.isRunning()) {
				game.p2.makeMove(game.board);
				game.board.printBoard();
			}
			
			System.out.println("Glückwunch "+game.board.whoWon+". Sie haben gewonnen!");
			
			Game game = new Game(); //Muss anders gelöst werden namens konflikt!
			
			
		}
		
	}
}
