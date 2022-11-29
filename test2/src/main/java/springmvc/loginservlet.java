package springmvc;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.products;
import model.Login;
import model.logindao;
import model.productDAO;
 
@Controller
@RequestMapping("/")

public class loginservlet { 
    @RequestMapping("/login/read")
    public String read(@ModelAttribute("login") Login login, ModelMap model) {   
    	List<Login> a=null;
    	a=loginservlet.readLogin();
    	model.addAttribute ("login",a);       
		return"productshow";        
    }
    public static Session contect() {
		Session s=null;
		s=(new Configuration().configure().buildSessionFactory()).openSession();
		return s;
    }
		
    @RequestMapping("/login/insert")
    public String insert(@ModelAttribute("Login") Login Login, ModelMap model) {   
    	List<Login> a=null;
    	a=logindao.addLogin(Login);
    	model.addAttribute ("login",a);       
		return"login";      
    }
    public static List<Login> readLogin() {
		   Session a=loginservlet.contect();
		   a.getTransaction().begin();
		   TypedQuery<Login> query=a.createQuery("from login",Login.class);
		   List<Login> Login=query.getResultList();
		   a.getTransaction().commit();	   
		   a.close();		
		   return Login;
	   }

	
  
}
