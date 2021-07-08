package com.example.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.user.UserClass;
import com.example.demo.user.UserController;

@Controller
public class loginViewController {
	private final UserController userController;
	
	@Autowired
	public loginViewController(UserController userController) {
		this.userController = userController;
	}
	
	@RequestMapping("displayLogin")
	public ModelAndView displayLoginView() {
		ModelAndView mv = new ModelAndView();
		System.out.println("Login Page Requested");
		mv.setViewName("loginView");	
		return mv;
	}
	
	@RequestMapping("verifyLogin")
	public ModelAndView login(@RequestParam("userName")String userName, @RequestParam("passWord")String passWord) {
		ModelAndView mv = new ModelAndView();
		boolean flag = false;
		String name = "";
		List<UserClass>list = userController.getUsers();
		System.out.println("verify user credential");
		
		// verify credentials
		for(int i = 0; i < list.size(); i++) {
			String tempUser = list.get(i).getUserName();
			String tempPass = list.get(i).getPassWord();
			if(tempUser.equals(userName) && tempPass.equals(passWord)) {
				name = list.get(i).getFirstName();
				flag = true;
			}
		}
		if (flag == true) {
			System.out.println("Valid Credentials");
			mv.addObject("name", name);
			mv.setViewName("successful");
		}
		else {
			System.out.println("Invalid Credentials");
			mv.setViewName("unsuccessful");
		}
		
		return mv;
	}
}
