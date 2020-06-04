package dieBoese2;

import java.awt.Point;

/**
 * 
 * @author Floris Wittner, Nicolas Biundo, Ian Reeves
 * @version 1.0.0.
 * @date 04.06.2020
 *
 */
public class Board {

    boolean player1;
    char boardstate[][];
    boolean whoWon;
    boolean isRunning = true;
    int zugcounter = 1;

    Board(int size, boolean player) {
        this.player1 = player;
        boardstate = new char[size][size];
        for (int i = 0; i < boardstate.length; i++) {
            for (int j = 0; j < boardstate[0].length; j++) {
                boardstate[i][j] = ' ';
            }
        }
    }

    protected void printBoard() {
        int counter = boardstate.length - 1;
        System.out.print("    ");
        for (int i = 97; i < 97 + boardstate.length; i++) {
            System.out.print((char) i + "  ");
        }
        System.out.println();
        while (counter >= 0) {
            if(counter < 9) {           
            System.out.print(counter + 1 + "  ");
            }
            else {
                System.out.print(counter + 1 + " ");
            }
            for (int i = 0; i < boardstate.length; i++) {
                System.out.print("[" + boardstate[i][counter] + "]");
            }
            counter--;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Board board = new Board(16, true);
        board.printBoard();
//      Menu menu1 = new Menu();
//      Scanner sc = new Scanner(System.in);
//      board.printBoard();
//      do {
//          board.placeFigure(sc.nextLine(), board.getSymbol());
//          menu1.cls();
//      } while (board.isRunning());
//      sc.close();

//      String test = "a12";
//      // System.out.println((int) test.charAt(1));
//      // System.out.println(board.boardstate.length);
//      // System.out.println(board.isValidMove("1a"));
//      // System.out.println(board.isValidMove("a13"));
//      // System.out.println(board.isValidMove("17bd"));
//      // System.out.println(board.isValidMove("z7"));
//      // System.out.println(board.isValidMove("t"));
//      board.placeFigure("a1", board.getSymbol());
//      board.placeFigure("a2", board.getSymbol());
//      board.placeFigure("b1", board.getSymbol());
//      board.placeFigure("b2", board.getSymbol());
//      board.placeFigure("c1", board.getSymbol());
//      board.placeFigure("c2", board.getSymbol());
//      board.placeFigure("d1", board.getSymbol());
//      board.placeFigure("d2", board.getSymbol());
//      board.placeFigure("e1", board.getSymbol());
//      board.placeFigure("e2", board.getSymbol());
//      board.printBoard();

    }

    /**
     * 
     * @param coordinate
     * @return true if a figure could be set at coordinate; false if not
     * 
     */
    protected boolean isValidMove(String coordinate) {

        // keine richtige koordinate &&
        // außerhalb des Spielfelds -> convert überprüft, fehler rückmeldung muss noch
        // erfastt werden

        // besetzt

        Point point = this.convertCoordinate(coordinate);
        if (point == null) {
            System.out.println("Falsche Eingabe bitte geben sie eine gültige Koordinate ein.");
            return false;
        }
        if (point.x > this.boardstate.length || point.x < 0 || point.y > this.boardstate[0].length || point.y < 0) {
            System.out.println("Diese Koordinate liegt nicht auf dem Spielbrett");
            return false;
        }
        if (this.boardstate[point.x - 1][point.y - 1] == ' ')
            return true;
        else {
            System.out.println("Das Feld " + coordinate + " ist schon belegt. Geben sie ein neues Feld ein.");
            return false;
        }
    }

    boolean isRunning() {
        return isRunning;
    }

    /**
     * convert the coordinate from String to a Point
     * 
     * @param coordinate
     * @return Point
     * 
     */
    protected Point convertCoordinate(String coordinate) {

        int x = 0, y = 0;
        int firstChar, secondChar, thirdChar;

        coordinate = coordinate.toLowerCase();
        // wenn coordinate aus 2 Ziffer und 1 Buchstabe besteht
        if (coordinate.length() == 3) {
            firstChar = (int) coordinate.charAt(0) - 48;
            secondChar = (int) coordinate.charAt(1) - 48;
            thirdChar = (int) coordinate.charAt(2) - 48;
            if (firstChar <= this.boardstate.length) {

                y = firstChar * 10 + secondChar;
                x = thirdChar;

            } else if (firstChar > 48) {
                y = secondChar * 10 + thirdChar;
                x = firstChar;

            }
            // wenn coordinate aus 1 Ziffer und 1 Buchstabe besteht
        } else if (coordinate.length() == 2) {
            firstChar = (int) coordinate.charAt(0) - 48;
            secondChar = (int) coordinate.charAt(1) - 48;
            if (firstChar <= this.boardstate.length) {

                y = firstChar;
                x = secondChar;
            } else if (firstChar > 48) {

                y = secondChar;
                x = firstChar;
            }
            // falls String keine vernünftige Koordinate ist //ist das ein unschöne Lösung?
        } else {
            return null;
        }

        Point point = new Point(x - 48, y);

        return point;

    }

    boolean whoWon() {

        isRunning = false;
        if (player1) {
            System.out.println("Spieler 1 hat gewonnen!");
        } else {
            System.out.println("Spieler 2 hat gewonnen!");
        }

        return player1;

    }

    protected void checkWin(String coordinate, char symbol) {

        int x = (int) convertCoordinate(coordinate).getY() - 1;
        int y = (int) convertCoordinate(coordinate).getX() - 1;

// check vertical   
        for (int i = 0; i < 5; i++) {

            int matches = 0;
//      therefore we check 4 times starting at x-4 if there are 4 matches in a row
            for (int j = 4; j >= 0; j--) {
                int offset = i - j;
//              System.out.println(matches + "+" + j + "+" + symbol + "+" + i);
//          dont forget to stay inside the bounds of the board
                if (y + offset >= 0 && y + offset < boardstate.length) {
                    if (boardstate[y + offset][x] == symbol) {
                        matches++;
                    }
                }
                if (matches == 5) {
                    whoWon();
                }
            }
        }

//    check horizontal
//  we have to check everything from -5 to the left, until +5 to the right
        for (int i = 0; i < 5; i++) {

            int matches = 0;
//      therefore we check 4 times starting at x-4 if there are 4 matches in a row
            for (int j = 4; j >= 0; j--) {
                int offset = i - j;
//          dont forget to stay inside the bounds of the board
                if (x + offset >= 0 && x + offset < boardstate.length) {
                    if (boardstate[y][x + offset] == symbol) {
                        matches++;
                    }
                }
            }
//      if we find 5 machtes, we return true. otherwise we start looking for 4 matches on the next position
            if (matches == 5) {
                whoWon();
            }

        }
//    check diagonal
//  simular to the horizontal check, you have to check everything around the last coin diagonally from -5 to +5
        for (int i = 0; i < 5; i++) {
            int matches2 = 0;
            int matches = 0;
            for (int j = 4; j >= 0; j--) {
                int offset = i - j;
//          now not only 1 variable changes but both, since we move diagonally (this one is the slash check /)
//          don't forget to stay in bounds
                if (x + offset >= 0 && x + offset < boardstate.length && y + offset < boardstate.length
                        && y + offset >= 0) {
                    if (boardstate[y + offset][x + offset] == symbol) {
                        matches++;
                    }
                }
//          this one is the backslash check \
//          don't forget to stay in bounds
                if (x + offset >= 0 && x + offset < boardstate.length && y - offset < boardstate.length
                        && y - offset >= 0) {
                    if (boardstate[y - offset][x + offset] == symbol) {
                        matches2++;
                    }

                }
            }

//      if there is a diagonal / or \ match, we return true
            if (matches == 5 || matches2 == 5) {
                whoWon();
            }
        }
//      if none of the winning conditions are met, we return false
    }

    protected void checkDeleted(String coordinate, char symbol) {

        int y = (int) convertCoordinate(coordinate).getY() - 1;
        int x = (int) convertCoordinate(coordinate).getX() - 1;
        char enemysymbol = ' ';
        if (symbol == 'X') {
            enemysymbol = 'O';
        } else {
            enemysymbol = 'X';
        }
        // horizontal links
        if (x - 3 >= 0) {
            System.out.println("1");
            if (boardstate[x - 3][y] == symbol) {
                System.out.println("2");
                if (boardstate[x - 2][y] == enemysymbol && boardstate[x - 1][y] == enemysymbol) {
                    System.out.println("3");
                    boardstate[x - 1][y] = ' ';
                    boardstate[x - 2][y] = ' ';
                    System.out.println("Es wurden Figuren geschlagen!");
                    System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                    this.printBoard();
                }
            }
        }
        // horizontal rechts
        if (x + 3 < boardstate.length) {
            System.out.println("1");
            if (boardstate[x + 3][y] == symbol) {
                System.out.println("2");
                if (boardstate[x + 1][y] == enemysymbol && boardstate[x + 2][y] == enemysymbol) {
                    System.out.println("3");
                    boardstate[x + 1][y] = ' ';
                    boardstate[x + 2][y] = ' ';
                    System.out.println("Es wurden Figuren geschlagen!");
                    System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
                    this.printBoard();
                }
            }
        }
        // vertikal unten
        if (y - 3 >= 0) {
            System.out.println("1");
            if (boardstate[x][y - 3] == symbol) {
                System.out.println("2");
                if (boardstate[x][y - 1] == enemysymbol && boardstate[x][y - 2] == enemysymbol) {
                    System.out.println("3");
                    boardstate[x][y - 1] = ' ';
                    boardstate[x][y - 2] = ' ';
                    System.out.println("Es wurden Figuren geschlagen!");
                    System.out.println("|||||||||||||||||||||||||||||||||||||||||||||");
                    System.out.println("|||||||||||||||||||||||||||||||||||||||||||||");
                    this.printBoard();
                }
            }
        }
        // vertikal oben
        if (y + 3 < boardstate.length) {
            System.out.println("1");
            if (boardstate[x][y + 3] == symbol) {
                System.out.println("2");
                if (boardstate[x][y + 1] == enemysymbol && boardstate[x][y + 2] == enemysymbol) {
                    System.out.println("3");
                    boardstate[x][y + 1] = ' ';
                    boardstate[x][y + 2] = ' ';
                    System.out.println("Es wurden Figuren geschlagen!");
                    System.out.println("|||||||||||||||||||||||||||||||||||||||||||||");
                    System.out.println("|||||||||||||||||||||||||||||||||||||||||||||");
                    this.printBoard();
                }
            }
        }

        // diagonal unten links --> oben rechts
        if (x + 3 < boardstate.length && y + 3 < boardstate.length) {
            if (boardstate[x + 3][y + 3] == symbol) {
                if (boardstate[x + 1][y + 1] == enemysymbol && boardstate[x + 2][y + 2] == enemysymbol) {
                    boardstate[x + 1][y + 1] = ' ';
                    boardstate[x + 2][y + 2] = ' ';
                    System.out.println("Es wurden Figuren geschlagen!");
                    System.out.println("|||||||||||||||||||||||||||||||||||||||||||||");
                    System.out.println("|||||||||||||||||||||||||||||||||||||||||||||");
                    this.printBoard();
                }
            }
        }

        // diagonal oben rechts --> unten links
        if (x - 3 >= 0 && y - 3 >= 0) {
            if (boardstate[x - 3][y - 3] == symbol) {
                if (boardstate[x - 1][y - 1] == enemysymbol && boardstate[x - 2][y - 2] == enemysymbol) {
                    boardstate[x - 1][y - 1] = ' ';
                    boardstate[x - 2][y - 2] = ' ';
                    System.out.println("Es wurden Figuren geschlagen!");
                    System.out.println("|||||||||||||||||||||||||||||||||||||||||||||");
                    System.out.println("|||||||||||||||||||||||||||||||||||||||||||||");
                    this.printBoard();
                }
            }
        }

        // diagonal unten rechts --> oben links
        if (x - 3 >= 0 && y + 3 < boardstate.length) {
            if (boardstate[x - 3][y + 3] == symbol) {
                if (boardstate[x - 1][y + 1] == enemysymbol && boardstate[x - 2][y + 2] == enemysymbol) {
                    boardstate[x - 1][y + 1] = ' ';
                    boardstate[x - 2][y + 2] = ' ';
                    System.out.println("Es wurden Figuren geschlagen!");
                    System.out.println("|||||||||||||||||||||||||||||||||||||||||||||");
                    System.out.println("|||||||||||||||||||||||||||||||||||||||||||||");
                    this.printBoard();
                }
            }
        }

        // diagonal oben links --> unten rechts
        if (x + 3 < boardstate.length & y - 3 >= 0) {
            if (boardstate[x + 3][y - 3] == symbol) {
                if (boardstate[x + 1][y - 1] == enemysymbol && boardstate[x + 2][y - 2] == enemysymbol) {
                    boardstate[x + 1][y - 1] = ' ';
                    boardstate[x + 2][y - 2] = ' ';
                    System.out.println("Es wurden Figuren geschlagen!");
                    System.out.println("|||||||||||||||||||||||||||||||||||||||||||||");
                    System.out.println("|||||||||||||||||||||||||||||||||||||||||||||");
                    this.printBoard();
                }
            }
        }

    }

    void placeFigure(String coordinate, char symbol) {
        if (zugcounter == 3) {
            if (blockBoard(coordinate)) {

                if (isValidMove(coordinate)) {
                    boardstate[(int) convertCoordinate(coordinate).getX()
                            - 1][(int) convertCoordinate(coordinate).getY() - 1] = symbol;

//          System.out.println(
//                  boardstate[(int) convertCoordinate(coordinate).getX()-1][(int) convertCoordinate(coordinate).getY()-1]);
                    this.printBoard();
                    this.checkDeleted(coordinate, symbol);
                    checkWin(coordinate, symbol);

                    player1 = !player1;
                    zugcounter++;
                }
            }
        } else {
            if (isValidMove(coordinate)) {
                boardstate[(int) convertCoordinate(coordinate).getX() - 1][(int) convertCoordinate(coordinate).getY()
                        - 1] = symbol;

//      System.out.println(
//              boardstate[(int) convertCoordinate(coordinate).getX()-1][(int) convertCoordinate(coordinate).getY()-1]);
                this.printBoard();
                this.checkDeleted(coordinate, symbol);
                checkWin(coordinate, symbol);

                player1 = !player1;
                zugcounter++;
            }
        }
    }

    // Frage: bei geradem Spielfeld (16x16) werden 2 Felder blockiert (jeweils die
    // mittigen) oder welcher?

    protected boolean blockBoard(String coordinate) {

        int y = (int) convertCoordinate(coordinate).getY() - 1;
        int x = (int) convertCoordinate(coordinate).getX() - 1;

        // Viereck in der Mitte wird geblockt
        if (x > 0 && boardstate.length - 1 > x || y > 0 && boardstate.length - 1 > y) {
            System.out.println("Diese Feld ist in diesem Zug blockiert, wähle erneut!");
            return false;
        }
        // gerades Spielfeld
        if (boardstate.length % 2 == 0) {
            if (x == 0 && y == boardstate.length / 2 || x == 0 && y == boardstate.length / 2 - 1
                    || x == boardstate.length - 1 && y == boardstate.length / 2
                    || x == boardstate.length - 1 && y == boardstate.length / 2 - 1
                    || y == 0 && x == boardstate.length / 2 || y == 0 && x == boardstate.length / 2 - 1
                    || y == boardstate.length - 1 && x == boardstate.length / 2
                    || y == boardstate.length - 1 && x == boardstate.length / 2 - 1) {
                System.out.println("Diese Feld ist in diesem Zug blockiert, wähle erneut!");
                return false;
            }
            // ungerades Spielfeld
        } else {
            if (x == (boardstate.length - 1) / 2 && y == 0
                    || x == (boardstate.length - 1) / 2 && y == boardstate.length - 1
                    || y == (boardstate.length - 1) / 2 && x == 0
                    || y == (boardstate.length - 1) / 2 && x == boardstate.length - 1) {
                System.out.println("Diese Feld ist in diesem Zug blockiert, wähle erneut!");
                return false;
            }
        }

        return true;
    }

    char getSymbol() {
        if (player1) {
            return 'X';
        } else {
            return 'O';
        }
    }
}