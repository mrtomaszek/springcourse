package com.homework.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MyCRUDAppRead {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			Employee newEmp = new Employee("Raito", "Yagami", "Death Note");

			session.beginTransaction();

			session.save(newEmp);

			session.getTransaction().commit();

			System.out.println("Saved emp. genereted id: " + newEmp.getId());

			session = factory.getCurrentSession();

			session.beginTransaction();

			Employee tempEmp = session.get(Employee.class, newEmp.getId());

			System.out.println("My employee: " + tempEmp);

			session.getTransaction().commit();

		}

		finally {
			factory.close();
		}
	}

}
