package discussionforum;

import logicalcollections.LogicalList;

import java.util.ArrayList;
import java.util.List;

/**
 * Instances of this class represent a message.
 * 
 * @invar | getAuthor() != null
 * @invar | getReactions() != null
 * @invar | getReactions().stream().allMatch(r -> r != null && !(r.isRemoved()) && r.getParentMessage() == this)
 * @invar | LogicalList.distinct(getReactions())
 */
public class Message {
	
	/**
	 * @invar | author != null
	 * @invar | reactions != null
	 * @invar | reactions.stream().allMatch(r -> r != null && !(r.isRemoved()) && r.getParentMessage() == this)
	 * @invar | LogicalList.distinct(reactions)
	 */
	private final String author;
	/**
	 * @representationObject
	 * @peerObjects
	 */
	final List<Reaction> reactions = new ArrayList<>();
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
	 * @mutates | this
	 * @post | isRemoved()
	 */
	public void removeMessage() {
		this.removed = true;
	}
	
	/**
	 * @immutable
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * @creates | result
	 * @peerObjects
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
