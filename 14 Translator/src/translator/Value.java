package translator;

//Note: Java does not allow that you inherit of more than one class. But: it does allow to inherit from more than one interface
//Interface: No fields and no constructors
//Interface can't inherit of classes. So: value should also be an interface
//Default keyword in instance --> abstract method
//If you want to implement a method in this interface --> e.g. default boolean isZero() {...};
public interface Value {
	
	//e.g. /*public static final*/ int[] x = new int[10];

	public static Value evaluate(Value value1, char operator, Value value2) {
		switch (operator) {
		case '+':
			if (value1 instanceof AddableValue)
				return ((AddableValue) value1).add(value2);
			else
				throw new RuntimeException("Cannot apply + to these values");
		case '&':
			if (value1 instanceof AndableValue)
				return ((AndableValue) value1).and(value2);
			else
				throw new RuntimeException("Cannot apply & to these values");
		default:
			throw new RuntimeException("Operator not supported.");
		}
	}
}
