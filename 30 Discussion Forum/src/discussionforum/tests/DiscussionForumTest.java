package discussionforum.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import discussionforum.OriginalMessage;
import discussionforum.Reaction;

class DiscussionForumTest {

	@Test
	void test() {
		OriginalMessage rootMessage = new OriginalMessage("Jorrit Willaert");
		assertEquals("Jorrit Willaert", rootMessage.getAuthor());
		assertFalse(rootMessage.isRemoved());
		assertEquals(List.of(), rootMessage.getReactions());
		
		Reaction reaction1 = new Reaction("Elon Musk", rootMessage);
		assertEquals("Elon Musk", reaction1.getAuthor());
		assertFalse(reaction1.isRemoved());
		assertEquals(List.of(), reaction1.getReactions());
		assertEquals(List.of(reaction1), rootMessage.getReactions());
		assertEquals(rootMessage, reaction1.getParentMessage());
		
		Reaction reaction2 = new Reaction("Bill Gates", rootMessage);
		assertEquals(List.of(reaction1, reaction2), rootMessage.getReactions());
		assertEquals(rootMessage, reaction2.getParentMessage());
		
		Reaction reaction3 = new Reaction("Steve Jobs", reaction2);
		assertEquals(List.of(reaction1, reaction2), rootMessage.getReactions());
		assertEquals(List.of(reaction3), reaction2.getReactions());
		assertEquals(reaction2, reaction3.getParentMessage());
		
		reaction1.removeMessage();
		assertEquals(List.of(reaction2), rootMessage.getReactions());
		assertEquals(List.of(reaction3), reaction2.getReactions());
		
		assertTrue(reaction1.isRemoved());
	}

}
