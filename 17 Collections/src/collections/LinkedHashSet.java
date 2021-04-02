package collections;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LinkedHashSet implements Set {
	
	//Note: we stated that the map contains all nodes of our linked list & we stated that every node of our linked list is in our map!
	
	private class Node {
		/**
		 * @invar | (element == null) == (this == sentinel)
		 * @invar | previous != null
		 * @invar | next != null
		 * @invar | this == next.previous
		 * @invar | this == previous.next
		 * @invar | this == sentinel || map.get(element) == this
		 * 
		 * @peerObject
		 */
		private Node previous;
		/**
		 * @peerObject
		 */
		private Node next;
		private Object element;
	}
	
	private boolean isInLinkedList(Node node) {
		Node n = sentinel.next;
		while (n != sentinel) {
			if (n == node)
				return true;
			n = n.next;
		}
		return false;
	}

	/**
	 * @invar | sentinel != null
	 * @representationObject
	 */
	private Node sentinel;
	/**
	 * @invar | map != null
	 * @invar | Arrays.stream(map.entrySet().toArray()).allMatch(e -> 
	 * 		  |		((Map.Entry)e).getValue() instanceof Node &&
	 * 		  | 	isInLinkedList((Node)((Map.Entry)e).getValue()) &&
	 * 		  |		((Node)((Map.Entry)e).getValue()).element == ((Map.Entry)e).getKey())
	 * @representationObject
	 */
	private HashMap map;
	
	public LinkedHashSet() {
		sentinel = new Node();
		sentinel.previous = sentinel;
		sentinel.next = sentinel;
		map = new HashMap();
	}
	
	@Override
	public Object[] toArray() {
		Node node = sentinel.next;
		Object[] array = new Object[map.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = node.element;
			node = node.next;
		}
		return array;
	}
	
	@Override
	public void add(Object object) {
		if (!map.containsKey(object)) {
			Node node = new Node();
			Node prevLast = sentinel.previous;
			node.element = object;
			node.next = sentinel;
			node.previous = prevLast;
			prevLast.next = node;
			sentinel.previous = node;
			map.put(object, node);
		}
	}
	
	@Override
	public boolean contains(Object object) {
		return map.containsKey(object);
	}
	
	@Override
	public void remove(Object object) {
		Node node = (Node)map.get(object);
		if (node != null) {
			map.remove(object);
			node.previous.next = node.next;
			node.next.previous = node.previous;
		}
	}
	
	@Override
	public int size() {
		return map.size();
	}
	
}

