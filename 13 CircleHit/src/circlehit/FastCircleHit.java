package circlehit;

/**
 * An instance of this class checks withing in a bounding box whether a given point is located in a given 'circle'.
 */
public class FastCircleHit extends CircleHit {
	
	//Pre-documentatie is dezelfde als bij de opgeloste methode. De post-conditie is strenger.
	/**
	 * @pre | circle != null
	 * @pre | point != null
	 * @post | result == !(Math.abs(circle.getCenter().getX() - point.getX()) >= circle.getRadius() || Math.abs(circle.getCenter().getY() - point.getY()) >= circle.getRadius())
	 */
	public boolean containsPoint(Circle circle, Point point) {
		Point center = circle.getCenter();
		if (Math.abs(center.getX() - point.getX()) >= circle.getRadius() || Math.abs(center.getY() - point.getY()) >= circle.getRadius())
			return false;
		return true;
	}
}
