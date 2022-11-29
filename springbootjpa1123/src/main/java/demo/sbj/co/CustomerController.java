package demo.sbj.co;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import demo.sbj.model.*;
import demo.sbj.service.*;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> getAllUser() {
    	customerService.saveCustomer(new Customer("AAA", 10, "SYSTEM"));
    	customerService.saveCustomer(new Customer("BBB", 20, "SYSTEM"));
    	customerService.saveCustomer(new Customer("CCC", 30, "SYSTEM"));
    	customerService.saveCustomer(new Customer("DDD", 40, "SYSTEM"));
    	customerService.saveCustomer(new Customer("EEE", 50, "SYSTEM"));

    	return customerService.findAll();
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(Customer customer) {
        customer = customerService.saveCustomer(customer);
        return "新增成功，返回用戶id為：" + customer.getId();
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public Customer findUser(@PathVariable Long id) {
        return customerService.findOneById(id);
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public String delUser(@RequestParam("id") Long id) {
        customerService.delCustomerById(id);
        return "用戶id為：" + id + "，已被删除!";
    }

    @RequestMapping(value = "/find/{name}/{age}", method = RequestMethod.GET)
    public List<Customer> findUserByCodeAndName(@PathVariable("name") String name, @PathVariable("age") int age) {
        return customerService.findByNameAndAge(name, age);
    }

}


