package dieBoese2;

public class Board {
	char boardstate[][];

   Board() {
	   boardstate = new char [15][15];
   }
	Board(int size) {
		boardstate = new char[size][size];
		
	}
	   public static void main(String[] args) {
			Board board = new Board();
			
			String test = "a12"; 
//			System.out.println((int) test.charAt(1));
//			System.out.println(board.boardstate.length);
		   System.out.println(board.convertCoordinate("1a"));
		   System.out.println(board.convertCoordinate("a1"));
		   System.out.println(board.convertCoordinate("a13"));
		   System.out.println(board.convertCoordinate("13b"));
		  
		}

	protected boolean isValidMove(String coordinate) {

	   //keine richtige koordinate, auserhalb des spielfeld
	   
	   // besetzt
		  return false;
	   
   }

	protected int[] convertCoordinate(String coordinate) {

		int x = 0, y = 0;
		
		int coordinateInt[] = new int[2];
		coordinate = coordinate.toLowerCase();
		

		if (coordinate.length() == 3) {
			if ((int) coordinate.charAt(1) <= this.boardstate.length && ((int) coordinate.charAt(2) - 48) <= this.boardstate.length) {

				y = (int) coordinate.charAt(1) * 10 + coordinate.charAt(2);
				x = (int) coordinate.charAt(3) - 48;

			} else if ((int) coordinate.charAt(2) <= this.boardstate.length && ((int) coordinate.charAt(1) - 48) <= this.boardstate.length) {
				y = (int) coordinate.charAt(2) * 10 + coordinate.charAt(3);
				x = (int) coordinate.charAt(1) - 48;

			}
		} else if (coordinate.length() == 2) {
//			System.out.println(this.boardstate.length);
//			System.out.println(coordinate.charAt(1));
			if ((int) coordinate.charAt(1) <= this.boardstate.length &&
					((int) coordinate.charAt(2) - 48) <= this.boardstate.length) {

			y = (int) coordinate.charAt(1);
			x = (int) coordinate.charAt(2) - 48;

		} else if ((int) coordinate.charAt(2) <= this.boardstate.length && ((int) coordinate.charAt(1) - 48) <= this.boardstate.length) {
			y = (int) coordinate.charAt(2);
			x = (int) coordinate.charAt(1) - 48;

		}
		}
		coordinateInt[1] = x;
		coordinateInt[2] = y;
		return coordinateInt;

	
}
	}
