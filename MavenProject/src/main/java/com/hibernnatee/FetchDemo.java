package com.hibernnatee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

    public static void main(String[] args) {
        // Load Hibernate configuration
         SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            // Open a new session
            Session session = factory.openSession();
                // Retrieve the address with ID 1 from the database
                Student  st = session.get(Student.class, 103);
                // Print the retrieved address
                System.out.println(st);
                Address ad=session.get(Address.class, 1);
                System.out.println(ad);
                System.out.println(ad.getCity());
        }
    }
