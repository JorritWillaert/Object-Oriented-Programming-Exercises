package intlist.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import intlist.IntArray;

class IntArrayTest {

	@Test
	void test() {
		//Note: the tests are the same for IntArray and IntLinkeList, since the API should be the same, regardless of the implementation.
		IntArray myArray = new IntArray();
		assertEquals(0, myArray.getLength());
		myArray.appendElement(4);
		myArray.appendElement(5);
		myArray.appendElement(7);
		assertEquals(3, myArray.getLength());
		assertEquals(5, myArray.getElement(1));
		int[] array = myArray.getArray();
		int[] testArray = {4, 5, 7};
		for (int i = 0; i < myArray.getLength(); i++) {
			assertEquals(array[i], testArray[i]);
		}
		assertEquals(7, myArray.removeLastElement());
		assertEquals(2, myArray.getLength());
		int[] array2 = myArray.getArray();
		int[] testArray2 = {4, 5};
		for (int i = 0; i < myArray.getLength(); i++) {
			assertEquals(array2[i], testArray2[i]);
		}
	}

}
