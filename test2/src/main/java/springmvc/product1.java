package springmvc;

import java.util.List;
import org.springframework.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.products;
import model.productDAO;
 
@Controller
@RequestMapping("/")

public class product1 { 
    @RequestMapping("/product/read")
    public String read(@ModelAttribute("products") products products, ModelMap model) {   
    	List<products> a=null;
    	a=productDAO.readProduct();
    	model.addAttribute ("productsList",a);       
		return"productshow";        
    }
    @RequestMapping("/product/update")
    public String update(@ModelAttribute("products") products products, ModelMap model) {   
    	List<products> a=null;
    	a=productDAO.updateProduct(products);
    	model.addAttribute ("productsList",a);       
		return"productshow";     
    }
    @RequestMapping("/product/insert")
    public String insert(@ModelAttribute("products") products products, ModelMap model) {   
    	List<products> a=null;
    	a=productDAO.addProduct(products);
    	model.addAttribute ("productsList",a);       
		return"productshow";      
    }
    @RequestMapping("/product/delete")
    public String delete(@ModelAttribute("products") products products, ModelMap model) {   
    	List<products> a=null;
    	a=productDAO.deleteProduct(products);
    	model.addAttribute ("productsList",a);       
		return"productshow"; 
    }
}
