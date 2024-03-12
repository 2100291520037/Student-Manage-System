package com.exampleSmartStudent.demo8.controler;

import java.util.Enumeration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exampleSmartStudent.demo8.Dao.UserRepository;
import com.exampleSmartStudent.demo8.entity.User;
import com.exampleSmartStudent.demo8.helper.Message;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller

public class HomeControler {
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/")
	public String home(Model model)
	{
		model.addAttribute("title","Home - Smart Contact Manager");
		return "home";
	}
	@RequestMapping("/about")
	public String about(Model model)
	{
		model.addAttribute("title","About - Smart Contact Manager");
		return "about";
	}
	@RequestMapping("/signup")
	public String signup(Model model)
	{
		model.addAttribute("title","Register - Smart Contact Manager");
		model.addAttribute("user",new User());//black field jaayangi
		return "signup";
	}
	///do_register
	@PostMapping("/do_register")
	public String registerUser(@Valid @ModelAttribute("user") User user,BindingResult result1,@RequestParam(value="agreement",defaultValue="false") boolean agreement,Model model,HttpSession session)
	{
		try {
			if(!agreement) {
				System.out.println("can' fill agreement");
				throw new Exception("you have not agreed the terms and conditions");
			}
			if(result1.hasErrors()) {
			    // Iterate over each error in the BindingResult object
			    System.out.println(result1);
			    model.addAttribute("user", user);
			    return "signup";
			}

			user.setRole("Role_USER");
			user.setEnable(true);
			user.setImageUrl("default.png");
			System.out.println("agreement"+ agreement);
			System.out.println(user);
			userRepository.save(user);
			System.out.println("Sccuess full add");
			model.addAttribute("user",new User());
			Message message=new Message("Successfully Registered!! ","alert-success");
			//session.setAttribute("message",message));
			model.addAttribute("message",message);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			model.addAttribute("user",user);
			session.setAttribute("message",new Message("Something Went wrong !!"+e.getMessage(),"alert-danger"));
			
		}
		 session.removeAttribute("message");
		return "signup";
	}
	

}
