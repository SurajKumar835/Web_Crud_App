package surajs_pkg.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import surajs_pkg.springdemo.dao.CustomerDAO;
import surajs_pkg.springdemo.entity.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {
	//need to inject dao
	@Autowired
	private CustomerDAO customerDao;
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}
	@Override
	@Transactional
	public void saveCustomer(Customer c) {
		customerDao.saveCustomer(c);
		
	}
	@Override
	@Transactional
	public Customer getCustomer(int id) {
		return customerDao.getCustomer(id);
	}
	@Override
	@Transactional
	public void delete(int id) {
		customerDao.delete(id);
	}
	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		return customerDao.searchCustomers(theSearchName);
	}

}
