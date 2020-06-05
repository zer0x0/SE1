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
				this.exit();
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
			return "PvKI";
		} else
			return "PvP ";
	}

	private String stringDifficulity() {
		if (difficulity == 1) {
			return "Leicht";
		} else if (difficulity == 2) {
			return "Normal";
		} else
			return "Schwer";
	}

	private String stringWhoBegins() {
		if (whoBegins) {
			return "Spieler1";
		} else
			return "Spieler2";
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
		System.out.println("║ 1: Spiel Starten                                                               ║");
		System.out.println("║                                                                                ║");
		System.out.println("║ 2: Board Größe ändern                (Momentane Größe: " + boardSize + "x" + boardSize
				+ ")                  ║");
		System.out.println("║ 3: Spiel Mode ändern                 (Momentanes Mode: " + stringGameMode()
				+ ")                   ║");
		System.out.println("║ 4: KI Schwierigkeit ändern           (Momentane Schwierigkeit: " + stringDifficulity()
				+ ")         ║");
		System.out.println(
				"║ 5: Beginnenden Spieler ändern        (Momentan Beginnender Spieler: " + stringWhoBegins() + ")  ║");
		System.out.println("║                                                                                ║");
		System.out.println("║ 6: Speil verlassen                                                             ║");
		System.out.println("╚════════════════════════════════════════════════════════════════════════════════╝");
	}

	private void printSettingsBoard() {
		System.out.println("╔════════════════════════════════════════════════════════════════════════════════╗");
		System.out.println("║ MENU> Board Größe ändern: (Momentane Größe: " + boardSize + "x" + boardSize
				+ ")                             ║");
		System.out.println("║                                                                                ║");
		System.out.println("║ Wähle deine gewünschte Board Größe.                                            ║");
		System.out.println("║                                                                                ║");
		System.out.println("║ Auswahl:                                                                       ║");
		System.out.println("║ 15: Größe zu (15x15)                                                           ║");
		System.out.println("║ 16: Größe zu (16x16)                                                           ║");
		System.out.println("║ 17: Größe zu (17x17)                                                           ║");
		System.out.println("║ 18: Größe zu (18x18)                                                           ║");
		System.out.println("║ 19: Größe zu (19x19)                                                           ║");
		System.out.println("╚════════════════════════════════════════════════════════════════════════════════╝");
	}

	private void printSettingsMode() {
		System.out.println("╔════════════════════════════════════════════════════════════════════════════════╗");
		System.out.println("║ MENU> Spiel Mode ändern: (Momentanes Mode: " + stringGameMode()
				+ ")                               ║");
		System.out.println("║                                                                                ║");
		System.out.println("║ Wähle dein gewünschtes Spiel Mode.                                             ║");
		System.out.println("║                                                                                ║");
		System.out.println("║ Auswahl:                                                                       ║");
		System.out.println("║ 1: Spieler vs Computer (PvAI)                                                  ║");
		System.out.println("║ 2: Spieler vs Spieler (PvP)                                                    ║");
		System.out.println("╚════════════════════════════════════════════════════════════════════════════════╝");
	}

	private void printSettingsDifficulity() {
		System.out.println("╔════════════════════════════════════════════════════════════════════════════════╗");
		System.out.println("║ MENU> KI Schwierigkeit ändern: (Momentane Schwierigkeit: " + stringDifficulity()
				+ ")               ║");
		System.out.println("║                                                                                ║");
		System.out.println("║ Wähle die gewünschte Computer Schwierigkeit.                                   ║");
		System.out.println("║                                                                                ║");
		System.out.println("║ Auswahl:                                                                       ║");
		System.out.println("║ 1: Leicht                                                                      ║");
		System.out.println("║ 2: Normal                                                                      ║");
		System.out.println("║ 3: Schwer                                                                      ║");
		System.out.println("╚════════════════════════════════════════════════════════════════════════════════╝");
	}

	private void printSettingsWhoBegins() {
		System.out.println("╔════════════════════════════════════════════════════════════════════════════════╗");
		System.out.println(
				"║ MENU> Beginnenden Spieler ändern: (Current Starting Player: " + stringWhoBegins() + ")          ║");
		System.out.println("║                                                                                ║");
		System.out.println("║ Wähle welcher Spieler beginnt.                                                 ║");
		System.out.println("║                                                                                ║");
		System.out.println("║ Auswahl:                                                                       ║");
		System.out.println("║ 1: Spieler 1                                                                   ║");
		System.out.println("║ 2: Spieler 2                                                                   ║");
		System.out.println("╚════════════════════════════════════════════════════════════════════════════════╝");
	}

// End of all printable interfaces of the Menu

	// to get the user inputs, limited to what is possible in the specific selection
	private int getMenuChoice(int limitLow, int limitHigh, Scanner keyboard) {

		int choice = -1;
		do {
			System.out.print("  Erlaubte Inputs (" + limitLow + "-" + limitHigh + ") ");
			System.out.print("Auswahl eingeben: ");
			try {
				choice = Integer.parseInt(keyboard.nextLine());
				if (choice < limitLow || choice > limitHigh) {
					System.out.println("Auswahl auserhalb erlaubtem Bereich, wähle bitte neu.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Auswahl ungültig. Bitte nur Zahlen eingeben.");
			}

		} while (choice < limitLow || choice > limitHigh);

		return choice;
	}

	// to clear the console
	private void cls() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	//just to make safe, that the console closes on every PC
	private void exit() {
		try {
			new ProcessBuilder("cmd", "/c", "exit").inheritIO().start().waitFor();
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
