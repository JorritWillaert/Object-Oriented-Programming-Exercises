package queues;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BagTest {

	void testBehavesLikeBag(Bag bag) {
		assertArrayEquals(bag.getElements(), new Object[] {});
		
		Object v1 = 10;
		Object v2 = 20;
		
		bag.put(v1);
		bag.put(v2);
		
		Object e1 = bag.take();
		Object e2 = bag.take();
		
		assertTrue(e1 == v1 && e2 == v2 || e1 == v2 && e2 == v1);
	}
	
	@Test
	void test() {
		testBehavesLikeBag(new Queue());
		testBehavesLikeBag(new Stack());
	}

}
