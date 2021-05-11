package listswithiteratorandgenerics;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ListsWithIteratorTest {

	@Test
	void test() {
		EmptyList myEmptyList = new EmptyList();
		EmptyList mySecondEmptyList = new EmptyList();
		
		assertEquals("[]", "" + myEmptyList);
		assertEquals(myEmptyList, mySecondEmptyList);
		
		EmptyList l1 = new EmptyList();
		NonEmptyList l2 = new NonEmptyList(30, l1);
		NonEmptyList l3 = new NonEmptyList(20, l2);
		NonEmptyList l4 = new NonEmptyList(10, l3);
		assertEquals(10, l4.getHead());
		assertEquals(l3, l4.getTail());
		assertEquals(20, l3.getHead());
		assertEquals(l2, l3.getTail());
		assertEquals(3, l4.getLength());
		assertEquals("[10,20,30]", l4.toString());
		assertEquals(new NonEmptyList(10, new NonEmptyList(20, new NonEmptyList(30, new EmptyList()))), l4);
		
		//If interfaces of java.util used, then you can use the enhanced for loop
		
		IteratorSelfmade i = l4.iterator();
		assertTrue(i.hasNext());
		assertEquals(10, i.next());
		assertTrue(i.hasNext());
		assertEquals(20, i.next());
		assertTrue(i.hasNext());
		assertEquals(30, i.next());
		assertFalse(i.hasNext());
		
		ArrayList<Object> elements = new ArrayList<>();
		l4.forEach(element -> {
			elements.add(element);
		});
		
		assertEquals(List.of(10, 20, 30), elements);
		
		//Iterator is a generic interface. Better to use Iterator<Integer> if you use the java.util interface.
	}

}
