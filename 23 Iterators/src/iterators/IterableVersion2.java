package iterators;

public interface IterableVersion2 {

	IteratorOtherVersion iterator();
	
	//Given an external iterator, it is very easy to implement an internal iterator; The reverse is not true
	default void forEach(Consumer consumer) {
		for (IteratorOtherVersion iterator = iterator(); iterator.hasNext(); )
			consumer.accept(iterator.next());
	}
	
}
