package translator;

public class StringValue implements AddableValue{
	
	public final String value; //Public --> Because final
	
	public StringValue (String value) {
		this.value = value;
	}
	
	@Override
	public Value add(Value other) {
		if (other instanceof StringValue)
			return new StringValue(value + ((StringValue) other).value);
		else
			throw new RuntimeException("Cannot add a string to this value");
	}
}
