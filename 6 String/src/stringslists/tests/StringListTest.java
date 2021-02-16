package stringslists.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import stringslists.StringList;

class StringListTest {

	@Test
	void test() {
		String[] myStrings = {"Hello", "Bye"};
		StringList myStringList = new StringList(myStrings);
		
		
		//myStrings[0] = null;
		//assertThrows(NullPointerException.class, () ->
		//		myStringList.getConcatenation());	
		//This test succeeds if the constructor does not clone elements!
	}

}
