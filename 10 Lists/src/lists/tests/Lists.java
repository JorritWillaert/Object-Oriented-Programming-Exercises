package lists.tests;

abstract class Lists {
	public abstract String toString();
}

class EmptyList extends Lists {
	public EmptyList() {}
	
	@Override
	public String toString() {
		return "[]";
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof EmptyList)
			return true;
		return false;
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
			string = string + "," + tail[i];
		}
		string += "]";
		return string;
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof NonEmptyList))
			return false;
		NonEmptyList otherNonEmptyList = (NonEmptyList) other;
		if (otherNonEmptyList.getLength() != getLength())
			return false;
		if (otherNonEmptyList.getHead() != getHead())
			return false;
		int[] otherTail = otherNonEmptyList.getTail();
		for (int i = 0; i < otherNonEmptyList.getLength() - 1; i++)
			if (otherTail[i] != tail[i])
				return false;
		return true;
	}
}


