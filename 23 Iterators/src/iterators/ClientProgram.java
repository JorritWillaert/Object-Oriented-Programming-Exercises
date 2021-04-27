package iterators;

public class ClientProgram {
	
	public static void printBoth(Iterable collection1, Iterable collection2) {
		printAll(collection1.iterator());
		printAll(collection2.iterator());
	}

	public static void printAll(Iterator iterator) {
		for (; iterator.hasNext(); ) {
			System.out.println(iterator.next());
		}
	}
	
}
