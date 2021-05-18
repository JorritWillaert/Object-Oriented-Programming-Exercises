package listswithiteratorandgenerics;

public interface IterableSelfmade<T> {
	
	IteratorSelfmade<T> iterator();
	
	void forEach(ConsumerSelfmade<? super T> consumer);
	
}
