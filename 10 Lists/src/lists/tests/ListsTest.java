package lists.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ListsTest {

	@Test
	void test() {
		EmptyList myEmptyList = new EmptyList();
		int[] ints = {1, 2, 3};
		NonEmptyList myNonEmptyList = new NonEmptyList(ints);
	}

}
