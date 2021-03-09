package company;

public abstract class Math {
	
	//(Earlier) @pre | false --> Methode hoeft in geen enkele omstandigheid te werken
	/**
	 * @pre | 0 <= x
	 * @post | result == x
	 */
	public abstract int absoluteValue(int x);
}
