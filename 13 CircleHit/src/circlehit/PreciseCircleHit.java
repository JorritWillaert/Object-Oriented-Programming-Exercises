package circlehit;

/**
 * An instance of this class checks exactly whether a given point is located in a given circle.
 */
public class PreciseCircleHit extends CircleHit {
	
	//Pre-documentatie is dezelfde als bij de opgeloste methode. De post-conditie is strenger.
	/**
	 * @throws IllegalArgumentException if the given circle is null
	 * 		| circle == null
	 * @throws IllegalArgumentException if the given point is null
	 * 		| point == null
	 * @post | result == (Math.sqrt(Math.pow(circle.getCenter().getX() - point.getX(), 2) + Math.pow(circle.getCenter().getY() - point.getY(), 2)) <= circle.getRadius())
	 */
	public boolean containsPoint(Circle circle, Point point) {
		if (circle == null)
			throw new IllegalArgumentException("The given circle may not be null.");
		if (point == null)
			throw new IllegalArgumentException("The given point may not be null.");
		Point center = circle.getCenter();
		double distance = Math.sqrt(Math.pow(center.getX() - point.getX(), 2) + Math.pow(center.getY() - point.getY(), 2));
		if (distance <= circle.getRadius())
			return true;
		return false;
	}
}
