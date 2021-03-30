package groupwork;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {

	@Test
	void test() {
		Student an = new Student();
		Student bert = new Student();
		an.setTeammate(bert);
		assertEquals(bert, an.getTeammate());
		assertEquals(an, bert.getTeammate());
		bert.clearTeammate();
		assertEquals(null, an.getTeammate());
		assertEquals(null, bert.getTeammate());
	}

}
