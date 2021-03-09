package queues;

import java.util.Arrays;

/**
 * Each instance of this class stores a bag of elements.
 */
public abstract class Bag {
	//Queue and Stack do have a tighter specification than Bag --> Correct to say that Stack and Queue are an extension of Bag.
	
	/**
	 * Returns a new array containing the elements of this bag, in the order they were added to the bag.
	 */
	public abstract Object[] getElements();
	
	/**
	 * Adds the element to the end of this bag.
	 * 
	 * @post | getElements().length == old(getElements()).length + 1
	 * @post | Arrays.equals(getElements(), 0, old(getElements()).length, old(getElements()), 0, old(getElements().length))
	 * @post | getElements()[old(getElements()).length] == element
	 */
	public abstract  void put(Object element);
	
	/**
	 * Removes an element from this bag and returns it.
	 * 
	 * @pre | getElements().length > 0
	 * @post | getElements().length == old(getElements()).length - 1
	 * @post | Arrays.stream(old(getElements())).anyMatch(e -> e == result)
	 * @post | Arrays.stream(old(getElements())).allMatch(e ->
	 * 		 | 		Arrays.stream(old(getElements())).filter(e1 -> e1 == e).count() == 
	 * 		 |		Arrays.stream(getElements()).filter(e1 -> e1 == e).count() + 
	 * 		 |		(e == result ? 1: 0))
	 */
	public abstract Object take();
	
}
