package discussionforum;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

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
	
	/**
	 * @throws IllegalArgumentException if the given message is null.
	 * 		| messageGiven == null
	 * @throws IllegalArgumentException if the consumer is null.
	 * 		| consumer == null
	 */
	public static void forEachAncestor(Message messageGiven, Consumer<? super Message> consumer) {
		if (messageGiven == null)
			throw new IllegalArgumentException("The given message may not be null.");
		if (consumer == null)
			throw new IllegalArgumentException("The consumer may not be null.");
		
		Message message = messageGiven;
		while (message instanceof Reaction) {
			Reaction reaction = (Reaction)message;
			consumer.accept(reaction);
			message = reaction.getParentMessage();
		}
		consumer.accept(message);
	}
	
	
	/**
	 * @throws IllegalArgumentException if the given message is null.
	 * 		| message == null
	 */
	private static Stream<Message> streamAllMessages(Message message) {
		 if (message == null)
				throw new IllegalArgumentException("The given message may not be null.");
		 Stream<Message> stream = Stream.of(message);
		 Stream.concat(stream, message.getReactions().stream().flatMap(reaction -> streamAllMessages(reaction)));
		 return stream;
	}
	
	/**
	 * @throws IllegalArgumentException if the given original message is null.
	 * 		| originalMessage == null
	 * @throws IllegalArgumentException if the given author is null.
	 * 		| author == null
	 */
	public static Stream<Message> streamOfGivenAuthor(OriginalMessage originalMessage, String author) {
		if (originalMessage == null)
			throw new IllegalArgumentException("The given original message may not be null.");
		if (author == null)
			throw new IllegalArgumentException("The given author may not be null.");
		Stream<Message> allMessages = streamAllMessages(originalMessage);
		return allMessages.filter(m -> m.getAuthor().equals(author));
	}
	
}
