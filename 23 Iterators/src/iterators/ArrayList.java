package iterators;

import java.util.Iterator;

public class ArrayList implements Iterable {

	private Object[] elements; //Now: can be made private - nested class has access to elements
	
	public Iterator iterator() {
		return new Iterator() {
			
			private int index;
			
			//Non-static (= inner) class --> Constructor takes implicit an arrayList as argument + implicit field of an ArrayList
			//private IteratorImpl() {} //You can also remove this default constructor
			
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
		};
		//Since you only use this class one time - class definition and instantiation put together
		//Anonymous class instantiation
		//"return new Interface/superclass (arguments constructor){body}"
	}
	
}
