package circlehit;

public abstract class CircleHit {
	
	/**
	 * @pre | circle != null
	 * @pre | point != null
	 * @post | true
	 */
	public abstract boolean containsPoint(Circle circle, Point point);
}
