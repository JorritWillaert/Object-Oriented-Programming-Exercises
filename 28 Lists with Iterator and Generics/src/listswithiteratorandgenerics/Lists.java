package listswithiteratorandgenerics;

abstract class Lists<I extends Comparable<I>> implements IterableSelfmade<I> {
	public String toString() {
		String result = "[";
		boolean first = true;
		Lists<I> list = this;
		while (list instanceof NonEmptyList) {
			NonEmptyList<I> nel = (NonEmptyList<I>) list;
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
	public IteratorSelfmade<I> iterator() {
		//Iterator from java.util is a generic interface. Better to use Iterator<Integer> if you use the java.util interface.
		return new IteratorSelfmade<I>() {
			
			private Lists<I> list = Lists.this;
			
			@Override
			public boolean hasNext() {
				return list.getLength() > 0;
			}
			
			@Override
			public I next() {
				NonEmptyList<I> listNonEmpty = (NonEmptyList<I>)list;
				list = listNonEmpty.getTail();
				return listNonEmpty.getHead();
			}
		};
	}
	
	@Override
	public void forEach(ConsumerSelfmade<I> consumer) {
		//Consumer from java.util is a generic interface. Better to use Consumer<Integer> if you use the java.util interface.
		Lists<I> list = this;
		while (list.getLength() != 0) {
			NonEmptyList<I> listNonEmpty = (NonEmptyList<I>)list;
			consumer.accept(listNonEmpty.getHead());
			list = listNonEmpty.getTail();
		}
	}
	
}

class EmptyList<I extends Comparable<I>> extends Lists<I> {
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

class NonEmptyList<I extends Comparable<I>> extends Lists<I> {
	
	/**
	 * @invar | tail != null
	 */
	private final I head;
	private final Lists<I> tail;
	
	public NonEmptyList(I head, Lists<I> tail) {
		if (tail == null)
			throw new IllegalArgumentException("The given values-array may not be empty.");
		this.head = head;
		this.tail = tail;
	}
	
	/**
	 * @basic
	 */
	public I getHead() {
		return head;
	}
	
	/**
	 * @basic
	 */
	public Lists<I> getTail() {
		return tail;
	}
	
	public int getLength() {
		return 1 + tail.getLength();
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof NonEmptyList))
			return false;
		@SuppressWarnings("unchecked")
		NonEmptyList<I> otherNonEmptyList = (NonEmptyList<I>)other;
		return head == otherNonEmptyList.head && tail.equals(otherNonEmptyList.tail);
	}

	
}
