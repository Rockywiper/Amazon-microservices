package com.amazonCustomer.AmazonCustomer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonCustomer.AmazonCustomer.model.Customer;
import com.amazonCustomer.AmazonCustomer.repository.CustomerRepository;
import com.amazonCustomer.AmazonCustomer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController 
{
	Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerRepository repo;
	
	@Autowired
	private CustomerService service;
	
	@PostMapping("/add")
	public Customer addDetail(@RequestBody Customer cus)
	{
		log.info("Adding customer details");
		return repo.save(cus);
	}
	
	@GetMapping("/getall")
	public List<Customer> getDetails()
	{
		log.info("Getting all customer details");
		return repo.findAll();
	}
	
	@RequestMapping("/get/{id}")
	public Customer getDetail(@PathVariable Long id)
	{
		log.info("Getting a particular customer detail by id");
		Customer cus = service.getCustomer(id);	
		return cus;	
	}
	
	@PutMapping("/update")
	public Customer putDetail(@RequestBody Customer cus)
	{
		log.info("Updating customer details");
		return repo.save(cus);
	}
	
	@DeleteMapping("/delete/{cId}")
	public void delete(@PathVariable Long cId)
	{
		log.info("Deleting customer detail by id");
		repo.deleteById(cId);
	}
	
}
