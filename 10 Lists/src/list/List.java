package list;

abstract class Lists {
	public abstract String toString();
}

class EmptyList extends Lists {
	public EmptyList() {}
	
	@Override
	public String toString() {
		return "[]";
	}
}

class NonEmptyList extends Lists {
	
	private int head;
	private int[] tail;
	
	public NonEmptyList(int[] values) {
		if (values.length == 0)
			throw new IllegalArgumentException("The given values-array may not be empty.");
		head = values[0];
		if (values.length >= 1)
			tail = new int[values.length - 1];
			System.arraycopy(values, 1, tail, 0, tail.length);
	}
	
	/**
	 * @basic
	 */
	public int getHead() {
		return head;
	}
	
	/**
	 * @basic
	 */
	public int[] getTail() {
		return tail.clone();
	}
	
	/**
	 * @post | result == getTail().length + 1
	 */
	public int getLength() {
		return getTail().length + 1;
	}
	
	@Override
	public String toString() {
		String string = "[" + head; 
		for (int i = 0; i < tail.length; i++) {
			string = string + ", " + tail[i];
		}
		return string;
	}
}
