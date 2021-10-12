package surajs_pkg.springdemo.dao;

import java.util.List;

import surajs_pkg.springdemo.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer c);

	public Customer getCustomer(int id);

	public void delete(int id);

	public List<Customer> searchCustomers(String theSearchName);

}
