package fractions;

import java.math.BigInteger;

/**
 * Instances of this class represent fractions (i.e. rational numbers).
 * 
 * @invar The denominator is positive. 
 * 		| getDenominator() > 0
 * @invar The numerator is greater than the minimal value that can be represented by a long.
 * 		| Long.MIN_VALUE < getNumerator()
 * @invar The fraction is irreducable.
 * 		| MoreMath.gcd(MoreMath.absolute(getNumerator()), getDenominator()) == 1
 * 
 * @immutable
 */
public class Fraction {
	
	/**
	 * @invar | denominator > 0
	 * @invar | Long.MIN_VALUE < numerator
	 * @invar | MoreMath.gcd(MoreMath.absolute(numerator), denominator) == 1
	 */
	private final long numerator;
	private final long denominator;
	
	/**
	 * @invar | ZERO.getNumerator() == 0
	 * @invar | ZERO.getDenominator() == 1
	 */
	private static Fraction ZERO = new Fraction(0, 1);
	
	/**
	 * @pre | denominator > 0
	 * 
	 * @post | getNumerator() == numerator
	 * @post | getDenominator() == denominator
	 */
	private Fraction(long numerator, long denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	/**
	 * Create an instance of a fraction.
	 * 
	 * @throws IllegalArgumentException if the denominator is 0.
	 * 		| denominator == 0
	 * 
	 * @post The result is not null.
	 * 		| result != null
	 * @post The rational number represented by the result equals the rational number given.
	 * 		| BigInteger.valueOf(result.getNumerator()).multiply(BigInteger.valueOf(denominator)).equals(
	 * 		| BigInteger.valueOf(numerator).multiply(BigInteger.valueOf(result.getDenominator())))
	 */
	public Fraction of(long numerator, long denominator) {
		if (denominator == 0)
			throw new IllegalArgumentException("The denominator may not be 0.");
		if (numerator == 0)
			return ZERO;
		long gcd = MoreMath.gcd(MoreMath.absolute(numerator), MoreMath.absolute(denominator));
		if (denominator < 0)
			gcd = - gcd;
		return new Fraction(numerator / gcd, denominator / gcd);
	}
	
	public long getNumerator() {
		return numerator;
	}
	
	public long getDenominator() {
		return denominator;
	}

}
