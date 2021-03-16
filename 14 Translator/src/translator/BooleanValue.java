package translator;

public class BooleanValue implements AndableValue{

	public final boolean value; //Public --> Because final
	 
	public BooleanValue (Boolean value) {
		this.value = value;
	}
	
	@Override
	public Value and(Value other) {
		if (other instanceof BooleanValue)
			return new BooleanValue(value & ((BooleanValue) other).value);
		else
			throw new RuntimeException("Cannot and the other value to this value");
	}
}
