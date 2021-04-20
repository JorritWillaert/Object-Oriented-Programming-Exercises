package examsandrooms;

import java.util.Set;

import logicalcollections.LogicalSet;

/**
 * Represents a room in an exam-room composition graph.
 */
public class Room {
	
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
	 * 		| getExams() == LogicalSet.plus(old(getExams()), exam)
	 */
	public void addExam(Exam exam) {
		
	}
	
	/**
	 * Register the fact that an exam will be cancelled in this room.
	 * 
	 * @throws IllegalArgumentException if the given exam is null.
	 * 		| exam == null
	 * @throws IllegalStateException if the given room was not assigned for this exam
	 * 		| !(getExams().contains(exam))
	 * 
	 * @mutates | this
	 * 
	 * @post The given room is removed from the set of rooms where this exam takes place. The other rooms are not changed.
	 * 		| getExams() == LogicalSet.minus(old(getExams()), exam)
	 */
	public void removeExam(Exam exam) {
		
	}

}
