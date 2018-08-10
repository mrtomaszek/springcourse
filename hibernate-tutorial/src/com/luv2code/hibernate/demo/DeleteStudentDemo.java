package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			// delete the student
			// session.delete(myStudent);
			// System.out.println("deleting student " + myStudent);
			
			// delete student wit id=2
			System.out.println("deleting student id=2");
			session.createQuery("delete from Student where id=2").executeUpdate();
						
			//commit transaction
			session.getTransaction().commit();
			
			
			System.out.println("done!!!");
		}
		finally {
			factory.close();
		}
	}

}
