package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import java.util.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.*;

@Controller
public class SupplierCoffeeController {
	List<Coffee> coffees = new ArrayList<>();

	@RequestMapping(value="/supplier" ,method = RequestMethod.GET)
	public String getSupplierView() {
		return "supplier";
	}
	@RequestMapping(value = "/addSupplier", method = RequestMethod.POST  )
	public ModelAndView addSupplier(@RequestBody Supplier sup, ModelMap modelMap) {	
		
		modelMap.addAttribute("sups", sup);
		return new ModelAndView("showSupplier");

	}
	
	@RequestMapping(value="/home" ,method = RequestMethod.GET)
	public String getFirstView() {
		return "home";
	}

	@RequestMapping(value = "/addOrder", method = RequestMethod.POST  )
	public ModelAndView addOrder(@RequestBody Coffee coffee, ModelMap modelMap) {
		Supplier sup = coffee.getSuppliers();
		coffees.add(coffee);
		modelMap.addAttribute("coffees", coffees);
		modelMap.addAttribute("sups", sup);
		return new ModelAndView("showCoffee");

	}
}
