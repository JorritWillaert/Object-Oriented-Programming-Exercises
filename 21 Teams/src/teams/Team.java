package teams;

import java.util.Set;

/**
 * Represents a team in a team composition graph.
 * 
 * @invar The student-team association is consistent.
 * 		| getMembers().stream().allMatch(student -> student.getTeam() == this)
 */
public class Team {

	//@creates --> New object OR immutable object
	/**
	 * Returns the set of members of this team.
	 * 
	 * @creates | result
	 * @post | result != null
	 */
	public Set<Student> getMembers() {
		
	}
	
	public Team() {
		
	}
	
}
