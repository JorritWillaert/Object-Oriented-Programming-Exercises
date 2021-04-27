package internal_iterators;

public class LinkedList implements Iterable {

	public static class Node{
		public Object value;
		public Node next;
	}
	
	public Node firstNode;
	
	public void forEach(Consumer consumer) {
		for (Node node = firstNode; node != null; node = node.next)
			consumer.accept(node.value);
	}
	
}
