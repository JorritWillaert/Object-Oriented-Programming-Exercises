package lists.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ListsTest {

	@Test
	void test() {
		EmptyList myEmptyList = new EmptyList();
		EmptyList mySecondEmptyList = new EmptyList();
		
		assertEquals("[]", "" + myEmptyList);
		assertEquals(myEmptyList, mySecondEmptyList);
		
		int[] ints = {1, 2, 3};
		NonEmptyList myNonEmptyList = new NonEmptyList(ints);
		int[] otherIntsObject = {1, 2, 3};
		NonEmptyList mySecondNonEmptyList = new NonEmptyList(otherIntsObject);
		
		assertEquals("[1,2,3]", ""+ myNonEmptyList);
		assertEquals(myNonEmptyList, mySecondNonEmptyList);
	}

}
