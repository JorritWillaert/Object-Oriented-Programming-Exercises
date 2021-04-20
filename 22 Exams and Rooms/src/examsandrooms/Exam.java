package examsandrooms;

import java.util.HashSet;
import java.util.Set;
import logicalcollections.LogicalSet;

/**
 * Represents an exam in an exam-room composition graph.
 */
public class Exam {
	
	/**
	 * @invar | rooms != null
	 * 
	 * @peerObjects
	 * @representationObject
	 */
	Set<Room> rooms = new HashSet<>();
	
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
		return Set.copyOf(rooms);
	}
	
	/**
	 * Register the fact that an exam will be made in the given room.
	 * 
	 * @throws IllegalArgumentException if the given room is null.
	 * 		| room == null
	 * 
	 * @mutates_properties | getRooms(), room.getExams()
	 * 
	 * @post The given room is added to the set of rooms where this exam takes place. The other rooms are not changed.
	 * 		| getRooms().equals(LogicalSet.plus(old(getRooms()), room))
	 * @post This exam is added to the given room. The other exams are not changed.
	 * 		| room.getExams().equals(LogicalSet.plus(old(room.getExams()), this))
	 */
	public void addRoom(Room room) {
		if (room == null)
			throw new IllegalArgumentException("Room is null.");
		rooms.add(room);
		room.exams.add(this);
	}
	
	/**
	 * Register the fact that an exam will be cancelled in the given room.
	 * 
	 * @throws IllegalArgumentException if the given room is null.
	 * 		| room == null
	 * @throws IllegalStateException if the given room was not assigned for this exam
	 * 		| !(getRooms().contains(room))
	 * 
	 * @mutates_properties | getRooms(), room.getExams()
	 * 
	 * @post The given room is removed from the set of rooms where this exam takes place. The other rooms are not changed.
	 * 		| getRooms().equals(LogicalSet.minus(old(getRooms()), room))
	 * @post This exam is removed from the given room. The other exams are not changed.
	 * 		| room.getExams().equals(LogicalSet.minus(old(room.getExams()), this))
	 */
	public void removeRoom(Room room) {
		if (room == null)
			throw new IllegalArgumentException("Room is null.");
		if (!(rooms.contains(room)))
			throw new IllegalStateException("The room to be removed is not present in the planned rooms.");
		rooms.remove(room);
		room.exams.remove(this);
	}

}
