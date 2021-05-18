package discussionforum;

/**
 * An instance of this class represents an original message.
 * 
 * @invar | getAuthor() != null
 * @invar | getReactions() != null
 * @invar | getReactions().stream().allMatch(r -> r != null && !(r.isRemoved()))
 */
public class OriginalMessage extends Message {
	
	/**
	 * @throws IllegalArgumentException if the given author is null.
	 * 		| author == null
	 * 
	 * @post | getAuthor().equals(author)
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
