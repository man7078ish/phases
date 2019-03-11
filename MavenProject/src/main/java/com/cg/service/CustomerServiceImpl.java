package com.cg.service;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.beans.Customer;
import com.cg.exception.InvalidEmailException;
import com.cg.exception.InvalidMobileException;
import com.cg.exception.InvalidNameException;
import com.cg.repo.ICustomerRepository;
@Transactional
@Service("service")
public class CustomerServiceImpl implements ICustomerService{
	@Autowired
	ICustomerRepository repo;	
	public ICustomerRepository getRepo() {
		return repo;
	}
	public void setRepo(ICustomerRepository repo) {
		this.repo = repo;
	}
	@Override
	public Customer addCustomer(Customer customer) {
		String mobno=customer.getMobileNo();
		Pattern pattern=Pattern.compile("^[0-9]{10}$");
		Matcher mat=pattern.matcher(mobno);
		if(mat.matches()==false)
			throw new InvalidMobileException();
		
		
		String email=customer.getEmail();
		Pattern emailPat=Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher emailmat=emailPat.matcher(email);
		if(emailmat.matches()==false)
			throw new InvalidEmailException();
		
		String fname=customer.getFirstName();
		Pattern namePat=Pattern.compile("[A-Z][a-zA-Z]*");
		Matcher nameMa=namePat.matcher(fname);
		if(nameMa.matches()==false)
			throw new InvalidNameException();
		String lName=customer.getLastName();
		Matcher nameMat=namePat.matcher(lName);
		if(nameMat.matches()==false)
			throw new InvalidNameException();
		
		
		
		return repo.addCustomer(customer);
	}
	@Override
	public Customer findCustomer(int customerid) {
		return repo.findCustomer(customerid);
	}
	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return repo.updateCustomer(customer);
	}
	@Override
	public List<Customer> getCustomerList() {
		return repo.getCustomerList();
	}
	@Override
	public Customer removeCustomer(int custid) {
		// TODO Auto-generated method stub
		return repo.removeCustomer(custid);
	}
}
