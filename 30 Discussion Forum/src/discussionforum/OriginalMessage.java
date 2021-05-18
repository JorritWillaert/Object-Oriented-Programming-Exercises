package discussionforum;

public class OriginalMessage extends Message {
	
	/**
	 * @throws IllegalArgumentException if the given author is null.
	 * 		| author == null
	 */
	public OriginalMessage(String author) {
		super(author);
	}
	
	@Override
	/**
	 * @pre | !(isRemoved())
	 * 
	 * @post | isRemoved()
	 */
	public void removeMessage() {
		this.removed = true;
	}

}
