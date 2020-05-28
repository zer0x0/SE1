package dieBoese2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 
 * @author Floris Wittner
 * @version 1.0.0
 *
 */
public class HumanPlayer extends Player {
 
	public HumanPlayer(char figure){
		super(figure);
 }
	public String getMyMove()
	{ String coordinate;
	var in = new BufferedReader(new InputStreamReader(System.in));
	try {
		coordinate = in.readLine();
	// ACHTUNG könnte Endlosschleife werden
	} catch (IOException e) {
		return getMyMove();  

	}
		return coordinate;
		}
	}