package examsandrooms;

import java.util.HashSet;
import java.util.Set;

import logicalcollections.LogicalSet;

/**
 * Represents a room in an exam-room composition graph.
 */
public class Room {
	
	/**
	 * @invar | exams != null
	 * 
	 * @peerObjects
	 * @representationObject
	 */
	private Set<Exam> exams = new HashSet<>();
	
	/**
	 * Create a new room.
	 * 
	 * @post | getExams().equals(Set.of())
	 */
	public Room() {}
	
	/**
	 * Return all the exams that take place in this room.
	 * 
	 * @basic
	 * @peerObjects
	 * 
	 * @post | result != null
	 */
	public Set<Exam> getExams() {
		return Set.copyOf(exams);
	}
	
	/**
	 * Register the fact that an exam will be made in this room.
	 * 
	 * @throws IllegalArgumentException if the given exam is null.
	 * 		| exam == null
	 * 
	 * @mutates_properties | getExams(), exam.getRooms()
	 * 
	 * @post The given exam is added to the set of exams that will take place in this room. The other exams are not changed.
	 * 		| getExams().equals(LogicalSet.plus(old(getExams()), exam))
	 * @post This room is added to the given exam. The other rooms are not changed.
	 * 		| exam.getRooms().equals(LogicalSet.plus(old(exam.getRooms()), this))
	 */
	public void addExam(Exam exam) {
		if (exam == null)
			throw new IllegalArgumentException("Exam is null.");
		exams.add(exam);
		exam.addRoomOnly(this);
	}
	
	/**
	 * Just add a given exam, don't bother about consistency.
	 * 
	 * @throws IllegalArgumentException if the given exam is null.
	 * 		| exam == null
	 * 
	 * @mutates_properties | getExams()
	 * 
	 * @post The given exam is added to the set of exams that will take place in this room. The other exams are not changed.
	 * 		| getExams().equals(LogicalSet.plus(old(getExams()), exam))
	 */
	void addExamOnly(Exam exam) {
		if (exam == null)
			throw new IllegalArgumentException("Exam is null.");
		exams.add(exam);
	}
	
	/**
	 * Register the fact that an exam will be cancelled in this room.
	 * 
	 * @throws IllegalArgumentException if the given exam is null.
	 * 		| exam == null
	 * @throws IllegalStateException if the given room was not assigned for this exam.
	 * 		| !(getExams().contains(exam))
	 * @throws IllegalStateException if the corresponding rooms of the given exam does not contain this room.
	 * 		| !(exam.getRooms().contains(this))
	 * 
	 * @mutates_properties | getExams(), exam.getRooms()
	 * 
	 * @post The given room is removed from the set of rooms where this exam takes place. The other rooms are not changed.
	 * 		| getExams().equals(LogicalSet.minus(old(getExams()), exam))
	 * @post This room is added to the given exam. The other rooms are not changed.
	 * 		| exam.getRooms().equals(LogicalSet.minus(old(exam.getRooms()), this))
	 */
	public void removeExam(Exam exam) {
		if (exam == null)
			throw new IllegalArgumentException("Exam is null.");
		if (!(exams.contains(exam)))
			throw new IllegalStateException("The exam to be removed is not present in the scheduled exams.");
		if (!(exam.getRooms().contains(this)))
			throw new IllegalStateException("The corresponding rooms of the given exam does not contain this room.");
		exams.remove(exam);
		exam.removeRoomOnly(this);
	}
	
	/**
	 * Just remove a given exam, don't bother about consistency.
	 * 
	 * @throws IllegalArgumentException if the given exam is null.
	 * 		| exam == null
	 * @throws IllegalStateException if the given room was not assigned for this exam.
	 * 		| !(getExams().contains(exam))
	 * 
	 * @mutates_properties | getExams()
	 * 
	 * @post The given room is removed from the set of rooms where this exam takes place. The other rooms are not changed.
	 * 		| getExams().equals(LogicalSet.minus(old(getExams()), exam))
	 */
	void removeExamOnly(Exam exam) {
		if (exam == null)
			throw new IllegalArgumentException("Exam is null.");
		if (!(exams.contains(exam)))
			throw new IllegalStateException("The exam to be removed is not present in the scheduled exams.");
		exams.remove(exam);
	}

}
