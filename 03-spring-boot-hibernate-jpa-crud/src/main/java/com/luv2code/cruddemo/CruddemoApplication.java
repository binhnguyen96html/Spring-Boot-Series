package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.dao.StudentDAOImpl;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			// createStudent(studentDAO);
			 createMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			//	queryForStudents(studentDAO);
			// queryForStudentsByLastName(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO){
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted " + numRowsDeleted + " students");
	}
	private void deleteStudent(StudentDAO studentDAO){
		int studentId = 3;
		System.out.println("Deleting student: " + studentId);
		studentDAO.delete(studentId);
	}
	private void updateStudent(StudentDAO studentDAO){
		//retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change first name to "Thanh"
		System.out.println("Updating student with id: ");
		myStudent.setFirstName("Thanh");

		// update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("Updated studentL " + myStudent);
	}
	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Nguyen 2");

		//display list of students
		for(Student student : theStudents) {
			System.out.println(student);
		}
	}
	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findAll();

		//display list of students
		for(Student student : theStudents) {
			System.out.println(student);
		}
	}
	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating new student object: ");
		Student tempStudent = new Student("Binh", "Nguyen", "binh@gmail.com");

		//save the student
		System.out.println("Save the student object: ");
		studentDAO.save(tempStudent);

		//display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Successfully created student: " + theId);

		//retrieve student based on the id: primary key
		System.out.println("Retrieving the student object with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		//display student
		System.out.println("Found the student: " + myStudent);
	}
	private void createMultipleStudents(StudentDAO studentDAO) {
		//create multiple students
		System.out.println("Creating new student: ");
		Student tempStudent1 = new Student("Binh 2", "Nguyen 2", "binh2@gmail.com");
		Student tempStudent2 = new Student("Binh 3", "Nguyen 3", "binh3@gmail.com");
		Student tempStudent3 = new Student("Binh 4", "Nguyen 4", "binh4@gmail.com");

		//save the student objects
		System.out.println("Saving student: ");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}
	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student: ");
		Student tempStudent = new Student("Binh", "Nguyen", "binh@gmail.com");

		//save the student object
		System.out.println("Saving the student: ");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Successfully created student: " + tempStudent.getId());
	}

}
