package teams;

import logicalcollections.*;

/**
 * Represents a student in a team composition graph.
 * 
 * @invar The student-team association is consistent.
 * 		| getTeam() == null || getTeam().getMembers().contains(this)
 */
public class Student {

	/**
	 * Returns this student's team, or null if the student is not in a team.
	 */
	public Team getTeam() {
		
	}
	
	public Student() {
		
	}
	
	/**
	 * Registers the fact that this student is now a member of the given team.
	 * 
	 * @throws IllegalArgumentException if the given team is null.
	 * 		| team == null
	 * @throws IllegalStateException if the student is already in a team.
	 * 		| getTeam() == null
	 * 
	 * @mutates_properties | getTeam(), team.getMembers()
	 * 
	 * @post The give team's set of members equals its old set of members plus this student.
	 * 		| team.getMembers().equals(LogicalSet.plus(old(team.getMembers()), this))
	 */
	public void joinTeam(Team team) {
		
	}
	
	/**
	 * Registers the fact that this student is no longer a member of its team
	 *
	 * @throws IllegalStateException if this student is not in a team
	 * 		| getTeam() == null
	 * 
	 * @mutates_properties | getTeam(), getTeam().getMembers()
	 * 
	 * @post This student is not in a team.
	 * 		| getTeam() == null
	 * @post This student's old team's set of members equals its old set of members minus this student.
	 * 		| old(getTeam()).getMembers().equals(LogicalSet.minus(old(getTeam().getMembers()), this))
	 */
	public void leaveTeam() {
		
	}
	
}
