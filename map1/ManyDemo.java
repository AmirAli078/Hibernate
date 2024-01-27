package com.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyDemo {

	public static void main(String[] args) {
		 Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        SessionFactory factory = cfg.buildSessionFactory();
             Empolyee emp=new Empolyee();
             Empolyee emp1=new Empolyee();
	        // add employee one 
             emp.setEid(8);
             emp.setName("Inam");
      //add empolyee 2
             emp1.setEid(78);
             emp1.setName("Amir Ali");
             
             // create object for project
             Project p=new Project();
             Project p1=new Project();
             // add one project fisrt 
             p.setPid(12);
             p.setProjectName("Library Managment System");
             // add 2 project
             p1.setPid(32);
             p1.setProjectName("ChatBot");
             // add both projects and empolyee in lists 
             
             List<Empolyee> list1= new  ArrayList<Empolyee>();
             List<Project> list2= new ArrayList<>();
             
             list1.add(emp);
             list1.add(emp1);
             
             list2.add(p);
             list2.add(p1);
             
             // assign projects to empolyees vice versa 
             
             emp.setProjects(list2);
             p.setEmployee(list1);
             
             Session session=factory.openSession();
             Transaction tx=session.beginTransaction();
             
             session.save(emp);
             session.save(emp1);
             session.save(p);
             session.save(p1);
             tx.commit();
             session.close();
	        factory.close();
	}

}
