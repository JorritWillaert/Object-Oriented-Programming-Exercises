package teams;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

class TeamsTest {

	@Test
	void test() {
		Student student1 = new Student();
		Student student2 = new Student();
		Student student3 = new Student();
		Team team1 = new Team();
		Team team2 = new Team();
		
		student1.joinTeam(team1);
		student2.joinTeam(team2);
		student3.joinTeam(team2);
		
		assertEquals(Set.of(student1), team1.getMembers());
		assertEquals(Set.of(student2, student3), team2.getMembers());
		
		student3.leaveTeam();
		assertEquals(Set.of(student2), team2.getMembers());
	}

}
