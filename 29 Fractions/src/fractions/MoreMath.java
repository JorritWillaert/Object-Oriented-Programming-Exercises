package fractions;

import java.util.stream.LongStream;

/**
 * This class offers some static math methods.
 */
public class MoreMath {
	
	/**
	 * Compute the absolute value of a given long number.
	 * 
	 * @post The result should be positive.
	 * 		| result > 0
	 * @post The result should be x or the negative of x. 
	 * 		| result == x || result == -x
	 */
	public static long absolute(long x) {
		if (x < 0)
			return -x;
		return x;
	}
	
	/**
	 * Check if the first number divides the second.
	 * 
	 * @pre The first number may not be zero.
	 * 		| y != 0
	 * 
	 * @post | result == ((y / x) * x == x)
	 */
	public static boolean divides(long x, long y) {
		return y % x == 0;
	}
	
	/**
	 * Search the greatest common divisor of two numbers.
	 * 
	 * @pre The given numbers are positive.
	 * 		| x >= 0 && y >= 0
	 * 
	 * @post The returned number should be positive.
	 * 		| result >= 0
	 * @post The result divides both numbers.
	 * 		| divides(x, result) && divides(y, result)
	 * @post No greater number divides both numbers.
	 * 		| LongStream.range(result, Math.max(x, y)).allMatch(value -> !(divides(value + 1, x) && divides(value + 1, y)))
	 */
	public static long gcd(long x, long y) {
		if (x == 0)
			return y;
		if (y == 0)
			return x;
		if (x < y)
			return gcd(y % x, x);
		return gcd(x % y, y);
	}

}
