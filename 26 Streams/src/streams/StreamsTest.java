package streams;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class Exam {
	int score;
}

class Student {
	String name;
	int credits;
	List<Exam> exams;
}

class MasterStudent extends Student {
	
}

class StreamsTest {

	List<Student> students = null; //Won't really make. Just show how the construction.
	
	@Test
	void test() {
		students.stream().allMatch(student -> student.exams.size() >= 5); //Did all the students in the list made at least five exams?
		students.stream().anyMatch(student -> student.exams.size() >= 5); //Did any student from the list made at least five exams?
		List<Student> studentsWithFiveExams = students.stream().filter(student 
				-> student.exams.size() >= 5).collect(Collectors.toList()); //Collect all students who made at least five exams.
		List<Student> studentsSorted = students.stream().sorted((s1, s2) 
				-> Integer.compare(s1.credits, s2.credits)).collect(Collectors.toList()); //Sort all students on their credits.
		//(Note: Comparable not implemented in Student, so implement this here.)
		
		List<String> names = students.stream().map(student -> student.name).collect(Collectors.toList()); //Collect all names from the students.
		int totalCredits = students.stream().mapToInt(student -> student.credits).sum(); //Sum the credits of all the students.
		int productCredits = students.stream().mapToInt(student -> student.credits).reduce(1, (c1, c2) -> c1 * c2); //Reduce stream to one value.
		//Neutral element (= 1 here) is for the case that it the stream is empty. Then reduce by using the operator.
		
		List<Exam> exams = students.stream().flatMap(student 
				-> student.exams.stream()).collect(Collectors.toList()); //Create a new stream for every element. FlatMap chains them all together.
		
		//Especially useful for combining map and filter
		List<MasterStudent> masterstudents = students.stream().flatMap(s 
				-> s instanceof MasterStudent ? Stream.of((MasterStudent)s) : Stream.of()).collect(Collectors.toList()); //Stream of Students to stream of MasterStudents.
		
		Student student100Credits = students.stream().filter(s -> s.credits >= 100).findAny().orElse(null); //Return any student who has at least 100 credits.
		//Uses an optional --> returns student if exists, ortherwise null.
		
		Student firstStudent100Credits = students.stream().filter(s 
				-> s.credits >= 100).findAny().orElse(null); //Find the first student in the list who has at least 100 credits.
		List<MasterStudent> firstTenMasterstudents = students.stream().flatMap(s 
				-> s instanceof MasterStudent ? Stream.of((MasterStudent)s) : Stream.of())
				.limit(10).collect(Collectors.toList()); //Only the first ten masterstudents. Streams are lazy, flatmap won't be executed on the other students.
		//Stream just captures everything. Only 'executed' at collect().
		
		Student[] studentsArray = students.stream().toArray(n -> new Student[n]); //Needs to say that it has to create an array of Students.
	}

}
