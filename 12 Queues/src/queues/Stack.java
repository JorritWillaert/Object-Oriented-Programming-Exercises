package queues;

import java.util.Arrays;

/**
 * Each instance of this class stores a queue of elements, with last-in first-out (LIFO) behavior.
 * 
 * @invar | getElements() != null
 */
public class Stack extends Queue { //Not a problem to use 'extends Queue' for Java - Same methods; Syntactically equal
	
	private Object[] elements = new Object[0];
	
	/**
	 * Initializes this stack with an empty sequence of elements.
	 * @post | getElements().length == 0
	 */
	public Stack() {}
	
	/**
	 * Returns a new array containing the sequence of elements in this stack.
	 */
	public Object[] getElements() {
		return elements.clone();
	}
	
	/**
	 * Adds the element to the end of this stack.
	 * 
	 * @post | getElements().length == old(getElements()).length + 1
	 * @post | Arrays.equals(getElements(), 0, old(getElements()).length, old(getElements()), 0, old(getElements().length))
	 * @post | getElements()[old(getElements()).length] == element
	 */
	public void put(Object element) {
		Object[] newElements = new Object[elements.length + 1];
		System.arraycopy(elements, 0, newElements, 0, elements.length);
		newElements[elements.length] = element;
		elements = newElements;
	}
	
	/**
	 * Removes an element from the back of this stack and returns it.
	 * 
	 * @pre | getElements().length > 0
	 * @post | getElements().length == old(getElements()).length - 1
	 * @post | result == old(getElements())[getElements().length]
	 * @post | Arrays.equals(getElements(), 0, getElements().length, old(getElements()), 0, getElements().length)
	 */
	public Object take() {
		Object result = elements[elements.length - 1];
		Object[] newElements = new Object[elements.length - 1];
		System.arraycopy(elements, 0, newElements, 0, newElements.length);
		elements = newElements;
		return result;
	}

}
