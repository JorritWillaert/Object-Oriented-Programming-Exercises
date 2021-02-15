package sqrt;

public class MyMath {
	//Constructor van MyMath niet nodig --> private
	private MyMath() {}
	
	//Javadoc's kunnen automatisch geexporteerd worden. '/**' (Project --> Generate Javadoc)
	
	//Definitie van de procedurale abstractie
	//Als je pre en post gebruikt is het toegelaten om param en return weg te laten.
	//De pre en postcondities worden ook in Javadoc gegenereert met de ogp-taglets (https://github.com/btj/ogptaglets)
	/**
	 * Returns the square root, rounded down, of the given number.
	 * 
	 * @pre The given number is not negative.
	 * 		|0 <= x
	 * @post The square of the result is not greater than the given number.
	 * 		| result * result <= x
	 * @post The square of one more than the result is greater than the given number.
	 * 		| x < (result + 1) * (result + 1)
	 */
	public static int sqrt(int x) {
		//Implementatie van de procedurale abstractie
		int result = 0;
		while (result * result <= x)
			result++;
		return result - 1;
	}
}
