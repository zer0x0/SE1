package dieBoese2;

/**
 * 
 * @author Nasir Ahmad 
 * @version 0.3.2
 *
 */


public class Main {

	public static void main(String[] args) {
		
			Game game = new Game();
		
		for(int i=0;i<3;i++) {
			
			game.p1.blockSpace(game.board);
			game.p2.blockSpace(game.board);
		}
		
		game.board.printBoard();
		game.p1.makeMove(game.board);
		game.board.printBoard();
		game.p2.makeMove(game.board);
		
		game.board.blockBoard();
		game.board.printBoard();
		
		game.p1.makeMove(game.board);
		game.board.unblockBoard();
		game.board.printBoard();
		game.p2.makeMove(game.board);
		
		while(game.board.isRunning()) {
			
			game.p1.makeMove(game.board);
			game.board.printBoard();
			
			if(game.board.isRunning()) {
				game.p2.makeMove(game.board);
				game.board.printBoard();
			}
			
			System.out.println("Glueckwunsch "+game.board.whoWon()+". Sie haben gewonnen!");
			
			game = new Game(); 
			
			
		}
		
	}
}
