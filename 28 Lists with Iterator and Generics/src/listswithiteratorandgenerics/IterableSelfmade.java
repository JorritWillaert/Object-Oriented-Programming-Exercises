package listswithiteratorandgenerics;

public interface IterableSelfmade {
	
	IteratorSelfmade iterator();
	
	void forEach(ConsumerSelfmade consumer);
	
}
