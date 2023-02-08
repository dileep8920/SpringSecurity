package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Service.CustomerService;
import com.masai.entity.Customer;
import com.masai.exception.CustomerException;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService cService;
	
	@Autowired
	private PasswordEncoder pEncoder;
	
	@GetMapping("/welcome")
	public String testHandler() {
		return "Welcome to Spring Security";
	}
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer){
		
		customer.setPassword(pEncoder.encode(customer.getPassword()));
		
		Customer c=cService.registerCustomer(customer);
		
		return new ResponseEntity<Customer>(c,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/customers/{email}")
	public ResponseEntity<Customer> getCustomerByEmail(@PathVariable("email") String email) throws CustomerException{
		Customer c=cService.getCustomerDetailsByEmail(email);
		
		return new ResponseEntity<Customer>(c,HttpStatus.OK);
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomer() throws CustomerException{
		List<Customer> lst=cService.getAllCustomerDetails();
		
		return new ResponseEntity<List<Customer>>(lst,HttpStatus.OK);
	}
	
	
}
