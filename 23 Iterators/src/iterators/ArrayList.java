package iterators;

import java.util.Iterator;

public class ArrayList implements Iterable {

	public Object[] elements; //For the moment - no encapsulation; This is the subject of this lecture
	
	public Iterator iterator() {
		return new ArrayListIterator(this);
	}
	
}
