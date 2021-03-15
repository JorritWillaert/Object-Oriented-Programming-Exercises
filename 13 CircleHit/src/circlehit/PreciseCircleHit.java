package circlehit;

/**
 * An instance of this class checks exactly whether a given point is located in a given circle.
 */
public class PreciseCircleHit extends CircleHit {
	
	/**
	 * @post | result == (Math.sqrt(Math.pow(center.getX() - point.getX(), 2) + Math.pow(center.getY() - point.getY(), 2)) <= circle.getRadius())
	 */
	public boolean containsPoint(Circle circle, Point point) {
		Point center = circle.getCenter();
		double distance = Math.sqrt(Math.pow(center.getX() - point.getX(), 2) + Math.pow(center.getY() - point.getY(), 2));
		if (distance <= circle.getRadius())
			return true;
		return false;
	}
}
