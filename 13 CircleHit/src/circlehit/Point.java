package circlehit;

/**
 * An instance of this class represents a point with X and Y coordinates.
 * 
 * @immutable
 */
public class Point {
	
	private int x;
	private int y;
	
	/**
	 * Create an instance of a point with the given x and y coordinates.
	 * 
	 * @post | getX() == x
	 * @post | getY() == y
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Return the X-coordinate of this point
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Return the Y-coordinate of this point
	 */
	public int getY() {
		return y;
	}

}
