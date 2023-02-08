package com.masai.Service;

import java.util.List;

import com.masai.entity.Customer;
import com.masai.exception.CustomerException;

public interface CustomerService {

	public Customer registerCustomer(Customer customer);
	
	public Customer getCustomerDetailsByEmail(String email) throws CustomerException;
	
	public List<Customer> getAllCustomerDetails() throws CustomerException;
}
