package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		 Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");
	        SessionFactory factory = cfg.buildSessionFactory();
	        
//	        // creating one question and its answer 
//	        Questions q=new Questions();
//	        q.setQuestionId(1);
//	        q.setQuestion("What is java?");
//	        //creating one answer
//	        Answer ans=new Answer();
//	        ans.setAnswerId(121);
//	        ans.setAnswer("Java is programming language.");
//	        ans.setQuestion(q);
//	        //creating 2nd answer for same queston 
//	        Answer ans1=new Answer();
//	        ans1.setAnswerId(12);
//	        ans1.setAnswer("Which help to build softwares.");
//	        ans1.setQuestion(q);
//	        
//	        //creating 3nd answer for same queston 
//	        Answer ans2=new Answer();
//	        ans2.setAnswerId(112);
//	        ans2.setAnswer("Java contain frameworks which help to improve code readbility ");
//	        ans2.setQuestion(q);
//	        List<Answer> list =new ArrayList<Answer>();
//	        list.add(ans);
//	        list.add(ans1);
//	        list.add(ans2);
//	       q.setAnswer(list);
	        
	        Session s=factory.openSession();
	        Transaction tx=s.beginTransaction();
//	        s.save(q);
//	        s.save(ans);
//	        s.save(ans1);
//	        s.save(ans2);
	        tx.commit();
	        
	        //fetch 
	        Questions qu=(Questions)s.get(Questions.class, 1);
	        System.out.println(qu.getQuestion());
	        
	        for(Answer a:qu.getAnswer()) {
	        	System.out.println(a.getAnswer());
	        }
//	        Questions getq=(Questions)s.get(Questions.class, 1);
//	        System.out.println(getq.getQuestion());
//	        System.out.println(getq.getAnser().getAnswer());
	        s.close();
	        factory.close();

	}

}
