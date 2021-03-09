package queues;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueTest {
	
	void testHasFifoBehavior(Queue queue) {
		assertArrayEquals(queue.getElements(), new Object[] {});
		
		queue.put(10);
		queue.put(20);
		
		assertEquals(10, queue.take());
		assertEquals(20, queue.take());
	}

	@Test
	void test() {
		testHasFifoBehavior(new Queue());
	}

}
