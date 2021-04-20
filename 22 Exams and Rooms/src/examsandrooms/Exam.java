package examsandrooms;

import java.util.Set;
import logicalcollections.LogicalSet;

/**
 * Represents an exam in an exam-room composition graph.
 */
public class Exam {
	
	/**
	 * Create a new exam.
	 * 
	 * @post | getRooms().equals(Set.of())
	 */
	public Exam() {}
	
	/**
	 * Return all the rooms where this exam takes place.
	 * 
	 * @basic
	 * @peerObjects
	 * 
	 * @post | result != null
	 */
	public Set<Room> getRooms() {
		
	}
	
	/**
	 * Register the fact that an exam will be made in the given room.
	 * 
	 * @throws IllegalArgumentException if the given room is null.
	 * 		| room == null
	 * 
	 * @mutates | this
	 * 
	 * @post The given room is added to the set of rooms where this exam takes place. The other rooms are not changed.
	 * 		| getRooms() == LogicalSet.plus(old(getRooms()), room)
	 */
	public void addRoom(Room room) {
		
	}
	
	/**
	 * Register the fact that an exam will be cancelled in the given room.
	 * 
	 * @throws IllegalArgumentException if the given room is null.
	 * 		| room == null
	 * @throws IllegalStateException if the given room was not assigned for this exam
	 * 		| !(getRooms().contains(room))
	 * 
	 * @mutates | this
	 * 
	 * @post The given room is removed from the set of rooms where this exam takes place. The other rooms are not changed.
	 * 		| getRooms() == LogicalSet.minus(old(getRooms()), room)
	 */
	public void removeRoom(Room room) {
		
	}

}
