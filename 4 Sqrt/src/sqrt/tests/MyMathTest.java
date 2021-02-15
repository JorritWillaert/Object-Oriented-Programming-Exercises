package sqrt.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sqrt.MyMath;

class MyMathTest {

	@Test
	void test() {
		assertEquals(3, MyMath.sqrt(9));
	}

}
