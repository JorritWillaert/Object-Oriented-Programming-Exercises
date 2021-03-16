package translator;

//If interface inherits from other interface --> extends
//If class inherits from interface --> implements
public interface AddableValue extends Value{
	
	public abstract Value add(Value other);
}
