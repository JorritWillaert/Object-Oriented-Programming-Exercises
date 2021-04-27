package internal_iterators;

public class ArrayList implements Iterable {
	
	public int[] elements;
	
	public void forEach(Consumer consumer) {
		for (int i = 0; i < elements.length; i++)
			consumer.accept(elements[i]);
	}

}
