package internal_iterators;

public class ClientProgram {
	
	//Previous lecture: external iterators - Now: Internal iterators. Every data structure must get a forEach method which takes a consumer object as data object
	public static void printBoth(Iterable collection1, Iterable collection2) {
		printAll(collection1);
		printAll(collection2);
	}
	
	public static void printAll(Iterable iterable) {
		iterable.forEach(new PrintConsumer());
	}
	
}
