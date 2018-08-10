package com.luv2code.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start transaction
			session.beginTransaction();
			
			Course tempCourse = new Course("Pacman - how to win");
			
			System.out.println("Saving course...");
			session.save(tempCourse);
			System.out.println("saved");
			
			Student tempStudent1 = new Student("John", "Doe", "doe@gmail.com");
			Student tempStudent2 = new Student("Mary", "Poppins", "poppy@gmail.com");
			
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			System.out.println("saving students..");
			
			session.save(tempStudent1);
			session.save(tempStudent2);
			
			System.out.println("saved");
			
			System.out.println(tempCourse.getStudents());
			
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("done");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
