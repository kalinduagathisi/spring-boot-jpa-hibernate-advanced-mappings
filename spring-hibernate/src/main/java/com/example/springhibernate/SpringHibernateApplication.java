package com.example.springhibernate;

import com.example.springhibernate.dao.AppDAO;
import com.example.springhibernate.entity.Course;
import com.example.springhibernate.entity.Instructor;
import com.example.springhibernate.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner-> {
			createInstructor(appDAO);
//			findInstructorById(appDAO);
//			deleteInstructorById(appDAO);
//			findByInstructorDetailId(appDAO);
//			deleteByInstructorDetails(appDAO);
		};
	}

	private void deleteByInstructorDetails(AppDAO appDAO) {
		int id = 2;
		appDAO.deleteByInstructorDetails(2);
		System.out.println("Instructor detils and Instructor deleted of ID: "+ id);
	}

	private void findByInstructorDetailId(AppDAO appDAO) {
		int id = 3;
		InstructorDetail instructorDetailToBeFound = appDAO.findByInstructorDetailID(id);
//		System.out.println("Instructor found by instructor details: "+ instructorDetailToBeFound);
		System.out.println("The instructor: "+ instructorDetailToBeFound.getInstructor());
	}

	private void deleteInstructorById(AppDAO appDAO) {
		int id = 1;
		appDAO.deleteById(id);
		System.out.println("Instructor deleted.. ID: "+id);
	}

	private void findInstructorById(AppDAO appDAO) {
		int id = 2;
		Instructor instructorToBeFound = appDAO.findByID(id);

		System.out.println("Instructor found: "+ instructorToBeFound);
		System.out.println("Instructor details: "+ instructorToBeFound.getInstructorDetail());
	}


	private void createInstructor(AppDAO appDAO) {

		// create instructor
		Instructor instructor = new Instructor("Garry", "Smith", "gsmith@gmai.com");

		// create instructor details
		InstructorDetail instructorDetail = new InstructorDetail("garyCode", "coding");

		// set instructor details to the instructor object
		instructor.setInstructorDetail(instructorDetail);

		// set course details
//		Course course1 = new Course("Spring boot");
		Course course2 = new Course("django");
		Course course3 = new Course("express js");

//		instructor.add(course1);
		instructor.add(course2);
		instructor.add(course3);

		// saving instructor
		// this will save instructor details object also,
		// because cascadeType.ALL

		System.out.println("Saving instructor..");

		appDAO.save(instructor);

		System.out.println("Instructor saved successfully..");
	}

}
