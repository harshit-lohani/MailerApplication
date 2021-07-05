package com.harshit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.harshit.beans.Credentials;
import com.harshit.beans.Mail;
import com.harshit.beans.User;
import com.harshit.dao.UserDao;
import com.harshit.service.Mailer;

@Controller
public class UserController {
	
	
	@Autowired
	private UserDao dao;			//will inject dao from xml file
	private Credentials userCred = null;
	
	/*
	 *It displays a form to input data, "command" here is
	 *a reserved attribute which is used to display
	 *object data into form 
	 */
	@RequestMapping("/userForm")
	public String showForm(Model m) {
		m.addAttribute("command", new User());
		
		return "userForm";
	}
	
	@RequestMapping("/showLogin")
	public String showLogin(Model m) {
		m.addAttribute("command", new Credentials());		
		return "loginForm";
	}
	
	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public String loginProcess(@ModelAttribute("credentials") Credentials cred) {
		
		
		System.out.println("Cred UserEmail: " + cred.getUserEmail());
		System.out.println("Cred password : " + cred.getPassword());
		
		User user = dao.validateCredentials(cred);

		if (user != null) {
			this.userCred = cred;
			return "homepage";
		}
		else {
			return "failure";
		}
	}
	
	@RequestMapping("showMailer")
	public String showMailer(Model m) {;
		m.addAttribute("command", new Mail());
		return "mailerForm";
	}
	
	@RequestMapping(value = "mailProcess", method = RequestMethod.POST)
	public String mailerProcess(@ModelAttribute("mail") Mail mail) {
		System.out.println("Mail: "+ mail.getBody());
		System.out.println("User: " + userCred.getUserEmail());
//		System.out.println("Credentials: " + cred.getUserEmail());
		
		Mailer mailer = new Mailer(mail, userCred);
		
		boolean sent = mailer.callMailer();
		
		if(sent)
			return "success";
		else
			return "failure";
	}
	
	
	
	
	/*Saves the object user into
	 * the database. The @ModelAttribute puts requested
	 * data into model object
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("user") User user) {
		dao.save(user);
		return "redirect:/viewUser";
	}
	
	
	/*Provides list of all objects
	 * in the User Table
	 */
	@RequestMapping("/viewUser")
	public String viewUser(Model m) {
		List <User> list = dao.getUsers();
		for(User user : list) {
			System.out.println(user.getFirstName());
		}
		m.addAttribute("list", list);
		return "viewUser";
	}
	
	/*It displays the data into form for the given id
	 * The @PathVaribale puts URL data into a variable
	 */
	@RequestMapping("/edit")
	public String edit(@PathVariable int id, Model m) {
		User user = dao.getUserById(id);
		m.addAttribute("command", user);
		return "redirect:/veiwUser";
	}
	
	
	@RequestMapping("/signout")
	public String signout() {
		this.userCred = null;
		return "loginForm";
	}
	
	
	
}
