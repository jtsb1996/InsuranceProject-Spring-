package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.cart.CartClass;
import com.example.demo.cart.CartController;
import com.example.demo.insurance.InsuranceController;
import com.example.demo.user.UserClass;
import com.example.demo.user.UserController;

@Controller
public class insuranceViewController {
	
	@Autowired
	InsuranceController insuranceController;
	@Autowired
	CartController cartController;
	@Autowired
	UserController userController;
	
	
	@RequestMapping("addtoCart")
	public ModelAndView addToCart(@RequestParam("name")String name, CartClass cart) {
		ModelAndView mv = new ModelAndView();
		UserClass user = userController.getUserByName(name);
		cart.setuID(user.getuID());
		cartController.addCart(cart);
		
		mv.setViewName("successful");
		mv.addObject("name", name);
		return mv;
	}

}
