package com.masai.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Repository.CustomerRepo;
import com.masai.entity.Customer;
import com.masai.exception.CustomerException;

@Service
public class CustomerServiceImpl implements CustomerService{

	
	@Autowired
	private CustomerRepo cRepo;
	
	@Override
	public Customer registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		Customer c=cRepo.save(customer);
		return c;
	}

	@Override
	public Customer getCustomerDetailsByEmail(String email) throws CustomerException {
		// TODO Auto-generated method stub
		
		Customer c=cRepo.findByEmail(email).orElseThrow(()-> new CustomerException("Customer not found with this Email "+email));		
		return c;
	}

	@Override
	public List<Customer> getAllCustomerDetails() throws CustomerException {
		// TODO Auto-generated method stub
		
		List<Customer> lst=cRepo.findAll();
		if(lst.isEmpty()) {
			throw new CustomerException("Customer Not Found");
		}else {
			return lst;
		}
		
	}

}
