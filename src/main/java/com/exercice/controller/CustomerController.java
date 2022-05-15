package com.exercice.controller;

import com.exercice.repository.CustomerRep;
import com.exercice.service.UserServiceImpl;
import com.exercice.model.Customer;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerRep customerRep;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	// Show customer table of the current user
	@RequestMapping(value="/usermanage")
	public ModelAndView getAll(Principal principal) {			
		return new ModelAndView("usermanage", "customerList", userServiceImpl.findByUsername(principal.getName()).getCustomers());
	}
	
	// add 
	@RequestMapping(method = RequestMethod.GET, value = "/addcustomer" )
    public ModelAndView addCustomer(ModelAndView model) {
		Customer customer = new Customer();
        model.addObject("customer", customer);
        model.setViewName("addcustomer");
        return model;
    }
	
	// save
	@RequestMapping(method = RequestMethod.POST, value = "/saveCustomer")
    public ModelAndView saveCustomer(@ModelAttribute Customer customer, Principal principal) {
		String userName = principal.getName();
        if (customer.getId() == null) { 
        	customer.setId(1L); 
        	customer.setU_name(userName);
    		customerRep.save(customer);
        } else {       
        	customer.setU_name(userName);
        	customerRep.save(customer);
        }
        
        return new ModelAndView("redirect:/usermanage");
    }
	
    // edit view
	@RequestMapping(value = "/editcustomer/{id}")
    public ModelAndView updatePage(ModelAndView model, @PathVariable Long id) {		
		model.addObject("customer", customerRep.findOne(id));
        model.setViewName("editcustomer");
        return model;
    }
	
	// update
	@RequestMapping(method = RequestMethod.POST, value = "/updateCustomer")
    public ModelAndView updateCustomer(@ModelAttribute Customer customer) {
	    Customer c = customerRep.findOne(customer.getId());
	    c.setFirstName(customer.getFirstName());
	    c.setLastName(customer.getLastName());
	    customerRep.save(c);	    
        return new ModelAndView("redirect:/usermanage");
    }
	
	// delete 
	@RequestMapping(method=RequestMethod.GET, value="/deletecustomer/{id}")
	public ModelAndView deleteACustomer(@PathVariable Long id) {
		customerRep.delete(id);
		return new ModelAndView("redirect:/usermanage");
	}
	
	// delete all
	@RequestMapping(value="/delete")
	public String deleteAll() {
		customerRep.deleteAll();
		return "redirect:/usermanage";
	}

}
