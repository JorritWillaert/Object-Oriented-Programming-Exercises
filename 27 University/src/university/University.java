package university;

class Student {
	int nbCredits;
}

class StaffMember {
	int nbPubs;
}

interface Iterator {
	boolean hasNext();
	Object next();
}

class LinkedList {
	
	static class Node {
		Node previous;
		Object element;
		Node next;
	}
	
	Node sentinel;
	
	LinkedList() {
		sentinel = new Node();
		sentinel.next = sentinel;
		sentinel.previous = sentinel;
	}
	
	void add(Object element) {
		Node node = new Node();
		node.element = element;
		node.next = sentinel;
		node.previous = sentinel.previous;
		node.next.previous = node;
		node.previous.next = node;
	}
	
	boolean contains(Object element) {
		for (Node n = sentinel.next; n != sentinel; n = n.next)
			if (n.element == element)
				return true;
		return false;
	}
	
	Iterator iterator() {
		return new Iterator() {
			Node node = sentinel.next;
			
			@Override
			public boolean hasNext() {
				return node != sentinel;
			}
			
			@Override
			public Object next() {
				Object result = node.element;
				node = node.next;
				return result;
			}
		};
	}
}

public class University {

	private LinkedList students = new LinkedList();
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
		for (Iterator i = students.iterator(); i.hasNext(); ) {
			nbCredits += ((Student)i.next()).nbCredits;
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
		for (Iterator i = staffMembers.iterator(); i.hasNext();)
			result += ((StaffMember)i.next()).nbPubs;
		return result;
	}
	
}
