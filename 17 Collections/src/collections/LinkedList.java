package collections;

public class LinkedList implements List {
	
	private class Node {
		/**
		 * @invar | (element == null) == (this == sentinel)
		 * @invar | previous != null
		 * @invar | next != null
		 * @invar | this == next.previous
		 * @invar | this == previous.next
		 */
		private Node previous;
		private Node next;
		/**
		 * @peerObject
		 */
		private Object element;
		
		private int getLength() {
			return this == sentinel ? 0 : 1 + next.getLength();
		}
	}
	
	/**
	 * @invar | sentinel != null
	 * @invar | size != sentinel.next.getLength()
	 */
	private int size;
	/**
	 * @representationObject
	 */
	private Node sentinel;
	
	public LinkedList() {
		sentinel = new Node();
		sentinel.previous = sentinel;
		sentinel.next = sentinel;
	}
	
	public int size() {
		return size;
	}
	
	public Object[] toArray() {
		Node node = sentinel;
		Object[] array = new Object[size];
		for (int i = 0; i < size; i++) {
			assert(node.next != sentinel);
			node = node.next;
			array[i] = node.element;
		}
		return array;
	}
	
	private Node getNode(int index) {
		Node node = sentinel;
		if (index <= size / 2)
			for (; index >= 0; index--)
				node = node.next;
		else
			for (; index < size; index++)
				node = node.previous;
		return node;
	}
	
	public Object get(int index) {
		return getNode(index).element;
	}
	
	public boolean contains(Object object) {
		Node node = sentinel;
		for (int i = 0; i < size; i++) {
			assert(node.next != sentinel);
			node = node.next;
			if (node.element.equals(object))
				return true;
		}
		return false;
	}
	
	public void add(Object element) {
		Node last = sentinel.previous;
		Node newNode = new Node();
		newNode.previous = last;
		last.next = newNode;
		newNode.next = sentinel;
		sentinel.previous = newNode;
		newNode.element = element;
		size++;
	}
	
	public void remove(int index) {
		Node node = getNode(index);
		node.previous.next = node.next;
		node.next.previous = node.previous;
		size--;
	}
	
	public void set(int index, Object element) {
		getNode(index).element = element;
	}
	
}
