package discussionforum;

import java.util.Iterator;

public class MessageUtils {

	/**
	 * @throws IllegalArgumentException if the given message is null.
	 * 		| message == null
	 */
	public static int calculateDepth(Message message) {
		if (message == null)
			throw new IllegalArgumentException("The given message may not be null.");
		if (message instanceof OriginalMessage)
			return 0;
		Reaction reaction = (Reaction)message;
		return 1 + calculateDepth(reaction.getParentMessage());
	}
	
	/**
	 * @throws IllegalArgumentException if the given message is null
	 * 		| messageGiven == null
	 */
	public static Iterator<Message> iteratorAncestors(Message messageGiven) {
		if (messageGiven == null)
			throw new IllegalArgumentException("Message may not be null.");
		return new Iterator<Message>() {
			
			private Message message = messageGiven;
			
			@Override
			public boolean hasNext() {
				if (message instanceof OriginalMessage)
					return false;
				return true;
			}
			
			@Override
			public Message next() {
				Reaction message = (Reaction)messageGiven;
				return message.getParentMessage();
			}
		};
	}
	
}
