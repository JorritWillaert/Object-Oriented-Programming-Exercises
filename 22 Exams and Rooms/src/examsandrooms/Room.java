package examsandrooms;

import java.util.HashSet;
import java.util.Set;

import logicalcollections.LogicalSet;

/**
 * Represents a room in an exam-room composition graph.
 * 
 * @invar | getExams() != null
 * @invar | getExams().stream().allMatch(exam -> exam != null && exam.getRooms().contains(this))
 */
public class Room {
	
	/**
	 * @invar | exams != null
	 * @invar | exams.stream().allMatch(exam -> exam != null)
	 * 
	 * @representationObject
	 */
	private Set<Exam> exams = new HashSet<Exam>();
	
	/**
	 * Create a new room.
	 * 
	 * @post | getExams().isEmpty()
	 */
	public Room() {}
	
	/**
	 * @invar | getExamsInternal().stream().allMatch(exam -> exam.getRoomsInternal().contains(this))
	 * 
	 * @creates | result
	 * @post | result != null
	 * @post | result.stream().allMatch(exam -> exam != null)
	 * 
	 * @peerObjects (package-level)
	 */
	Set<Exam> getExamsInternal() {
		return Set.copyOf(exams);
	}
	
	/**
	 * Return all the exams that take place in this room.
	 * 
	 * @creates | result
	 * @basic
	 * @peerObjects
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
	 * @mutates | this
	 * 
	 * @post The given exam is added to the set of exams that will take place in this room. The other exams are not changed.
	 * 		| getExamsInternal().equals(LogicalSet.plus(old(getExamsInternal()), exam))
	 */
	void addExam(Exam exam) {
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
	 * 		| !(getExamsInternal().contains(exam))
	 * 
	 * @mutates | this
	 * 
	 * @post The given room is removed from the set of rooms where this exam takes place. The other rooms are not changed.
	 * 		| getExamsInternal().equals(LogicalSet.minus(old(getExamsInternal()), exam))
	 */
	void removeExam(Exam exam) {
		if (exam == null)
			throw new IllegalArgumentException("Exam is null.");
		if (!(exams.contains(exam)))
			throw new IllegalStateException("The exam to be removed is not present in the scheduled exams.");
		exams.remove(exam);
	}

}
