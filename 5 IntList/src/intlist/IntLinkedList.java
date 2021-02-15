package intlist;

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
	 * Return the array
	 * 
	 * Contractual:
	 * @pre The length of the array should be greater than zero.
	 * 		| getLength() > 0
	 * 
	 * Defensive:
	 * @throws IllegalArgumentException if the length of the array is less or equal than zero
	 * 		| getLength() <= 0
	 */
	public int[] getArray() {
		if (getLength() <= 0) {
			throw new IllegalArgumentException("The array does not yet exist");
		}
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
	 * 		| getElement(getLength() - 1) == element
	 * @post The length of the array is increased by one
	 * 		| getLength() == old(getLength()) + 1
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
