package listswithiterator;

import static org.junit.jupiter.api.Assertions.*;

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
		
		//Test external iterator - Exotic method to test since normally you don't do this
		System.out.println("Test external iterator: expected output = 10, 20, 30");
		for (Object element : l4) {
			System.out.println(element);
		}
		
		System.out.println("Test internal iterator: expected output = 10, 20, 30");
		//Test internal iterator with lambda expression
		l4.forEach(element -> System.out.println(element));
	}

}
