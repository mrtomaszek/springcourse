package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// create student object
			System.out.println("create new student object");
			Student tempStudent = new Student("Donald", "Duck", "donald@gmail.com");
			
			// start transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("saving student");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			// new code
			
			// get studetn id
			System.out.println("Saved student. genereted id: " + tempStudent.getId());
			
			//now get a new session and transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve student
			System.out.println("getting student with id: " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			System.out.println("get complete: " + myStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("done!!!");
		}
		finally {
			factory.close();
		}
	}

}
