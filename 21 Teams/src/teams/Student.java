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
	//New: most invariants to method getTeamInternal(). Best to see previous commits for the usage of phase 1 & 2
	//Now: phases not longer needed. Class invariants are always checked before package invariants
	private Team team;
	//Earlier: no keyword = package-accessible -> So, change client to different package
	//Now: Nested abstractions
	
	/**
	 * Initializes this object to represent a student that is not in a team.
	 * 
	 * @mutates | this
	 * @post | getTeam() == null
	 */
	public Student() {}
	
	/**
	 * @invar | getTeamInternal() == null || getTeamInternal().getMembersInternal().contains(this)
	 * 
	 * @peerObject (package-level)
	 */
	Team getTeamInternal() {
		return team;
	}
	
	/**
	 * Returns this student's team, or null if the student is not in a team.
	 * 
	 * @peerObject (package-level)
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
		team.addStudent(this);
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
		team.removeStudent(this);
		team = null;
	}
	
}
