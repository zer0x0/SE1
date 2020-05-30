package dieBoese2;

import java.util.Scanner;


//V.1.0.0
//Author - Gabriel Kremensas
public class Menu {
	private int boardSize = 15;
	private boolean PvPorPvAI = false;
	private int difficulity = 2;
	private boolean whoBegins = true;

	public Menu() {

	}

	void menuLoop() {
		int choice = 0;
		Scanner keyboard = new Scanner(System.in);
		boolean weChillInMenu = true;
		do {
			this.cls();
			this.printHeader();

// Main Menu:
			if (choice == 0) {
				this.printChoices();
//				this.printSystemInstructions();
				choice = this.getMenuChoice(1, 6, keyboard);
			}

// Start Game:
			if (choice == 1) {
				weChillInMenu = false;
			}

// Change Board size:
			if (choice == 2) {
				System.out.println("Pick your new Board Size ");
				this.setBoardSize(this.getMenuChoice(15, 19, keyboard));

				choice = 0;
			}
// Change PvP or PvAI:
			if (choice == 3) {
				System.out.println("1: Play vs AI");
				System.out.println("2: Play vs another Player");
				this.setPvPorPvAI(this.getMenuChoice(1, 2, keyboard));
				choice = 0;

			}
// Change AI difficulty
			if (choice == 4) {
				System.out.println("1: Easy");
				System.out.println("2: Normal");
				System.out.println("3: Hard");

				this.setDifficulty(this.getMenuChoice(1, 3, keyboard));
				choice = 0;
			}

// Change Who begins
			if (choice == 5) {
				System.out.println("1: Player 1 starts");
				System.out.println("2: Player 2 starts");
				this.setWhoBegins(this.getMenuChoice(1, 2, keyboard));
				choice = 0;
			}

// Exit Game
			if (choice == 6) {
				keyboard.close();
				weChillInMenu = false;
			}
		} while (weChillInMenu);

	}

	// Set Methods:
	private void setBoardSize(int newBoardSize) {
		boardSize = newBoardSize;
	}

	private void setPvPorPvAI(int newPvPorPvE) {
		if (newPvPorPvE == 1) {
			PvPorPvAI = true;
		} else {
			PvPorPvAI = false;
		}
	}

	private void setDifficulty(int newDifficulity) {
		difficulity = newDifficulity;
	}

	private void setWhoBegins(int newBegins) {
		if (newBegins == 1) {
			whoBegins = true;
		} else {
			whoBegins = false;
		}
	}

	// Get Methods:
	int getBoardSize() {
		return boardSize;
	}

	boolean getPvPorPvAI() {
		return PvPorPvAI;
	}

	int getDifficulty() {
		return difficulity;
	}

	boolean getWhoBegins() {
		return whoBegins;
	}

	private void printHeader() {
		System.out.println("++-----------------------------------------------------------------------------++");
		System.out.println("||			Welcome to the Bose2 Game				||");
		System.out.println("||				Main Menu					||");
		System.out.println("++------------------------------------------------------------------------------++");

		
	}

	private void printChoices() {
		System.out.println("++------------------------------------------------------------------------------++");
		System.out.println("|| 1: Start Game								||");
		System.out.println("||										||");
		System.out.println("|| 2: Change Board size 				(" + boardSize + "x" + boardSize + ")			||");
		System.out.println("|| 3: Change PvP or PvAI		 		(PvAI==" + PvPorPvAI + ")		||");
		System.out.println("|| 4: Change AI difficulity 				(Difficulity==" + difficulity + ")	||");
		System.out.println("|| 5: Change who starts					(P1 start==" + whoBegins + ")	||");
		System.out.println("||										||");
		System.out.println("|| 6: Exit Game									||");
		System.out.println("++------------------------------------------------------------------------------++");
	}
	
	private void printCurrentSettings() {
		System.out.println("||Current Settings: ");
		System.out.println("||(BoardSize= " + boardSize + "x" + boardSize);
		System.out.println("||(PvAI=" + PvPorPvAI);
		System.out.println("||Difficulity=" + difficulity);
		System.out.println("||(P1 start=" + whoBegins);
	}
	
	


	private int getMenuChoice(int limitLow, int limitHigh, Scanner keyboard) {

		int choice = -1;
		do {
			System.out.print("Allowed Input (" + limitLow + " - " + limitHigh + " )  ");
			System.out.print("Enter your choice: ");
			try {
				choice = Integer.parseInt(keyboard.nextLine());
        if (choice < limitLow || choice > limitHigh) {
				  System.out.println("Choice outside of range. Please chose again.");
			}
			} catch (NumberFormatException e) {
				System.out.println("Invalid selection. Numbers only please.");
			}
		
		} while (choice < limitLow || choice > limitHigh);

		return choice;
	}

	private void cls() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	
}
