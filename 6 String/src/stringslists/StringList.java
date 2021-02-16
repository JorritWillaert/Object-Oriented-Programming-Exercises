package stringslists;

import java.util.Arrays;

/**
 * Each instance of this class represents a sequence of strings.
 * 
 * @invar | getElements() != null
 * @invar | Arrays.stream(getElements()).allMatch(e -> e != null)
 */
public class StringList {
	
	/**
	 * @invar | elements != null
	 * @invar | Arrays.stream(elements).allMatch(e -> e != null)
	 * 
	 * @representationObject
	 */
	private String[] elements;
	
	public StringList(String[] elements) {
		if (elements == null)
			throw new IllegalArgumentException("The given array may not be null");
		if (Arrays.stream(elements).anyMatch(e -> e == null)) //exists e in elements where e == null
			throw new IllegalArgumentException("The elements may not be null");
		this.elements = elements.clone();
	}
	
	/**
	 * Returns the elements of this string list as an array.
	 * 
	 * @creates | result
	 * 
	 * If you don't use .clone() --> Specify contractually that the client may not insert null (This course, preferably defensive!)
	 * "The client shall not mutate the result array"
	 * "The result array may change as a result of changes to this StringList object"
	 */
	public String[] getElements() {
		return elements.clone();
	}
	
	public String getConcatenation() {
		if (elements.length == 0)
			return "";
		else {
			String result = elements[0];
			for (int i = 1; i < elements.length; i++) {
				result = result.concat(elements[i]);
			}
			return result;
		}
	}
	
	public void setElement(int index, String value) {
		if (value == null)
			throw new IllegalArgumentException("The given value may not be null");
		elements[index] = value;
	}
}
