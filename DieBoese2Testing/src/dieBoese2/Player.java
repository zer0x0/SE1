package dieBoese2;

/**
 * 
 * @author Floris Wittner 1921233
 * @version V 0.1.1
 * @date 29.05
 *       <p>
 *       </p>
 *       {@link Player} is a abstract Class.
 *       <p>
 *       </p>
 *       AI and HumanPlayer has to implement {@link #blockSpace(Board)} and
 *       {@link #makeMove(Board)}
 * 
 */
public abstract class Player {
	char figure;

	/**
	 * 
	 * @param figure Char X or O
	 * @category constructor
	 */
	Player(char figure) {
		this.figure = figure;
	}

	/**
	 * HumanPlayer and AI has to block Spaces
	 * 
	 * @param board
	 */
	protected abstract void blockSpace(Board board);

	/**
	 * HumanPlayer and AI has to set their figure at a Space
	 * 
	 * @param board
	 */
	protected abstract void makeMove(Board board);

}
