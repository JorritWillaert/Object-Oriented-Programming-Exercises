package teams;

import logicalcollections.*;

/**
 * Represents a student in a team composition graph.
 * 
 * @invar The student-team association is consistent.
 * 		| getTeam() == null || getTeam().getMembers().contains(this)
 */
public class Student {
	
	//Note: if you write: @invar | team == null || team.members.contains(this)	--> Possible null pointer exception (invariant in team (members != null) may be checked later)
	//We use the convention that we begin by checking all first invariants, then all seconds, ... --> Add dummy invariant
	/**
	 * @invar | true //Phase 1
	 * @invar | team == null || team.members.contains(this) //Phase 2
	 * 
	 * @peerObject
	 */
	Team team; //No keyword = package-accessible -> So, change client to different package
	
	public Student() {}
	
	/**
	 * Returns this student's team, or null if the student is not in a team.
	 * 
	 * @peerObject
	 */
	public Team getTeam() {
		return team;
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
		if (team == null)
			throw new IllegalArgumentException("Team is null");
		if (this.team != null)
			throw new IllegalArgumentException("Student already in team");
		this.team = team;
		team.members.add(this);
	}
	
	/**
	 * Registers the fact that this student is no longer a member of its team.
	 *
	 * @throws IllegalStateException if this student is not in a team.
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
		if (team == null)
			throw new IllegalStateException("Not in a team");
		team.members.remove(this);
		team = null;
	}
	
}
