package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.user.UserClass;
import com.example.demo.user.UserController;

@Controller
public class registerViewController {
	@Autowired
	UserController userController;
	
	@RequestMapping("displayRegister")
	public String displayRegisterPage(){
		return "registerView";
	}
	
	@RequestMapping("registerUser")
	public ModelAndView register(UserClass user) {
		userController.addUser(user);
		ModelAndView mv = new ModelAndView("redirect:/"  );
		return mv;
	}
}
