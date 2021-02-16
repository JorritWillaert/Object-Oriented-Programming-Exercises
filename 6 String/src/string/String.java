package string;

import java.util.Arrays;

/**
 * Each instance of this class represents a sequence of characters.
 * 
 * @immutable 
 */
public class String { //Immutable: No mutators for String
	
	/**
	 * @invar | characters != null
	 * @representationObject
	 * // May not be leaked to the client
	 */
	private final char[] characters; // final --> Not mutable after construction
	
	private String(char[] characters) { //Constructors are typically private for immutables --> Decide internally if you make a new object or return an existing one
		//Note: if public --> You can create a String and change it by changing the corresponding array
		this.characters = characters;
	}
	
	/**
	 * @inspects | this
	 * //@inspects needed because the method does not start with 'get' -> FSC4J does not know that it is an inspector
	 * @basic
	 */
	public char[] toCharArray() { 
		return characters.clone();
	}
	
	/**
	 * @inspects | this
	 * @post | result == toCharArray().length
	 */
	public int length() {
		return characters.length;
	}
	
	/**
	 * @inspects | this
	 * @pre | 0 <= index && index < length()
	 * @post result == toCharArray()[index]
	 */
	public char charAt(int index) {
		return characters[index];
	}
	
	/**
	 * @post | result != null
	 * @post | Arrays.equals(result.toCharArray(), new char[] {c})
	 */
	public static String valueOf(char c) { 
		return new String(new char[] {c});
	}
	
	
	/**
	 * @pre | other != null
	 * 
	 * @inspects | this, other
	 * 
	 * @post | result != null
	 * @post | result.length() == this.length() + other.length()
	 * @post | Arrays.equals(result.toCharArray(), 0, this.length(),  
	 * 		 | 		this.toCharArray(), 0, this.length())
	 * @post | Arrays.equals(result.toCharArray(), this.length(), result.length(), 
	 * 		 |		other.toCharArray(), 0, other.length())
	 */
	public String concat(String other) { 
		char[] newCharacters = new char[length() + other.length()];
		System.arraycopy(this.characters, 0, newCharacters, 0, length());
		System.arraycopy(other.characters, 0, newCharacters, length(), other.length());
		return new String(newCharacters);
	}
	
}
