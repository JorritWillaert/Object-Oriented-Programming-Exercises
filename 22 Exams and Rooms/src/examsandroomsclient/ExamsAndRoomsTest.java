package examsandroomsclient;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

import examsandrooms.Exam;
import examsandrooms.Room;

class ExamsAndRoomsTest {

	@Test
	void test() {
		Exam exam1 = new Exam();
		Exam exam2 = new Exam();
		Exam exam3 = new Exam();
		Exam exam4 = new Exam();
		
		Room room1 = new Room();
		Room room2 = new Room();
		
		exam1.addRoom(room1);
		exam2.addRoom(room2);
		
		assertEquals(Set.of(room1), exam1.getRooms());
		assertEquals(Set.of(room2), exam2.getRooms());
		assertEquals(Set.of(exam1), room1.getExams());
		assertEquals(Set.of(exam2), room2.getExams());
		assertEquals(Set.of(), exam3.getRooms());
		
		exam3.addRoom(room1);
		exam4.addRoom(room1);
		exam1.addRoom(room2);
		
		assertEquals(Set.of(room1, room2), exam1.getRooms());
		assertEquals(Set.of(exam1, exam3, exam4), room1.getExams());
		assertEquals(Set.of(exam1, exam2), room2.getExams());
	}

}
