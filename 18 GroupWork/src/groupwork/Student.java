package groupwork;

/**
 * @invar | getTeammate() == null || getTeammate().getTeammate() == this
 */
public class Student {
	
	/**
	 * @invar | teammate == null || teammate.teammate == this
	 * @peerObject
	 */
	private Student teammate; //peerObject: invariant could crash if the teammate sets only its teammate on null --> this.teammate == teammate, but teammate.teammate == null
	//Representation invariant may only talk about its own fields and the fields of its peerObjects.
	
	/**
	 * @post | getTeammate() == null
	 */
	public Student() {}
	
	/**
	 * @peerObject
	 */
	public Student getTeammate() {
		return teammate;
	}
	
	/**
	 * @mutates | this, other
	 * @throws IllegalArgumentException | other == null
	 * @throws IllegalArgumentException | getTeammate() != null
	 * @throws IllegalArgumentException | other.getTeammate() != null
	 * @post | getTeammate() == other
	 */
	public void setTeammate(Student other) { //@mutates | this, other --> this and other not yet in same peer group.
		if (other == null)
			throw new IllegalArgumentException("Teammate may not be null.");
		if (this.teammate != null)
			throw new IllegalArgumentException("Already a teammate assigned.");
		if (other.teammate != null)
			throw new IllegalArgumentException("Teammate already has a teammate.");
		teammate = other;
		other.teammate = this;
	}
	
	/**
	 * @mutates | this
	 * @throws IllegalArgumentException | getTeammate() == null
	 * @post | getTeammate() == null
	 * @post | old(getTeammate()).getTeammate() == null
	 */
	public void clearTeammate() { //@mutates | this --> Only this, because this and other are in the same peer group.
		if (teammate == null)
			throw new IllegalArgumentException("No teammate assigned.");
		teammate.teammate = null;
		teammate = null;
	}
	
}
