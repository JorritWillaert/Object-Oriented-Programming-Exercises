package company;

public class MyMath extends Math{

	//Als we specificatie willen verstrengen --> pre is verzwakken & post versterken!
	//Geldige verstrenging van specificatie;
	/**
	 * @pre | 0 <= x
	 * @post | result == x
	 */
	public int absoluteValue(int x) {
		return x; //Bad method because of pre
	}
}
