package model;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductDAO {
   public static List<Product> getAll(){
	   List<Product> data=null;
	   SessionFactory factory=null;
       try {
    	   factory=new Configuration().configure().buildSessionFactory();
       }catch(Exception ex) {
    	   System.out.println("SessionFactory error "+ex.getMessage());
    	   return null;
       }
       Session ss=factory.openSession();
       ss.getTransaction().begin();
       data=ss.createQuery("from Product").list();
       ss.getTransaction().commit();
       factory.close();
	   return data;
   }
}
