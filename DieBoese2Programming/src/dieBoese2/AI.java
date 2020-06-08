package dieBoese2;

public class AI extends Player {
int difficulty;
	AI(char figure, int difficulty) {
		super(figure);
		this.difficulty = difficulty;
	}
	public static void main(String[] args) {
		AI test = new AI('B',3);
		System.out.println(test.convertCoordinate(1, 2));
		System.out.println(test.convertCoordinate(14, 15));
	}

	@Override
	protected void blockSpace(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void makeMove(Board board) {
		// TODO Auto-generated method stub
		
	}
	
	protected int getDepth() {
		return difficulty;
	}
	
	protected int[] generateBlockMove(Board board) {
		int blockedField[] = new int[2];
		int x = board.getBoardstate().length/2;
		int y = board.getBoardstate().length/2;
		while(!board.isValidMove(convertCoordinate(x, y))) {
			
		}
		return blockedField;
		
	}
	private String convertCoordinate(int x, int y) {
		String coordinates;
		char xChar = (char)(x+96);
		if (y<10) {
		char yChar = (char)(y+48);
		coordinates = String.valueOf(xChar)+ String.valueOf(yChar);
		
		}else{
			char yChar = (char)((y%10)+48);
			System.out.println(yChar);
			char yyChar = (char)((y/10)+48);
			System.out.println(yyChar);
			coordinates = String.valueOf(xChar)+ String.valueOf(yyChar)+ String.valueOf(yChar);
		}
		
		return coordinates;
		
	}

}
