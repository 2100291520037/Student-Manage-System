package com.exampleSmartStudent.demo8.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserControler {
	@RequestMapping("/index")
	public String dashboard()
	{
		return "normal/user_dashboard";
	}

}
