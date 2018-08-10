package com.homework.practice;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MyCRUDAppQuery {

	public static void main(String[] args) {
		
		// create session factory
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
						.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			
			// create new employees
						
			session.beginTransaction();
			
			List<Employee> compEmp = session.createQuery("from Employee s where s.company='Death Note'").getResultList();		
			
			for(Employee em : compEmp) {
				System.out.println(em);
			}
			
			
			session.getTransaction().commit();
			
			
			
			
		}
		
		finally {
			factory.close();
		}
	}

}
