package circlehit;

/**
 * An instance of this class represents a circle with a given center (a point) and a radius.
 * 
 * @immutable
 */
public class Circle {
	
	private Point center;
	private int radius;
	
	/**
	 * Create an instance of a circle with the given center and a radius.
	 * 
	 * @post | getCenter() == center
	 * @post | getRadius() == radius
	 */
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	
	/**
	 * Return the center of this circle.
	 */
	public Point getCenter() {
		return center;
	}
	
	/**
	 * Return the radius of this circle.
	 */
	public int getRadius() {
		return radius;
	}
}
