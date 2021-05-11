package listswithiteratorandgenerics;

abstract class Lists implements IterableSelfmade {
	//Iterable from java.util is a generic interface. Better to use Iterable<Integer> if you use the java.util interface.
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
	
	@Override
	public IteratorSelfmade iterator() {
		//Iterator from java.util is a generic interface. Better to use Iterator<Integer> if you use the java.util interface.
		return new IteratorSelfmade() {
			
			private Lists list = Lists.this;
			
			@Override
			public boolean hasNext() {
				return list.getLength() > 0;
			}
			
			@Override
			public Object next() {
				NonEmptyList listNonEmpty = (NonEmptyList)list;
				list = listNonEmpty.getTail();
				return listNonEmpty.getHead();
			}
		};
	}
	
	@Override
	public void forEach(ConsumerSelfmade consumer) {
		//Consumer from java.util is a generic interface. Better to use Consumer<Integer> if you use the java.util interface.
		Lists list = this;
		while (list.getLength() != 0) {
			NonEmptyList listNonEmpty = (NonEmptyList)list;
			consumer.accept(listNonEmpty.getHead());
			list = listNonEmpty.getTail();
		}
	}
	
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
