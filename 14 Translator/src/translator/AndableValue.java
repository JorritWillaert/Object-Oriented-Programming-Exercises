package translator;

//If interface inherits from other interface --> extends
//If class inherits from interface --> implements
public interface AndableValue extends Value {
	
	public abstract Value and(Value other);
}
