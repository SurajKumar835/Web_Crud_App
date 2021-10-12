package surajs_pkg.springdemo.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import surajs_pkg.springdemo.entity.Customer;
@Repository
public class CustomerDAOImpl implements CustomerDAO {
		//need to inject hibernate Session factory
	@Autowired
	private SessionFactory sessionfactory;
	@Override
	public List<Customer> getCustomers() {
		//get hibernate session
		Session currentSession=sessionfactory.getCurrentSession();
		//query 
		Query<Customer> q=
				currentSession.createQuery("from Customer order by lastName",Customer.class);
		//get result list 
		List<Customer> result=q.getResultList();
		//return the customer i retrieve
		
		return result;
	}
	@Override
	public void saveCustomer(Customer c) {
		Session currentSession=sessionfactory.getCurrentSession();
		currentSession.saveOrUpdate(c);
		
	}
	@Override
	public Customer getCustomer(int id) {
		Session currentSession=sessionfactory.getCurrentSession();
		Customer c=currentSession.get(Customer.class, id);
		return c;
		
	}
	@Override
	public void delete(int id) {
		Session currentSession=sessionfactory.getCurrentSession();
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", id);
		
		theQuery.executeUpdate();
		
	}
	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		
		 Session currentSession = sessionfactory.getCurrentSession();
	        
	        Query theQuery = null;
	        
	        //
	        // only search by name if theSearchName is not empty
	        //
	        if (theSearchName != null && theSearchName.trim().length() > 0) {
	            // search for firstName or lastName ... case insensitive
	            theQuery =currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
	            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
	        }
	        else {
	            // theSearchName is empty ... so just get all customers
	            theQuery =currentSession.createQuery("from Customer", Customer.class);            
	        }
	        
	        // execute query and get result list
	        List<Customer> customers = theQuery.getResultList();
	                
	        // return the results        
	        return customers;
	        
	    }
	

}
