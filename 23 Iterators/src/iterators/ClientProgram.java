package iterators;

public class ClientProgram {
	
	public static void printBoth(ArrayList arrayList, LinkedList linkedList) {
		printAll(new ArrayListIterator(arrayList));
		printAll(new LinkedListIterator(linkedList));
	}

	public static void printAll(Iterator iterator) {
		for (; iterator.hasNext(); ) {
			System.out.println(iterator.next());
		}
	}
	
}
