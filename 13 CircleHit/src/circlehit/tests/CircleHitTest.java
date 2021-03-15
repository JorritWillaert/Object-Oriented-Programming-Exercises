package circlehit.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import circlehit.Circle;
import circlehit.FastCircleHit;
import circlehit.Point;
import circlehit.PreciseCircleHit;

class CircleHitTest {

	@Test
	void test() {
		Point point = new Point(2, 2);
		Circle circle = new Circle(point, 4);
		Point pointAlwaysOut = new Point(7, 3);
		Point pointInSquare = new Point(5, 5);
		Point pointInCircle = new Point(4, 5);
		
		PreciseCircleHit myPreciseCircleHit = new PreciseCircleHit();
		FastCircleHit myFastCircleHit = new FastCircleHit();
		
		assertFalse(myFastCircleHit.containsPoint(circle, pointAlwaysOut));
		assertFalse(myPreciseCircleHit.containsPoint(circle, pointAlwaysOut));
		
		assertTrue(myFastCircleHit.containsPoint(circle, pointInSquare));
		assertFalse(myPreciseCircleHit.containsPoint(circle, pointInSquare));
		
		assertTrue(myFastCircleHit.containsPoint(circle, pointInCircle));
		assertTrue(myPreciseCircleHit.containsPoint(circle, pointInCircle));
	}

}
