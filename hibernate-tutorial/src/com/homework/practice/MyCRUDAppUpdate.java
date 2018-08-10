package com.homework.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MyCRUDAppUpdate {

	public static void main(String[] args) {
		
		// create session factory
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
						.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			
			int empId = 6;
			
			session.beginTransaction();
			
			Employee tempEmp = session.get(Employee.class, empId);
			
			tempEmp.setFirstName("Yama");
			tempEmp.setLastName("Kuro");
			
			session.getTransaction().commit();
			
			
			
			
		}
		
		finally {
			factory.close();
		}
	}

}
