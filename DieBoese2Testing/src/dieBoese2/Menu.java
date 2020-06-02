package dieBoese2;

import java.util.Scanner;

//V.1.1.0
//Author - Gabriel Kremensas
public class Menu {
	private int boardSize = 15; // board size 15= 15x15, 16=16x16, ... 
	private boolean PvPorPvAI = false; // false = PvP, true = PvAI
	private int difficulity = 2; // 1=easy, 2=normal, 3=hard
	private boolean whoBegins = true; // true= Player 1, false= Player 2

//Constructor is going to need a Scanner passed to him later on...
	public Menu() {
	}

	
//Start of menu loop
	void menuLoop() {
		int choice = 0;
		// TODO: The scanner should be passed to the Menu from The main or the game...
		Scanner keyboard = new Scanner(System.in);
		boolean weChillInMenu = true;
		do {
			this.cls();
			this.printHeader();

// Main Menu:
			if (choice == 0) {
				this.printMainMenu();
				choice = this.getMenuChoice(1, 6, keyboard);
			}

// Start Game:
			if (choice == 1) {
				weChillInMenu = false;
			}

// Change Board size:
			if (choice == 2) {
				this.cls();
				printHeader();
				printSettingsBoard();
				this.setBoardSize(this.getMenuChoice(15, 19, keyboard));

				choice = 0;
			}
// Change PvP or PvAI:
			if (choice == 3) {
				this.cls();
				printHeader();
				printSettingsMode();
				this.setPvPorPvAI(this.getMenuChoice(1, 2, keyboard));
				choice = 0;

			}
// Change AI difficulty
			if (choice == 4) {
				this.cls();
				printHeader();
				printSettingsDifficulity();
				this.setDifficulty(this.getMenuChoice(1, 3, keyboard));
				choice = 0;
			}

// Change Who begins
			if (choice == 5) {
				this.cls();
				printHeader();
				printSettingsWhoBegins();
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
// End of loop
	
	
	// Beginning of all Set Methods:
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
	// End of all Set Methods
	
	// Beginning of all Get Methods
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
	// end of all Get Methods
	
// Beginning of Strings that I need to display in the Menu
	private String stringGameMode() {
		if (PvPorPvAI) {
			return "PvAI";
		} else
			return "PvP ";
	}

	private String stringDifficulity() {
		if (difficulity == 1) {
			return "Easy  ";
		} else if (difficulity == 2) {
			return "Normal";
		} else
			return "Hard  ";
	}

	private String stringWhoBegins() {
		if (whoBegins) {
			return "Player 1";
		} else
			return "Player 2";
	}
// End of Strings i need to display in Menu

	
// Beginning of all Printable Interfaces in the Menu
	private void printHeader() {

		System.out.println();
		System.out.println("       ██████╗ ██╗███████╗    ██████╗  ██████╗ ███████╗███████╗    ██████╗ ");
		System.out.println("       ██╔══██╗██║██╔════╝    ██╔══██╗██╔═══██╗██╔════╝██╔════╝    ╚════██╗");
		System.out.println("       ██║  ██║██║█████╗      ██████╔╝██║   ██║███████╗█████╗       █████╔╝");
		System.out.println("       ██║  ██║██║██╔══╝      ██╔══██╗██║   ██║╚════██║██╔══╝      ██╔═══╝ ");
		System.out.println("       ██████╔╝██║███████╗    ██████╔╝╚██████╔╝███████║███████╗    ███████╗");
		System.out.println("       ╚═════╝ ╚═╝╚══════╝    ╚═════╝  ╚═════╝ ╚══════╝╚══════╝    ╚══════╝");

	}

	private void printMainMenu() {
		System.out.println("╔════════════════════════════════════════════════════════════════════════════════╗");
		System.out.println("║ MENU:                                                                          ║");
		System.out.println("║                                                                                ║");
		System.out.println("║ 1: Start Game                                                                  ║");
		System.out.println("║                                                                                ║");
		System.out.println("║ 2: Change Board Size                 (Current Size: " + boardSize + "x" + boardSize
				+ ")                     ║");
		System.out.println("║ 3: Change Game Mode                  (Current Mode: " + stringGameMode()
				+ ")                      ║");
		System.out.println("║ 4: Change Computer Difficulity       (Current Difficulity: " + stringDifficulity()
				+ ")             ║");
		System.out.println(
				"║ 5: Change Starting Player            (Current Starting Player: " + stringWhoBegins() + ")       ║");
		System.out.println("║                                                                                ║");
		System.out.println("║ 6: Exit Game                                                                   ║");
		System.out.println("╚════════════════════════════════════════════════════════════════════════════════╝");
	}

	private void printSettingsBoard() {
		System.out.println("╔════════════════════════════════════════════════════════════════════════════════╗");
		System.out.println("║ MENU> Change Board Size: (Current Size: " + boardSize + "x" + boardSize
				+ ")                                 ║");
		System.out.println("║                                                                                ║");
		System.out.println("║ Set the Size, that you want your board to be.                                  ║");
		System.out.println("║                                                                                ║");
		System.out.println("║ Choices:                                                                       ║");
		System.out.println("║ 15: Size to (15x15)                                                            ║");
		System.out.println("║ 16: Size to (16x16)                                                            ║");
		System.out.println("║ 17: Size to (17x17)                                                            ║");
		System.out.println("║ 18: Size to (18x18)                                                            ║");
		System.out.println("║ 19: Size to (19x19)                                                            ║");
		System.out.println("╚════════════════════════════════════════════════════════════════════════════════╝");
	}

	private void printSettingsMode() {
		System.out.println("╔════════════════════════════════════════════════════════════════════════════════╗");
		System.out.println("║ MENU> Change Game mode: (Current Mode: " + stringGameMode()
				+ ")                                   ║");
		System.out.println("║                                                                                ║");
		System.out.println("║ Set the Game Mode, that you want to play on.                                   ║");
		System.out.println("║                                                                                ║");
		System.out.println("║ Choices:                                                                       ║");
		System.out.println("║ 1: Player vs Computer (PvAI)                                                   ║");
		System.out.println("║ 2: Player vs Player (PvP)                                                      ║");
		System.out.println("╚════════════════════════════════════════════════════════════════════════════════╝");
	}

	private void printSettingsDifficulity() {
		System.out.println("╔════════════════════════════════════════════════════════════════════════════════╗");
		System.out.println("║ MENU> Change Computer Difficulity: (Current Difficulity: " + stringDifficulity()
				+ ")               ║");
		System.out.println("║                                                                                ║");
		System.out.println("║ Set the Computer Difficulity, that you want to play on.                        ║");
		System.out.println("║                                                                                ║");
		System.out.println("║ Choices:                                                                       ║");
		System.out.println("║ 1: Easy                                                                        ║");
		System.out.println("║ 2: Normal                                                                      ║");
		System.out.println("║ 3: Hard                                                                        ║");
		System.out.println("╚════════════════════════════════════════════════════════════════════════════════╝");
	}

	private void printSettingsWhoBegins() {
		System.out.println("╔════════════════════════════════════════════════════════════════════════════════╗");
		System.out.println(
				"║ MENU> Change Starting Player: (Current Starting Player: " + stringWhoBegins() + ")              ║");
		System.out.println("║                                                                                ║");
		System.out.println("║ Set the Starting Player.                                                       ║");
		System.out.println("║                                                                                ║");
		System.out.println("║ Choices:                                                                       ║");
		System.out.println("║ 1: Player 1                                                                    ║");
		System.out.println("║ 2: Player 2                                                                    ║");
		System.out.println("╚════════════════════════════════════════════════════════════════════════════════╝");
	}

// End of all printable interfaces of the Menu

	
	// to get the user inputs, limited to what is possible in the specific selection
	private int getMenuChoice(int limitLow, int limitHigh, Scanner keyboard) {

		int choice = -1;
		do {
			System.out.print("  Allowed Inputs (" + limitLow + "-" + limitHigh + ") ");
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

	// to clear the console
	public void cls() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// for testing
	public static void main(String[] Args) {
		Menu menu = new Menu();
		menu.menuLoop();
		System.out.println("This is where the game should start...");

	}
}
