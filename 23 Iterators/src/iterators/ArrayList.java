package iterators;

import java.util.Iterator;

public class ArrayList implements Iterable {

	private Object[] elements; //Now: can be made private - nested class has access to elements
	
	public Iterator iterator() {
		//Local class
		class IteratorImpl implements Iterator {
			
			private int index;
			
			//Non-static (= inner) class --> Constructor takes implicit an arrayList as argument + implicit field of an ArrayList
			private IteratorImpl() {} //You can also remove this default constructor
			
			@Override
			public boolean hasNext() {
				//return index < ArrayList.this.elements.length; //ArrayList.this: Reference to implicit field of ArrayList
				return index < elements.length; //'elements' of ArrayList.this is implicitly used
			}
			
			@Override
			public Object next() {
				//return ArrayList.this.elements[index++];
				return elements[index++]; //'elements' of ArrayList.this is implicitly used
			}
		}
		
		return new IteratorImpl(); //'this' of the outer class (= an instance of ArrayList) is given to the constructor
	}
	
}
