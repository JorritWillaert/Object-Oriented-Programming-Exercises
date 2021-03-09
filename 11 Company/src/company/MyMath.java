package company;

public class MyMath extends Math{

	//Als we specificatie willen verstrengen --> pre is verzwakken & post versterken (in de gevallen waarin de pre conditie van de zwakkere specificatie geldt)!
	//Geldige verstrenging van specificatie; Noot: hier verstrengen we post niet, maar de pre conditie is al verzwakt hier en nu is het dus toegestaan de post ook te verzwakken
	/**
	 * @pre | true
	 * @post | 0 <= result && (result == x || result == -x)
	 */
	public int absoluteValue(int x) {
		return x; //Bad method because of pre
	}
}
