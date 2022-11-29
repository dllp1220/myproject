package model;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class logindao {
		public static Session contect() {
			Session s=null;
			s=(new Configuration().configure().buildSessionFactory()).openSession();
			return s;
		}

	   public static List<Login> addLogin(Login s) {
		   List<Login>b=null;
		   Session a=logindao.contect();
		   a.getTransaction().begin();
		   a.persist(s);
		   a.getTransaction().commit();	   
		   a.close();
		   b=logindao.readLogin();
		   return b;
	   }
	 
	   
	   public static List<Login> readLogin() {
		   Session a=logindao.contect();
		   a.getTransaction().begin();
		   TypedQuery<Login> query=a.createQuery("from Login",Login.class);
		   List<Login> Login=query.getResultList();
		   a.getTransaction().commit();	   
		   a.close();		
		   return Login;
	   }
	   
}
