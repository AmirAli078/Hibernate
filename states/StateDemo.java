package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernnatee.Certificate;
import com.hibernnatee.Student;

public class StateDemo {

	public static void main(String[] args) {
		// hibernate state practical 
		//Transiant state
		//persistent state
		//detched state
		//removed state 
		
		System.out.println("project is started....");
		
		SessionFactory factory =new Configuration().configure().buildSessionFactory();
		
		// creating a object of student 
		
		Student st=new Student();
		st.setId(3456);
		st.setName("Aslam");
		st.setCity("Moro");
		st.setCerti(new Certificate("Java","2 months"));
		// now it is at transient state. it is not note in database and not in session objt
		
		Session session=factory.openSession();
	    Transaction tx=session.beginTransaction();
		session.save(st);
		// at persistent state you can chage the value of entities 
		st.setName("Saeed");
		tx.commit();
		// now it is in Persistent state now the data is in Database  --also in---session object
		session.close();
		// now session is close and now you are at ------deteched state------now you can not chnage in database but you can change in sesion
		
		st.setName("Ubaid");
		System.out.println(st);
	
		factory.close();

	}

}
