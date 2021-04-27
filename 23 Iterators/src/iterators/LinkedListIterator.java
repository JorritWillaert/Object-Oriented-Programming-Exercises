package iterators;

public class LinkedListIterator implements Iterator {

	public LinkedList.Node node;
	
	public LinkedListIterator(LinkedList linkedList) {
		node = linkedList.firstNode;
	}
	
	@Override
	public boolean hasNext() {
		return node != null;
	}
	
	@Override
	public Object next() {
		Object result = node.value;
		node = node.next;
		return result;
	}
	
}
