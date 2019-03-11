package com.cg.Maven.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.beans.Customer;
import com.cg.beans.Employee;
import com.cg.exception.InvalidEmailException;
import com.cg.exception.InvalidIdException;
import com.cg.exception.InvalidMobileException;
import com.cg.exception.InvalidNameException;
import com.cg.service.ICustomerService;

@RestController
public class MyRestController {
@Autowired
ICustomerService service;

	
	public ICustomerService getService() {
	return service;
}
public void setService(ICustomerService service) {
	this.service = service;
}


	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public String printHello() {
		return "Hello";
	}
	@RequestMapping(value="/getEmployee",method=RequestMethod.GET,produces="application/json")
	public Employee getEmployeeDetails(){
		Employee emp=new Employee();
		emp.setFirstName("manish");
		emp.setLastName("kumar");
		emp.setMobileNo("7252090047");
		emp.setEmail("manish@gmail.com");
		return emp;
	}
	@RequestMapping(value="/addEmployee",method=RequestMethod.POST)
	public Employee addEmployee(@RequestParam("fname")String firstName,
			@RequestParam("lname")String lastName,
			@RequestParam("mobno")String mobileNo,
			@RequestParam("email")String email) {
		Employee emp=new Employee();
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setMobileNo(mobileNo);
		emp.setEmail(email);
		return emp;
		
	}
	@RequestMapping(value="/addCustomer",consumes="application/json",produces="application/json",method=RequestMethod.POST)
	public Customer addCustomer(@RequestBody Customer customer) {
		
		
		customer=service.addCustomer(customer);
		return customer;
		
	}
	@RequestMapping(value="/getCustomer/{custid}")
	public Customer findCustomer(@PathVariable int custid) {
		Customer customer=service.findCustomer(custid);
		return customer;
	}
	/*@RequestMapping(value="/update/{custid}",method=RequestMethod.POST)
	public Customer updateCustomer(@PathVariable int custid,@RequestParam("fname")String firstName,
			@RequestParam("lname")String lastName,
			@RequestParam("age")int age,
			@RequestParam("city")String city,
			@RequestParam("mobno")String mobileNo,
			@RequestParam("email")String email) {
		Customer customer=service.findCustomer(custid);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setAge(age);
		customer.setCity(city);
		customer.setMobileNo(mobileNo);
		customer.setEmail(email);
		Customer updated=service.updateCustomer(customer);
		return updated;
	}*/
	@RequestMapping(value="/update",method=RequestMethod.POST,consumes="application/json",produces="application/json")
	public Customer updateCustomer(@RequestBody Customer customer) {
		
		
		Customer updated=service.updateCustomer(customer);
		return updated;
	}
	@RequestMapping(value="/getList")
	public List<Customer> getCustomerList(){
		List<Customer> cList=service.getCustomerList();
		return cList;
	}
	@RequestMapping(value="/remove/{custid}")
	public Customer remove(@PathVariable int custid) {
		Customer customer=service.removeCustomer(custid);
		return customer;
	}
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Enter corrct mobile no.")
	@ExceptionHandler({InvalidMobileException.class})
	public void handleMobileException() {
		
	}
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Enter corrct Email")
	@ExceptionHandler({InvalidEmailException.class})
	public void handleEmailException() {
		
	}
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Enter corrct Id")
	@ExceptionHandler({InvalidIdException.class})
	public void handleIdException() {
		
	}
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Enter corrct Name")
	@ExceptionHandler({InvalidNameException.class})
	public void handleNameException() {
		
	}
}
