package lists.tests;

abstract class Lists {
	public String toString() {
		String result = "[";
		boolean first = true;
		Lists list = this;
		while (list instanceof NonEmptyList) {
			NonEmptyList nel = (NonEmptyList) list;
			if (first) 
				first = false;
			else
				result += ",";
			result += nel.getHead();
			list = nel.getTail();
		}
		result += "]";
		return result;
	}
	
	public abstract int getLength();
}

class EmptyList extends Lists {
	public EmptyList() {}
	
	public int getLength() {
		return 0;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof EmptyList)
			return true;
		return false;
	}
}

class NonEmptyList extends Lists {
	
	/**
	 * @invar | tail != null
	 */
	private final int head;
	private final Lists tail;
	
	public NonEmptyList(int head, Lists tail) {
		if (tail == null)
			throw new IllegalArgumentException("The given values-array may not be empty.");
		this.head = head;
		this.tail = tail;
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
	public Lists getTail() {
		return tail;
	}
	
	public int getLength() {
		return 1 + tail.getLength();
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof NonEmptyList))
			return false;
		NonEmptyList otherNonEmptyList = (NonEmptyList) other;
		return head == otherNonEmptyList.head && tail.equals(otherNonEmptyList.tail);
	}
}


