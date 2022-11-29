package demo.sbj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import demo.sbj.model.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        customer.setCreateBy("SYSTEM");
        return customerRepository.save(customer);
    }
    
    @Override
    public void delCustomerById(Long id) {
        customerRepository.deleteById(id);
    }
    
    @Override
    public void delAll() {
        customerRepository.deleteAll();
    }

    @Override
    public Customer findOneById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
    
    @Override
    public Customer findByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public List<Customer> findByNameAndAge(String name, Integer age) {
        return customerRepository.findByNameAndAge(name, age);
    }

    @Override
    public Customer queryByName(String name) {
        return customerRepository.queryByName(name);
    }

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

}
