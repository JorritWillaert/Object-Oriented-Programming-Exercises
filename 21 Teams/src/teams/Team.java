package teams;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a team in a team composition graph.
 * 
 * @invar The student-team association is consistent.
 * 		| getMembers().stream().allMatch(student -> student.getTeam() == this)
 */
public class Team {
	
	//We use the convention that we begin by checking all first invariants, then all seconds, ...
	/**
	 * @invar | members != null //Phase 1
	 * @invar | members.stream().allMatch(s -> s != null && s.team == this) //Phase 2
	 * 
	 * @representationObject
	 * @peerObjects
	 */
	Set<Student> members = new HashSet<Student>(); //No keyword = package-accessible -> So, change client to different package

	public Team() {}
	
	//@creates --> New object OR immutable object
	/**
	 * Returns the set of members of this team.
	 * 
	 * @creates | result
	 * @post | result != null
	 * 
	 * @peerObjects
	 */
	public Set<Student> getMembers() {
		return Set.copyOf(members);
	}
	
}
