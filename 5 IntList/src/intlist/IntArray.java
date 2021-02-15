package intlist;

/**
 * Each instance of this class represents an array.
 * @invar The length of the array is greater or equal to zero.
 * 		| 0 <= getLength()
 */
public class IntArray {
	/**
	  * @invar The length of the array is greater or equal to zero.
	  * 	| 0 <= array.length
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
	 * @post Check that the length of the array is greater or equal than zero
	 * 		| result >= 0
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
	 * 
	 * Defensive:
	 * @throws IllegalArgumentException if the given index is less than zero
	 * 		| index < 0
	 */
	public int getElement(int index) {
		//Defensive
		if (index < 0) {
			throw new IllegalArgumentException("Index less than zero");
		}
		return array[index];
	}
	
	/**
	 * Return the array
	 */
	public int[] getArray() {
		return array;
	}
	
	/**
	 * Append an element to the end of the array
	 * 
	 * @post The last element of the array equals the given argument
	 * 		| getElement(getLength() - 1) == element
	 * @post The length of the array is increased by one
	 * 		| getLength() == old(getLength()) + 1
	 */
	public void appendElement(int element) {
		int[] biggerArray = new int[getLength() + 1];
		array = copy(array, biggerArray, getLength());
		array[getLength() - 1] = element;
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
	 */
	public int removeLastElement() {
		if (getLength() <= 0) {
			throw new IllegalArgumentException("The length of the array must be greater than zero before an element is removed");
		}
		int[] smallerArray = new int[getLength() - 1];
		int lastElement = array[getLength() - 1];
		array = copy(array, smallerArray, getLength() - 1);
		return lastElement;
	}
	
	private static int[] copy(int[] oldArray, int[] copiedArray, int toExclusive) {
		for (int i = 0; i < toExclusive; i++)
			copiedArray[i] = oldArray[i];
		return copiedArray;
	}
}
