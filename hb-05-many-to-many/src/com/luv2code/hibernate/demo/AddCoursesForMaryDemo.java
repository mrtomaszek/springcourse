package com.luv2code.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

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
			
			int theId = 2;
			
			Student tempStudent = session.get(Student.class, theId);
			
			System.out.println("loaded: " + tempStudent);
			
			Course course1 = new Course("Rubik's Cube - speed cube");
			Course course2 = new Course("Atari 2600 - game development");
			
			course1.addStudent(tempStudent);
			course2.addStudent(tempStudent);
			
			System.out.println("saving courses...");
			session.save(course1);
			session.save(course2);
			
			System.out.println("saved");
			
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
