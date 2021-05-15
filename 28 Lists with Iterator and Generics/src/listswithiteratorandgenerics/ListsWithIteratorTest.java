package listswithiteratorandgenerics;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ListsWithIteratorTest {

	@Test
	void test() {
		EmptyList<Integer> myEmptyList = new EmptyList<Integer>();
		EmptyList<Integer> mySecondEmptyList = new EmptyList<Integer>();
		
		assertEquals("[]", "" + myEmptyList);
		assertEquals(myEmptyList, mySecondEmptyList);
		
		EmptyList<Integer> l1 = new EmptyList<Integer>();
		NonEmptyList<Integer> l2 = new NonEmptyList<Integer>(30, l1);
		NonEmptyList<Integer> l3 = new NonEmptyList<Integer>(20, l2);
		NonEmptyList<Integer> l4 = new NonEmptyList<Integer>(10, l3);
		assertEquals(10, l4.getHead());
		assertEquals(l3, l4.getTail());
		assertEquals(20, l3.getHead());
		assertEquals(l2, l3.getTail());
		assertEquals(3, l4.getLength());
		assertEquals("[10,20,30]", l4.toString());
		assertEquals(new NonEmptyList<Integer>(10, new NonEmptyList<Integer>(20, new NonEmptyList<Integer>(30, new EmptyList<Integer>()))), l4);
		
		//If interfaces of java.util used, then you can use the enhanced for loop
		
		IteratorSelfmade<Integer> i = l4.iterator();
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
	}

}
