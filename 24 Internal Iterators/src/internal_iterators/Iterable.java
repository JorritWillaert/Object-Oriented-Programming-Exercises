package internal_iterators;

public interface Iterable {

	/**
	 * Calls the consumers's accept method on each element of the collection.
	 */
	public void forEach(Consumer consumer);
	
}
