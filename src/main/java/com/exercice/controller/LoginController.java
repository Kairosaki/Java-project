package com.exercice.controller;


import com.exercice.model.User;
import com.exercice.repository.CustomerRep;
import com.exercice.repository.UserRep;
import com.exercice.service.UserServiceImpl;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@Autowired
	CustomerRep customerRep;
	
	@Autowired
	UserRep userRep;
	
	@Autowired
	UserServiceImpl userServiceImpl;

	@RequestMapping(value = "/showLoginPage")
	public String showLoginPage() {
		return "login";
	}
	
	@RequestMapping(method= RequestMethod.POST, value = "/returnLoginPage")
	public String returnLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="/")
	public ModelAndView getUserTable(Principal principal) {	
		return new ModelAndView("userdb", "customerList", userServiceImpl.findByUsername(principal.getName()).getCustomers());
	}
	
	@RequestMapping(value="/accessdenied")
	public String showAccessDenied() {
		return "accessdenied";
	}
	
	// register view
	@RequestMapping(method = RequestMethod.GET, value = "/register" )
    public String registration(Model model) {
		model.addAttribute("userForm", new User());
        return "register";
    }
		
	@RequestMapping(method = RequestMethod.POST, value = "/register")
    public String registration(@ModelAttribute("userForm") User userForm) {	
        if ( userForm.getUsername() == null && userForm.getPassword() == null ) {        	
        	return "register";
        }         
        userServiceImpl.save(userForm);
        return "redirect:/showLoginPage";
    }
	
}
