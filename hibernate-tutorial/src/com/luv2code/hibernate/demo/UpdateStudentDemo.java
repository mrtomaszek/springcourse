package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			
			int studentId = 1;
			
			
			//now get a new session and transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student
			System.out.println("getting student with id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("get complete: " + myStudent);
			
			System.out.println("updating student...");
			
			myStudent.setFirstName("Scooby");
			
			//commit transaction
			session.getTransaction().commit();
			
			// new code
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// update email for all
			System.out.println("updating email for all");
			
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("done!!!");
		}
		finally {
			factory.close();
		}
	}

}
