package com.example.demo;

import java.awt.print.Pageable;
import org.springframework.data.domain.PageRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.StudentRepositoryClone;

@Configuration
@SpringBootApplication
@ComponentScan("com.example.demo.*")
@EntityScan(basePackages = {"com.example.demo.entity", "com.example.demo"})
@EnableJpaRepositories(basePackages = {"com.example.demo.repository"})
public class DemoApplication {

	@Autowired
	private StudentRepository studentRepo;
	@Autowired
	private StudentRepositoryClone studentRepo2;
	//private StudentService studentRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner run() throws Exception {
	    return args -> {
	        // Add 3 new students to the database
	    	Student student1 = new Student(1, "John", 20, "cuong@gmail.com", 9.0);
	    	Student student2 = new Student(2, "John Cena", 25, "quan@gmail.com", 8.0);
	    	Student student3 = new Student(3, "Hai", 20, "hai@gmail.com", 9.5);
	    	studentRepo.save(student1);
	    	studentRepo.save(student2);
	    	studentRepo.save(student3);
	    	List<Student> students = (List<Student>) studentRepo.findAll();
	        System.out.println("Students:");
	        for (Student student : students) {
	            System.out.println(student);
	        }
	             
//	        // Update any student's information and print out the results after updating
//	        Student studentToUpdate = students.get(0);
//	        studentToUpdate.setName("Johnny");
//	        studentToUpdate.setAge(21);
//	        studentRepo.save(studentToUpdate);
//	        System.out.println("Updated student: " + studentRepo.findById(studentToUpdate.getId()));
//	        
//	        // Delete a student from the database and print the result after deleting
//	        Student studentToDelete = students.get(1);
//	        studentRepo.delete(studentToDelete);
//	        System.out.println("Deleted student: " + studentToDelete);

	        
	    //--------------------------------------------EX 4-----------------------------------------------------
	        //Uncommented this if you want to test Exercise 4
	        // Read a list of students whose age is greater than or equal to 25
	        List<Student> students_age = studentRepo.findByAgeGreaterThanEqual(25);
	        students_age.forEach(System.out::println);
	        
	        //Count the number of students whose ielts score is equal to 9.0
	        long count = studentRepo.countByIeltsScore(9.0);
	        System.out.println("Number of students with an ielts score of 9.0: " + count);
	        
	        //Find the list of students whose name contains the word "John"
	        List<Student> students_name = studentRepo.findByNameContainingIgnoreCase("John");
	        students_name.forEach(System.out::println);
	        
	   //--------------------------------------------EX 5-----------------------------------------------------
	        //Uncommented this and Uncommented the code in StudentRepository.java file if you want to test Exercise 5
//	        List<Student> students1 = studentRepo.findByAgeGreaterThanOrEqual(20);
//	        students1.forEach(System.out::println);
//        
//	        long count2 = studentRepo.countByIeltsScore(9.0);
//	        System.out.println("Number of students with an ielts score of 9.0: " + count2);
//	        
//	        List<Student> students2 = studentRepo.findByNameContainingIgnoreCase("john");
//	        students2.forEach(System.out::println);
	        
	     //-----------------------------------------------EX6---------------------------------------------------------------------
	     // Read the list of students, sorted in descending order by age. If there are more than one student of the same age, sort them in ascending order according to their ielts scores.
//	        List<Student> sortedStudents = studentRepo2.findAllByOrderByAgeDescIeltsScoreAsc();
//	        System.out.println("Sorted students:");
//	        for (Student student : sortedStudents) {
//	            System.out.println(student);
//	        }	        
	    };
	}
}

