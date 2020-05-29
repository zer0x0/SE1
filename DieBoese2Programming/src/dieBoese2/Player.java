package dieBoese2;

import java.util.Scanner;

/**
 * 
 * @author Floris Wittner 1921233
 *  @version V 0.1.0
 *  @date 29.05
 *  
 *   */
public abstract class Player {
	char figure;

Player(char figure) {
	 this.figure = figure;
 }
 protected abstract void blockSpace(Board board);
 protected abstract void makeMove(Board board);
 
}
