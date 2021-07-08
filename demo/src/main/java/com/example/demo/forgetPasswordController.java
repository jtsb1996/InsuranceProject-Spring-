package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.user.UserClass;
import com.example.demo.user.UserController;

@Controller
public class forgetPasswordController {
	@Autowired
	UserController userController;
		
	@RequestMapping("displayForgetPassword")
	public ModelAndView display() {
		ModelAndView mv = new ModelAndView("forgetPasswordView");
		return mv;
	}
	
	// to be further simplfied
	@RequestMapping("displaySecurityQuestion")
	public ModelAndView displaySQView(@RequestParam("userName")String name) {
		ModelAndView mv = new ModelAndView("securityQuestionView");
		// error check for null name
		
		UserClass user = userController.getUserByUserName(name);
		if(user == null) {
			System.out.println("error");
		}
		else {
			String question = user.getSecurityQ();
			int id = user.getuID();
			mv.addObject("id",id);
			mv.addObject("question",question);
		}
		
		return mv;
	}
	
	@RequestMapping("verifySecurity")
	public ModelAndView verify(@RequestParam("id")int id, @RequestParam("securityA")String answer) {
		ModelAndView mv = new ModelAndView("index");
		UserClass user = userController.getUserById(id);
		if (user.getSecurityA().equals(answer)) {
			String password = user.getPassWord();
			mv.setViewName("displayPassword");
			mv.addObject("password", password);
		}
		
		else {
			mv.setViewName("unsuccessful");
		}
		return mv;
	}

}
