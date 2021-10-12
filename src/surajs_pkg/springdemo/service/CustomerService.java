package surajs_pkg.springdemo.service;

import java.util.List;

import surajs_pkg.springdemo.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer c);

	public Customer getCustomer(int id);

	public void delete(int id);

	public List<Customer> searchCustomers(String theSearchName);
}
