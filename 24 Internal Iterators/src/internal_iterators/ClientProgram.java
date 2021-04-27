package internal_iterators;

public class ClientProgram {
	
	//Previous lecture: external iterators - Now: Internal iterators. Every data structure must get a forEach method which takes a consumer object as data object
	public static void printBoth(Object exclude, Iterable collection1, Iterable collection2) {
		printAll(exclude, collection1);
		printAll(exclude, collection2);
	}
	
	public static void printAll(Object exclude, Iterable iterable) {
		
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
		//iterable.forEach(value -> System.out.println(value));
		//Only possible since the interface Consumer has only one abstract method --> Usage of lambda expression is possible
		//Iterator has two abstract methods (hasNext() and next()) --> Not possible to implement with a lambda expression
		
		//Now: exclude an object
		iterable.forEach(value -> {
			if (!value.equals(exclude))
				System.out.println(value);
		});
	}
	
}
