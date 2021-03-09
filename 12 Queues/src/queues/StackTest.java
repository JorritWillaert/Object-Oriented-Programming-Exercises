package queues;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackTest {

	void testHasLifoBehavior(Stack stack) {
		assertArrayEquals(stack.getElements(), new Object[] {});
		
		stack.put(10); 
		stack.put(20);
		
		assertEquals(20, stack.take());
		assertEquals(10, stack.take());
	}
	
	@Test
	void test() {
		testHasLifoBehavior(new Stack());
	}

}
