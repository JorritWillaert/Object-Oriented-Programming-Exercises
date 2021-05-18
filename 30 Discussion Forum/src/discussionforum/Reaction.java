package discussionforum;

import logicalcollections.LogicalList;

/**
 * An instance of this class represents a reaction.
 * 
 * @invar | getAuthor() != null
 * @invar | getReactions() != null
 * @invar | getReactions().stream().allMatch(r -> r != null && !(r.isRemoved()) && r.getParentMessage() == this)
 * @invar | getParentMessage() != null
 * @invar | isRemoved() || getParentMessage().getReactions().contains(this)
 */
public class Reaction extends Message {
	
	/**
	 * @invar | parentMessage != null
	 * @invar | isRemoved() || parentMessage.getReactions().contains(this)
	 * 
	 * @peerObject
	 */
	private final Message parentMessage;

	/**
	 * @throws IllegalArgumentException if the author is null.
	 * 		| author == null
	 * @throws IllegalArgumentException if the parentMessage is null.
	 * 		| parentMessage == null
	 * 
	 * @mutates_properties | parentMessage.getReactions()
	 * 
	 * @post | getAuthor().equals(author)
	 * @post | getParentMessage() == parentMessage
	 * @post | getReactions().isEmpty()
	 * @post | !(isRemoved())
	 * @post | parentMessage.getReactions().equals(LogicalList.plus(old(parentMessage.getReactions()), this))
	 */
	public Reaction(String author, Message parentMessage) {
		super(author);
		if (parentMessage == null)
			throw new IllegalArgumentException("The parent message may not be null.");
		this.parentMessage = parentMessage;
		parentMessage.reactions.add(this);
	}
	
	/**
	 * @immutable
	 * @peerObject
	 */
	public Message getParentMessage() {
		return parentMessage;
	}
	
	@Override
	/**
	 * @pre | !(isRemoved())
	 * @mutates_properties | isRemoved(), getParentMessage().getReactions()
	 * @post | isRemoved()
	 * @post | getParentMessage().getReactions().equals(LogicalList.minus(old(getParentMessage().getReactions()), this))
	 */
	public void removeMessage() {
		super.removeMessage();
		parentMessage.reactions.remove(this);
	}
	
}
