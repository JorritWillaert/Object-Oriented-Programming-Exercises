package iterators;

import java.util.Iterator;

public class ClientProgram {
	
	public static void printBoth(Iterable collection1, Iterable collection2) {
		printAll(collection1);
		printAll(collection2);
	}

	public static void printAll(Iterable iterable) {
//		for (Iterator iterator = iterable.iterator(); iterator.hasNext(); ) {
//			Object element = iterator.next();
//			System.out.println(element);
//		}
		
		//Can be simpler with enhanced for loop; Equivalent loops
		for (Object element: iterable) {
			System.out.println(element);
		}
	}
	
}
