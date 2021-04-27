package iterators;

public class ClientProgram {

	public static void printBoth(ArrayList arrayList, LinkedList linkedList) {
		//Note: we need two different methods because the internal representation are different
		printAll(arrayList);
		printAll(linkedList);
	}

	public static void printAll(ArrayList arrayList) {
		for (int i = 0; i < arrayList.elements.length; i++)
			System.out.println(arrayList.elements[i]); // Equivalent with arrayList.elements[i].toString()
	}
	
	public static void printAll(LinkedList linkedList) {
		for (LinkedList.Node node = linkedList.firstNode; node != null; node = node.next)
			System.out.println(node.value);
	}
	
}
