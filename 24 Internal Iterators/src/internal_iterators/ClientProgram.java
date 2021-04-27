package internal_iterators;

public class ClientProgram {

	public static void printBoth(ArrayList arrayList, LinkedList linkedList) {
		printAll(arrayList);
		printAll(linkedList);
	}
	
	public static void printAll(ArrayList arrayList) {
		for (int i = 0; i < arrayList.elements.length; i++)
			System.out.println(arrayList.elements[i]);
	}
	
	public static void printAll(LinkedList linkedList) {
		for (LinkedList.Node node = linkedList.firstNode; node != null; node = node.next)
			System.out.println(node.value);
	}
	
}
