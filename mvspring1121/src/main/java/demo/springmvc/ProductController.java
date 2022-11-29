package demo.springmvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.*;
import java.util.*;

@Controller
public class ProductController {
	
  @RequestMapping(value="/test" , method = RequestMethod.GET)
  public String welcome(ModelMap model) {
	  model.addAttribute("test","Hello ProductController");
	  return "test";
  }
  @RequestMapping(value="/products" , method = RequestMethod.GET)
  public String getAllProducts(ModelMap model) {
	  List<Product> data=ProductDAO.getAll();
	  if(data==null)
		  System.out.println("Product No Data");
	  model.addAttribute("products",data);
	  return "product";
  }
  
  @RequestMapping(value = "/coffee",method = RequestMethod.GET)
	public String spJdbc(ModelMap model) {		
      
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");  
		    CoffeeDAO dao=(CoffeeDAO)ctx.getBean("cfdao"); 
		    JdbcTemplate tm=(JdbcTemplate)ctx.getBean("myTemplate");
		    dao.setTemplate(tm);
		    List<Coffee> list=dao.getAllEmployeesRowMapper();  
		          
		model.addAttribute("coffees", list);
		return "coffee";
	}

}
