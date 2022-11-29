package demo.sbthymeleaf.co;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import demo.sbthymeleaf.model.*;

@Controller
public class CustomerController {
	@RequestMapping(value = "/customerUpdate", method = RequestMethod.GET)
    public ModelAndView updateForm() {
       ModelAndView model = new ModelAndView("customerUpdate");
       Customer cx=new Customer("Mary","Taipei",40);
       model.addObject("customer",cx);
       return model;
    }
	@RequestMapping(value = "/customerUpdate", method = RequestMethod.POST)
    public ModelAndView updateForm(@ModelAttribute Customer  cus) {
       ModelAndView model = new ModelAndView("customerDone");      
       model.addObject("customer",cus);
       return model;
    }
	@RequestMapping(value = "/customerCreate", method = RequestMethod.GET)
    public ModelAndView openForm() {
       ModelAndView model = new ModelAndView("customerCreate");
       Customer cx=new Customer("Mary","Taipei",40);
       model.addObject("cs",cx);
       return model;
    }

    @RequestMapping(value = "/customerCreate", method = RequestMethod.POST)
    public ModelAndView processForm(@ModelAttribute Customer  cus) {
       ModelAndView model = new ModelAndView("customerDone");
       model.addObject("customer",cus);
       return model;
    }
    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public ModelAndView openForm2() {
       ModelAndView model = new ModelAndView("customerTest");
       model.addObject("name", "Danny" );
       model.addObject("address", "Taipei" );
       return model;
    }
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ModelAndView openList() {
       ModelAndView model = new ModelAndView("customerList");
       List<Customer> list=List.of(new Customer("Mary","Taipei",40),new Customer("John","Taipei",40),new Customer("George","Taipei",40));
       model.addObject("customers", list );
       return model;
    }
    
}