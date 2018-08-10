package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display the students
			displayStudents(theStudents);
			
			// query students last name
			System.out.println("\nDuck students");
			theStudents = session.createQuery("from Student s where s.lastName='Duck'").getResultList();
			displayStudents(theStudents);
			
			// query students lastname duck or first name john
			System.out.println("\nduck or john:");
			theStudents = 
					session.createQuery("from Student s where s.lastName='Duck' OR s.firstName='John'").getResultList();
			displayStudents(theStudents);
			
			// query like gmail.com
			System.out.println("\nthe gmail ones");
			theStudents = 
					session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
			displayStudents(theStudents);
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("\ndone!");
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}
