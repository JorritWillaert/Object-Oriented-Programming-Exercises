package discussionforum;

import java.util.List;

/**
 * Instances of this class represent a message.
 * 
 * @invar | getAuthor() != null
 * @invar | getReactions() != null
 * @invar | getReactions().stream().allMatch(r -> r != null && !(r.isRemoved()))
 */
public abstract class Message {
	
	/**
	 * @invar | author != null
	 * @invar | reactions != null
	 * @invar | reactions.stream().allMatch(r -> r != null)
	 */
	private final String author;
	List<Reaction> reactions;
	boolean removed;
	
	/**
	 * @throws IllegalArgumentException if the author is null.
	 * 		| author == null
	 * 
	 * @post | getAuthor().equals(author)
	 */
	public Message(String author) {
		if (author == null)
			throw new IllegalArgumentException("The author may not be null.");
		this.author = author;
	}
	
	/**
	 * @pre | !(isRemoved())
	 * 
	 * @post | isRemoved()
	 */
	public abstract void removeMessage();
	
	public String getAuthor() {
		return author;
	}
	
	/**
	 * @creates | result
	 */
	public List<Reaction> getReactions() {
		return List.copyOf(reactions);
	}
	
	/**
	 * @inspects | this
	 */
	public boolean isRemoved() {
		return removed;
	}

}
