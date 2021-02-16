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
		int[] intList = myArray.getArray();
		assertArrayEquals(new int[] {4, 5, 7}, intList);
		intList[0] = 10; //Internal array is not changed. The copy is changed. (Otherwise: representation exposure)
		intList = myArray.getArray();
		assertArrayEquals(new int[] {4, 5, 7}, intList);
		assertEquals(7, myArray.removeLastElement());
		assertEquals(2, myArray.getLength());
		intList = myArray.getArray();
		assertArrayEquals(new int[] {4, 5}, intList);
		
		myArray.setElement(0, 43);
		assertEquals(4, intList[0]); 
		//The first element of the internal array has changed (the representation object), 
		//but intList not! (Because of 'clone' in getArray())
		
		intList = myArray.getArray();
		assertEquals(43, intList[0]); 
	}

}
