package internal_iterators;

public class ClientProgram {
	
	//Previous lecture: external iterators - Now: Internal iterators. Every data structure must get a forEach method which takes a consumer object as data object
	public static void printBoth(ArrayList arrayList, LinkedList linkedList) {
		printAll(arrayList);
		printAll(linkedList);
	}
	
	public static void printAll(ArrayList arrayList) {
//		for (int i = 0; i < arrayList.elements.length; i++)
//			System.out.println(arrayList.elements[i]);
		
		arrayList.forEach(new PrintConsumer());
	}
	
	public static void printAll(LinkedList linkedList) {
//		for (LinkedList.Node node = linkedList.firstNode; node != null; node = node.next)
//			System.out.println(node.value);
		
		linkedList.forEach(new PrintConsumer());
	}
	
}
