package internal_iterators;

public class ClientProgram {
	
	//Previous lecture: external iterators - Now: Internal iterators. Every data structure must get a forEach method which takes a consumer object as data object
	public static void printBoth(Iterable collection1, Iterable collection2) {
		printAll(collection1);
		printAll(collection2);
	}
	
	public static void printAll(Iterable iterable) {
		
		//Use an anonymous class instantiation
//		iterable.forEach(new Consumer() {
//			
//			public void accept(Object value) {
//				System.out.println(value);
//			}
//			
//		});
		
		//Equivalent code as above (lambda-expression)
		//iterable.forEach((Object value) -> {System.out.println(value);}); //We do not mention the interface Consumer, but Java determines it by itself (= target typing)
		iterable.forEach(value -> System.out.println(value));
		//Only possible since the interface Consumer has only one abstract method --> Usage of lambda expression is possible
		//Iterator has two abstract methods (hasNext() and next()) --> Not possible to implement with a lambda expression
	}
	
}
