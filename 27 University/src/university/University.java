package university;

class Student {
	int nbCredits;
}

class StaffMember {
	int nbPubs;
}

interface IteratorOfStudent {
	boolean hasNext();
	Student next();
}

class LinkedListOfStudent {
	
	static class Node {
		Node previous;
		Student element;
		Node next;
	}
	
	Node sentinel;
	
	LinkedListOfStudent() {
		sentinel = new Node();
		sentinel.next = sentinel;
		sentinel.previous = sentinel;
	}
	
	void add(Student student) {
		Node node = new Node();
		node.element = student;
		node.next = sentinel;
		node.previous = sentinel.previous;
		node.next.previous = node;
		node.previous.next = node;
	}
	
	boolean contains(Student student) {
		for (Node n = sentinel.next; n != sentinel; n = n.next)
			if (n.element == student)
				return true;
		return false;
	}
	
	IteratorOfStudent iterator() {
		return new IteratorOfStudent() {
			Node node = sentinel.next;
			
			@Override
			public boolean hasNext() {
				return node != sentinel;
			}
			
			@Override
			public Student next() {
				Student result = node.element;
				node = node.next;
				return result;
			}
		};
	}
}

public class University {

	private LinkedListOfStudent students = new LinkedListOfStudent();
	private LinkedList staffMembers = new LinkedList();
	
	void addStudent(Student student) {
		students.add(student);
	}
	
	boolean hasStudent(Student student) {
		return students.contains(student);
	}
	
	int averageNbCredits() {
		int nbCredits = 0;
		int nbStudents = 0;
		for (IteratorOfStudent i = students.iterator(); i.hasNext(); ) {
			nbCredits += i.next().nbCredits;
			nbStudents++;
		}
		return nbCredits / nbCredits;
	}
	
	void addStaffMember(StaffMember staffMember) {
		
	}
	
	boolean hasStafMember(StaffMember staffMember) {
		
	}
	
	int totalNbPubs() {
		
	}
}
