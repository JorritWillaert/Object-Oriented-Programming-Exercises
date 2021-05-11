package university;

import java.util.function.IntFunction;

interface Comparable<T> {
	
	/**
	 * Returns a negative number, zero, or a positive number if this object is less than, equal to, or greater than {@code other}.
	 */
	int compareTo(T other);
}

class Member {
	
}

class Student extends Member implements Comparable<Student> {
	int nbCredits;
	
	@Override
	public int compareTo(Student other) {
		return nbCredits - other.nbCredits;
	}
}

class StaffMember extends Member implements Comparable<StaffMember> {
	int nbPubs;
	
	@Override
	public int compareTo(StaffMember other) {
		return nbPubs - other.nbPubs;
	}
}

interface Iterator<E> {
	boolean hasNext();
	E next();
}

class LinkedList<T> {
	
	class Node { //Need to write Node<T> if you use static classes. Not needed if inner class is used (now used)
		Node previous;
		T element;
		Node next;
	}
	
	Node sentinel;
	
	LinkedList() {
		sentinel = new Node();
		sentinel.next = sentinel;
		sentinel.previous = sentinel;
	}
	
	//Note: Generics are used only for the static type checking. Once running, everything is changed in "Object".
	//This means that it is not possible to make: T[] toArray() {}
	T[] toArray(IntFunction<T[]> generator) {
		//T[] result = new T[10]; //You can't create an array where the element type is a type parameter. Because the element type of an array must be known at runtime.
		T[] result = generator.apply(10);
		return result;
	}
	
	void add(T element) {
		Node node = new Node();
		node.element = element;
		node.next = sentinel;
		node.previous = sentinel.previous;
		node.next.previous = node;
		node.previous.next = node;
	}
	
	@SuppressWarnings("unchecked")
	void addObject(Object element) { //Do this only if you're sure that this cast will always succeed at runtime
		add((T)element); //Unchecked cast; No runtime check
	}
	
	boolean contains(T element) {
		for (Node n = sentinel.next; n != sentinel; n = n.next)
			if (n.element == element)
				return true;
		return false;
	}
	
	Iterator<T> iterator() {
		return new Iterator<T>() {
			Node node = sentinel.next;
			
			@Override
			public boolean hasNext() {
				return node != sentinel;
			}
			
			@Override
			public T next() {
				T result = node.element;
				node = node.next;
				return result;
			}
		};
	}
	
	void copyTo(LinkedList<? super T> other) { //Lower-bounded wildcard - OK as long as it is a super type of T. (So here, Member is a supertype of Student)
		for (Iterator<T> i = iterator(); i.hasNext(); )
			other.add(i.next());
	}
	
	void addAll(LinkedList<? extends T> other) { //Upper-bouned wildcard - OK as long as it is a sub type of T. (So here, StaffMember is a subtype of Member)
		for (Iterator<? extends T> i = other.iterator(); i.hasNext(); )
			add(i.next());
	}
	
	//Also possible: LinkedList<T> from, LinkedList<? super T> to - You may also use both at once
	static <T> void copy(LinkedList<? extends T> from, LinkedList<T> to) { //Linked list where you're copying to must be a super type of where you copy from. Note the parameter <T> after static!
		from.copyTo(to);
	}
}

class SortedLinkedList<T extends Comparable<T>> extends LinkedList<T> { //"T extends Comparable<T>": T must be comparable with itself (Type bound). T is a bounded type parameter
	
	@Override
	void add(T element) {
		Node n = sentinel.next;
		while (n != sentinel && n.element.compareTo(element) < 0)
			n = n.next;
		Node node = new Node();
		node.previous = n.previous;
		node.next = n;
		node.element = element;
		node.next.previous = node;
		node.previous.next = node;
	}
	
}

public class University {

	private LinkedList<Student> students = new SortedLinkedList<Student>(); //Instantiated type
	private LinkedList<StaffMember> staffMembers = new SortedLinkedList<StaffMember>(); //Instantiated type
	
	void addStudent(Student student) {
		students.add(student);
	}
	
	boolean hasStudent(Student student) {
		return students.contains(student);
	}
	
	Student[] getStudentsAsArray() {
		return students.toArray(n -> new Student[n]);
	}
	
	int averageNbCredits() {
		int nbCredits = 0;
		int nbStudents = 0;
		for (Iterator<Student> i = students.iterator(); i.hasNext(); ) {
			nbCredits += i.next().nbCredits;
			nbStudents++;
		}
		return nbCredits / nbStudents;
	}
	
	void addStaffMember(StaffMember staffMember) {
		staffMembers.add(staffMember);
		//students.addObject(staffMember) //No exception at runtime due to unchecked cast (heap pollution - add wrong types to generic collection)
	}
	
	boolean hasStafMember(StaffMember staffMember) {
		return staffMembers.contains(staffMember);
	}
	
	int totalNbPubs() {
		int result = 0;
		for (Iterator<StaffMember> i = staffMembers.iterator(); i.hasNext();)
			result += i.next().nbPubs;
		return result;
	}
	
	/**
	 * Return all members of the university (students & staffmembers).
	 */
	LinkedList<Member> getAllMembers() {
		LinkedList<Member> result = new LinkedList<Member>();
		
		//Let's implement two different methods for this
		students.copyTo(result); //Give a LinkedList of Member - Allowed due to lower-bounded wildcard.
		//result.addAll(staffMembers); //Generics are invariant
		
		//Another method to try (static now)
		LinkedList.copy(staffMembers, result);
		return result;
	}
	
}
