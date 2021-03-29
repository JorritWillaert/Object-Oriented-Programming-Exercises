package collections;

import java.util.Arrays;

public class ArrayList implements List {
	
	private int size;
	private Object[] elements;
	
	/**
	 * @post | size() == 0
	 */
	public ArrayList() {
		elements = new Object[10];
	}
	
	public Object[] toArray() {
		return Arrays.copyOf(elements, size); //No clone, since we only return the number of elements in use (size may be smaller than capacity)
	}
	
	public int size() {
		return size;
	}
	
	public Object get(int index) {
		return elements[index];
	}
	
	public boolean contains(Object object) {
		for (int i = 0; i < size; i++)
			if (elements[i].equals(object))
				return true;
		return false;
	}
	
	public void add(Object element) {
		if (elements.length == size) {
			Object[] newElements = new Object[elements.length * 2];
			System.arraycopy(elements, 0, newElements, 0, size);
			elements = newElements;
		}
		elements[size++] = element;
	}
	
	public void remove(int index) {
		System.arraycopy(elements, index + 1, elements, index, size() - index - 1);
		size--;
	}
	
	public void set(int index, Object element) {
		elements[index] = element;
	}
	
}
