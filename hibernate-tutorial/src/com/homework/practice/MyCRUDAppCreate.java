package com.homework.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MyCRUDAppCreate {

	public static void main(String[] args) {
		
		// create session factory
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
						.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			
			// create new employees
			
			Employee emp1 = new Employee("Mary", "Jane", "Intel");
			Employee emp2 = new Employee("Adam", "Night", "Intel");
			Employee emp3 = new Employee("Bruce", "Wayne", "Wayne Corp");
			Employee emp4 = new Employee("Thor", "Mighty", "Asgard");
			Employee emp5 = new Employee("Hello", "World", "Java");
			
			session.beginTransaction();
			
			session.save(emp1);
			session.save(emp2);
			session.save(emp3);
			session.save(emp4);
			session.save(emp5);
			
			session.getTransaction().commit();
			
			
			
			
		}
		
		finally {
			factory.close();
		}
	}

}
