package intlist.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import intlist.IntLinkedList;

class IntLinkedListTest {

	@Test
	void test() {
		//Note: the tests are the same for IntArray and IntLinkeList, since the API should be the same, regardless of the implementation. 
		IntLinkedList myLinkedList = new IntLinkedList();
		assertEquals(0, myLinkedList.getLength());
		myLinkedList.appendElement(4);
		myLinkedList.appendElement(5);
		myLinkedList.appendElement(7);
		assertEquals(3, myLinkedList.getLength());
		assertEquals(5, myLinkedList.getElement(1));
		int[] array = myLinkedList.getArray();
		int[] testArray = {4, 5, 7};
		for (int i = 0; i < myLinkedList.getLength(); i++) {
			assertEquals(array[i], testArray[i]);
		}
		assertEquals(7, myLinkedList.removeLastElement());
		assertEquals(2, myLinkedList.getLength());
		int[] array2 = myLinkedList.getArray();
		int[] testArray2 = {4, 5};
		for (int i = 0; i < myLinkedList.getLength(); i++) {
			assertEquals(array2[i], testArray2[i]);
		}
	}

}
