package com.homework.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MyCRUDAppDelete {

	public static void main(String[] args) {
		
		// create session factory
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
						.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			
			int empId = 8;
			
			session.beginTransaction();
			
			Employee delEmp = session.get(Employee.class, empId);
			
			session.delete(delEmp);
			
			session.getTransaction().commit();
			
			
			
			
		}
		
		finally {
			factory.close();
		}
	}

}
