package circlehit;

public abstract class CircleHit {
	
	//No throws --> Stronger than pre-conditions! (FastCircle does not throw exceptions)
	//conditie ? waar-waarde : onwaar-waarde
	//Eerste post: ofwel binnen bounding box, ofwel false
	//Tweede post: ofwel niet binnen de exacte cirkel, ofwel true
	/**
	 * @pre | circle != null
	 * @pre | point != null
	 * @post | (Math.abs(circle.getCenter().getX() - point.getX()) >= circle.getRadius() || Math.abs(circle.getCenter().getY() - point.getY()) >= circle.getRadius())
	 * 		 | 		|| result == false
	 * @post | !(Math.sqrt(Math.pow(circle.getCenter().getX() - point.getX(), 2) + Math.pow(circle.getCenter().getY() - point.getY(), 2)) <= circle.getRadius())
	 * 		 | 		|| result == true
	 */
	public abstract boolean containsPoint(Circle circle, Point point);
}
