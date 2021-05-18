package discussionforum;

import logicalcollections.LogicalList;

/**
 * An instance of this class represents a reaction.
 * 
 * @invar | getAuthor() != null
 * @invar | getReactions() != null
 * @invar | getReactions().stream().allMatch(r -> r != null && !(r.isRemoved()))
 * @invar | getParentMessage() != null
 */
public class Reaction extends Message {
	
	/**
	 * parentMessage != null
	 * 
	 * @peerObject
	 */
	private Message parentMessage;

	/**
	 * @throws IllegalArgumentException if the author is null.
	 * 		| author == null
	 * @throws IllegalArgumentException if the parentMessage is null.
	 * 		| parentMessage == null
	 * 
	 * @post | getAuthor().equals(author)
	 * @post | getParentMessage() == parentMessage
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
	 * @peerObject
	 */
	public Message getParentMessage() {
		return parentMessage;
	}
	
	@Override
	/**
	 * @pre | !(isRemoved())
	 * 
	 * @post | isRemoved() && old(getParentMessage()).getReactions().equals(LogicalList.minus(old(getParentMessage().getReactions()), this))
	 */
	public void removeMessage() {
		this.removed = true;
		parentMessage.reactions.remove(this);
	}
	
}
