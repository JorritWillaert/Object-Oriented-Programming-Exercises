package iterators;

import java.util.Iterator;

public class LinkedList implements Iterable {

	public static class Node {
		public Object value;
		public Node next;
	}
	
	public Node firstNode; //For the moment - no encapsulation; This is the subject of this lecture
	
	public Iterator iterator() {
		return new LinkedListIterator(this);
	}
	
}
