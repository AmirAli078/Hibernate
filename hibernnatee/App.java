package com.hibernnatee;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project is started!" );
        Configuration cfg=new Configuration();
        cfg.configure();
        SessionFactory factory=cfg.buildSessionFactory();
      System.out.println(factory);
     // Creating student object means creating st table in databse 
      Student st=new Student();
      st.setId(103);
      st.setName("Saqib");
      st.setCity("multan");
      System.out.println(st);
      
      //creating addresss object again
      Address ad=new Address();
     ad.setStreet("Phase-II");
      ad.setCity("Hyderabad");
      ad.setOpen(false);
      ad.setAddedDate(new Date());
      ad.setX(1234254);
      
     Session session =factory.openSession();
     
     Transaction tx= session.beginTransaction();
     session.save(st);
     session.save(ad);
     tx.commit();
     session.close();
     System.out.println("Done......");
      
      
    }
}
