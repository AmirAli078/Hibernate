package com.hibernnatee;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        // student one is ready
        Student st = new Student();
        st.setId(11);
        st.setName("Tahir");
        st.setCity("Jamshoro");  
        Certificate certi = new Certificate();
        certi.setCourse("Android");
        certi.setDuration("2 Months");
        st.setCerti(certi);

        // student t20 is ready
        Student st1 = new Student();
        st1.setId(12);
        st1.setName("Rafay");
        st1.setCity("Badin");
        Certificate certi1 = new Certificate();
        certi1.setCourse("Python");
        certi1.setDuration("1.5 Months");
        st1.setCerti(certi1);  

        Session s = factory.openSession();
        Transaction tx = s.beginTransaction();
        
        // save both objects
        s.save(st);
        s.save(st1);

        tx.commit();  
        s.close();
        factory.close();
    }
}
