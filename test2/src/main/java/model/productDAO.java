package model;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class productDAO {
		public static Session contect() {
			Session s=null;
			s=(new Configuration().configure().buildSessionFactory()).openSession();
			return s;
		}

	   public static List<products> addProduct(products s) {
		   List<products>b=null;
		   Session a=productDAO.contect();
		   a.getTransaction().begin();
		   a.persist(s);
		   a.getTransaction().commit();	   
		   a.close();
		   b=productDAO.readProduct();
		   return b;
	   }
	   public static List<products> updateProduct(products s) {
		   List<products>b=null;
		   Session a=productDAO.contect();
		   a.getTransaction().begin();
		   products c=a.get(products.class, s.getProduct_ID());
		   c.setProduct_catagory(s.getProduct_catagory());
		   c.setProduct_Name(s.getProduct_Name());
		   c.setProduct_price(s.getProduct_price());
		   c.setImagePath(s.getImagePath());
		   c.setProduct_describe(s.getProduct_describe());
		   a.update(c);
		   a.getTransaction().commit();	   
		   a.close();		   
		   b=productDAO.readProduct();
		   return b;
	   }
	   public static List<products> deleteProduct(products s) {
		   List<products>b=null;
		   Session a=productDAO.contect();
		   a.getTransaction().begin();
		   products c=a.get(products.class, s.getProduct_ID());
		   a.delete(c);
		   a.getTransaction().commit();	   
		   a.close();
		   b=productDAO.readProduct();
		   return b;
	   }
	   public static List<products> readProduct() {
		   Session a=productDAO.contect();
		   a.getTransaction().begin();
		   TypedQuery<products> query=a.createQuery("from products",products.class);
		   List<products> product=query.getResultList();
		   a.getTransaction().commit();	   
		   a.close();		
		   return product;
	   }
	   
}
