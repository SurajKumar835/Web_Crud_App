package surajs_pkg.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import surajs_pkg.springdemo.entity.Customer;
import surajs_pkg.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	//need to inject the DAO into this controller
	@Autowired
	private CustomerService customerService;
	@GetMapping("/list")
	public String customer_list(Model model) {
		//get customers from dao add to spring mvc model
		List<Customer> customer=customerService.getCustomers();
		model.addAttribute("customers",customer);
		return "list-customer";
	}
	// Form to add the customer
	@GetMapping("/addform")
	public String addForm(Model model)
	{
		Customer c=new Customer();
		model.addAttribute("customer",c);
		return "customer-form";
	}
	//save data from html form method
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer c)
	{
		customerService.saveCustomer(c);
		return "redirect:/customer/list";
	}
	// Form to update the customer
		@GetMapping("/showformforupdate")
		public String addForm(@RequestParam("customerId") int id,
				Model model)
		{
			Customer c=customerService.getCustomer(id);
			model.addAttribute("customer",c);
			return "customer-form";
		}
		// delete the customer
		@GetMapping("/delete")
		public String delete(@RequestParam("customerId") int id)
		{
			customerService.delete(id);
			return "redirect:/customer/list";
			
			
		}
		  @GetMapping("/search")
		    public String searchCustomers(@RequestParam("theSearchName") String theSearchName,
		                                    Model theModel) {
		        // search customers from the service
		        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);
		                
		        // add the customers to the model
		        theModel.addAttribute("customers", theCustomers);
		        return "list-customer";        
		    }
		
}
