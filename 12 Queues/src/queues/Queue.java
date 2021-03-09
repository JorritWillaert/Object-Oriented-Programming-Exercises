package queues;

import java.util.Arrays;

/**
 * Each instance of this class stores a queue of elements, with first-in first-out (FIFO) behavior.
 * 
 * @invar | getElements() != null
 */
public class Queue {
	
	private Object[] elements = new Object[0];
	
	/**
	 * Initializes this queue with an empty sequence of elements.
	 * @post | getElements().length == 0
	 */
	public Queue() {}
	
	/**
	 * Returns a new array containing the sequence of elements in this queue.
	 */
	public Object[] getElements() {
		return elements.clone();
	}
	
	/**
	 * Adds the element to the end of this queue.
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
	 * Removes an element from the front of this queue and returns it.
	 * 
	 * @pre | getElements().length > 0
	 * @post | result == old(getElements())[0]
	 * @post | Arrays.equals(getElements(), 0, getElements().length, old(getElements()), 1, old(getElements()).length)
	 */
	public Object take() {
		Object result = elements[0];
		Object[] newElements = new Object[elements.length - 1];
		System.arraycopy(elements, 1, newElements, 0, newElements.length);
		elements = newElements;
		return result;
	}

}
