package model;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class StudentDAO {
   public static void addStudent(Student s) {
	   SessionFactory f=null;
	   try {
		   f=new Configuration().configure().buildSessionFactory();
	   }catch(Exception ex) {
		   System.out.println("SessionFactory Error:"+ex.getMessage());
		   return;
	   }
	   Session ss=f.openSession();
	   ss.getTransaction().begin();
	   ss.persist(s);
	   ss.getTransaction().commit();	   
	   System.out.println(s.toString()+" add to Student Table");
   }
}
