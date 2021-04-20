package teams;

import java.util.HashSet;
import java.util.Set;
import logicalcollections.*;

/**
 * Represents a team in a team composition graph.
 * 
 * @invar The student-team association is consistent.
 * 		| getMembers().stream().allMatch(student -> student.getTeam() == this)
 */
public class Team {
	
	//We use the convention that we begin by checking all first invariants, then all seconds, ...
	//Use getTeamInternal() --> The public method getTeam() already assumes all invariants to be true. Circular
	//New: most invariants to method getMembersInternal(). Best to see previous commits for the usage of phase 1 & 2
	/**
	 * @invar | members != null
	 * @invar | members.stream().allMatch(s -> s != null)
	 * 
	 * @representationObject (package-level)
	 */
	private Set<Student> members = new HashSet<Student>();
	//Earlier: no keyword = package-accessible -> So, change client to different package
	//Now: Nested abstractions

	/**
	 * Initializes this object to represent a team with no members.
	 * 
	 * @mutates | this
	 * @post | getMembers().isEmpty()
	 */
	public Team() {}
	
	/**
	 * @invar | getMembersInternal().stream().allMatch(s -> s.getTeamInternal() == this)
	 *
	 * @peerObjects (package-level)
	 * 
	 * @post | result != null
	 * @post | result.stream().allMatch(s -> s != null)
	 */
	Set<Student> getMembersInternal() {
		return Set.copyOf(members);
	}
	
	//@creates --> New object OR immutable object
	/**
	 * Returns the set of members of this team.
	 * 
	 * @creates | result
	 * @post | result != null
	 * @post | result.stream().allMatch(s -> s != null)
	 * 
	 * @peerObjects
	 */
	public Set<Student> getMembers() {
		return Set.copyOf(members);
	}
	
	//At the moment these two methods are called --> Not guaranteed that the package level invariants will be true for the peer group.
	//Only the class level invariants are true
	//Since the public getters may assume that all invariants are true (also package level), can't we use them in the post condition.
	//Can't use getMembers() (= public method)
	/**
	 * Adds the given student to this team's set of members.
	 * 
	 * @throws IllegalArgumentException if the given student is null.
	 * 		| student == null
	 * @mutates | this //Note: on private field members not a peergroup annotation --> Class level peer group on this level is only this! Not the whole package level peergroup.
	 * @post | getMembersInternal().equals(LogicalSet.plus(old(getMembersInternal()), student))
	 */
	void addStudent(Student student) {
		if (student == null)
			throw new IllegalArgumentException("Student is null");
		members.add(student);
	}
	
	/**
	 * Removes the given student from this team's set of members.
	 * 
	 * @throws IllegalArgumentException if the given student is null.
	 * 		| student == null
	 * @mutates | this
	 * @post | getMembersInternal().equals(LogicalSet.minus(old(getMembersInternal()), student))
	 */
	void removeStudent(Student student) {
		if (student == null)
			throw new IllegalArgumentException("Student is null");
		members.remove(student);
	}
	
}
