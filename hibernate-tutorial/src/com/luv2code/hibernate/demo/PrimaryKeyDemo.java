package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// create 3 students object
			System.out.println("create new students object");
			Student tempStudent1 = new Student("John", "Paul", "john@gmail.com");
			Student tempStudent2 = new Student("Long", "John", "long@gmail.com");
			Student tempStudent3 = new Student("Allen", "Walker", "allen@gmail.com");

			// start transaction
			session.beginTransaction();

			// save the student objects
			System.out.println("saving students");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("done");
		} finally {
			factory.close();
		}

	}

}
