package intlist;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Each instance of this class represents an array.
 * @invar The length of the array is greater or equal to zero.
 * 		| 0 <= getLength()
 */
public class IntArray {
	/**
	 * @representationObject
	 * 
	  * @invar The array must exist
	  * 	| array != null
	 */
	private int[] array;
	
	/**
	 * Initialize an empty array
	 * 
	 * @post The length of the array equals zero
	 * 		| getLength() == 0
	 */
	public IntArray() {
		array = new int[0];
	}
	
	/**
	 * Return the length of the array
	 * @post | result == getArray().length
	 */
	public int getLength() {
		return array.length;
	}
	
	/**
	 * Return the element at a given index of the array
	 * 
	 * Contractual:
	 * @pre The given index should be greater or equal than zero
	 * 		| 0 <= index
	 * @pre The given index should be smaller than the length of the array
	 * 		| index < getLength()
	 * @pre The length of the array should be greater than zero.
	 * 		| getLength() > 0
	 * 
	 * Defensive:
	 * @throws IllegalArgumentException if the given index is less than zero
	 * 		| index < 0
	 * @throws IllegalArgumentException if the given index is greater than the length of the array
	 * 		| index >= getLength()
	 * @throws IllegalArgumentException if the length of the array is less or equal than zero
	 * 		| getLength() <= 0
	 * 
	 * @post | result == getArray()[index]
	 * 
	 * // Note: no need to specify that no elements may be changed, since 'get' implies for FSC4J that it does not mutate objects.
	 */
	public int getElement(int index) {
		//Defensive
		if (index < 0) {
			throw new IllegalArgumentException("Index less than zero");
		}
		if (index >= getLength()) {
			throw new IllegalArgumentException("Index out of upper bound");
		}
		if (getLength() <= 0) {
			throw new IllegalArgumentException("The array does not yet exist");
		}
		return array[index];
	}
	
	/**
	 * @mutates | this
	 * 
	 * @pre | 0 <= index && index < getLength()
	 * @post | getLength() == old(getLength())
	 * @post | IntStream.range(0, getLength()).allMatch(i ->
	 * 		 |	 	i == index ?
	 * 		 |			getElement(i) == value
	 * 		 | 		: 
	 * 		 | 			getElement(i) == old(getArray())[i])
	 * 
	 * // statement ? true-value : false-value
	 */
	public void setElement(int index, int value) { 
		array[index] = value;
	}
	
	/**
	 * Return a copy of the internal array (otherwise does the client has access to the internal representation: representation exposure) - see '@creates'
	 * @creates | result
	 * @basic
	 */
	public int[] getArray() {
		return array.clone(); //Client can't change the internal array; @basic needed for the post-condition of getLength()
	}
	
	/**
	 * Append an element to the end of the array
	 * 
	 * @post The last element of the array equals the given argument
	 * 		| getElement(old(getLength())) == element
	 * @post The length of the array is increased by one
	 * 		| getLength() == old(getLength()) + 1
	 * @post The existing elements in the array are unchanged
	 * 		| IntStream.range(0, old(getLength())).allMatch(i ->
	 * 		|		getElement(i) == old(getArray())[i])
	 * 
	 * // IntStream.range(a, b).allMatch(i -> statement about i)		(inclusive a, exclusive b)
	 * 
	 * Alternative:
	 * @post | Arrays.equals(getArray(), 0, getLength() - 1, old(getArray()), 0, old(getLength()))
	 */
	public void appendElement(int element) {
		int[] biggerArray = new int[array.length + 1];
		System.arraycopy(array, 0, biggerArray, 0, array.length);
		biggerArray[array.length] = element;
		array = biggerArray;
	}
	
	/**
	 * Remove the last element of the array
	 * 
	 * Contractual:
	 * @pre The length of the array is greater than zero
	 * 		| getLength() > 0
	 * 
	 * Defensive:
	 * @throws IllegalArgumentException if the length of the array is less or equal than zero
	 * 		| getLength() <= 0
	 * 
	 * @post The returned element was the last element of the array
	 * 		| result == old(getElement(old(getLength()) - 1))
	 * @post The length of the array is reduced by one
	 * 		| 1 + getLength() == old(getLength())
	 * @post The other existing elements in the array are unchanged
	 * 		| IntStream.range(0, getLength() - 1).allMatch(i ->
	 * 		|		getElement(i) == old(getArray())[i])
	 */
	public int removeLastElement() {
		if (getLength() <= 0) {
			throw new IllegalArgumentException("The length of the array must be greater than zero before an element is removed");
		}
		int[] smallerArray = new int[getLength() - 1];
		int lastElement = array[getLength() - 1];
		System.arraycopy(array, 0, smallerArray, 0, array.length - 1);
		array = smallerArray;
		return lastElement;
	}
}
