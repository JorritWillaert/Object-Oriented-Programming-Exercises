package university;

class Student {
	int nbCredits;
}

class StaffMember {
	int nbPubs;
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
	
	void add(T element) {
		Node node = new Node();
		node.element = element;
		node.next = sentinel;
		node.previous = sentinel.previous;
		node.next.previous = node;
		node.previous.next = node;
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
}

public class University {

	private LinkedList<Student> students = new LinkedList<Student>(); //Instantiated type
	private LinkedList<StaffMember> staffMembers = new LinkedList<StaffMember>(); //Instantiated type
	
	void addStudent(Student student) {
		students.add(student);
	}
	
	boolean hasStudent(Student student) {
		return students.contains(student);
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
	
}
