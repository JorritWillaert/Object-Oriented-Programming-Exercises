package internal_iterators;

public class PrintConsumer implements Consumer {
	
	public void accept(Object value) {
		System.out.println(value);
	}
	
}
