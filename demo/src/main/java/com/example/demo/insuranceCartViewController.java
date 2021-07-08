package com.example.demo;

import java.util.List;

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
public class insuranceCartViewController {
	@Autowired
	UserController userController;
	@Autowired
	InsuranceController insuranceController;
	@Autowired
	CartController cartController;
	
	@RequestMapping("removeFromCart")
	public ModelAndView removeFromCart(@RequestParam("firstName")String name, @RequestParam("sId")int currentCart) {
		ModelAndView mv = new ModelAndView();
		cartController.removeCartById(currentCart);
		mv.addObject("name",name);
		mv.setViewName("redirect:/insuranceCart");
		return mv;
	}
	
	@RequestMapping("buyAllPolicies")
	public ModelAndView buyAll(@RequestParam("firstName")String name) {
		ModelAndView mv = new ModelAndView();
		UserClass user = userController.getUserByName(name);
		List<CartClass> list = cartController.getCartByUserId(user.getuID());
		int totalPrice = 0;
		for (int i = 0; i < list.size(); i++) {
			totalPrice = totalPrice + list.get(i).getiPrice();
		}
		mv.addObject("name", name);
		mv.addObject("price", totalPrice);
		mv.addObject("cart", list);
		mv.setViewName("paymentPage");
		return mv;
	}
	
	@RequestMapping("submitCredentials")
	public ModelAndView submitCredentials(@RequestParam("name")String name) {
		ModelAndView mv = new ModelAndView("successful");
		UserClass user = userController.getUserByName(name);
		int id = user.getuID();
		List<CartClass> cc = cartController.getCartByUserId(id);
		for (int i = 0; i < cc.size(); i++) {
			cartController.setPaid(cc);
		}
		mv.addObject("name",name);
		return mv;
	}

}
