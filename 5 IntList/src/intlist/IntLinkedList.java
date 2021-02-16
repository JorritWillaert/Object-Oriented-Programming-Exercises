package intlist;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Each instance of this class represents an array.
 * @invar The length of the array is greater or equal to zero.
 * 		| 0 <= getLength()
 */
public class IntLinkedList {
	/**
	 * Each instance of this class represents a node of a linked list
	 */
	private class Node {
		private int value;
		private Node next;
		
		/**
		 * Initialize a node
		 * @post The value of the node should be zero
		 * 		| getValue() == 0
		 * @post The next pointer of the node should be null
		 * 		| getNextNode() == null 
		 */
		private Node() {};
		
		private int getValue() {
			return value;
		}
		
		private Node getNextNode() {
			return next;
		}
		/**
		 * @post The next pointer points to the nextNode
		 * 		| getNextNode() == nextNode
		 */
		private void setNextNode(Node nextNode) {
			next = nextNode;
		}
		
		/**
		 * The value of the node equals the given value
		 * 		| this.value == value
		 */
		private void setValue(int value) {
			this.value = value;
		}
	}

	/**
	 * @representationObject
	 */
	private Node head;
	
	/**
	 * Initialize an empty array
	 * 
	 * @post The length of the array equals zero
	 * 		| getLength() == 0
	 */
	public IntLinkedList() {}
	
	/**
	 * Return the length of the array
	 * @post Check that the length of the array is greater or equal than zero
	 * 		| result >= 0
	 */
	public int getLength() {
		if (head == null) {
			return 0;
		}
		int count = 1;
		Node node = head;
		while (node.getNextNode() != null) {
			node = node.getNextNode();
			count++;
		}
		return count;
	}
	
	/**
	 * Return the element at a given index of the array
	 * 
	 * Contractual:
	 * @pre The given index should be greater or equal than zero
	 * 		| 0 <= index
	 * @pre The given index should be smaller than the length of the array
	 * 		| index < getLength()
	 * @pre The length of the array should be greater than zero.
	 * 		| getLength() > 0
	 * 
	 * Defensive:
	 * @throws IllegalArgumentException if the given index is less than zero
	 * 		| index < 0
	 * @throws IllegalArgumentException if the given index is greater than the length of the array
	 * 		| index >= getLength()
	 * @throws IllegalArgumentException if the length of the array is less or equal than zero
	 * 		| getLength() <= 0
	 * 
	 * @post | result == getArray()[index]
	 * 
	 * // Note: no need to specify that no elements may be changed, since 'get' implies for FSC4J that it does not mutate objects.
	 */
	public int getElement(int index) {
		//Defensive
		if (index < 0) {
			throw new IllegalArgumentException("Index less than zero");
		}
		if (index >= getLength()) {
			throw new IllegalArgumentException("Index out of upper bound");
		}
		if (getLength() <= 0) {
			throw new IllegalArgumentException("The array does not yet exist");
		}
		
		Node node = head;
		for (int i = 0; i < index; i++) {
			node = node.getNextNode();
			if (node == null) {
				throw new RuntimeException("The node does not exist");
			}
		}
		return node.getValue();
	}
	
	/**
	 * @mutates | this
	 * 
	 * @pre | 0 <= index && index < getLength()
	 * @post | getLength() == old(getLength())
	 * @post | IntStream.range(0, getLength()).allMatch(i ->
	 * 		 |	 	i == index ?
	 * 		 |			getElement(i) == value
	 * 		 | 		: 
	 * 		 | 			getElement(i) == old(getArray())[i])
	 * 
	 * // statement ? true-value : false-value
	 */
	public void setElement(int index, int value) { 
		if (index < 0) {
			throw new IllegalArgumentException("Index less than zero");
		}
		if (index >= getLength()) {
			throw new IllegalArgumentException("Index out of upper bound");
		}
		if (getLength() <= 0) {
			throw new IllegalArgumentException("The array does not yet exist");
		}
		Node node = head;
		for (int i = 0; i < index; i++) {
			node = node.getNextNode();
			if (node == null) {
				throw new RuntimeException("The node does not exist");
			}
		}
		node.setValue(value);
	}
	
	/**
	 * Return a copy of the internal array (otherwise does the client has access to the internal representation: representation exposure) - see '@creates'
	 * @creates | result
	 * @basic
	 */
	public int[] getArray() {
		int[] array = new int[getLength()];
		Node node = head;
		for (int i = 0; i < getLength(); i++) {
			if (node == null) {
				throw new RuntimeException("The node does not exist");
			}
			array[i] = node.value;
			node = node.getNextNode();
		}
		return array;
	}
	
	/**
	 * Append an element to the end of the array
	 * 
	 * @post The last element of the array equals the given argument
	 * 		| getElement(old(getLength())) == element
	 * @post The length of the array is increased by one
	 * 		| getLength() == old(getLength()) + 1
	 * @post The existing elements in the array are unchanged
	 * 		| IntStream.range(0, old(getLength())).allMatch(i ->
	 * 		|		getElement(i) == old(getArray())[i])
	 * 
	 * // IntStream.range(a, b).allMatch(i -> statement about i)		(inclusive a, exclusive b)
	 * 
	 * Alternative:
	 * @post | Arrays.equals(getArray(), 0, getLength() - 1, old(getArray()), 0, old(getLength()))
	 */
	public void appendElement(int element) {
		if (head == null) {
			head = new Node();
			head.setValue(element);
		} else {
		Node node = head;
		for (int i = 0; i < getLength() - 1; i++) {
			node = node.getNextNode();
			if (node == null) {
				throw new RuntimeException("The node does not exist");
			}
		}
		Node newNode = new Node();
		node.setNextNode(newNode);
		newNode.setValue(element);
		}
	}
	
	/**
	 * Remove the last element of the array
	 * 
	 * Contractual:
	 * @pre The length of the array is greater than zero
	 * 		| getLength() > 0
	 * 
	 * Defensive:
	 * @throws IllegalArgumentException if the length of the array is less or equal than zero
	 * 		| getLength() <= 0
	 * 
	 * @post The returned element was the last element of the array
	 * 		| result == old(getElement(old(getLength()) - 1))
	 * @post The length of the array is reduced by one
	 * 		| 1 + getLength() == old(getLength())
	 * @post The other existing elements in the array are unchanged
	 * 		| IntStream.range(0, getLength() - 1).allMatch(i ->
	 * 		|		getElement(i) == old(getArray())[i])
	 */
	public int removeLastElement() {
		Node node = head;
		for (int i = 0; i < getLength() - 2; i++) {
			node = node.getNextNode();
			if (node == null) {
				throw new RuntimeException("The node does not exist");
			}
		}
		int lastValue = node.getNextNode().getValue();
		node.setNextNode(null);
		return lastValue;
	}
}
